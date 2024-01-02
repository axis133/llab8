import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тип данных для поиска: ");
        String dataType = scanner.next();

        String filename = "text.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.equals(dataType)) {
                        System.out.println("Найдено соответствие: " + word);
                    } else {
                        try {
                            if (isInteger(word) && dataType.equals("int")) {
                                System.out.println("Найдено соответствие: " + word);
                            } else if (isFloat(word) && dataType.equals("float")) {
                                System.out.println("Найдено соответствие: " + word);
                            }
                            else if ( dataType.equals("string"))
                            System.out.println("Найдено соответствие: " + word);

                        } catch (NumberFormatException e) {
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isFloat(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}