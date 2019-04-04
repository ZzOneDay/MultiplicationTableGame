import javax.swing.*;
import java.awt.*;

public class Loader {

    String name;
    Integer complexity;
    static JFrame jFrame;


    public static void main(String[] args) {
        jFrame = new JFrame();
        WelcomeJPanel welcomeJPanel = new WelcomeJPanel();
        jFrame.setContentPane(welcomeJPanel.getRootPanel());
        jFrame.setSize(800, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setTitle("Our first windows application");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setMinimumSize(new Dimension(800, 600));
    }

    Integer nextMission (JButton jButton1, JButton jButton2, JButton jButton3, JButton jButton4, JTextArea jTextArea1, JTextArea jTextArea2)
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

        for (int i = 0; i < jButtons.length-1; i++)
        {
            if (jButtons[i].getText().equals(jButtons[i+1].getText()))
            {
                jButtons[i].setText(jButtons[i].getText()+1);
            }
        }

        return answer;
    }

    void checkAnswer (JButton jButton, Integer answer, JPanel jPanel, Integer level, Integer points, Integer miss)
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
        MainJPanel mainJPanel = new MainJPanel(level,miss, points);
        jFrame.setContentPane(mainJPanel.getRootPanel());
        System.out.println(level);
        System.out.println(points);
    }

}
