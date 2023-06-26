CREATE DATABASE MovieEditorJavaProject
Go
use MovieEditorJavaProject
/*drop database MovieEditorJavaProject2*/

GO
-----------------ADMIN/USER--------------------------
CREATE TABLE UserRole(
IDUserRole INT PRIMARY KEY IDENTITY, 
URName NVARCHAR(20) not null
)
GO

CREATE TABLE Users(
IDUser INT PRIMARY KEY IDENTITY, 
FirstName NVARCHAR(50) NULL,
LastName NVARCHAR(50) NULL,
Username NVARCHAR(50) UNIQUE NOT NULL, 
UserPassword NVARCHAR(max) NOT NULL, 
UserRoleID int constraint FK_User_UserRole foreign key references UserRole(IDUserRole)
)
GO

SET IDENTITY_INSERT UserRole ON

INSERT INTO UserRole (IDUserRole, URName) VALUES (1,'admin')
GO

SET IDENTITY_INSERT UserRole OFF 

INSERT INTO Users (Username, UserPassword, UserRoleID) VALUES ('admin', 'admin', 1)
GO

INSERT INTO UserRole (URName) VALUES ('user')
GO


CREATE PROC registerUser
@firstname NVARCHAR(50),
@lastname NVARCHAR(50),
@username NVARCHAR(100), 
@userpassword NVARCHAR(50),
@iduser int output
AS
BEGIN
DECLARE @userrole INT
SELECT @userrole = ur.IDUserRole FROM UserRole AS ur WHERE ur.URName = 'user'
INSERT INTO Users (FirstName, LastName, Username, UserPassword, UserRoleID) VALUES (@firstname, @lastname, @username, @userpassword, @userrole)
SET @iduser = SCOPE_IDENTITY()
END
GO

CREATE PROCEDURE loginUser 
@iduser INT
AS
BEGIN
	SELECT u.Username,u.UserPassword, u.UserRoleID FROM Users AS u  WHERE u.IDUser = @iduser
END
GO
CREATE PROCEDURE selectUsers 
AS
BEGIN
	SELECT * FROM Users
END
GO

/****DIRECTOR*****/


CREATE TABLE Director
(
	IDDirector INT CONSTRAINT PK_Director PRIMARY KEY IDENTITY,
	FirstName NVARCHAR(300) UNIQUE,
	/*LastName NVARCHAR(900),*/
	PicturePath NVARCHAR(90) NULL,

) 
GO
/*******MOVIES ********/

CREATE TABLE Movie
(
	IDMovie INT CONSTRAINT PK_Movie PRIMARY KEY IDENTITY,
	Title NVARCHAR(100),
	PubDate NVARCHAR(20) NULL,
	Descr NVARCHAR(max) NULL,
	OrigiTitle NVARCHAR(200) NULL,
/*	DirectorID INT CONSTRAINT FK_Director_Movie FOREIGN KEY REFERENCES Director(IDDirector) NULL,*/
/*	ActorName NVARCHAR(200) NULL,*/
	Duration INT NULL,
	Genre NVARCHAR(200) NULL,
	PicturePath NVARCHAR(200) NULL	
)
GO
/*****ACTOR******/

CREATE TABLE Actor
(
	IDActor INT  CONSTRAINT PK_Actor PRIMARY KEY IDENTITY,
	ActorName NVARCHAR(300),
	PicturePath NVARCHAR(90) NULL
)
GO

/****ACTOR-MOVIE****/
CREATE TABLE Movie_Actor
(
	IDMovieActor INT PRIMARY KEY IDENTITY, 
	MovieID INT CONSTRAINT FK_Movie_Actor FOREIGN KEY REFERENCES Movie(IDMovie), 
	ActorID INT CONSTRAINT FK_Actor_Movie FOREIGN KEY REFERENCES Actor(IDActor)
)

GO



/***DIRECTOR-MOVIE***/
create table Movie_Director
(
	IDDirectorMovie INT PRIMARY KEY IDENTITY, 
	MovieID INT CONSTRAINT FK_Movie_Director FOREIGN KEY REFERENCES Movie(IDMovie), 
	DirectorID INT CONSTRAINT FK_Director_Movie FOREIGN KEY REFERENCES Director(IDDirector)
)
GO

/********************CRUD***********************/

/*CREATE MOVIE*/
CREATE PROC createMovie
	@Title NVARCHAR(300),
	@PubDate NVARCHAR (90),
	@Descr NVARCHAR(max),
	@OrigiTitle NVARCHAR(900),
	@ActorName NVARCHAR(300),
	@DirectorName NVARCHAR(300),
	@Duration INT,
	@Genre NVARCHAR (900),
	@PicturePath NVARCHAR(900),
	@IDMovie INT OUTPUT
