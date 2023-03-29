// Дана строка (получение через обычный текстовый файл!!!)

// "фамилия":"Иванов","оценка":"5","предмет":"Математика"
// "фамилия":"Петрова","оценка":"4","предмет":"Информатика"

// Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
// Студент [фамилия] получил [оценка] по предмету [предмет].

// Пример вывода в консоль:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class task2 {
    public static void main(String[] args) {
        try {
            File file = new File("data.txt"); 
            Scanner sc = new Scanner(file); 
            while (sc.hasNextLine()) {
                String line = sc.nextLine(); 
                String[] array = line.split(",");
                String firstName = array[0].split(":")[1].replaceAll("\"", "");
                String grade = array[1].split(":")[1].replaceAll("\"", "");
                String subject = array[2].split(":")[1].replaceAll("\"", "");
                StringBuilder result = new StringBuilder();
                result.append("Студент ").append(firstName);
                result.append(" получил ").append(grade);
                result.append(" по предмету ").append(subject);
                System.out.println(result);
            }
            sc.close(); 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}