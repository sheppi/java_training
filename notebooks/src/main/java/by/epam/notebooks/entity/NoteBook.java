package by.epam.notebooks.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Kirill_Kaluga on 6/29/2016.
 */
public class NoteBook {
    private UUID uuid;
    private String name;
    private int maxSize;
    private List<Note> notes;

    public NoteBook(UUID uuid) {
        this.name = null;
        this.uuid = uuid;
        this.notes = new ArrayList<>();
        this.maxSize = -1;
    }

    public boolean isFull() {
        return (notes.size()<maxSize) || (maxSize == 1);
    }

    public boolean write(String note) {
        notes.add(new Note(note));
        return true;
    }

    public boolean write(Date date, Date lastChanged, String note) {
        notes.add(new Note(date, lastChanged, note));
        return true;
    }

    public String getName() {
        return name;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }


    public UUID getUuid() {
        return uuid;
    }

    //functionality

    //@Override

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        NoteBook noteBook = (NoteBook) o;

        return new EqualsBuilder()
                .append(name, noteBook.name)
                .append(uuid, noteBook.uuid)
                .append(notes, noteBook.notes)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(uuid)
                .append(notes)
                .toHashCode();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("");
        if (!name.equals("")) {
            result.append("name: ").append(name).append("; ");
        }
        result.append("uuid: ").append(uuid).append("; ")
                .append("maxSize: ").append(maxSize).append("; ");
        for (int i = 0; i < notes.size(); i++){
            result.append(i).append(". ").append(notes.get(i).toString()).append("\n");
        }
        return result.toString();
    }


    public String notesToString(int... numNote) {
        StringBuilder result = new StringBuilder("");
        for (int num: numNote){
            result.append(num).append(". ").append(notes.get(num).toString()).append("\n");
        }
        return result.toString();
    }
}
