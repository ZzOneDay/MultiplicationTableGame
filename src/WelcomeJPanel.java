import javax.swing.*;

public class WelcomeJPanel {

    private JPanel rootPanel;
    private JTextArea gameTitle;
    private JTextPane доброПожаловатьВИгруTextPane;
    private JTextArea textTypeYourName;
    private JTextField textFieldYourName;
    private JTextArea textSelectСomplexity;
    private JComboBox complexityJComboBox;

    WelcomeJPanel ()
    {
        String []strings = {"lite", "normal", "hard" };

        complexityJComboBox.add(0, strings[0])
    }
}
