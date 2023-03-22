package ru.stepchenkov.labs.lab5.view;

import ru.stepchenkov.labs.lab5.controller.CoderController;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CoderView extends JFrame {

    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 300;
    public static final int DIVIDER = 2;
    private CoderController controller;
    private JTextField inputField;
    private JTextField keyField;
    private JTextField outputField;
    private JButton clearButton;
    private JButton encryptButton;
    private JButton decryptButton;

    public CoderView(CoderController controller) {
        this.controller = controller;
    }

    public void init() {
        defaultWindowParams();
        add(createMainPanel());

        encryptButton.addActionListener(e -> {
            controller.getRandomNumberInts();
            String key = Arrays.stream(controller.getModel().getKeySet()).boxed().map(String::valueOf).collect(Collectors.joining());
            keyField.setText(key);

            outputField.setText(controller.encrypt(inputField.getText()));
        });

        decryptButton.addActionListener(e -> {

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
        setTitle("lab5");
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        panel.setPreferredSize(new Dimension(400, 400));

        JLabel inputInfo = new JLabel("Введите исходную строчку");
        JLabel keyInfo = new JLabel("Введите ключ");
        JLabel outputInfo = new JLabel("Зашифрованная строка");
        inputField = new JTextField("Введите текст");
        outputField = new JTextField("результат шифрования");
        keyField = new JTextField("Введите ключ");
        clearButton = new JButton("Очистить");
        encryptButton = new JButton("Шифровать");
        decryptButton = new JButton("Дешифровать");

        inputInfo.setBounds(50, 50, 170, 20);
        keyInfo.setBounds(50, 100, 150, 20);
        outputInfo.setBounds(260, 100, 150, 20);
        inputField.setBounds(50, 75, 200, 20);
        outputField.setBounds(260, 125, 200, 20);
        keyField.setBounds(50, 125, 200, 20);
        clearButton.setBounds(310, 175, 140, 20);
        encryptButton.setBounds(50, 175, 120, 20);
        decryptButton.setBounds(180, 175, 120, 20);

        panel.add(inputInfo);
        panel.add(keyInfo);
        panel.add(outputInfo);
        panel.add(inputField);
        panel.add(outputField);
        panel.add(keyField);
        panel.add(clearButton);
        panel.add(encryptButton);
        panel.add(decryptButton);

        return panel;
    }
}
