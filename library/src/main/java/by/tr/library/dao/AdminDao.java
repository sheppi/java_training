package by.tr.library.dao;

import by.tr.library.bean.Book;
import by.tr.library.dao.exception.DAOException;

public interface AdminDao {
	boolean blockUser(int idUser)throws DAOException;
	boolean unBlockUser(int idUser) throws DAOException;
	boolean deleteUser(int idUser) throws DAOException;
	boolean addNewBook(Book book)throws DAOException;
	boolean deleteBook(String title) throws DAOException;

}
