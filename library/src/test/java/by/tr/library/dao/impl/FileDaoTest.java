package by.tr.library.dao.impl;

import by.tr.library.bean.Book;
import by.tr.library.bean.ProgrammerBook;
import by.tr.library.dao.impl.file.FileAdminDao;
import by.tr.library.dao.impl.file.FileCommonDao;
import by.tr.library.dao.impl.file.FileUserDao;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Kirill Kaluga on 12.07.2016.
 */
public abstract class FileDaoTest {
    protected Path path_users;
    protected Path path_books;
    protected FileAdminDao adminDao;
    protected FileCommonDao commonDao;
    protected FileUserDao userDao;
    protected String login;
    protected String password;
    protected Book book;
    protected ProgrammerBook programmerBook;
    protected String author;
    protected String title;
    protected String programmerTitle;
    protected int price;
    protected String language;
    protected String level;

    public FileDaoTest() {
        path_users = Paths.get("data" + File.separator + "test" + File.separator + "test_users.txt");
        path_books = Paths.get("data" + File.separator + "test" + File.separator + "test_books.txt");
        adminDao = new FileAdminDao();
        commonDao = new FileCommonDao();
        userDao = new FileUserDao();
        adminDao.setUsers(path_users);
        commonDao.setUsers(path_users);
        userDao.setUsers(path_users);
        adminDao.setBooks(path_books);
        commonDao.setBooks(path_books);
        userDao.setBooks(path_books);
        login = "testlogin";
        password = "testpassword";
        author = "test_author";
        title = "test_book";
        programmerTitle = "test_programmerBook";
        price = 10;
        language = "C";
        level = "novice";
        book = new Book(author, title, price);
        programmerBook = new ProgrammerBook(author, programmerTitle, price, language, level);
    }
}
