import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeJPanel extends Loader{

    private JPanel rootPanel;
    JTextArea gameTitle;
    JTextPane textPaneHello;
    JTextArea textTypeYourName;
    private JTextField textFieldYourName;
    private JPanel mainJPanel;
    private JButton nextButton;
    JTextPane textPanelYourMission;
    private JButton btnResults;

    WelcomeJPanel ()
    {
        mainJPanel.setLayout(new BoxLayout(mainJPanel,BoxLayout.Y_AXIS));

        nextButton.addActionListener(e -> {
            if (checkJTextField(textFieldYourName)) {
                name = textFieldYourName.getText().trim().replaceAll("\\s+", "_");

                rootPanel.setVisible(false);
                System.out.println("Переход");
                MainJPanel mainJPanel = new MainJPanel(1,0,0);
                jFrame.setContentPane(mainJPanel.getRootPanel());
            }
            else
                {
                    JOptionPane.showMessageDialog(rootPanel,"Укажите ваше имя");
                    textFieldYourName.grabFocus();
                }
        });
        btnResults.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jFrame, readFromFile());
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
