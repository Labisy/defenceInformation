package ru.stepchenkov.labs.lab4.view;

import ru.stepchenkov.labs.lab4.controller.GfgController;
import ru.stepchenkov.labs.lab4.model.GfgModel;

import javax.swing.*;
import java.awt.*;

public class GfgView extends JFrame {

    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 300;
    public static final int DIVIDER = 2;
    private GfgController controller;
    private JTextField aField;
    private JTextField bField;
    private JTextField mField;
    private JTextField y0Field;
    private JTextField inputField;
    private JTextField outputField;
    private JButton clearButton;
    private JButton encryptButton;
    private JButton decryptButton;
    public GfgView(GfgController controller) {
        this.controller = controller;
    }

    public void init() {
        defaultWindowParams();
        add(createMainPanel());

        encryptButton.addActionListener(e -> {
            int a = Integer.parseInt(aField.getText());
            int b = Integer.parseInt(bField.getText());
            int m = Integer.parseInt(mField.getText());
            int y = Integer.parseInt(y0Field.getText());
            controller.setModel(new GfgModel(a, b, m, y, new int[inputField.getText().length()]));
            outputField.setText(controller.encrypt(inputField.getText()));
        });

        decryptButton.addActionListener(e -> {
            outputField.setText(controller.decrypt(outputField.getText()));
        });

        clearButton.addActionListener(e -> {
            inputField.setText("");
            outputField.setText("");
        });

        setVisible(true);
    }

    private void defaultWindowParams() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int positionWidth = screenSize.width / DIVIDER - WINDOW_WIDTH / DIVIDER;
        int positionHeight = screenSize.height / DIVIDER - WINDOW_HEIGHT / DIVIDER;

        setBounds(positionWidth, positionHeight, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("lab4");
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        panel.setPreferredSize(new Dimension(400, 400));

        aField = new JTextField("");
        bField = new JTextField("");
        mField = new JTextField("");
        y0Field = new JTextField("");
        JLabel a = new JLabel("A");
        JLabel b = new JLabel("B");
        JLabel m = new JLabel("M");
        JLabel y0 = new JLabel("Y0");
        inputField = new JTextField("Введите текст");
        outputField = new JTextField("результат шифрования");
        clearButton = new JButton("Очистить");
        encryptButton = new JButton("Шифровать");
        decryptButton = new JButton("Дешифровать");

        aField.setBounds(70, 50, 50, 20);
        bField.setBounds(170, 50, 50, 20);
        mField.setBounds(270, 50, 50, 20);
        y0Field.setBounds(370, 50, 50, 20);
        a.setBounds(50, 50, 50, 20);
        b.setBounds(150, 50, 50, 20);
        m.setBounds(250, 50, 50, 20);
        y0.setBounds(350, 50, 50, 20);
        inputField.setBounds(70, 100, 200, 20);
        outputField.setBounds(70, 125, 200, 20);
        clearButton.setBounds(280, 150, 140, 20);
        encryptButton.setBounds(280, 100, 140, 20);
        decryptButton.setBounds(280, 125, 140, 20);

        panel.add(aField);
        panel.add(bField);
        panel.add(mField);
        panel.add(y0Field);
        panel.add(a);
        panel.add(b);
        panel.add(m);
        panel.add(y0);
        panel.add(inputField);
        panel.add(outputField);
        panel.add(clearButton);
        panel.add(encryptButton);
        panel.add(decryptButton);

        return panel;
    }
}
