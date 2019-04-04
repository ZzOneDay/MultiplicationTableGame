import javax.swing.*;

public class MainJPanel extends Loader{
    JTextArea gameTitle;
    JPanel title;
    JTextArea textCommand;
    private JTextArea firstNumber;
    JTextArea textAreaX;
    private JTextArea secondNumber;
    JPanel answerjPanel;
    private JButton button1;
    private JPanel rootPanel;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    JTextArea textAreaMission;
    private JTextArea numberMission;
    JTextArea textAreaMiss;
    private JTextArea numberMiss;
    JTextArea ProgressBarText;
    JProgressBar progressBar1;
    JPanel mainGameJPanel;
    private JTextArea textAreaPoint;
    private JTextArea numberPoint;


    MainJPanel (Integer level, Integer miss, Integer points)
    {
        System.out.println("новое окно");
        numberMission.setText(String.valueOf(level));
        numberMiss.setText(String.valueOf(miss));
        numberPoint.setText(String.valueOf(points));
        Integer answer = nextMission(button1,button2,button3,button4,firstNumber,secondNumber);
        button1.addActionListener(e -> checkAnswer (button1,answer, rootPanel, level,points,miss));
        button2.addActionListener(e -> checkAnswer (button2,answer, rootPanel, level, points, miss));
        button3.addActionListener(e -> checkAnswer (button3,answer, rootPanel,level, points, miss));
        button4.addActionListener(e -> checkAnswer (button4,answer,rootPanel,level, points, miss));
        System.out.println("Очки " + points);
    }


    JPanel getRootPanel() {
        return rootPanel;
    }
}
