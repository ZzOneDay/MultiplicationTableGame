import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EndGame extends Loader {
    private JTextArea gameTitle;
    private JTextPane textPanelResult;
    private JTextPane textPanelYourResult;
    private JTextArea textPanelListResultPlayer;
    private JTextArea textSelectNewGame;
    private JButton buttonNewGame;
    private JLabel jLabelResult;
    private JPanel rootPanel;
    private JTextPane textPaneForResult;
    private JPanel endGame;

    EndGame (int points) {
        Loader loader = new Loader();
        textPaneForResult.setText(loader.readFromFile());
        textPanelYourResult.setText("Вы набрали " + points + " очков");

        rootPanel.setLayout(new BoxLayout(rootPanel,BoxLayout.Y_AXIS));
        buttonNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                startGame();
            }
        });
    }

    JPanel getRootPanel() {
        return rootPanel;
    }


}
