import javax.swing.*;
import java.awt.*;


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

    EndGame () {
        Loader loader = new Loader();
        textPaneForResult.setText(loader.readFromFile());

         rootPanel.setLayout(new BoxLayout(rootPanel,BoxLayout.Y_AXIS));
    }

    JPanel getRootPanel() {
        return rootPanel;
    }


}
