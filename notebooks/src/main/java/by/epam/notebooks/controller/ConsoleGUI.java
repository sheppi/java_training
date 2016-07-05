package by.epam.notebooks.controller;

import by.epam.notebooks.dao.DataProvider;

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

        Scanner scan = new Scanner(System.in);
        //there is interface
        System.out.println("Hello. This is Notebooks Holder v0.3.1");
        do {

            System.out.println("Menu. Enter the correct number to select the desired item:");
            System.out.println("1. set all negotiators on all dates.");
            System.out.println("2. set particular date.");
            System.out.println("3. set particular negotiator.");
            System.out.println("4. report");
            System.out.println("5. (not ready) report to emails");
            System.out.println("6. exit");

            while (!scan.hasNextInt()) {
                System.out.println("WARN: Please, enter the correct number");
                scan.next();
            }
            choice = scan.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    System.out.println("Setting all negotiators on all dates...");
                    System.out.print("Ready. ");
                    break;

                case 2:
                    System.out.println("Setting on particular date.");
                    System.out.println("Type the date at MM/DD/YYYY format, please:");
                    //checker
                    break;

                case 3:
                    System.out.println("Setting on particular negotiator.");
                    System.out.println("Type name of negotiator, please:");
                    scan.nextLine();
                    break;

                case 4:
                    System.out.println("Reporting...");
                    scan.nextLine();
                    break;

                case 5:
                    System.out.println("This functionality is not yet ready.");
                    scan.nextLine();
                    break;

                case 6:
                    f = false;
                    if (true){
                        System.out.println("Session ended successfully.");
                    }
                    else{
                        System.out.println("There are some errors at session ending. Please, check logs for detail info.");
                    }
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
