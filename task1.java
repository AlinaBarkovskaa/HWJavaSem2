// Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
// результат после каждой итерации запишите в лог-файл.
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class task1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        sc.close(); 
        File logFile = new File("sort.log");
        FileWriter writer = new FileWriter(logFile);
        writer.write("Array: " + Arrays.toString(array) + "\n");
        boolean swapped = true;
        int iteration = 0;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            iteration++;
            writer.write("After iteration" + iteration + ": " + Arrays.toString(array) + "\n");
        }
        writer.close();
    }
}