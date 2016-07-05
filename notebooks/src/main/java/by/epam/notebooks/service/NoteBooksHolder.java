package by.epam.notebooks.service;

import by.epam.notebooks.entity.NoteBook;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Kirill_Kaluga on 7/5/2016.
 */
public class NoteBooksHolder {
    private HashMap<UUID, NoteBook> noteBooks;

    public NoteBooksHolder() {
        this.noteBooks = new HashMap<>();
    }

    public HashMap<UUID, NoteBook> getNoteBooks() {
        return noteBooks;
    }

    public void setNoteBooks(HashMap<UUID, NoteBook> noteBooks) {
        this.noteBooks = noteBooks;
    }

    public void put(UUID uuid, NoteBook noteBook){
        noteBooks.put(uuid, noteBook);
    }

    public NoteBook get(UUID uuid){
        return noteBooks.get(uuid);
    }

    public String allNotebooksToString() {
        return noteBooks.toString();
    }
}
