/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal.sql;

import hr.algebra.dal.Repository;
import hr.algebra.model.user.User;
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
 * @author Jo /* package hr.algebra.dal.sql;
 *
 * import hr.algebra.dal.Repository;
 *
 * /**
 *
 * @author Jo
 */
public class UserSqlRepository<T> implements Repository<User> {

    private static final String ID_USER = "IDUser";

    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";
    private static final String USERROLE_ID = "UserRoleID";
    private static final String USERNAME = "Username";
    private static final String PASSWORD = "UserPassword";

    private static final String CREATE_USER = "{  CALL registerUser (?,?,?,?,?)  }";
    private static final String SELECT_USER = "{  CALL loginUser(?)  }";
    private static final String SELECT_USERS = "{  CALL selectUsers  }";

    @Override
    public int createOne(User u) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_USER)) {

            stmt.setString("@" + FIRST_NAME, u.getUsername());
            stmt.setString("@" + LAST_NAME, u.getPassword());
            stmt.setString("@" + USERNAME, u.getUsername());
            stmt.setString("@" + PASSWORD, u.getPassword());

            stmt.registerOutParameter("@" + ID_USER, Types.INTEGER);

            stmt.executeUpdate();

            return stmt.getInt("@" + ID_USER);
        }
    }

    @Override
    public void createList(List t) throws Exception {
    }

    @Override
    public void deleteOne(int id) throws Exception {

    }

    @Override
    public Optional<User> selectOne(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_USER)) {
            stmt.setInt("@" + ID_USER, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    return Optional.of(new User(
                            rs.getString(USERNAME),
                            rs.getString(PASSWORD),
                            rs.getInt(USERROLE_ID)
                    ));
                }
            }
        }

        return Optional.empty();
    }

    @Override
    public List<User> selectList() throws Exception {
        List<User> users = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_USERS);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {

                users.add(new User(
                        rs.getInt(ID_USER),
                        rs.getString(FIRST_NAME),
                        rs.getString(LAST_NAME),
                        rs.getString(USERNAME),
                        rs.getString(PASSWORD),
                        rs.getInt(USERROLE_ID)
                ));
            }
        }
        return users;
    }

    @Override
    public void updateOne(int id, User t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
