package dankur.adminbot;

import dankur.adminbot.dao.AdminBotImpl;
import dankur.adminbot.model.Person;
import dankur.adminbot.model.Table;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class AdminBotAppl {
    public static void main(String[] args) {
        // Создаем список столов
        List<Table> tables = new ArrayList<>();

        // Создаем экземпляр AdminBotImpl
        AdminBotImpl adminBot = new AdminBotImpl(tables);

        // Создаем и добавляем столики
        Table table1 = new Table(1);
        Table table2 = new Table(2);
        adminBot.addTable(table1);
        adminBot.addTable(table2);

        // Создаем клиента
        Person customer = new Person("Danil", "Petrov", "1234567890");

        // Создаем даты начала и окончания брони
        Date startTime = new Date();
        Date endTime = new Date(startTime.getTime() + 3600000); // 1 час после начала

        // Резервируем столик
        adminBot.reserveTable(table1, customer, startTime, endTime);

        // Отменяем бронь по ID
        int reservationId = table1.getReservation().getReservationId();
        adminBot.cancelReservation(reservationId);

        // Выводим информацию о столиках
        for (Table table : tables) {
            System.out.println("Table " + table.getTableNumber() + " isReserved: " + table.isReserved());
            if (table.getReservation() != null) {
                System.out.println("Reservation ID: " + table.getReservation().getReservationId());
                System.out.println("Customer: " + table.getReservation().getCustomer().getFullName());
                System.out.println("Start Time: " + adminBot.formatTime(table.getReservation().getStartTime()));
                System.out.println("End Time: " + adminBot.formatTime(table.getReservation().getEndTime()));
            }
        }
    }
}
