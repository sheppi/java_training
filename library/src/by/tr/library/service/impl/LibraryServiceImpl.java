package by.tr.library.service.impl;

import java.util.List;

import by.tr.library.bean.Book;
import by.tr.library.bean.ProgrammerBook;
import by.tr.library.dao.AdminDao;
import by.tr.library.dao.DAOFactory;
import by.tr.library.dao.UserDao;
import by.tr.library.dao.exception.DAOException;
import by.tr.library.service.LibraryService;
import by.tr.library.service.exception.ServiceException;

public class LibraryServiceImpl implements LibraryService{

	@Override
	public Book findByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addBook(String author, String title, int price) throws ServiceException {
		//validation
		
		Book book = new Book(author, title, price);
		
		DAOFactory factory = DAOFactory.getInstance();
		AdminDao adminDAo = factory.getAdminDao();
		
		// call method check
		try {
			adminDAo.addNewBook(book);
		} catch (DAOException e) {
			throw new ServiceException("service message", e);
		}
		
		return false;
	}

	@Override
	public boolean addBook(String author, String title, int price, String language, String level) throws ServiceException {
		//validation

		Book book = new ProgrammerBook(author, title, price, language, level);

		DAOFactory factory = DAOFactory.getInstance();
		AdminDao adminDao = factory.getAdminDao();

		// call method check
		try {
			adminDao.addNewBook(book);
		} catch (DAOException e) {
			throw new ServiceException("service message", e);
		}

		return false;
	}

	@Override
	public List<Book> getCatalog() throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		UserDao userDao = factory.getUserDao();
		
		List<Book> listBook;
		try {
			listBook = userDao.getCatalog();
		} catch (DAOException e) {
			throw new ServiceException("service message", e);
		}
		
		return listBook;
	}

}

















