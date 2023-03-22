package ru.stepchenkov.labs.lab3.view;

import ru.stepchenkov.labs.lab3.controller.EncryptoController;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicReference;

public class EncryptoView extends JFrame {

    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 300;
    public static final int DIVIDER = 2;
    private EncryptoController controller;
    private JButton encryptionButton;
    private JButton clearButton;
    private JButton decryptionButton;
    private JPasswordField keyFieldEncrypt;
    private JPasswordField keyFieldDecrypt;
    private JTextField inputField;
    private JTextField outputField;
    private JLabel keyInfo;
    private JLabel keyInfo2;

    public EncryptoView(EncryptoController controller) {
        this.controller = controller;
    }

    public void init() {
        defaultWindowParams();
        add(createMainPanel());
        AtomicReference<String> inputText = new AtomicReference<>("");
        AtomicReference<String> inputEncrypt = new AtomicReference<>("");

        encryptionButton.addActionListener(event -> {
            String keyEncrypt = keyFieldEncrypt.getText();
            inputText.set(inputField.getText());

            String result = controller.encrypt(inputText.get(), keyEncrypt);
            inputEncrypt.set(result);
            String result2 = controller.encrypt(keyEncrypt, keyEncrypt);

            controller.setKey(result + result2);
            inputField.setText(result + result2);
        });

        decryptionButton.addActionListener(e -> {
            String keyDec = keyFieldDecrypt.getText();

            if (controller.checkKey(keyDec, inputText.get())) {
                String result = controller.decrypt(inputEncrypt.get(), keyDec);
                outputField.setText(result);
            } else {
                outputField.setText("Ошибка");
            }
        });

        clearButton.addActionListener(e -> {
            inputField.setText("");
            keyFieldEncrypt.setText("");
            outputField.setText("");
            keyFieldDecrypt.setText("");
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
        setTitle("Ecrypto");
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        panel.setPreferredSize(new Dimension(400, 400));

        encryptionButton = new JButton("Шифрование");
        decryptionButton = new JButton("Дешифрование");
        clearButton = new JButton("Очистить");
        keyFieldEncrypt = new JPasswordField(20);
        keyFieldDecrypt = new JPasswordField(20);
        keyInfo = new JLabel("Повторите ключ");
        keyInfo2 = new JLabel("Введите ключ шифра");
        inputField = new JTextField("Введите текст");
        outputField = new JTextField("Результат шифрования");

        encryptionButton.setBounds(80, 150, 150, 20);
        decryptionButton.setBounds(260, 150, 150, 20);
        clearButton.setBounds(260, 210, 150, 20);
        keyFieldEncrypt.setBounds(310, 50, 100, 20);
        keyFieldDecrypt.setBounds(310, 100, 100, 20);
        keyInfo2.setBounds(170, 50, 150, 20);
        keyInfo.setBounds(200, 100, 150, 20);
        inputField.setBounds(60, 30, 350, 20);
        outputField.setBounds(60, 80, 350, 20);

        panel.add(encryptionButton);
        panel.add(clearButton);
        panel.add(keyFieldEncrypt);
        panel.add(keyFieldDecrypt);
        panel.add(keyInfo);
        panel.add(keyInfo2);
        panel.add(inputField);
        panel.add(outputField);
        panel.add(decryptionButton);

        return panel;
    }
}
