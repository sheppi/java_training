package by.epam.notebooks.controller;

import by.epam.notebooks.entity.NoteBook;
import by.epam.notebooks.service.NoteBooksHolder;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Kirill_Kaluga on 6/30/2016.
 */
public class NoteBookProvider {
    private static NoteBookProvider uniqueInstance;
    private NoteBooksHolder holder;
    private UUID lastID;

    private NoteBookProvider(){
        holder = new NoteBooksHolder();
        lastID = null;
    }

    public static NoteBookProvider getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new NoteBookProvider();
        }
        return uniqueInstance;
    }

    /**
     * Write note to last not full default notebook
     */
    public boolean writeNote(String note){
        NoteBook workbook = holder.get(lastID);
        if (workbook.isFull()){
            workbook = new NoteBook(UUID.randomUUID());
            lastID = workbook.getUuid();
            while (holder.get(workbook.getUuid()) != null){
                lastID = UUID.randomUUID();
            }
            workbook.setUuid(lastID);
            holder.put(lastID, workbook);
        }
        return workbook.write(note);
    }

    /**
     * Write note to certain notebook by notebook id
     */
    public boolean writeNote(UUID id, String note){
        NoteBook workbook = holder.get(id);
        if (workbook == null){
            workbook = new NoteBook(id);
            holder.put(id, workbook);
        }
        if (workbook.isFull()){
            return false;
        }
        return workbook.write(note);
    }

    public boolean writeNote(UUID id, Date date, Date lastChange, String note){
        NoteBook workbook = holder.get(id);
        if (workbook == null){
            workbook = new NoteBook(id);
            holder.put(id, workbook);
        }
        if (workbook.isFull()){
            return false;
        }
        return workbook.write(date, lastChange, note);
    }

    public boolean writeNotebook(UUID id, NoteBook noteBook){
        if (holder.get(id) == null){
            holder.put(id, noteBook);
            return true;
        }else{
            return false;
        }
    }

    public String notebookToString(UUID id){
        return holder.get(id).toString();
    }

    public String allNotebooksToString() { return holder.toString(); }

    public String notesToString(UUID id, int[] numNote) {
        return holder.get(id).notesToString(numNote);
    }
}
