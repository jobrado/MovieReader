/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal;

import hr.algebra.dal.sql.ActorSqlRepository;
import hr.algebra.dal.sql.DirectorSqlRepository;
import hr.algebra.dal.sql.MovieSqlRepository;
import hr.algebra.dal.sql.UserSqlRepository;
import java.io.IOException;

/**
 *
 * @author Jo
 */
public class RepositoryFactory {

    private RepositoryFactory() {
    }

    public static Repository getMovieRepository() throws IOException {
        return new MovieSqlRepository();
    }

    public static Repository getActorRepository() throws IOException {
        return new ActorSqlRepository();
    }

    public static Repository getDirectorRepository() throws IOException {
        return new DirectorSqlRepository();
    }

    public static Repository getUserRepository() throws IOException {
        return new UserSqlRepository();
    }

}
