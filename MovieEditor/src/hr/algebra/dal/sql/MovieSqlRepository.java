/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal.sql;

import hr.algebra.dal.Repository;
import hr.algebra.model.Actor;
import hr.algebra.model.Director;
import hr.algebra.model.Movie;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

public class MovieSqlRepository<T> implements Repository<Movie> {

    private static final String ID_MOVIE = "IDMovie";
    private static final String TITLE = "Title";
    private static final String PUB_DATE = "PubDate";
    private static final String DESCRIPTION = "Descr";
    private static final String ORIGI_TITLE = "OrigiTitle";
    private static final String DIRECTOR_ID = "DirectorName";
    private static final String DIRECTOR_ID1 = "FirstName";
    private static final String ACTOR_ID = "ActorName";
    private static final String DURATION = "Duration";
    private static final String GENRE = "Genre";
    private static final String PICTURE_PATH = "PicturePath";
    private static final String DILIMITER = ",";
    private List<Actor> actors1;

    private static final String CREATE_MOVIE = "{  CALL createMovie(?,?,?,?,?,?,?,?,?,?)  }";
    private static final String UPDATE_MOVIE = "{  CALL updateMovie(?,?,?,?,?,?,?,?,?,?)  }";
    private static final String DELETE_MOVIE = "{  CALL deleteMovie(?)  }";
    private static final String DELETE_MOVIES = "{  CALL deleteMovies  }";
    private static final String SELECT_MOVIE = "{  CALL selectMovie(?)  }";
    private static final String SELECT_MOVIES = "{  CALL selectMovies  }";

    @Override
    public int createOne(Movie movie) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_MOVIE)) {
            List<Actor> actors = movie.getActors();
            for (Actor a : actors) {
                stmt.setString("@" + TITLE, movie.getTitle());
                stmt.setString("@" + PUB_DATE, movie.getPubDate().format(Movie.DATE_FORMATTER));
                stmt.setString("@" + DESCRIPTION, movie.getDescription());
                stmt.setString("@" + ORIGI_TITLE, movie.getOrigiTitle());
                stmt.setString("@" + DIRECTOR_ID, movie.getDirector().getDirectorName());
                stmt.setString("@" + ACTOR_ID, a.getFirstName());
                stmt.setInt("@" + DURATION, movie.getDuration());
                stmt.setString("@" + GENRE, movie.getGenre());
                stmt.setString("@" + PICTURE_PATH, movie.getPicturePath());

                stmt.registerOutParameter("@" + ID_MOVIE, Types.INTEGER);

                stmt.executeUpdate();
            }
            return stmt.getInt("@" + ID_MOVIE);
        }
    }

    @Override
    public void createList(List<Movie> movies) throws Exception {

        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_MOVIE)) {
            for (Movie movie : movies) {
                if (movie.getActors() != null) {
                    List<Actor> actors = movie.getActors();
                    Director d = movie.getDirector();
                    for (Actor a : actors) {

                        stmt.setString("@" + TITLE, movie.getTitle());
                        stmt.setString("@" + PUB_DATE, movie.getPubDate().format(Movie.DATE_FORMATTER));
                        stmt.setString("@" + DESCRIPTION, movie.getDescription());
                        stmt.setString("@" + ORIGI_TITLE, movie.getOrigiTitle());
                        stmt.setString("@" + DIRECTOR_ID, d.getDirectorName());
                        stmt.setString("@" + ACTOR_ID, a.getFirstName());
                        stmt.setInt("@" + DURATION, movie.getDuration());
                        stmt.setString("@" + GENRE, movie.getGenre());
                        stmt.setString("@" + PICTURE_PATH, movie.getPicturePath());

                        stmt.registerOutParameter("@" + ID_MOVIE, Types.INTEGER);

                        stmt.executeUpdate();
                    }
                }

            }

        }

    }

    @Override
    public void updateOne(int id, Movie data) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_MOVIE)) {
            List<Actor> actors = data.getActors();
            Director dir = data.getDirector();
            for (Actor a : actors) {
                stmt.setString("@" + TITLE, data.getTitle());
                stmt.setString("@" + PUB_DATE, data.getPubDate().format(Movie.DATE_FORMATTER));
                stmt.setString("@" + DESCRIPTION, data.getDescription());
                stmt.setString("@" + ORIGI_TITLE, data.getOrigiTitle());
                stmt.setString("@" + DIRECTOR_ID, dir.getDirectorName());
                stmt.setString("@" + ACTOR_ID, a.getFirstName());
                stmt.setInt("@" + DURATION, data.getDuration());
                stmt.setString("@" + GENRE, data.getGenre());
                stmt.setString("@" + PICTURE_PATH, data.getPicturePath());

                stmt.setInt("@" + ID_MOVIE, id);

                stmt.executeUpdate();
            }
        }
    }

    @Override
    public void deleteOne(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_MOVIE)) {

            stmt.setInt("@" + ID_MOVIE, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Movie> selectOne(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_MOVIE)) {
            stmt.setInt("@" + ID_MOVIE, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    return Optional.of(new Movie(
                            rs.getInt(ID_MOVIE),
                            rs.getString(TITLE),
                            LocalDate.parse(rs.getString(PUB_DATE), Movie.DATE_FORMATTER),
                            rs.getString(DESCRIPTION),
                            rs.getString(ORIGI_TITLE),
                            handleDirector(rs.getString(DIRECTOR_ID1)),
                            handleActor(rs.getString(ACTOR_ID)),
                            rs.getInt(DURATION),
                            rs.getString(GENRE),
                            rs.getString(PICTURE_PATH)
                    ));
                }
            }
        }

        return Optional.empty();

    }

    @Override
    public List<Movie> selectList() throws Exception {
        actors1 = new ArrayList<>();
        List<Movie> movies = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        Movie m = null;
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_MOVIES);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                if (m != null && m.getTitle().equals(rs.getString(TITLE))) {
                    m.setActors(handleActor(rs.getString(ACTOR_ID)));
                } else {
                    if (m != null) {
                        movies.add(m);
                        actors1 = new ArrayList<>();
                    }
                    m = new Movie(
                            rs.getInt(ID_MOVIE),
                            rs.getString(TITLE),
                            LocalDate.parse(rs.getString(PUB_DATE), Movie.DATE_FORMATTER),
                            rs.getString(DESCRIPTION),
                            rs.getString(ORIGI_TITLE),
                            handleDirector(rs.getString(DIRECTOR_ID1)),
                            handleActor(rs.getString(ACTOR_ID)),
                            rs.getInt(DURATION),
                            rs.getString(GENRE),
                            rs.getString(PICTURE_PATH)
                    );

                }
            }
        }

        return movies;
    }

    private List<Actor> handleActor(String data) {

        actors1.add(new Actor(data));
        return actors1;
    }

    private Director handleDirector(String id) throws Exception {
        return new Director(id);

    }

    @Override
    public void deleteAll() throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_MOVIES)) {

            stmt.executeUpdate();
        }
    }

}
