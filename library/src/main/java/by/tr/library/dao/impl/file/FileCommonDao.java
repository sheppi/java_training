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
            } catch (IOException e) {
                throw new DAOException(e.getMessage());
            }
        }
        else if (!Files.exists(users)){
            throw new DAOException("Filed doesn't exist.");
        }
        else {
            throw new DAOException("Filed doesn't readable.");
        }
        return false;
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
                    lastId = Integer.parseInt(line.substring(0,3));
                }
                String user = String.valueOf(lastId+1) + ' ' + login + ' ' + password + '\n';
                Files.write(users, user.getBytes(), StandardOpenOption.APPEND);
                return true;
            } catch (IOException e) {
                throw new DAOException(e.getMessage());
            }
        }
        else if (!Files.exists(users)){
            throw new DAOException("Filed doesn't exist.");
        }
        else {
            throw new DAOException("Filed doesn't readable or writable.");
        }
    }


}
