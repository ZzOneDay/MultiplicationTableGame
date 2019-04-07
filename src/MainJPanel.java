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
    JPanel mainGameJPanel;
    private JTextArea numberPoint;
    private JLabel label;
    private Timer timer;
    private int time;
    JTextArea textAreaPoint;


    MainJPanel (Integer level, Integer miss, Integer points, int complexity)
    {
        time = complexity;
        System.out.println("Time: " + time);
        timer = new Timer(1000, e -> setTimer(label, time--, timer, complexity));
        timer.start();

        System.out.println("Новое окно");
        numberMission.setText(String.valueOf(level));
        numberMiss.setText(String.valueOf(miss));
        numberPoint.setText(String.valueOf(points));
        Integer answer = nextMission(button1,button2,button3,button4,firstNumber,secondNumber);
        button1.addActionListener(e -> checkAnswer (button1, answer, rootPanel, level, points, miss, timer, complexity));
        button2.addActionListener(e -> checkAnswer (button2, answer, rootPanel, level, points, miss, timer, complexity));
        button3.addActionListener(e -> checkAnswer (button3, answer, rootPanel, level, points, miss, timer, complexity));
        button4.addActionListener(e -> checkAnswer (button4, answer, rootPanel, level, points, miss, timer, complexity));
        System.out.println("Очки " + points);
    }


    JPanel getRootPanel() {
        return rootPanel;
    }
}
