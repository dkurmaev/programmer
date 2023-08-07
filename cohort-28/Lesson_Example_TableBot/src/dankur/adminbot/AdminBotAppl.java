package dankur.adminbot;

import dankur.adminbot.model.Person;
import dankur.adminbot.model.Table;
import dankur.adminbot.dao.AdminBotImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AdminBotAppl {
    public static void main(String[] args) {
        Table table1 = new Table("1");
        Table table2 = new Table("2");
        Table table3 = new Table("3");
        ArrayList<Table> tables = new ArrayList<>();
        tables.add(table1);
        tables.add(table2);
        tables.add(table3);
        Person person1 = new Person("John", "Doe", "1234567890");
        Person person2 = new Person("Jane", "Doe", "0987654321");
        Person person3 = new Person("John", "Smith", "1234567890");
        AdminBotImpl adminBot = new AdminBotImpl(tables);
        Date startTime = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        calendar.add(Calendar.HOUR, 1);
        Date endTime = calendar.getTime();
        adminBot.reserveTable(table1, person1, startTime, endTime);
        adminBot.reserveTable(table2, person2, startTime, endTime);
        adminBot.reserveTable(table3, person3, startTime, endTime);
        for (Table table : tables) {
            System.out.println("==" + table);
            if (table.getReservation() != null) {
                System.out.println(table.getReservation());
            }
        }
    }
}