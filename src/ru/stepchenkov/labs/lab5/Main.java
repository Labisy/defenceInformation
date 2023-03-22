package ru.stepchenkov.labs.lab5;

import ru.stepchenkov.labs.lab5.controller.CoderController;
import ru.stepchenkov.labs.lab5.view.CoderView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        CoderController controller = new CoderController();
        CoderView view = new CoderView(controller);
        SwingUtilities.invokeLater(view::init);
    }
}
