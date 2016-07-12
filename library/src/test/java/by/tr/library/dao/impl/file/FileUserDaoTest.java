package by.tr.library.dao.impl.file;

import by.tr.library.bean.Book;
import by.tr.library.dao.impl.FileDaoTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Kirill Kaluga on 12.07.2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FileUserDaoTest extends FileDaoTest {

    @Test
    public void test7_getBookByTitle() throws Exception {
        Book resultBook = userDao.getBookByTitle(title);
        boolean result = book.equals(resultBook);
        assertTrue(result);

        resultBook = userDao.getBookByTitle(programmerTitle);
        result = programmerBook.equals(resultBook);
        assertTrue(result);


    }

    @Test
    public void test8_getCatalog() throws Exception {
        List<Book> expectedList = new ArrayList<>();
        expectedList.add(book);
        expectedList.add(programmerBook);

        List<Book> resultList = userDao.getCatalog();
        int n = resultList.size();
        List<Book> expectedResultList = resultList.subList(n-2, n);
        boolean result = expectedResultList.equals(expectedList);
        assertTrue(result);
    }

}