AS 
BEGIN 
if not exists( select * from Movie where Title = @Title)
	BEGIN
	INSERT INTO Movie(Title, PubDate, Descr, OrigiTitle, Duration,Genre, PicturePath) VALUES(@Title, @PubDate, @Descr,@OrigiTitle,@Duration, @Genre, @PicturePath)
		SET @IDMovie = SCOPE_IDENTITY()
	if not exists(select * from Director where Director.FirstName = @DirectorName)
	BEGIN
	declare @dirint int
		insert into Director(FirstName) values (@DirectorName)
		select @dirint = IDDirector from Director where FirstName = @DirectorName
		insert into Movie_Director values( @IDMovie, @dirint)
	END
	ELSE
		BEGIN
		select @dirint = IDDirector from Director where FirstName = @DirectorName
		insert into Movie_Director values( @IDMovie, @dirint)
	
	END
	declare @idactor int
		if not exists(select * from Actor as a where a.ActorName = @ActorName)
	begin
		
		insert into Actor(ActorName) values(@ActorName)
		select @idactor = IDActor from Actor where ActorName = @ActorName
		insert into Movie_Actor values( @IDMovie, @idactor)
	end
	else
		BEGIN
			select @idactor = IDActor from Actor where ActorName = @ActorName
			insert into Movie_Actor values( @IDMovie, @idactor)
		END
		END
		
ELSE
		BEGIN
		if not exists(select * from Actor as a where a.ActorName = @ActorName)
	begin
		
		insert into Actor(ActorName) values(@ActorName)
		select @idactor = IDActor from Actor where ActorName = @ActorName
		select @IDMovie = IDMovie from Movie where Title = @Title
		insert into Movie_Actor values(@IDMovie, @idactor)
	end
	else
		BEGIN
			select @idactor = IDActor from Actor where ActorName = @ActorName
			select @IDMovie = IDMovie from Movie where Title = @Title
			insert into Movie_Actor values(@IDMovie, @idactor)
		END		
		END
		
END
		GO
		
	



/*UPDATE MOVIE*/
CREATE PROC updateMovie
	@IDMovie INT,
	@Title NVARCHAR(300),
	@PubDate NVARCHAR (90),
	@Descr NVARCHAR(max),
	@OrigiTitle NVARCHAR(900),
	@DirectorName NVARCHAR(900),
	@ActorName  NVARCHAR(900),
	@Duration INT,
	@Genre NVARCHAR (90),
	@PicturePath NVARCHAR(900)
	 
AS 
BEGIN 
	UPDATE Movie SET 
		Title = @Title,
		PubDate=@PubDate,
		Descr = @Descr,
		OrigiTitle = @OrigiTitle,
		Duration = @Duration,
		Genre = @Genre,
		PicturePath = @PicturePath
	WHERE 
		IDMovie = @IDMovie
ALTER TABLE Movie_Actor NOCHECK CONSTRAINT ALL
ALTER TABLE Movie_Director NOCHECK CONSTRAINT ALL
	DELETE FROM Movie_Actor where Movie_Actor.MovieID = @IDMovie  
	DELETE FROM Movie_Director where Movie_Director.MovieID = @IDMovie  
	DECLARE @actorID INT
	DECLARE @dirID INT
	SELECT @actorID = a.IDActor FROM Actor AS a
	WHERE a.ActorName =@ActorName
	INSERT INTO Movie_Actor (ActorID, MovieID) VALUES (@actorID, @IDMovie)
	SELECT @dirID = d.IDDirector FROM Director as d where d.FirstName =@DirectorName
	INSERT INTO Movie_Director (DirectorID, MovieID) VALUES (@dirID, @IDMovie)
ALTER TABLE Movie_Actor WITH CHECK CHECK CONSTRAINT ALL
ALTER TABLE Movie_Director WITH CHECK CHECK CONSTRAINT ALL
END
GO



/*DELETE MOVIE */
GO

CREATE PROCEDURE deleteMovie
	@IDMovie INT	 
AS 
BEGIN 
ALTER TABLE Movie_Actor NOCHECK CONSTRAINT ALL
ALTER TABLE Movie_Director NOCHECK CONSTRAINT ALL
	DELETE FROM Movie WHERE IDMovie = @IDMovie
	DELETE FROM Movie_Actor WHERE MovieID = @IDMovie
	DELETE FROM Movie_Director WHERE MovieID=@IDMovie
