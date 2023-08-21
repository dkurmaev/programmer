package dankur.adminbot.dao;

import dankur.adminbot.model.Person;
import dankur.adminbot.model.Table;

import java.util.Date;
import java.util.List;

public interface AdminBot {
    List<Table> getTables(int tableNumber);

    void reserveTable(Table table, Person customer, Date startTime, Date endTime);
    void cancelReservation(int reservationId);
    void addTable(Table table);
    void removeTable(Table table);

    Table getTable(int tableNumber);


}
