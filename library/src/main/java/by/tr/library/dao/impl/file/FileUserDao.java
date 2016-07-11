package by.tr.library.dao.impl.file;

import by.tr.library.bean.Book;
import by.tr.library.bean.ProgrammerBook;
import by.tr.library.dao.UserDao;
import by.tr.library.dao.exception.DAOException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Kirill Kaluga on 10.07.2016.
 */
public class FileUserDao implements UserDao {

    @Override
    public List<Book> getCatalog() throws DAOException {
        Path books = Paths.get("data" + File.separator + "db" + File.separator + "books.txt");
        String line;
        ArrayList<Book> catalog = new ArrayList<>();
        Book book;

        if (Files.exists(books) && Files.isReadable(books)) {
            try (Scanner scanner = new Scanner(books)) {
                while (scanner.hasNext()) {
                    line = scanner.nextLine();
                    String[] bookParams = line.split(" ");
                    String author = bookParams[0];
                    String title = bookParams[1];
                    int price = Integer.parseInt(bookParams[2]);
                    if (bookParams.length < 4){
                        book = new Book(author, title, price);
                    }
                    else{
                        String language = bookParams[3];
                        String level = bookParams[4];
                        book = new ProgrammerBook(author, title, price, language, level);
                    }
                    catalog.add(book);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (!Files.exists(books)){
            throw new DAOException("Filed doesn't exist");
        }
        else {
            throw new DAOException("Filed doesn't readable.");
        }
        return catalog;
    }

    @Override
    public Book getBookByTitle(String title) throws DAOException {
        Path books = Paths.get("data" + File.separator + "db" + File.separator + "books.txt");
        String line; Book book;

        if (Files.exists(books) && Files.isReadable(books)) {
            try (Scanner scanner = new Scanner(books)) {
                while (scanner.hasNext()) {
                    line = scanner.nextLine();
                    String[] bookParams = line.split(" ");
                    String bookTitle = bookParams[1];
                    if ((title.trim().replace(' ', '_')).equals(bookTitle)){
                        String author = bookParams[0];
                        int price = Integer.parseInt(bookParams[2]);
                        if (bookParams.length < 4){
                            book = new Book(author, bookTitle, price);
                        }
                        else{
                            String language = bookParams[3];
                            String level = bookParams[4];
                            book = new ProgrammerBook(author, bookTitle, price, language, level);
                        }
                        return book;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (!Files.exists(books)){
            throw new DAOException("Filed doesn't exist");
        }
        else {
            throw new DAOException("Filed doesn't readable.");
        }
        return null;
    }
}
