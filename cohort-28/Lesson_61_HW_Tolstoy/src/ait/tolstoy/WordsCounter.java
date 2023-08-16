package ait.tolstoy;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WordsCounter {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите текст:");
        try {
            String text = reader.readLine();

            try (FileWriter writer = new FileWriter("text.txt")) {
                writer.write(text);
                System.out.println("Текст успешно записан в файл.");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Произошла ошибка при записи в файл.");
            }


            reader.close();


            try (BufferedReader fileReader = new BufferedReader(new FileReader("text.txt"))) {
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = fileReader.readLine()) != null) {
                    stringBuilder.append(line).append(" ");
                }

                String sentence = stringBuilder.toString();
                String[] words = sentence.split("\\s+");

                Map<String, Integer> wordFrequency = new HashMap<>();

                for (String word : words) {
                    word = word.toLowerCase().replaceAll("[^а-яёa-z-]", "");
                    if (!word.isEmpty()) {
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }

                for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                    System.out.println(entry.getKey() + " - " + entry.getValue() + " раз");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}