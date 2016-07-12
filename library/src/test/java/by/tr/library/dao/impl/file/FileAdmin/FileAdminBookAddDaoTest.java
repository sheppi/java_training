package by.tr.library.dao.impl.file.FileAdmin;

import by.tr.library.dao.impl.FileDaoTest;
import org.junit.Test;

import java.nio.file.Files;

import static org.junit.Assert.assertTrue;

/**
 * Created by Kirill Kaluga on 12.07.2016.
 */
public class FileAdminBookAddDaoTest extends FileDaoTest {
    @Test
    public void test6_AddNewBook() throws Exception {
        assertTrue(adminDao.addNewBook(book));
        assertTrue(adminDao.addNewBook(programmerBook));

        String resultFile = new String(Files.readAllBytes(path_books));
        String expectedResult = book.toString() + '\n' + programmerBook.toString();
        assertTrue(resultFile.contains(expectedResult));
    }
}
