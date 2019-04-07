import javax.swing.*;
import java.awt.*;

public class Loader {

    String name;
    int complexity;
    static JFrame jFrame;


    public static void main(String[] args) {
        jFrame = new JFrame();
        WelcomeJPanel welcomeJPanel = new WelcomeJPanel();
        jFrame.setContentPane(welcomeJPanel.getRootPanel());
        jFrame.setSize(800, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setTitle("2x2=4");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setMinimumSize(new Dimension(800, 600));
    }

    Integer nextMission (JButton jButton1, JButton jButton2, JButton jButton3, JButton jButton4, JTextArea jTextArea1,
                         JTextArea jTextArea2)
    {
        int numberOne = (int) (10.0*Math.random());
        jTextArea1.setText(String.valueOf(numberOne));
        int numberTwo = (int) (10.0*Math.random());
        jTextArea2.setText(String.valueOf(numberTwo));
        int answer = numberOne * numberTwo;

        JButton []jButtons = {jButton1, jButton2, jButton3, jButton4};

        for (JButton jButton5 : jButtons) {

            int number = (int) (10.0 * Math.random() * 10.0 * Math.random());

            jButton5.setText(String.valueOf(number));

        }

        int jButtonGoodNumber = 0;
        for (int i = 0; i < (int) (10.0 * Math.random()); i++)
        {
            jButtonGoodNumber = i;
            if (i > 3)
            {
                jButtonGoodNumber = 0;
            }
        }
        JButton jButton = jButtons[jButtonGoodNumber];
        jButton.setText(String.valueOf(answer));

        //Метод проверки чтобы не было одинаковых ответов
        for (int i = 0; i < jButtons.length; i++) {
            if (i == jButtonGoodNumber) {
                continue;
            }
            for (JButton button : jButtons) {
                if (jButtons[i].getText().equals(button.getText())) {
                    System.out.println("Кнопка изменена");
                    System.out.println("Было: " + jButtons[i].getText());
                    int newButton = Integer.valueOf(jButtons[i].getText()) + 1;
                    jButtons[i].setText(String.valueOf(newButton));
                    System.out.println("Стало" + newButton);
                }
            }
        }
        return answer;
    }

    void checkAnswer (JButton jButton, Integer answer, JPanel jPanel, Integer level, Integer points, Integer miss,
                      Timer timer, int complexity)
    {
        if (jButton.getText().equals(String.valueOf(answer)))
        {
            points += 1;
            JOptionPane.showMessageDialog(jFrame, "Ответ верный");
        }
        else
            {
                JOptionPane.showMessageDialog(jFrame,"Неверный ответ.\nПравильный ответ:" + answer);
                miss+=1;
            }
        level +=1;
        jPanel.setVisible(false);
        timer.stop();
        MainJPanel mainJPanel = new MainJPanel(level, miss, points, complexity);
        jFrame.setContentPane(mainJPanel.getRootPanel());
        System.out.println(level);
        System.out.println(points);
    }



    void setTimer (JLabel label, int count, Timer timer, int complexity) {
        if (count == 0) {
            JOptionPane.showMessageDialog(jFrame, "Время вышло!\n" +
                    "Игра окончена\n");
            timer.stop();
            MainJPanel mainJPanel = new MainJPanel(1,0,0, complexity);
            jFrame.setContentPane(mainJPanel.getRootPanel());
        }

        Integer minutes = (count/60);
        String strMin = "0";
        if (minutes < 10) {
            strMin += minutes;
        } else {
            strMin = String.valueOf(minutes);
        }

        Integer seconds = (count)%60;
        String strSec = "0";
        if (seconds < 10) {
            strSec += seconds;
        } else {
            strSec = String.valueOf(seconds);
        }
        label.setText("Осталось времени: " + strMin + ":" + strSec);
    }
}
