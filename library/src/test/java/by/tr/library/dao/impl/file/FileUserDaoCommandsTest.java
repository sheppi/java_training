package by.tr.library.dao.impl.file;

import by.tr.library.bean.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Request;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by Kirill Kaluga on 12.07.2016.
 */
public class FileUserDaoCommandsTest {

    private Path test_path;
    private FileAdminDao adminDao;
    private FileCommonDao commonDao;
    private String login;
    private String password;

    public FileUserDaoCommandsTest() {
        test_path = Paths.get("data" + File.separator + "test" + File.separator + "test_users.txt");
        adminDao = new FileAdminDao();
        commonDao = new FileCommonDao();
        adminDao.setUsers(test_path);
        commonDao.setUsers(test_path);
        login = "testlogin";
        password = "testpassword";
    }

    @Test
    public void testRegistration() throws Exception {
        assertTrue(commonDao.registration(login, password));
        String result = new String(Files.readAllBytes(test_path));
        assertTrue(result.contains(login + ' ' + password));
    }

    @Test
    public void testAuthorization() throws Exception {
        assertTrue(commonDao.authorization(login, password));
    }


    @Test
    public void testBlockUser() throws Exception {
        int idUser = 1;
        assertTrue(adminDao.blockUser(idUser));
        String result = new String(Files.readAllBytes(test_path));
        String 
        assertTrue(result.contains(login + ' ' + password + " blocked"));
    }

    @Test
    public void testUnblockUser() throws Exception {

    }

    @Test
    public void deleteUser() throws Exception {

    }

}