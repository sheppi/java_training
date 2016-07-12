package by.tr.library.dao.impl.file;

import by.tr.library.dao.impl.FileDaoTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.nio.file.Files;

import static org.junit.Assert.*;

/**
 * Created by Kirill Kaluga on 12.07.2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FileCommonDaoTest extends FileDaoTest {

    @Test
    public void test1_Registration() throws Exception {
        assertTrue(commonDao.registration(login, password));
        String resultFile = new String(Files.readAllBytes(path_users));
        String expectedResult = login + ' ' + password;
        assertTrue(resultFile.contains(expectedResult));
    }

    @Test
    public void test2_Authorization() throws Exception {
        assertTrue(commonDao.authorization(login, password));
    }

}