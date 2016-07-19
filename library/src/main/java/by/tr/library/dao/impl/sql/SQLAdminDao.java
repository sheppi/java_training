package by.tr.library.dao.impl.sql;

import by.tr.library.bean.Book;
import by.tr.library.dao.AdminDao;
import by.tr.library.dao.datatype.SQLDao;
import by.tr.library.dao.exception.DAOException;
import com.sun.org.apache.regexp.internal.RE;

import java.sql.ResultSet;

public class SQLAdminDao extends SQLDao implements AdminDao {

	public SQLAdminDao() throws DAOException {
		super();
		setProfile("library_admin", "admin");
	}

	@Override
	public boolean blockUser(int idUser) throws DAOException {
		String toBlockSQL = "UPDATE USERS"
				+ " SET ??? = 'false' " //TODO
				+ " WHERE USER_ID = " + idUser;
		ResultSet resultSet = execute(toBlockSQL);
		System.out.println(resultSet.toString()); //debug
		return true;
	}

	@Override
	public boolean unBlockUser(int idUser) throws DAOException {
		String toUnBlockSQL = "UPDATE USERS"
				+ " SET ??? = 'true' " //TODO
				+ " WHERE USER_ID = " + idUser;
		ResultSet resultSet = execute(toUnBlockSQL);
		System.out.println(resultSet.toString()); //debug
		return true;
	}

	@Override
	public boolean deleteUser(int idUser) throws DAOException {
		String deleteUserSQL = "DELETE USERS WHERE USER_ID = " + idUser;
		ResultSet resultSet = execute(deleteUserSQL);
		System.out.println(resultSet.toString()); //debug
		return true;
	}

	@Override
	public boolean addNewBook(Book book) throws DAOException {
		String addNewBookSQL;
		switch (book.getType()){
			case "programmer":
				addNewBookSQL = "INSERT INTO BOOKS"
						+ "(BOOK_AUTHOR, BOOK_TITLE, BOOK_PRICE, BOOK_TYPE, BOOK_FIRSTPARAM, BOOK_SECONDPARAM) " + "VALUES"
						+ "(" + book.toString() + ")";
				break;

			default:
				addNewBookSQL = "INSERT INTO BOOKS"
						+ "(BOOK_AUTHOR, BOOK_TITLE, BOOK_PRICE, BOOK_TYPE) " + "VALUES"
						+ "(" + book.toString() + ")";
				break;
		}
		ResultSet resultSet = execute(addNewBookSQL);
		System.out.println(resultSet.toString()); //debug
		return false;
	}

	@Override
	public boolean deleteBook(String title) throws DAOException {
		String deleteUserSQL = "DELETE BOOKS WHERE BOOK_TITLE = \'" + title + "\'";
		ResultSet resultSet = execute(deleteUserSQL);
		System.out.println(resultSet.toString()); //debug
		return false;
	}

}
