package by.tr.library.dao.impl.sql;

import java.security.spec.DSAGenParameterSpec;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.tr.library.bean.Book;
import by.tr.library.bean.ProgrammerBook;
import by.tr.library.dao.UserDao;
import by.tr.library.dao.datatype.SQLDao;
import by.tr.library.dao.exception.DAOException;

public class SQLUserDao extends SQLDao implements UserDao {

	public SQLUserDao() throws DAOException {
		super();
		setProfile("library_user", "user");
	}

	@Override
	public List<Book> getCatalog() throws DAOException {
		String getCatalogSQL = "SELECT * FROM books";
		ResultSet resultSet = execute(getCatalogSQL);
		ArrayList<Book> resultList = new ArrayList<>();
		Book tempBook;
		try {
			while (resultSet.next()) {
				String author = resultSet.getString("book_author");
				String title = resultSet.getString("book_title");
				int price = resultSet.getInt("book_price");
				String type = resultSet.getString("book_type");
				switch (type) {
					case "programmer":
						String language = resultSet.getString("book_firstparam");
						String level = resultSet.getString("book_secondparam");
						tempBook = new ProgrammerBook(author, title, price, language, level);
						break;

					default:
						tempBook = new Book(author, title, price);
						break;
				}
				resultList.add(tempBook);
			}
		} catch (SQLException e) {
			throw new DAOException("", e);
		}
		return resultList;
	}

	@Override
	public Book getBookByTitle(String titleToGet) throws DAOException {
		String getBookByTitleSQL = "SELECT * FROM books WHERE book_title = \'" + titleToGet + "\';";
		ResultSet resultSet = execute(getBookByTitleSQL);
		Book tempBook = null;
		try {
			resultSet.next();
			String author = resultSet.getString("book_author");
			String title = resultSet.getString("book_title");
			int price = resultSet.getInt("book_price");
			String type = resultSet.getString("book_type");
			switch (type) {
				case "programmer":
					String language = resultSet.getString("book_firstparam");
					String level = resultSet.getString("book_secondparam");
					tempBook = new ProgrammerBook(author, title, price, language, level);
					break;

				default:
					tempBook = new Book(author, title, price);
					break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tempBook;
	}
}