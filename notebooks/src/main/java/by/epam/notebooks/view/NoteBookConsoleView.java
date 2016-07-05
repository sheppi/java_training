package by.epam.notebooks.view;

import by.epam.notebooks.controller.NoteBookProvider;

import java.util.UUID;

/**
 * Created by Kirill_Kaluga on 6/30/2016.
 */
public class NoteBookConsoleView {
    private static NoteBookProvider provider = NoteBookProvider.getInstance();

    //all notebooks and notes
    public static void print(){
        System.out.println(provider.allNotebooksToString());
    }

    //all notes of certain notebooks
    public static void print(UUID... id){
        for (UUID currID : id){
            System.out.println(provider.notebookToString(currID));
        }
    }

    //certain notebook, certain note(s)
    public static void print(UUID id, int... numNote){
        System.out.println(provider.notesToString(id, numNote));
    }


}
