package by.tr.library.dao;

import by.tr.library.dao.impl.file.FileAdminDao;
import by.tr.library.dao.impl.file.FileCommonDao;
import by.tr.library.dao.impl.file.FileUserDao;
import by.tr.library.dao.impl.sql.SQLAdminDao;
import by.tr.library.dao.impl.sql.SQLCommonDao;
import by.tr.library.dao.impl.sql.SQLUserDao;

public class DAOFactory {
	private static final DAOFactory factory = new DAOFactory();
	
//	private final CommonDao commonDao = new SQLCommonDao();
//	private final UserDao userDao = new SQLUserDao();
//	private final AdminDao adminDao = new SQLAdminDao();

	private final CommonDao commonDao = new FileCommonDao();
	private final UserDao userDao = new FileUserDao();
	private final AdminDao adminDao = new FileAdminDao();
	
	private DAOFactory(){}
	
	
	public static DAOFactory getInstance(){
		return factory;
	}
	

	public CommonDao getCommonDao() {
		return commonDao;

	}

	public UserDao getUserDao() {

		return userDao;
	}

	public AdminDao getAdminDao() {
		return adminDao;

	}

}
