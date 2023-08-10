package ait.charstream;

import java.io.*;

public class ConsoleIOAppl {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter console = new PrintWriter(System.out, true);

        // Запрашиваем имя файла у пользователя
        console.println("Введите имя файла: ");

        String fileName = br.readLine(); // Считываем имя файла
        PrintWriter pw = new PrintWriter(new FileWriter(fileName, true)); // Создаем PrintWriter для записи в файл

        // Запрашиваем текст у пользователя и записываем его в файл
        console.println("Введите текст: ");
        String inputText = br.readLine(); // Считываем ввод пользователя

        while (!"exit".equalsIgnoreCase(inputText)) { // Пока пользователь не ввел "exit"
            pw.println(inputText); // Записываем текст в файл
            pw.flush(); // Принудительно очищаем буфер

            console.println("Введите текст: ");
            inputText = br.readLine(); // Считываем следующий ввод пользователя
        }

        pw.close(); // Закрываем PrintWriter и завершаем программу
    }
}
