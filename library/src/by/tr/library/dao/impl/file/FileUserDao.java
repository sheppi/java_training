package by.tr.library.dao.impl.file;

import by.tr.library.bean.Book;
import by.tr.library.dao.UserDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kirill Kaluga on 10.07.2016.
 */
public class FileUserDao implements UserDao {

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
