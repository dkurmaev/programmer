
package dankur.adminbot;

import dankur.adminbot.dao.AdminBotImpl;
import dankur.adminbot.model.Person;
import dankur.adminbot.model.Table;

import java.util.*;

public class AdminBotAppl {
    public static void main(String[] args) {
        AdminBotImpl adminBot = new AdminBotImpl();

        Table table1 = new Table(1);
        Table table2 = new Table(2);
        adminBot.addTable(table1);
        adminBot.addTable(table2);

        Person customer = new Person("Danil", "Petrov", "1234567890");

        Date startTime = new Date();
        Date endTime = new Date(startTime.getTime() + 3600000);

        adminBot.reserveTable(table1, customer, startTime, endTime);
        int reservationId = table1.getReservation().getReservationId();
        adminBot.cancelReservation(reservationId);

        for (Table table : adminBot.getTables()) {
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
