package ait.charstream;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class EmployeesDataAppl {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("Book1.csv"))) {
            String str = br.readLine();
            String[] cells = str.split(";");
            printCells(cells);
            str = br.readLine();
            int count = 0;
            double salary = 0;
            double age = 0;
            while (str != null) {
                count++;
                cells = str.split(";");
                salary += Double.parseDouble(cells[2]);
                LocalDate birthDate = LocalDate.parse(cells[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                age += ChronoUnit.YEARS.between(birthDate, LocalDate.now());
                printCells(cells);
                str = br.readLine();
            }
            System.out.println("Total salary: " + salary);
            System.out.println("Total employees: " + count);
            System.out.println("Average salary: " + salary / count);
            System.out.println("Average age: " + 1. * age / count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printCells(String[] cells) {
        for (String string : cells) {
            System.out.print(string + "\t ");
        }
        System.out.println();
    }
}