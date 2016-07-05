package by.epam.notebooks.controller;

import by.epam.notebooks.dao.DataProvider;
import by.epam.notebooks.view.NoteBookConsoleView;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by Kirill_Kaluga on 6/29/2016.
 */
public class ConsoleGUI {
    public void work(String[] args){
        Date date = null;
        DataProvider dataProvider = DataProvider.getInstance();
        NoteBookProvider noteBookProvider = NoteBookProvider.getInstance();
        String input = "";
        int choice;
        boolean f = true, pars;
        dataProvider.setFolder();
        dataProvider.readFiles();
        NoteBookConsoleView.print();
        Scanner scan = new Scanner(System.in);
        //there is interface
        System.out.println("Hello. This is Notebooks Holder v0.3.1");
        do {

            System.out.println("Menu. Enter the correct number to select the desired item:");
            System.out.println("1. print all");
            System.out.println("9. exit");

            while (!scan.hasNextInt()) {
                System.out.println("WARN: Please, enter the correct number");
                scan.next();
            }
            choice = scan.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    NoteBookConsoleView.print();
                    System.out.print("Ready. ");
                    break;

//                case 2:
//                    System.out.println("");
//                    System.out.println("");
//                    //checker
//                    break;
//
//                case 3:
//                    System.out.println("");
//                    System.out.println("");
//                    scan.nextLine();
//                    break;
//
//                case 4:
//                    System.out.println("");
//                    scan.nextLine();
//                    break;
//
//                case 5:
//                    System.out.println("");
//                    scan.nextLine();
//                    break;

                case 9:
                    f = false;
                    System.out.println("Bye-Bye.");
                    scan.nextLine();
                    break;

                default:
                    System.out.println("Wrong Entry.");
                    scan.nextLine();
                    break;
            }
            //waiting
            System.out.println("Type enter to continue.");
            scan.nextLine();
        } while (f);
    }
}
