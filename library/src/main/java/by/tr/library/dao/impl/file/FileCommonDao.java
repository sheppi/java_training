package by.tr.library.dao.impl.file;

import by.tr.library.dao.CommonDao;
import by.tr.library.dao.exception.DAOException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by Kirill Kaluga on 10.07.2016.
 */
public class FileCommonDao implements CommonDao {

    @Override
    public boolean authorization(String login, String password) throws DAOException {

        Path users = Paths.get("data" + File.separator + "db" + File.separator +"users.txt");
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
                e.printStackTrace();
            }
        }
        else if (!Files.exists(users)){
            throw new DAOException("Filed doesn't exist");
        }
        else {
            throw new DAOException("Filed doesn't readable.");
        }
        return false;
    }



}
