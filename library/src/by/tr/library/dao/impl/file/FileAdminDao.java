package by.tr.library.dao.impl.file;

import by.tr.library.bean.Book;
import by.tr.library.dao.AdminDao;
import by.tr.library.dao.exception.DAOException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by Kirill Kaluga on 10.07.2016.
 */
public class FileAdminDao implements AdminDao {

    @Override
    public boolean blockUser(int idUser) throws DAOException {
        Path users = Paths.get("data" + File.separator + "db" + File.separator + "users.txt");
        String line;
        Charset charset = StandardCharsets.UTF_8;
        StringBuilder content = new StringBuilder("");

        if (Files.exists(users) && Files.isWritable(users)) {
            try (Scanner scanner = new Scanner(users)) {
                while (scanner.hasNext()) {
                    line = scanner.nextLine();
                    if (line.startsWith(String.valueOf(idUser))) {
                        if (line.endsWith("blocked")) {
                            throw new DAOException("User blocked!");
                        }
                        content.append(line + " blocked.");
                        scanner.forEachRemaining(content::append);
                        Files.write(users, content.toString().getBytes(charset));
                        return true;
                    }
                }
                return false;
            }
            catch (IOException e) {
                throw new DAOException(e.getMessage());
            }
        }
        else if (!Files.exists(users)){
            throw new DAOException("Filed doesn't exist");
        }
        else {
            throw new DAOException("Filed doesn't readable.");
        }
    }

    @Override
    public boolean unBlockUser(int idUser) throws DAOException {
        Path users = Paths.get("data" + File.separator + "db" + File.separator + "users.txt");
        String line;
        Charset charset = StandardCharsets.UTF_8;
        StringBuilder content = new StringBuilder("");

        if (Files.exists(users) && Files.isWritable(users)) {
            try (Scanner scanner = new Scanner(users)) {
                while (scanner.hasNext()) {
                    line = scanner.nextLine();
                    if (line.startsWith(String.valueOf(idUser))) {
                        if (line.endsWith("blocked")) {
                            content.append(line.replace(" blocked", ""));
                            scanner.forEachRemaining(content::append);
                            Files.write(users, content.toString().getBytes(charset));
                            return true;
                        }
                        throw new DAOException("User is not blocked!");
                    }
                }
                return false;
            }
            catch (IOException e) {
                throw new DAOException(e.getMessage());
            }
        }
        else if (!Files.exists(users)){
            throw new DAOException("Filed doesn't exist");
        }
        else {
            throw new DAOException("Filed doesn't readable.");
        }
    }

    @Override
    public boolean deleteUser(int idUser) throws DAOException{
        Path users = Paths.get("data" + File.separator + "db" + File.separator + "users.txt");
        String line;
        Charset charset = StandardCharsets.UTF_8;
        StringBuilder content = new StringBuilder("");
        if (Files.exists(users) && Files.isWritable(users)){
            try (Scanner scanner = new Scanner(users)) {
                while (scanner.hasNext()) {
                    line = scanner.nextLine();
                    if (line.startsWith(String.valueOf(idUser))) {
                        scanner.forEachRemaining(content::append);
                        Files.write(users, content.toString().getBytes(charset));
                        return true;
                    }
                }
                throw new DAOException("User doesn't exist.");
            }
            catch (IOException e) {
                throw new DAOException(e.getMessage());
            }
        }
        else if (!Files.exists(users)){
            throw new DAOException("Filed doesn't exist.");
        }
        else {
            throw new DAOException("Filed doesn't readable.");
        }
    }

    @Override
    public boolean addNewBook(Book book) throws DAOException {
        Path books = Paths.get("data" + File.separator + "db" + File.separator + "books.txt");

        if (Files.exists(books) && Files.isWritable(books)){
            try {
                Files.write(books, book.toString().getBytes(), StandardOpenOption.APPEND);
                return true;
            }catch (IOException e) {
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

    @Override
    public boolean deleteBook(String title) throws DAOException {
        Path books = Paths.get("data" + File.separator + "db" + File.separator + "books.txt");
        String line;
        Charset charset = StandardCharsets.UTF_8;
        StringBuilder content = new StringBuilder("");

        if (Files.exists(books) && Files.isWritable(books)){
            try (Scanner scanner = new Scanner(books)) {
                while (scanner.hasNext()) {
                    line = scanner.nextLine();
                    String[] bookParams = line.split(" ");
                    String bookTitle = bookParams[1];
                    if ((title.trim().replace(' ', '_')).equals(bookTitle)){
                        scanner.forEachRemaining(content::append);
                        Files.write(books, content.toString().getBytes(charset));
                        return true;
                    }
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

