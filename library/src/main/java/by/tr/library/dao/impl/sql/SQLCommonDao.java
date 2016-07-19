package by.tr.library.dao.impl.sql;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.tr.library.dao.CommonDao;
import by.tr.library.dao.datatype.SQLDao;
import by.tr.library.dao.exception.DAOException;

public class SQLCommonDao extends SQLDao implements CommonDao {

	public SQLCommonDao() throws DAOException {
		super();
		setProfile("library_user", "user");
	}

	@Override
	public boolean authorization(String login, String password) throws DAOException {
		ResultSet resultSet = findUser(login);
		System.out.println(resultSet.toString()); //debug
		try {
			resultSet.next();
			String password_CHECK = resultSet.getString("user_password");
			if (password.equals(password_CHECK)){
				return true;
			}
            throw new DAOException("");
		} catch (SQLException e) {
			throw new DAOException("", e);
		}
	}

	@Override
	public boolean registration(String login, String password) throws DAOException {
		ResultSet resultSet = findUser(login);
		try {
			if (!resultSet.next()){
				String registrationSQL = "INSERT INTO users"
						+ "(user_login, user_password, user_status) " + "VALUES"
						+ "(\'" + login + "\',\'" + password + "\')";;
				resultSet = execute(registrationSQL);
				System.out.println(resultSet.toString()); //debug
				return true;
			}
            return false;
		} catch (SQLException e) {
			throw new DAOException("", e);
		}
	}

	public ResultSet findUser(String login) throws DAOException {
		String findUser = "SELECT * FROM users WHERE user_name = \'" + login + "\';";
		return execute(findUser);
	}
}
