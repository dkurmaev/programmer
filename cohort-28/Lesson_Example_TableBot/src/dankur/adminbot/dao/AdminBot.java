package dankur.adminbot.dao;

import dankur.adminbot.model.Person;
import dankur.adminbot.model.Table;

import java.util.Date;

public interface AdminBot {
    void reserveTable(Table table, Person customer, Date startTime, Date endTime);
    void cancelReservation(int reservationId);
    void addTable(Table table);
    void removeTable(Table table);
}
