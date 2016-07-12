package by.tr.library.dao.impl.file;

import by.tr.library.bean.Book;
import by.tr.library.dao.AdminDao;
import by.tr.library.dao.datatype.FileDao;
import by.tr.library.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Created by Kirill Kaluga on 10.07.2016.
 */
public class FileAdminDao extends FileDao implements AdminDao {

    private static final Logger LOG = LogManager.getRootLogger();

    @Override
    public boolean blockUser(int idUser) throws DAOException {
        String line;
        boolean flag = false;
        Charset charset = StandardCharsets.UTF_8;
        StringBuilder content = new StringBuilder("");

        if (Files.exists(users) && Files.isWritable(users)) {
            try (Scanner scanner = new Scanner(users)) {
                while (scanner.hasNext()) {
                    line = scanner.nextLine();
                    if (!flag && line.startsWith(String.valueOf(idUser))) {
                        if (line.endsWith("blocked")) {
                            return false;
                        }
                        flag = true;
                        content.append(line).append(" blocked\n");
                    }
                    content.append(line).append('\n');
                }
                if (flag){
                    Files.write(users, content.toString().getBytes(charset));
                    return true;
                }
                LOG.error("FileAdminDao: blockUser failed. User not found.");
                throw new DAOException("User not found");
            }
            catch (IOException e) {
                LOG.error("FileAdminDao: blockUser failed. " + e.getMessage());
                throw new DAOException(e.getMessage());
            }
        }
        else if (!Files.exists(users)){
            LOG.error("FileAdminDao: blockUser failed. Filed doesn't exist");
            throw new DAOException("Filed doesn't exist");
        }
        else {
            LOG.error("FileAdminDao: blockUser failed. Filed doesn't writable.");
            throw new DAOException("Filed doesn't writable.");
        }
    }

    @Override
    public boolean unBlockUser(int idUser) throws DAOException {
        String line;
        boolean flag = false;
        Charset charset = StandardCharsets.UTF_8;
        StringBuilder content = new StringBuilder("");

        if (Files.exists(users) && Files.isWritable(users)) {
            try (Scanner scanner = new Scanner(users)) {
                while (scanner.hasNext()) {
                    line = scanner.nextLine();
                    if (!flag && line.startsWith(String.valueOf(idUser))) {
                        if (line.endsWith("blocked")) {
                            flag = true;
                            content.append(line.replace(" blocked", "")).append('\n');
                        }
                        else{
                            return false;
                        }
                    }
                    content.append(line).append('\n');
                }
                if (flag) {
                    Files.write(users, content.toString().getBytes(charset));
                    return true;
                }
                throw new DAOException("User not found!");
            }
            catch (IOException e) {
                throw new DAOException(e.getMessage());
            }
        }
        else if (!Files.exists(users)){
            LOG.error("FileAdminDao: unBlockUser failed. Filed doesn't exist");
            throw new DAOException("Filed doesn't exist");
        }
        else {
            LOG.error("FileAdminDao: ubBlockUser failed. Filed doesn't writable.");
            throw new DAOException("Filed doesn't writable.");
        }
    }

    @Override
    public boolean deleteUser(int idUser) throws DAOException{
        String line;
        boolean flag = false;
        Charset charset = StandardCharsets.UTF_8;
        StringBuilder content = new StringBuilder("");
        if (Files.exists(users) && Files.isWritable(users)) {
            try (Scanner scanner = new Scanner(users)) {
                while (scanner.hasNext()) {
                    line = scanner.nextLine();
                    if (!line.startsWith(String.valueOf(idUser))) {
                        content.append(line).append('\n');
                    }
                    else{
                        flag = true;
                    }
                }
                if (flag){
                    Files.write(users, content.toString().getBytes(charset));
                    return true;
                }
                throw new DAOException("User doesn't exist.");
            } catch (IOException e) {
                throw new DAOException(e.getMessage());
            }
        }
        else if (!Files.exists(users)){
            LOG.error("FileAdminDao: deleteUser failed. Filed doesn't exist");
            throw new DAOException("File doesn't exist");
        }
        else {
            LOG.error("FileAdminDao: deleteUser failed. Filed doesn't writable.");
            throw new DAOException("File doesn't writable.");
        }
    }

    @Override
    public boolean addNewBook(Book book) throws DAOException {
        if (Files.exists(books) && Files.isWritable(books)){
            try {
                Files.write(books, (book.toString() + '\n').getBytes(), StandardOpenOption.APPEND);
                return true;
            }catch (IOException e) {
                throw new DAOException(e.getMessage());
            }
        }
        else if (!Files.exists(books)){
            LOG.error("FileAdminDao: addNewBook failed. Filed doesn't exist");
            throw new DAOException("File doesn't exist");
        }
        else {
            LOG.error("FileAdminDao: addNewBook failed. Filed doesn't writable.");
            throw new DAOException("File doesn't writable.");
        }
    }

    @Override
    public boolean deleteBook(String title) throws DAOException {
        String line;
        boolean flag = false;
        Charset charset = StandardCharsets.UTF_8;
        StringBuilder content = new StringBuilder("");

        if (Files.exists(books) && Files.isWritable(books)){
            try (Scanner scanner = new Scanner(books)) {
                while (scanner.hasNext()) {
                    line = scanner.nextLine();
                    String[] bookParams = line.split(" ");
                    String bookTitle = bookParams[1];
                    if (!(title.trim().replace(' ', '_')).equals(bookTitle)){
                        content.append(line).append('\n');
                    }
                    else{
                        flag = true;
                    }
                }
                if (flag){
                    Files.write(users, content.toString().getBytes(charset));
                    return true;
                }
                throw new DAOException("Book doesn't exist.");
            }
            catch (IOException e) {
                throw new DAOException(e.getMessage());
            }
        }
        else if (!Files.exists(books)){
            throw new DAOException("Filed doesn't exist");
        }
        else {
            throw new DAOException("Filed doesn't readable.");
        }
    }


}

