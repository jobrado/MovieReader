/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal.sql;

import hr.algebra.dal.Repository;
import hr.algebra.model.Director;
import hr.algebra.model.Movie;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

/**
 *
 * @author Jo
 */
public class DirectorSqlRepository<T> implements Repository<Director> {

    private static final String ID_DIRECTOR = "IDDirector";
    private static final String NAME = "FirstName";
    private static final String PICTURE_PATH = "PicturePath";
    private static final String MOVIE_TITLE = "MovieName";
    private static final String MOVIE_TITLE1 = "Title";

    private static final String CREATE_DIRECTOR = "{  CALL createDirector(?,?,?,?) }";
    private static final String UPDATE_DIRECTOR = "{  CALL updateDirector(?,?,?,?) }";
    private static final String DELETE_DIRECTOR = "{  CALL deleteDirector(?) }";
    private static final String SELECT_DIRECTOR = "{  CALL selectDirector(?) }";
    private static final String SELECT_DIRECTORS = "{  CALL selectDirectors }";

    @Override
    public int createOne(Director director) throws Exception {
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_DIRECTOR)) {
            List<Movie> movies = director.getMovies();
            for (Movie movie : movies) {
                stmt.setString("@" + NAME, director.getDirectorName());
                stmt.setString("@" + PICTURE_PATH, director.getPicturePath());
                stmt.setString("@" + MOVIE_TITLE, movie.getTitle());
                stmt.registerOutParameter("@" + ID_DIRECTOR, Types.INTEGER);

                stmt.executeUpdate();
            }
            return stmt.getInt("@" + ID_DIRECTOR);
        }
    }

    @Override
    public void createList(List<Director> directors) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_DIRECTOR)) {
            for (Director director : directors) {
                List<Movie> movies = director.getMovies();
                for (Movie movie : movies) {
                    stmt.setString("@" + NAME, director.getPicturePath());
                    stmt.setString("@" + PICTURE_PATH, director.getPicturePath());
                    stmt.setString("@" + MOVIE_TITLE, movie.getTitle());
                    stmt.registerOutParameter("@" + ID_DIRECTOR, Types.INTEGER);
                    stmt.executeUpdate();
                }
            }
        }
    }

    @Override
    public void updateOne(int id, Director director) throws Exception {

        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_DIRECTOR)) {
            List<Movie> movies = director.getMovies();
            for (Movie movie : movies) {
                stmt.setString("@" + NAME, director.getPicturePath());
                stmt.setString("@" + PICTURE_PATH, director.getPicturePath());
                stmt.setString("@" + MOVIE_TITLE, movie.getTitle());
                stmt.setInt("@" + ID_DIRECTOR, id);
                stmt.executeUpdate();
            }
        }
    }

    @Override
    public void deleteOne(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_DIRECTOR)) {

            stmt.setInt("@" + ID_DIRECTOR, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Director> selectOne(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_DIRECTOR)) {
            stmt.setInt("@" + ID_DIRECTOR, id);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    return Optional.of(new Director(
                            rs.getInt(ID_DIRECTOR),
                            rs.getString(NAME),
                            rs.getString(PICTURE_PATH),
                            handleMovie(rs.getString(MOVIE_TITLE1))
                    ));

                }

            }
            return Optional.empty();
        }
    }

    @Override
    public List<Director> selectList() throws Exception {
        List<Director> directors = new ArrayList<>();

        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_DIRECTORS);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                directors.add(new Director(
                        rs.getInt(ID_DIRECTOR),
                        rs.getString(NAME),
                        rs.getString(PICTURE_PATH),
                        handleMovie(rs.getString(MOVIE_TITLE1))
                ));
            }
            return directors;

        }

    }

    List<Movie> m = new ArrayList<>();

    private List<Movie> handleMovie(String s) throws Exception {
        m.add(new Movie(s));
        return m;
    }

    @Override
    public void deleteAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
