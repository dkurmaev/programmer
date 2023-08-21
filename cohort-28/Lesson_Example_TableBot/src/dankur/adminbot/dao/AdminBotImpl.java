package dankur.adminbot.dao;

import dankur.adminbot.model.Person;
import dankur.adminbot.model.Reservation;
import dankur.adminbot.model.Table;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class AdminBotImpl implements AdminBot {
    private static final long MAX_AGE_DAYS = 1;
    private final Map<Integer, Table> tablesMap;
    private final String directoryPath;
    private PrintWriter printWriter;


    public AdminBotImpl(String directoryPath) {
        this.directoryPath = directoryPath + File.separator + "reservation";
        this.tablesMap = new HashMap<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String currentDate = sdf.format(new Date());

            File reservationDir = new File(this.directoryPath);
            if (!reservationDir.exists()) {
                reservationDir.mkdirs();
            }

            this.printWriter = new PrintWriter(new FileWriter(this.directoryPath + File.separator + currentDate + ".txt", true));

            readReservationsFromFile(this.directoryPath + File.separator + currentDate + ".txt");

            cleanOldFiles(this.directoryPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addTable(Table table) {
        tablesMap.putIfAbsent(table.getTableNumber(), table);
    }


    public void addNewTables(List<Table> newTables) {
        newTables.forEach(table -> tablesMap.put(table.getTableNumber(), table));
    }



    @Override
    public List<Table> getTables(int tableNumber) {
        return new ArrayList<>(tablesMap.values());
    }

    public List<Table> getTables() {
        return new ArrayList<>(tablesMap.values());
    }

    @Override
    public Table getTable(int tableNumber) {
        return tablesMap.get(tableNumber);
    }

    @Override
    public void removeTable(Table table) {
        tablesMap.computeIfPresent(table.getTableNumber(), (tableNumber, existingTable) -> {
            existingTable.setReserved(false);
            existingTable.setReservation(null);
            System.out.println("Table " + tableNumber + " removed.");
            return null;
        });
    }

    @Override
    public void reserveTable(Table table, Person customer, Date startTime, Date endTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);

        if (calendar.get(Calendar.HOUR_OF_DAY) >= 21) {
            System.out.println("Резервация на текущий день после 21:00 недоступна.");
            return;
        }

        Calendar currentDate = Calendar.getInstance();
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.MILLISECOND, 0);

        if (calendar.before(currentDate)) {
            System.out.println("Резервация на прошедшие дни недоступна.");
            return;
        }

        tablesMap.computeIfPresent(table.getTableNumber(), (tableNumber, existingTable) -> {
            if (!existingTable.isReserved()) {
                if (existingTable.getReservation() == null) {
                    existingTable.setReservation(new Reservation(generateReservationId(), customer, startTime, endTime));
                } else {
                    Reservation existingReservation = existingTable.getReservation();
                    existingReservation.setCustomer(customer);
                    existingReservation.setStartTime(startTime);
                    existingReservation.setEndTime(endTime);
                }
                existingTable.setReserved(true);
                writeReservationToFile(existingTable);
                System.out.println("Reservation for Table " + tableNumber + " created.");
            } else {
                System.out.println("Table " + tableNumber + " is already reserved.");
            }
            return existingTable;
        });
    }

    @Override
    public void cancelReservation(int reservationId) {
        tablesMap.values().stream()
                .filter(table -> table.isReserved() && table.getReservation().getReservationId() == reservationId)
                .findFirst()
                .ifPresent(table -> {
                    table.setReserved(false);
                    table.setReservation(null);
                    System.out.println("Reservation with ID " + reservationId + " canceled for Table " + table.getTableNumber());
                });

        System.out.println("Reservation with ID " + reservationId + " not found.");
    }


    private int generateReservationId() {
        return (int) (Math.random() * 1000);
    }

    public String formatTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return sdf.format(date);
    }

    public void clearReservations() {
        for (Table table : tablesMap.values()) {
            table.setReserved(false);
            table.setReservation(null);
        }
    }
    private void writeReservationToFile(Table table) {
        if (table.isReserved()) {
            Reservation reservation = table.getReservation();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            String currentDate = sdf.format(new Date());

            String reservationInfo = sdf.format(reservation.getStartTime()) + " - Reservation for Table " + table.getTableNumber() + " created.";
            String customerInfo = "   - Customer: " + reservation.getCustomer().getFullName();
            String phoneNumberInfo = "   - Phone Number: " + reservation.getCustomer().getPhoneNumber();
            String reservationIdInfo = "   - Reservation ID: " + reservation.getReservationId();

            // Создаем папку, если она не существует
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            try {
                // Используем текущую дату как имя файла
                String fileName = currentDate + ".txt";
                Path filePath = Paths.get(directoryPath + File.separator + fileName);
                Files.write(filePath, Arrays.asList(reservationInfo, customerInfo, phoneNumberInfo, reservationIdInfo, ""), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    private void readReservationsFromFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            try (Stream<String> lines = Files.lines(file.toPath())) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

                lines.forEach(line -> {
                    String[] parts = line.split(" - ");
                    if (parts.length == 2) {
                        String dateTimeStr = parts[0].trim(); // Убрать лишние пробелы
                        String restOfLine = parts[1];

                        try {
                            Date dateTime = sdf.parse(dateTimeStr);
                            System.out.println("Parsed date: " + dateTime); // Печатаем дату и время бронирования

                            if (restOfLine.startsWith("Reservation for Table")) {
                                String[] reservationParts = restOfLine.split("\n");
                                if (reservationParts.length >= 3) {
                                    String clientName = parts[1].trim();
                                    String phoneNumber = parts[2].trim();
                                    reservation.setClientName(clientName);
                                    reservation.setPhoneNumber(phoneNumber);

                                    System.out.println("   - " + customerInfo); // Печатаем информацию о клиенте
                                    System.out.println("   - " + phoneNumberInfo); // Печатаем номер телефона
                                }
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Table findTableByReservationId(int reservationId) {
        for (Table table : tablesMap.values()) {
            if (table.isReserved() && table.getReservation().getReservationId() == reservationId) {
                return table;
            }
        }
        return null;
    }


    public void cleanOldFiles(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    long timeDifference = System.currentTimeMillis() - file.lastModified();
                    long maxAgeMillis = MAX_AGE_DAYS * 24 * 60 * 60 * 1000; // Максимальное время в миллисекундах

                    if (timeDifference > maxAgeMillis || timeDifference == maxAgeMillis) {
                        file.delete();
                    }
                }
            }
        }
    }

    private void createNewFile(String directoryPath) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String currentDate = sdf.format(new Date());

        try {
            if (printWriter != null) {
                printWriter.close();
            }
            printWriter = new PrintWriter(new FileWriter(directoryPath +  currentDate + ".txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDirectoryPath() {
        return directoryPath;
    }

    public void cleanTables() {
        cleanOldFiles(directoryPath);
    }

    public void createNewTableList() {
        tablesMap.clear();
    }


}

