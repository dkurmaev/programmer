package dankur.adminbot.dao;

import dankur.adminbot.model.Person;
import dankur.adminbot.model.Reservation;
import dankur.adminbot.model.Table;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class AdminBotImpl implements AdminBot {
    private final Map<Integer, Table> tablesMap;
    private PrintWriter printWriter;

    public AdminBotImpl() {
        this.tablesMap = new HashMap<>();
        try {
            this.printWriter = new PrintWriter(new FileWriter("tables.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addTable(Table table) {
        if (!tablesMap.containsKey(table.getTableNumber())) {
            tablesMap.put(table.getTableNumber(), table);
        }
    }

    @Override
    public void removeTable(Table table) {
        if (tablesMap.remove(table.getTableNumber()) != null) {
            table.setReserved(false);
            table.setReservation(null);
            System.out.println("Table " + table.getTableNumber() + " removed.");
        } else {
            System.out.println("Table " + table.getTableNumber() + " not found.");
        }
    }

    private int generateReservationId() {
        return (int) (Math.random() * 1000);
    }

    public String formatTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return sdf.format(date);
    }

    @Override
    public List<Table> getTables() {
        return new ArrayList<>(tablesMap.values());
    }

    @Override
    public void reserveTable(Table table, Person customer, Date startTime, Date endTime) {
        Reservation reservation = new Reservation(generateReservationId(), customer, startTime, endTime);
        table.setReserved(true);
        table.setReservation(reservation);
        writeReservationToFile(table); // Записываем информацию о бронировании в файл
        System.out.println("Reservation for Table " + table.getTableNumber() + " created.");
    }

    @Override
    public void cancelReservation(int reservationId) {
        for (Table table : tablesMap.values()) {
            Reservation reservation = table.getReservation();
            if (reservation != null && reservation.getReservationId() == reservationId) {
                table.setReserved(false);
                table.setReservation(null);
                System.out.println("Reservation with ID " + reservationId + " canceled for Table " + table.getTableNumber());
                return;
            }
        }
        System.out.println("Reservation with ID " + reservationId + " not found.");
    }


    private void writeReservationToFile(Table table) {
        if (table.isReserved()) {
            printWriter.println("Reservation for Table " + table.getTableNumber() + " created.");
            printWriter.flush();
        }
    }


    private void readReservationsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("tables.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
