package ru.stepchenkov.labs.lab2;

import ru.stepchenkov.labs.lab2.controller.VegenenerController;
import ru.stepchenkov.labs.lab2.model.Vegener;
import ru.stepchenkov.labs.lab2.view.VegenerView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Vegener vegener = new Vegener(1072, 33);
        VegenenerController vigenenerController = new VegenenerController(vegener);
        VegenerView view = new VegenerView(vigenenerController);
        SwingUtilities.invokeLater(view::init);
    }
}
