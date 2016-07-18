package by.tr.library.dao.datatype;

import by.tr.library.dao.exception.DAOException;

import java.sql.*;

/**
 * Created by Kirill_Kaluga on 7/18/2016.
 */
public abstract class SQLDao {

    private final String defaultDriver = "com.mysql.jdbc.Driver";
    private final String defaultDatabase = "jdbc:mysql://localhost/library";
    private final String defaultUser = "root";
    private final String defaultPassword = "";

    private Connection connection;
    private String driver;
    private String database;
    private String user;
    private String password;

    public SQLDao() throws DAOException {
        setConnection(defaultDriver, defaultDatabase);
        setProfile(defaultUser, defaultPassword);
    }

    public void setConnection(String driver, String database) throws DAOException {
        this.driver = driver;
        this.database = database;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new DAOException("Where is your MySQL JDBC Driver?");
        }
    }

    public void setProfile(String username, String password) {
        this.user = username;
        this.password = password;
    }

    protected ResultSet execute(String command) throws DAOException {
        try {
            connection = DriverManager
                    .getConnection(database, user, password);
            Statement statement = connection.createStatement();
            statement.execute(command);
        } catch (SQLException e) {
            throw new DAOException("Connection error", e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DAOException("Connection close error", e);
            }
        }
        return null;
    }
}
