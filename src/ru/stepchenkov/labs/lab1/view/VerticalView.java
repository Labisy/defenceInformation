package ru.stepchenkov.labs.lab1.view;

import ru.stepchenkov.labs.lab1.controller.VerticalController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VerticalView extends JFrame {

    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 300;
    public static final int DIVIDER = 2;
    private VerticalController controller;
    private JButton encryptionButton;
    private JButton clearButton;
    private JButton decryptionButton;
    private JTextField keyField;
    private JTextField inputField;
    private JTextField outputField;
    private JLabel keyInfo;
    private JTable table;
    private DefaultTableModel tableModel;

    public VerticalView(VerticalController controller) {
        this.controller = controller;
        tableModel = new DefaultTableModel();
    }

    public void init() {
        defaultWindowParams();
        add(createMainPanel());

        encryptionButton.addActionListener(e -> {
            String[][] resultTable = controller.getTable(inputField.getText(), keyField.getText().length());
            String[] columnName = keyField.getText().split("");
            tableModel = new DefaultTableModel(resultTable, columnName);
            table.setModel(tableModel);

            outputField.setText(controller.encrypt(resultTable, keyField.getText()));
        });

        decryptionButton.addActionListener(e -> {
            String[][] resultTable = controller.getOutputTable(outputField.getText(), keyField.getText());
            String[] columnName = keyField.getText().split("");
            tableModel = new DefaultTableModel(resultTable, columnName);
            table.setModel(tableModel);

            outputField.setText(controller.decrypt(resultTable, keyField.getText().length()));
        });

        clearButton.addActionListener(e -> {
            inputField.setText("");
            outputField.setText("");
            tableModel = new DefaultTableModel();
            table.setModel(tableModel);
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
        setTitle("Вертикальное");
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        panel.setPreferredSize(new Dimension(400, 400));

        encryptionButton = new JButton("Шифрование");
        decryptionButton = new JButton("Дешифрование");
        clearButton = new JButton("Очистить");
        keyField = new JTextField(20);
        keyInfo = new JLabel("Ключ");
        inputField = new JTextField("Введите текст");
        outputField = new JTextField("Результат шифрования");
        table = new JTable(tableModel);

        encryptionButton.setBounds(280, 180, 150, 20);
        decryptionButton.setBounds(280, 150, 150, 20);
        clearButton.setBounds(280, 210, 150, 20);
        keyField.setBounds(320, 100, 100, 20);
        keyInfo.setBounds(280, 100, 150, 20);
        inputField.setBounds(60, 30, 350, 20);
        outputField.setBounds(60, 50, 350, 20);
        table.setBounds(20, 120, 250, 120);

        panel.add(encryptionButton);
        panel.add(clearButton);
        panel.add(keyField);
        panel.add(keyInfo);
        panel.add(inputField);
        panel.add(outputField);
        panel.add(decryptionButton);
        panel.add(table);

        return panel;
    }
}
