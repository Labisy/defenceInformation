package ru.stepchenkov.labs.lab1;

import ru.stepchenkov.labs.lab1.controller.VerticalController;
import ru.stepchenkov.labs.lab1.view.VerticalView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        VerticalController controller = new VerticalController();
        VerticalView view = new VerticalView(controller);
        SwingUtilities.invokeLater(view::init);
    }
}
