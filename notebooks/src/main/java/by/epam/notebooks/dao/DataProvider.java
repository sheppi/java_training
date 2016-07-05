package by.epam.notebooks.dao;


import by.epam.notebooks.entity.NoteBook;
import by.epam.notebooks.controller.NoteBookProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Kirill_Kaluga on 6/30/2016.
 */
public class DataProvider{
    private static DataProvider uniqueInstance;
    private String folderPath;
    private NoteBookProvider provider;

    //private XSSFWorkbook workbook;
    private File folder, file;

    private DataProvider(){
        folderPath = "data" + File.separator + "k1enote" + File.separator + "NoteBooksHolder.xlsx";
        provider = NoteBookProvider.getInstance();
    }

    public static DataProvider getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new DataProvider();
        }
        return uniqueInstance;
    }


    public boolean setFolder(String path){
        folderPath = path;
        File tempFolder = new File(folderPath);
        if (tempFolder.exists() && tempFolder.isDirectory()){
            folder = tempFolder;
            return true;
        } else {
            return false;
        }
    }


    public boolean setFolder() {
        folderPath = "data" + File.separator + "json";
        File tempFolder = new File(folderPath);
        if (tempFolder.exists() && tempFolder.isDirectory()){
            folder = tempFolder;
            return true;
        } else {
            return false;
        }
    }

    public boolean readFiles(){
//        try {
            File[] files = folder.listFiles();
            for (File file: files){
                if (!handle(file)){
                    System.out.println("There are some troubles at " + file.getAbsolutePath());
                }
            }
            //workbook = new XSSFWorkbook(fileInputStream);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            return false;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
//        return handle();
        return false;
    }

//    private boolean handle() {
//        Iterator<Sheet> it_sheets = workbook.sheetIterator();
//        Cell c; Row row; Date date, lastChangeDate; String note; Sheet sheet; UUID id;
//        while (it_sheets.hasNext()){
//            sheet = it_sheets.next();
//            id = UUID.fromString(sheet.getSheetName());
//            Iterator<Row> it = sheet.rowIterator();
//            it.next();
//            while(it.hasNext()){
//                row = it.next();
//                try {
//                    date = row.getCell(0).getDateCellValue();
//                    lastChangeDate = row.getCell(1).getDateCellValue();
//                    note = row.getCell(2).getStringCellValue();
//                    provider.writeNote(id, date, lastChangeDate, note);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        }
//        return true;
//    }

    private boolean handle(File file){
        String name, author, note; Date date, lastChangeDate; UUID id;
        NoteBook noteBook;
        try {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
                    .create();
            JsonReader reader = new JsonReader(new FileReader(file));
            noteBook = gson.fromJson(reader, NoteBook.class);
            return provider.writeNotebook(noteBook.getUuid(), noteBook);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean saveCurrent(NoteBook noteBook){
        try (Writer writer = new FileWriter(file)) {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
                    .create();
            gson.toJson(noteBook, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
