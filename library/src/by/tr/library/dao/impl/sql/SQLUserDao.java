package by.tr.library.dao.impl.sql;

import java.util.ArrayList;
import java.util.List;

import by.tr.library.bean.Book;
import by.tr.library.dao.UserDao;

public class SQLUserDao implements UserDao{

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
