import javax.swing.*;
import java.awt.event.ActionListener;

public class MainJPanel extends Loader{
    JTextArea gameTitle;
    JPanel title;
    JTextArea textCommand;
    private JTextArea firstNumber;
    JTextArea textAreaX;
    private JTextArea secondNumber;
    JPanel answerJPanel;
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
    private Integer level;
    private Integer miss;
    private Integer points;
    private Integer answer;


    MainJPanel (Integer level, Integer miss, Integer points)
    {
        this.level = level;
        this.miss = miss;
        this.points = points;

        time = complexity;
        System.out.println("Time: " + time);
        timer = new Timer(1000, e -> setTimer(label, time--, timer, points));
        timer.start();

        System.out.println("Новое окно");
        numberMission.setText(String.valueOf(level));
        numberMiss.setText(String.valueOf(miss));
        numberPoint.setText(String.valueOf(points));
        answer = nextMission(button1,button2,button3,button4,firstNumber,secondNumber);
        button1.addActionListener(actionListenerByButtonCheckAnswer(button1));
        button2.addActionListener(actionListenerByButtonCheckAnswer(button2));
        button3.addActionListener(actionListenerByButtonCheckAnswer(button3));
        button4.addActionListener(actionListenerByButtonCheckAnswer(button4));
        System.out.println("Очки " + points);
    }

    private ActionListener actionListenerByButtonCheckAnswer (JButton jButton)
    {
        return e -> checkAnswer(jButton, answer, rootPanel, level, points, miss, timer);
    }


    JPanel getRootPanel() {
        return rootPanel;
    }
}
