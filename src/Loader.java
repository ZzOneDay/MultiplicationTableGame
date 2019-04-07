import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.io.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.List;

public class Loader {

    // TODO: Убрать нафиг глобальные переменные
    public static String name; // Имя игрока
    public static int complexity; // Сложность
    public static String fileName = "results.txt"; // Файл с результатами
    static JFrame jFrame;


    public static void main(String[] args) {
        startGame();
    }

    static void startGame() {
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
                      Timer timer)
    {
        if (jButton.getText().equals(String.valueOf(answer)))
        {
            timer.stop();
            points += 1;
            JOptionPane.showMessageDialog(jFrame, "Ответ верный");
        }
        else
            {
                timer.stop();
                JOptionPane.showMessageDialog(jFrame,"Неверный ответ.\nПравильный ответ:" + answer);
                miss+=1;
            }
        level +=1;

        // Если 3 ошибки - заканчиваем игру TODO: Переделать на 3 жизни
        if (miss == 3) {
            timer.stop();
            endGame(points, "Жизни закончились!");
        } else {
            timer.stop();
            jPanel.setVisible(false);
            MainJPanel mainJPanel = new MainJPanel(level, miss, points);
            jFrame.setContentPane(mainJPanel.getRootPanel());
            System.out.println(level);
            System.out.println(points);
        }
    }

    void setTimer (JLabel label, int time, Timer timer, int points) {
        if (time == 0) {
            timer.stop();
            endGame(points, "Время вышло!");
        }

        int minutes = (time/60);
        String strMin = "0";
        if (minutes < 10) {
            strMin += minutes;
        } else {
            strMin = String.valueOf(minutes);
        }

        int seconds = (time)%60;
        String strSec = "0";
        if (seconds < 10) {
            strSec += seconds;
        } else {
            strSec = String.valueOf(seconds);
        }
        label.setText("Осталось времени: " + strMin + ":" + strSec);
    }

    void printInFile (int points) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter (file, true);
            fileWriter.write(name + " - " + points + " points\n");

            fileWriter.close();
        } catch (IOException e){
            System.out.println("Ошибка записи в файл: " + e);
        }
    }

    public String readFromFile () {
        String currentLine;
        String tempLine[];
        String str = "";
        List<List<String>> arrayList = new ArrayList<>();
        BufferedReader bufferedReader = null; // Вместо файла можно указать имя
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                throw new IOException("Файл не создан");
            }
            bufferedReader = new BufferedReader(new FileReader(file));
            // Читаем в ArrayList
            while ((currentLine = bufferedReader.readLine()) != null) {
                tempLine = currentLine.split(" ");
                arrayList.add(Arrays.asList(tempLine));
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения из файла: " + e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Ошибка чтения из файла: " + e);
            }
        }

        // Магия, блядь, над которой я до 3 ночи сидел. Одна строка, Карл!
        arrayList.sort((left, right) -> Integer.parseInt(right.get(2)) - Integer.parseInt(left.get(2)));

        // Преобразовываем обратно в строку для вывода
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.get(i).size(); j++) {
                stringBuilder.append(arrayList.get(i).get(j));
                stringBuilder.append(" ");
            }
            stringBuilder.append("\n");
        }

        str = stringBuilder.toString();

        return str;
    }


    // TODO: Есть ошибка с перезапуском таймера после окончания игры
    void endGame (int points, String text) {
        MainJPanel mainJPanel = new MainJPanel(1,0,0);
        jFrame.setContentPane(mainJPanel.getRootPanel());

        JOptionPane.showMessageDialog(jFrame, text + "\n" +
                "Игра окончена\n");

        printInFile(points);
        jFrame.setVisible(false);
        startGame();
    }
}
