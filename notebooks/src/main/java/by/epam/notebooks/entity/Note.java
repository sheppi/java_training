package by.epam.notebooks.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Kirill_Kaluga on 6/29/2016.
 */
public class Note {
    private Date date;
    private Date lastChanged;
    private boolean changed;
    private String note;


    public Note(String text) {
        date = lastChanged = Calendar.getInstance().getTime();
        this.note = text;
        this.changed = true;
    }

    public Note(Date date, Date lastChanged, String note) {
        this.date = date;
        this.lastChanged = lastChanged;
        this.note = note;
        this.changed = false;
    }

    //setters

    public void setNote(String note) {
        this.changed = true;
        this.note = note;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    //getters

    public boolean isChanged() {
        return changed;
    }

    //functionality



    //@Override


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        return new EqualsBuilder()
                .append(date, note.date)
                .append(lastChanged, note.lastChanged)
                .append(this.note, note.note)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(date)
                .append(lastChanged)
                .append(note)
                .toHashCode();
    }

    @Override
    public String toString() {
        String answer = "created: " + date +
                " last changed: " + lastChanged +
                " note: " + note +
                " is changed: " + changed;
        changed = false;
        return answer;
    }
}
