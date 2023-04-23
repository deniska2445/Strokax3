import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        char operator;
        String[] data;
        if (str.contains(" + ")) {
            data = str.split(" \\+ ");
            operator = '+';
        } else if (str.contains(" - ")) {
            data = str.split(" - ");
            operator = '-';
        } else if (str.contains(" * ")) {
            data = str.split(" \\* ");
            operator = '*';
        } else if (str.contains(" / ")) {
            data = str.split(" / ");
            operator = '/';
        } else {
            throw new Exception("Некорректный знак действия");
        }
        if (data[0].matches("[0-10]+") || data[1].matches("[0-10]+")) {
            if (Integer.parseInt(data[0]) > 10 || Integer.parseInt(data[0]) < 1 || Integer.parseInt(data[1]) > 10 || Integer.parseInt(data[1]) < 1) {
                throw new Exception("Числа могут быть лишь от одного до десяти");
            }
        }
        if (data[0].length() > 10 || data[1].length() > 10) {
            throw new Exception("Длинна строки не может быть больше десяти");
        }
        if (operator == '*' || operator == '/') {
            if (data[0].contains("\"")) {
                throw new Exception("Строчку можно делить или умножать только на число");
            }
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }

        if (operator == '+') {
            printInQuotes(data[0] + data[1]);
        } else if (operator == '*') {
            int multiplier = Integer.parseInt(data[1]);
            String result = "";
            for (int i = 0; i < multiplier; i++) {
                result += data[0];
            }
            printInQuotes(result);
        } else if (operator == '-') {
            int index = data[0].indexOf(data[1]);
            if (index == -1) {
                printInQuotes(data[0]);
            } else {
                String result = data[0].substring(0, index);
                result += data[0].substring(index + data[1].length());
                printInQuotes(result);
            }
        } else {
            int newLine = data[0].length() / Integer.parseInt(data[1]);
            String result = data[0].substring(0, newLine);
            printInQuotes(result);
        }


    }

    static void printInQuotes(String text) {
        if (text.length() >= 40) {
            String result = text.substring(0, 40);
            System.out.println("\"" + result + "..." + "\"");
        } else {
            System.out.println("\"" + text + "\"");
        }
    }
}