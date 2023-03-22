package ru.stepchenkov.labs.lab3;

import ru.stepchenkov.labs.lab3.controller.EncryptoController;
import ru.stepchenkov.labs.lab3.view.EncryptoView;
import ru.stepchenkov.labs.lab3.model.Vegener;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Vegener vegener = new Vegener(1072, 33);
        EncryptoController encryptoController = new EncryptoController(vegener);
        EncryptoView view = new EncryptoView(encryptoController);
        SwingUtilities.invokeLater(view::init);
    }
}
