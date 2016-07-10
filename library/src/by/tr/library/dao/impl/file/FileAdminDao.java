package by.tr.library.dao.impl.file;

import by.tr.library.bean.Book;
import by.tr.library.dao.AdminDao;
import by.tr.library.dao.exception.DAOException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 * Created by Kirill Kaluga on 10.07.2016.
 */
public class FileAdminDao implements AdminDao {

    @Override
    public boolean blockUser(int idUser) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addNewBook(Book book) throws DAOException {
        Path books = Paths.get("data" + File.separator + "books.txt");
        String line;

        if (Files.exists(books) && Files.isWritable(books)){
            try {
                Files.write(books, book.toString().getBytes(), StandardOpenOption.APPEND);
            }catch (IOException e) {
                //exception handling left as an exercise for the reader
            }
        }
        else if (!Files.exists(books)){
            throw new DAOException("Filed doesn't exist");
        }
        else {
            throw new DAOException("Filed doesn't readable.");
        }
        return false;
    }

}

