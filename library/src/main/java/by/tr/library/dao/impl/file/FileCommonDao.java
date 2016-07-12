package by.tr.library.dao.impl.file;

import by.tr.library.dao.CommonDao;
import by.tr.library.dao.datatype.FileDao;
import by.tr.library.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 * Created by Kirill Kaluga on 10.07.2016.
 */
public class FileCommonDao extends FileDao implements CommonDao {

    private static final Logger LOG = LogManager.getRootLogger();

    @Override
    public boolean authorization(String login, String password) throws DAOException {
        String line;

        if (Files.exists(users) && Files.isReadable(users)){
            try (Scanner scanner = new Scanner(users)) {
                while (scanner.hasNext()){
                    line = scanner.nextLine();
                    if (line.contains(login + " " + password)){
                        if (line.endsWith("blocked")){
                            throw new DAOException("User blocked!");
                        }
                        return true;
                    }
                }
                LOG.error("FileCommonDao: authorization failed. This login doesn't exist.");
                throw new DAOException("This login doesn't exist.");
            } catch (IOException e) {
                LOG.error("FileCommonDao: authorization failed. Exception: " + e.getMessage());
                throw new DAOException(e.getMessage());
            }
        }
        else if (!Files.exists(users)){
            LOG.error("FileCommonDao: authorization failed. Filed doesn't exist");
            throw new DAOException("File doesn't exist");
        }
        else {
            LOG.error("FileCommonDao: authorization failed. Filed doesn't writable.");
            throw new DAOException("File doesn't writable.");
        }
    }

    @Override
    public boolean registration(String login, String password) throws DAOException {
        String line;
        int lastId = 0;

        if (Files.exists(users) && Files.isReadable(users) && Files.isWritable(users)){
            try (Scanner scanner = new Scanner(users)) {
                while (scanner.hasNext()){
                    line = scanner.nextLine();
                    if (line.contains(login + " " + password)){
                        throw new DAOException("User already exist");
                    }
                    String[] params = line.split(" ");
                    lastId = Integer.parseInt(params[0]);
                }
                String user = String.valueOf(lastId+1) + ' ' + login + ' ' + password + '\n';
                Files.write(users, user.getBytes(), StandardOpenOption.APPEND);
                return true;
            } catch (IOException e) {
                LOG.error("FileCommonDao: registration failed. Exception: " + e.getMessage());
                throw new DAOException(e.getMessage());
            }
        }
        else if (!Files.exists(users)){
            LOG.error("FileCommonDao: registration failed. Filed doesn't exist");
            throw new DAOException("File doesn't exist");
        }
        else {
            LOG.error("FileCommonDao: registration failed. Filed doesn't writable.");
            throw new DAOException("File doesn't writable.");
        }
    }


}
