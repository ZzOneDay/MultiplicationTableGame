import javax.swing.*;

public class StartJPanel extends Loader{

    private JPanel rootPanel;
    private JTextArea gameTitle;
    private JTextPane textPaneHello;
    private JTextPane textPanelYourMission;
    private JButton startButton;
    private JTextPane textGuide;
    private JLabel jLabelMission;

    StartJPanel ()
    {
        rootPanel.setLayout(new BoxLayout(rootPanel,BoxLayout.Y_AXIS));
        textGuide.setText(textToGuide());
        textPanelYourMission.setText(textToYourMission());
        startButton.addActionListener(e -> startFastGame());
    }

    private String textToGuide ()
    {
        return "Для старта нажмите Пробел\n" +
                "Используете кнопка 1 2 3 4 для быстрого ответа";
    }

    private String textToYourMission ()
    {
        return "Приготовьтесь!\nУ вас будет ровно 30 секунд чтобы успеть ответить на вопросы!\n" +
                "Старайтесь отвечать как можно быстрее";
    }

    JPanel getRootPanel() {
        return rootPanel;
    }

    private void startFastGame ()
    {

        MainJPanel mainJPanel = new MainJPanel(1,0,0);
        jFrame.setContentPane(mainJPanel.getRootPanel());
    }


}


