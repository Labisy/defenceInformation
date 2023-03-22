package ru.stepchenkov.labs.lab5;

import ru.stepchenkov.labs.lab5.controller.CoderController;
import ru.stepchenkov.labs.lab5.model.EncryptModel;
import ru.stepchenkov.labs.lab5.view.CoderView;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        EncryptModel model = new EncryptModel();
        CoderController controller = new CoderController(model);
        CoderView view = new CoderView(controller);
        SwingUtilities.invokeLater(view::init);
    }
}
