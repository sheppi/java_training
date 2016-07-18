package by.tr.library.dao.impl.sql;

import java.io.IOException;

import by.tr.library.dao.CommonDao;
import by.tr.library.dao.datatype.SQLDao;
import by.tr.library.dao.exception.DAOException;

public class SQLCommonDao extends SQLDao implements CommonDao {

	public SQLCommonDao() throws DAOException {
		super();
	}

	@Override
	public boolean authorization(String login, String password) throws DAOException {

		try {
			int x = 0;
			if (x > 0) {
				throw new IOException("IO message");
			}
		} catch (IOException e) {
			throw new DAOException("my messgae", e);
		}
		// STUB
		return true;
	}

	@Override
	public boolean registration(String login, String password) throws DAOException {
		return false;
	}

}
