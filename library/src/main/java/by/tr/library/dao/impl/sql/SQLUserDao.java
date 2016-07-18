package by.tr.library.dao.impl.sql;

import java.security.spec.DSAGenParameterSpec;
import java.util.ArrayList;
import java.util.List;

import by.tr.library.bean.Book;
import by.tr.library.dao.UserDao;
import by.tr.library.dao.datatype.SQLDao;
import by.tr.library.dao.exception.DAOException;

public class SQLUserDao extends SQLDao implements UserDao{

	public SQLUserDao() throws DAOException {
		super();
	}

	@Override
	public List<Book> getCatalog() {
		// TODO Auto-generated method stub
		return new ArrayList<Book>();
	}

	@Override
	public Book getBookByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