ALTER TABLE Movie_Actor WITH CHECK CHECK CONSTRAINT ALL
ALTER TABLE Movie_Director WITH CHECK CHECK CONSTRAINT ALL

END
GO

/*SELECT MOVIE*/

CREATE PROCEDURE selectMovie
	@IDMovie INT
AS 
BEGIN 
	SELECT DISTINCT
		  m.IDMovie, m.Title,m.PubDate,m.Descr,m.OrigiTitle,d.FirstName,a.ActorName,m.Duration,m.Genre,m.PicturePath
	FROM Movie as m 
	left join Movie_Director as md on m.IDMovie=md.MovieID
	right join Director as d on md.DirectorID= d.IDDirector
	inner join Movie_Actor as ma on m.IDMovie =ma.MovieID 
	right join Actor as a on ma.ActorID=a.IDActor
	WHERE 
		IDMovie = @IDMovie
END
GO

/*SELECT MOVIES*/

CREATE PROCEDURE selectMovies
AS 
BEGIN 
	SELECT DISTINCT m.IDMovie, m.Title,m.PubDate,m.Descr,m.OrigiTitle,d.FirstName,a.ActorName,m.Duration,m.Genre,m.PicturePath
	FROM Movie as m 
	left join Movie_Director as md on m.IDMovie=md.MovieID
	right join Director as d on md.DirectorID= d.IDDirector
	inner join Movie_Actor as ma on m.IDMovie =ma.MovieID 
	right join Actor as a on ma.ActorID=a.IDActor
	

END
GO

/*CREATE ACTOR*/ 
CREATE PROCEDURE createActor
	@ActorName NVARCHAR(300),
	@PicturePath NVARCHAR(90),
	@MovieName NVARCHAR(max),
	@IDActor INT OUTPUT
AS 
BEGIN 
  if not exists(select * from Actor as a where ActorName=@ActorName)
   BEGIN
	INSERT INTO Actor VALUES(@ActorName, @PicturePath)
	 SET @IDActor = SCOPE_IDENTITY()
	 declare @movieid int
	 if exists(select IDMovie=@movieid from Movie where Movie.Title = @MovieName)
		begin
	INSERT INTO Movie_Actor VALUES(@movieid, @IDActor)
		end
	else
		BEGIN
	INSERT INTO Movie(Title) VALUES (@MovieName)
	select IDMovie =@movieid from Movie where Title = @MovieName
	INSERT INTO Movie_Actor VALUES(@movieid, @IDActor)
		END
END
ELSE
	BEGIN
	if exists(select IDMovie=@movieid from Movie where Movie.Title = @MovieName)
		begin
	INSERT INTO Movie_Actor VALUES(@movieid, @IDActor)
		end
	else
		BEGIN
	INSERT INTO Movie(Title) VALUES (@MovieName)
	select IDMovie =@movieid from Movie where Title = @MovieName
	INSERT INTO Movie_Actor VALUES(@movieid, @IDActor)
		END
END
END
GO

/*UPDATE ACTOR*/
CREATE PROCEDURE updateActor
	@IDActor INT,
	@ActorName NVARCHAR(300),
	@PicturePath NVARCHAR(90),
	@MovieName NVARCHAR(400)
AS 
BEGIN 
	UPDATE Actor SET 
		ActorName = @ActorName,
		PicturePath = @PicturePath	
	WHERE 
		IDActor = @IDActor
		ALTER TABLE Movie_Actor NOCHECK CONSTRAINT ALL
	DELETE FROM Movie_Actor where Movie_Actor.ActorID = @IDActor 
	DECLARE @movieID INT
	SELECT @movieID = m.IDMovie FROM Movie AS m
	WHERE m.Title = @MovieName
	INSERT INTO Movie_Actor (ActorID, MovieID) VALUES (@IDActor, @movieID)
		ALTER TABLE Movie_Actor WITH CHECK CHECK CONSTRAINT ALL
END
GO
	
/*DELETE ACTOR*/

CREATE PROCEDURE deleteActor
	@IDActor INT	 
AS 
BEGIN 
ALTER TABLE Movie_Actor NOCHECK CONSTRAINT ALL
	DELETE  FROM Actor WHERE IDActor = @IDActor	
	DELETE FROM Movie_Actor WHERE ActorID = @IDActor
ALTER TABLE Movie_Actor WITH CHECK CHECK CONSTRAINT ALL
END
GO
/*SELECT ACTOR*/

CREATE PROCEDURE selectActor
	@IDActor INT
