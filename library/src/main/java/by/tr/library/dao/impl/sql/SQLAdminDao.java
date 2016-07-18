package by.tr.library.dao.impl.sql;

import by.tr.library.bean.Book;
import by.tr.library.dao.AdminDao;
import by.tr.library.dao.datatype.SQLDao;
import by.tr.library.dao.exception.DAOException;

public class SQLAdminDao extends SQLDao implements AdminDao {

	public SQLAdminDao() throws DAOException {
		super();
	}

	@Override
	public boolean blockUser(int idUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unBlockUser(int idUser) throws DAOException {
		return false;
	}

	@Override
	public boolean deleteUser(int idUser) throws DAOException {
		return false;
	}

	@Override
	public boolean addNewBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBook(String title) throws DAOException {
		return false;
	}

}
