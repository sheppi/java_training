package by.tr.library.dao.datatype;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Kirill Kaluga on 12.07.2016.
 */
public abstract class FileDao {

    protected Path users;
    protected Path books;

    public FileDao(){
        users = Paths.get("data" + File.separator + "db" + File.separator + "users.txt");
        books = Paths.get("data" + File.separator + "db" + File.separator + "books.txt");
    }

    public Path getUsers() {
        return users;
    }

    public void setUsers(Path users) {
        this.users = users;
    }

    public Path getBooks() {
        return books;
    }

    public void setBooks(Path books) {
        this.books = books;
    }
}