AS 
BEGIN 
	SELECT a.IDActor,a.ActorName,a.PicturePath,m.Title 
	FROM Actor as a 
	inner join Movie_Actor as ma on a.IDActor = ma.IDMovieActor 
	inner join Movie as m on m.IDMovie = ma.MovieID
	WHERE 
		IDActor = @IDActor
END
GO

/*SELECT ACTORS*/

CREATE PROCEDURE selectActors
AS 
BEGIN 
	SELECT a.IDActor,a.ActorName,a.PicturePath,m.Title 
	FROM Actor as a 
	inner join Movie_Actor as ma on a.IDActor = ma.IDMovieActor 
	inner join Movie as m on ma.MovieID = m.IDMovie
END
GO





/*CREATE DIRECTOR*/
CREATE PROCEDURE createDirector
	@FirstName NVARCHAR(300),
	@PicturePath NVARCHAR(90),
	@MovieName NVARCHAR(max),	
	@IDDirector INT OUTPUT
AS 
BEGIN 	
if not exists (select * from Director where FirstName = @FirstName)
begin
	INSERT INTO Director(FirstName,PicturePath) VALUES(@FirstName, @PicturePath)
	SET @IDDirector = SCOPE_IDENTITY()
	declare @id int
	select IDMovie = @id from Movie as m where @MovieName = Title	
	insert into Movie_Director(DirectorID, MovieID) values (@IDDirector, @id)		
end
else
begin
	select IDMovie = @id from Movie as m where @MovieName = Title
	select IDDirector = @IDDirector from Director as d where @FirstName =FirstName
	insert into Movie_Director(DirectorID, MovieID) values (@IDDirector, @id)	
end
	end
GO

/*UPDATE DIRECTOR*/
CREATE PROCEDURE updateDirector
	@FirstName NVARCHAR(300),
	@PicturePath NVARCHAR(90),
	@MovieName NVARCHAR(200),
	@IDDirector INT
AS 
BEGIN 
	UPDATE Director SET 
		FirstName = @FirstName,
		PicturePath = @PicturePath
	WHERE 
		IDDirector = @IDDirector
		ALTER TABLE Movie_Director NOCHECK CONSTRAINT ALL
	DELETE FROM Movie_Director where Movie_Director.DirectorID = @IDDirector 
	DECLARE @movieID INT
	SELECT @movieID = m.IDMovie FROM Movie AS m
	WHERE m.Title = @MovieName
	INSERT INTO Movie_Director (DirectorID, MovieID) VALUES (@IDDirector, @movieID)
		ALTER TABLE Movie_Director WITH CHECK CHECK CONSTRAINT ALL

END
GO
	
	
/*DELETE DIRECTOR */

CREATE PROCEDURE deleteDirector
	@IDDirector INT	 
AS 
BEGIN 
ALTER TABLE Movie_Director NOCHECK CONSTRAINT ALL		
	DELETE  
	FROM 
			Director
	WHERE 
		IDDirector = @IDDirector
	DELETE FROM Movie_Director WHERE DirectorID = @IDDirector
ALTER TABLE Movie_Director WITH CHECK CHECK CONSTRAINT ALL
END
GO
/*SELECT DIRECTOR*/

CREATE PROCEDURE selectDirector
	@IDDirector INT
AS 
BEGIN 
		SELECT  IDDirector, FirstName, d.PicturePath, m.Title FROM Director as d right join Movie_Director as md on d.IDDirector =md.DirectorID right join Movie as m on md.MovieID = m.IDMovie	 
	WHERE 
		IDDirector = @IDDirector
END
GO

/*SELECT DIRECTORS*/

CREATE PROCEDURE selectDirectors
AS 
BEGIN 
	SELECT IDDirector, FirstName, d.PicturePath, m.Title FROM Director as d right join Movie_Director as md on d.IDDirector =md.DirectorID right join Movie as m on md.MovieID = m.IDMovie
END
GO

/*DELETE ALLLLL DATAAAAAAAAAAA*/

CREATE PROCEDURE deleteMovies 
AS 
BEGIN 
	
ALTER TABLE Movie_Actor NOCHECK CONSTRAINT ALL
ALTER TABLE Movie_Director NOCHECK CONSTRAINT ALL
	DELETE  FROM Users where iduser > 1
	DELETE  FROM Movie
	DELETE  FROM Actor
	DELETE FROM Movie_Actor
	DELETE  FROM Director
	DELETE FROM Movie_Director
ALTER TABLE Movie_Actor WITH CHECK CHECK CONSTRAINT ALL
ALTER TABLE Movie_Director WITH CHECK CHECK CONSTRAINT ALL
END
GO
