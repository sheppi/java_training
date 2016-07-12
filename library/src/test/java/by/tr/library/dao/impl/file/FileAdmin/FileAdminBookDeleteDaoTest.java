package by.tr.library.dao.impl.file.FileAdmin;

import by.tr.library.dao.impl.FileDaoTest;
import org.junit.Test;

import java.nio.file.Files;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Kirill Kaluga on 12.07.2016.
 */
public class FileAdminBookDeleteDaoTest extends FileDaoTest {
    @Test
    public void test9_DeleteBook() throws Exception {
        assertTrue(adminDao.deleteBook(title));
        String resultFile = new String(Files.readAllBytes(path_books));
        String expectedResult = book.toString();
        assertFalse(resultFile.contains(expectedResult));

        assertTrue(adminDao.deleteBook(programmerTitle));
        resultFile = new String(Files.readAllBytes(path_books));
        expectedResult = programmerBook.toString();
        assertFalse(resultFile.contains(expectedResult));
    }
}
