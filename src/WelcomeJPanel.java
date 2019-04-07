import javax.swing.*;

public class WelcomeJPanel extends Loader{

    private JPanel rootPanel;
    JTextArea gameTitle;
    JTextPane textPaneHello;
    JTextArea textTypeYourName;
    private JTextField textFieldYourName;
    JTextArea textSelectComplexity;
    private JComboBox<String> complexityJComboBox;
    private JPanel mainJPanel;
    private JButton nextButton;
    JTextPane textPanelYourMission;

    WelcomeJPanel ()
    {
        mainJPanel.setLayout(new BoxLayout(mainJPanel,BoxLayout.Y_AXIS));
        complexityJComboBox.addItem("Легко");
        complexityJComboBox.addItem("Нормально");
        complexityJComboBox.addItem("Сложно");

        nextButton.addActionListener(e -> {
            // Читаем сложность. Далее она будет пробрасываться в проверку ответа и каждое новое jPanel
            switch (complexityJComboBox.getSelectedItem().toString()){
                case ("Легко"):
                    complexity = 60;
                    System.out.println("Complexity: " + complexity);
                    break;
                case ("Нормально"):
                    complexity = 30;
                    System.out.println("Complexity: " + complexity);
                    break;
                case ("Сложно"):
                    complexity = 10;
                    System.out.println("Complexity: " + complexity);
                    break;
            }
            if (checkJTextField(textFieldYourName)) {
                name = textFieldYourName.getText();
                // complexity = complexityJComboBox.getSelectedIndex(); // Не нужно, т.к. определяю выше.
                rootPanel.setVisible(false);
                System.out.println("Переход");
                MainJPanel mainJPanel = new MainJPanel(1,0,0, complexity);
                jFrame.setContentPane(mainJPanel.getRootPanel());
            }
            else
                {
                    JOptionPane.showMessageDialog(rootPanel,"Укажите ваше имя");
                    textFieldYourName.grabFocus();
                }
        });
    }

    JPanel getRootPanel() {
        return rootPanel;
    }

    private boolean  checkJTextField (JTextField jTextField)
    {
        boolean test = true;
        if (jTextField.getText().length() == 0)
        {
           test = false;
           System.out.println("Стопе");
        }
        return test;
    }





}
