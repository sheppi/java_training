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
				+ " SET user_status = 'false' " //TODO
				+ " WHERE USER_ID = " + idUser;
		ResultSet resultSet = execute(toBlockSQL);
		System.out.println(resultSet.toString()); //debug
		return true;
	}

	@Override
	public boolean unBlockUser(int idUser) throws DAOException {
		String toUnBlockSQL = "UPDATE users"
				+ " SET user_status = 'true' " //TODO
				+ " WHERE user_id = " + idUser;
		ResultSet resultSet = execute(toUnBlockSQL);
		System.out.println(resultSet.toString()); //debug
		return true;
	}

	@Override
	public boolean deleteUser(int idUser) throws DAOException {
		String deleteUserSQL = "DELETE users WHERE user_id = " + idUser;
		ResultSet resultSet = execute(deleteUserSQL);
		System.out.println(resultSet.toString()); //debug
		return true;
	}

	@Override
	public boolean addNewBook(Book book) throws DAOException {
		String addNewBookSQL;
		switch (book.getType()){
			case "programmer":
				addNewBookSQL = "INSERT INTO books"
						+ "(book_author, book_title, book_price, book_type, book_firstparam, book_secondparam) " + "VALUES"
						+ "(" + book.toString() + ")";
				break;

			default:
				addNewBookSQL = "INSERT INTO books"
						+ "(book_author, book_title, book_price, book_type) " + "VALUES"
						+ "(" + book.toString() + ")";
				break;
		}
		ResultSet resultSet = execute(addNewBookSQL);
		System.out.println(resultSet.toString()); //debug
		return false;
	}

	@Override
	public boolean deleteBook(String title) throws DAOException {
		String deleteUserSQL = "DELETE books WHERE book_title = \'" + title + "\'";
		ResultSet resultSet = execute(deleteUserSQL);
		System.out.println(resultSet.toString()); //debug
		return false;
	}

}
