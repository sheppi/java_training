package by.epam.notebooks.runner;

import by.epam.notebooks.controller.ConsoleGUI;

/**
 * Created by Kirill_Kaluga on 6/29/2016.
 */
public class Runner {
    public static void main(String[] args) {
        ConsoleGUI gui = new ConsoleGUI();
        gui.work(args);
    }
}
