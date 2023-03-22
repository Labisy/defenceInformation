package ru.stepchenkov.labs.lab4;

import ru.stepchenkov.labs.lab4.controller.GfgController;
import ru.stepchenkov.labs.lab4.view.GfgView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GfgController gfg = new GfgController();
        GfgView view = new GfgView(gfg);
        SwingUtilities.invokeLater(view::init);
    }
}
