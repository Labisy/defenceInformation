package ru.stepchenkov.labs.lab2.view;

import ru.stepchenkov.labs.lab2.controller.VegenenerController;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Toolkit;

public class VegenerView extends JFrame {

    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 300;
    public static final int DIVIDER = 2;
    private VegenenerController controller;
    private JButton encryptionButton;
    private JButton clearButton;
    private JButton decryptionButton;
    private JTextField keyField;
    private JTextField inputField;
    private JTextField outputField;
    private JLabel keyInfo;

    public VegenerView(VegenenerController controller) {
        this.controller = controller;
    }

    public void init() {
        defaultWindowParams();
        add(createMainPanel());

        encryptionButton.addActionListener(event -> {
            String result = controller.encrypt(inputField.getText(), keyField.getText());
            outputField.setText(result);
        });

        decryptionButton.addActionListener(e -> {
            String result = controller.decrypt(outputField.getText(), keyField.getText());
            outputField.setText(result);
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
        setTitle("Vegener");
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

        encryptionButton.setBounds(80, 150, 150, 20);
        decryptionButton.setBounds(260, 150, 150, 20);
        clearButton.setBounds(260, 210, 150, 20);
        keyField.setBounds(310, 100, 100, 20);
        keyInfo.setBounds(260, 100, 150, 20);
        inputField.setBounds(60, 30, 350, 20);
        outputField.setBounds(60, 50, 350, 20);

        panel.add(encryptionButton);
        panel.add(clearButton);
        panel.add(keyField);
        panel.add(keyInfo);
        panel.add(inputField);
        panel.add(outputField);
        panel.add(decryptionButton);

        return panel;
    }
}
