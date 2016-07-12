package by.tr.library.dao.impl;

import by.tr.library.dao.impl.file.*;
import by.tr.library.dao.impl.file.FileAdmin.FileAdminBookAddDaoTest;
import by.tr.library.dao.impl.file.FileAdmin.FileAdminBookDeleteDaoTest;
import by.tr.library.dao.impl.file.FileAdmin.FileAdminUserDaoTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Kirill Kaluga on 12.07.2016.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        FileCommonDaoTest.class,
        FileAdminUserDaoTest.class,
        FileAdminBookAddDaoTest.class,
        FileUserDaoTest.class,
        FileAdminBookDeleteDaoTest.class
})
public class FileDaoSuite {

}
