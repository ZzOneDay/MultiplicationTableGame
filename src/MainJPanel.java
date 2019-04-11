import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
        textCommand.grabFocus();

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
        textCommand.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyCode() == KeyEvent.VK_1 || e.getKeyCode() == KeyEvent.VK_NUMPAD1)
                {
                    System.out.println("1");
                    button1.doClick();
                }
                else if (e.getKeyCode() == KeyEvent.VK_2 || e.getKeyCode() == KeyEvent.VK_NUMPAD2)
                {
                    button2.doClick();
                }
                else if (e.getKeyCode() == KeyEvent.VK_3 || e.getKeyCode() == KeyEvent.VK_NUMPAD3)
                {
                    button3.doClick();
                }
                else if (e.getKeyCode() == KeyEvent.VK_4 || e.getKeyCode() == KeyEvent.VK_NUMPAD4)
                {
                    button4.doClick();
                }
            }
        });
    }

    private ActionListener actionListenerByButtonCheckAnswer (JButton jButton)
    {
        return e -> checkAnswer(jButton, answer, rootPanel, level, points, miss, timer);
    }




    JPanel getRootPanel() {
        return rootPanel;
    }
}
