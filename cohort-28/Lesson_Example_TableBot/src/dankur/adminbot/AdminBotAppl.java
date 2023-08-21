package dankur.adminbot;

import dankur.adminbot.dao.AdminBotImpl;
import dankur.adminbot.model.Person;
import dankur.adminbot.model.Table;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdminBotAppl {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private static String directoryPath = "src/reservation";

    private static void mainMenu(AdminBotImpl adminBot) {
        boolean exit = false;

        while (!exit) {
            System.out.println("Меню:");
            System.out.println("1. Показать список столов");
            System.out.println("2. Забронировать стол");
            System.out.println("3. Отменить бронь");
            System.out.println("4. Выйти");

            System.out.print("Выберите действие (1/2/3/4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Считываем лишний перевод строки

            switch (choice) {
                case 1:
                    showTables(adminBot);
                    break;
                case 2:
                    reserveTable(adminBot);
                    break;
                case 3:
                    cancelReservation(adminBot);
                    break;
//                case 4:
//                    adminBot.clearReservations();
//                    System.out.println("Резервации очищены.");
//                    break;
//                case 5:
//                    List<Table> newTables = inputNewTablesFromConsole();// Создайте новые столы по вашему усмотрению
//                            adminBot.addNewTables(newTables);
//                    System.out.println("Добавлены новые столы.");
                    //break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, выберите действие из списка.");
            }
        }
    }

    private static List<Table> inputNewTablesFromConsole() {
        System.out.print("Введите количество новых столов: ");
        int numTables = scanner.nextInt();
        scanner.nextLine();

        return IntStream.range(0, numTables)
                .mapToObj(i -> {
                    System.out.print("Введите номер нового стола: ");
                    int tableNumber = scanner.nextInt();
                    scanner.nextLine();
                    return new Table(tableNumber);
                })
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {


        AdminBotImpl adminBot = new AdminBotImpl(directoryPath);

        Table table1 = new Table(1);
        Table table2 = new Table(2);
        Table table3 = new Table(3);
        Table table4 = new Table(4);
        Table table5 = new Table(5);

        adminBot.addTable(table1); // Добавляем столы в adminBot
        adminBot.addTable(table2);
        adminBot.addTable(table3);
        adminBot.addTable(table4);
        adminBot.addTable(table5);

        mainMenu(adminBot);
    }

    private static void showTables(AdminBotImpl adminBot) {
        List<Table> tables = adminBot.getTables();

        System.out.println("Список столов:");
        tables.stream()
                .map(table -> {
                    String reservationStatus = table.isReserved() ?
                            (table.getReservation().getEndTime().getHours() >= 21 ? "Забронирован до 21:00" : "Забронирован") :
                            "Свободен";
                    return "Стол номер " + table.getTableNumber() + ": " + reservationStatus;
                })
                .forEach(System.out::println);
    }

    private static void reserveTable(AdminBotImpl adminBot) {
        System.out.print("Введите номер стола для бронирования: ");
        int tableNumber = scanner.nextInt();
        scanner.nextLine();

        List<Table> tables = adminBot.getTables();
        Table tableToReserve = null;

        for (Table table : tables) {
            if (table.getTableNumber() == tableNumber) {
                tableToReserve = table;
                break;
            }
        }

        if (tableToReserve != null && !tableToReserve.isReserved()) {
            System.out.print("Введите имя клиента: ");
            String firstName = scanner.nextLine();
            System.out.print("Введите фамилию клиента: ");
            String lastName = scanner.nextLine();
            System.out.print("Введите номер телефона клиента: ");
            String phoneNumber = scanner.nextLine();
            if (!isValidPhoneNumber(phoneNumber)) {
                System.out.println("Некорректный номер телефона.");
                return;
            }


            System.out.print("Введите дату и время начала брони (dd.MM.yyyy HH:mm): ");
            String startDateTimeStr = scanner.nextLine();
            Date startTime = null;
            try {
                Date dateTime = dateFormat.parse(startDateTimeStr);
                //startTime = dateFormat.parse(startDateTimeStr);
            } catch (ParseException e) {
                System.out.println("Некорректный формат даты и времени.");
                return;
            }

            System.out.print("Введите дату и время окончания брони (dd.MM.yyyy HH:mm): ");
            String endDateTimeStr = scanner.nextLine();
            Date endTime;
            try {
                endTime = dateFormat.parse(endDateTimeStr);
            } catch (ParseException e) {
                System.out.println("Некорректный формат даты и времени.");
                return;
            }

            adminBot.reserveTable(tableToReserve, new Person(firstName, lastName, phoneNumber), null, endTime);
            System.out.println("Стол забронирован успешно.");
        } else {
            System.out.println("Стол с номером " + tableNumber + " не найден или уже забронирован.");
        }
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\+49\\d{3}-\\d{2}-\\d{2}-\\d{2}");
    }

    private static void cancelReservation(AdminBotImpl adminBot) {
        System.out.print("Введите ID брони для отмены: ");
        int reservationId = scanner.nextInt();
        scanner.nextLine();

        adminBot.cancelReservation(reservationId);
    }
}
