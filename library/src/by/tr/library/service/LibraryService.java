package by.tr.library.service;

import java.util.List;

import by.tr.library.bean.Book;
import by.tr.library.service.exception.ServiceException;

public interface LibraryService {
	Book findByAuthor(String author)throws ServiceException ;
	Book findByTitle(String title)throws ServiceException ;
	boolean addBook(String titile, String author, int price)throws ServiceException;
	boolean addBook(String titile, String author, int price, String language, String level)throws ServiceException;
	List<Book> getCatalog()throws ServiceException ;
}
