package by.tr.library.dao.impl.file.FileAdmin;

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
public class FileAdminUserDaoTest extends FileDaoTest {

    @Test
    public void test3_BlockUser() throws Exception {
        int idUser = 2;
        assertTrue(adminDao.blockUser(idUser));
        String resultFile = new String(Files.readAllBytes(path_users));
        String expectedResult = login + ' ' + password + " blocked";
        assertTrue(resultFile.contains(expectedResult));
    }

    @Test
    public void test4_UnblockUser() throws Exception {
        int idUser = 2;
        assertTrue(adminDao.unBlockUser(idUser));
        String resultFile = new String(Files.readAllBytes(path_users));
        String expectedResult = login + ' ' + password;
        assertTrue(resultFile.contains(expectedResult));
    }

    @Test
    public void test5_DeleteUser() throws Exception {
        int idUser = 2;
        assertTrue(adminDao.deleteUser(idUser));
        String resultFile = new String(Files.readAllBytes(path_users));
        String expectedResult = login + ' ' + password;
        assertFalse(resultFile.contains(expectedResult));
    }

}