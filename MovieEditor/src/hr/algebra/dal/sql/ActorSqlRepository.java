/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal.sql;

import hr.algebra.dal.Repository;
import hr.algebra.model.Actor;
import hr.algebra.model.Movie;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

public class ActorSqlRepository<T> implements Repository<Actor> {

    private static final String ID_ACTOR = "IDActor";
    private static final String NAME = "ActorName";
    private static final String PICTURE_PATH = "PicturePath";
    private static final String MOVIES = "MovieName";
    private static final String MOVIES1 = "Title";

    private static final String CREATE_ACTOR = "{  CALL createActor(?,?,?,?)  }";
    private static final String UPDATE_ACTOR = "{  CALL updateActor(?,?,?,?) }";
    private static final String DELETE_ACTOR = "{  CALL deleteActor(?) }";
    private static final String SELECT_ACTOR = "{  CALL selectActor(?) }";
    private static final String SELECT_ACTORS = "{  CALL selectActors }";

    @Override
    public int createOne(Actor actor) throws Exception {
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_ACTOR)) {
            List<Movie> movies = actor.getMovies();
            for (Movie movie : movies) {

                stmt.setString("@" + NAME, actor.getFirstName());
                stmt.setString("@" + PICTURE_PATH, actor.getPicturePath());
                stmt.setString("@" + MOVIES, movie.getTitle());
                stmt.registerOutParameter("@" + ID_ACTOR, Types.INTEGER);

                stmt.executeUpdate();
            }
            return stmt.getInt("@" + ID_ACTOR);
        }

    }

    @Override
    public void createList(List<Actor> actors) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_ACTOR)) {
            for (Actor actor : actors) {
                List<Movie> movies = actor.getMovies();
                for (Movie movie : movies) {
                    stmt.setString("@" + NAME, actor.getPicturePath());
                    stmt.setString("@" + PICTURE_PATH, actor.getPicturePath());
                    stmt.setString("@" + MOVIES, movie.getTitle());
                    stmt.registerOutParameter("@" + ID_ACTOR, Types.INTEGER);
                    stmt.executeUpdate();
                }
            }
        }
    }

    @Override
    public void updateOne(int id, Actor actor) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_ACTOR)) {

            List<Movie> movies = actor.getMovies();
            for (Movie m : movies) {
                stmt.setString("@" + NAME, actor.getPicturePath());
                stmt.setString("@" + PICTURE_PATH, actor.getPicturePath());
                stmt.setString("@" + MOVIES, m.getTitle());
                stmt.setInt("@" + ID_ACTOR, id);
                stmt.executeUpdate();
            }
        }
    }

    @Override
    public void deleteOne(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_ACTOR)) {

            stmt.setInt("@" + ID_ACTOR, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Actor> selectOne(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_ACTOR)) {
            stmt.setInt("@" + ID_ACTOR, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    return Optional.of(new Actor(
                            rs.getInt(ID_ACTOR),
                            rs.getString(NAME),
                            rs.getString(PICTURE_PATH),
                            handleMovie(rs.getString(MOVIES1))
                    ));

                }

            }
        }
        return Optional.empty();
    }

    @Override
    public List<Actor> selectList() throws Exception {
        List<Actor> actors = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        Actor a = null;
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_ACTORS);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                if(a !=null && a.getFirstName().equals(rs.getString(NAME))){}
                else{
               a= new Actor(
                        rs.getInt(ID_ACTOR),
                        rs.getString(NAME),
                        rs.getString(PICTURE_PATH),
                        handleMovie(rs.getString(MOVIES1))
                );
               actors.add(a);
                }
            }
        }
        return actors;

    }
    private static List<Movie> movies = new ArrayList();

    private List<Movie> handleMovie(String data) {
        movies.add(new Movie(data));
        return movies;
    }

    @Override
    public void deleteAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
