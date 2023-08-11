package dankur.adminbot.test;

import dankur.adminbot.dao.AdminBotImpl;
import dankur.adminbot.model.Person;
import dankur.adminbot.model.Table;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdminBotApplTest {
    private AdminBotImpl adminBot;
    private Table table;
    private Person customer;
    private Date startTime;
    private Date endTime;

    @BeforeEach
    void setUp() {
        adminBot = new AdminBotImpl(new ArrayList<>());
        table = new Table(3);
        adminBot.addTable(table);
        customer = new Person("Danil", "Kurmayev", "0987654321");
        startTime = new Date();
        endTime = new Date(startTime.getTime() + 3600000);
    }

    @Test
    public void testAddTable() {
        Table table = new Table(3);
        adminBot.addTable(table);

        List<Table> tables = adminBot.getTables();
        assertTrue(tables.contains(table));    }

    @Test
    public void testRemoveTable() {
        Table table = new Table(1);
        adminBot.addTable(table);

        Person customer = new Person("John", "Doe", "0987654321");
        Date startTime = new Date();
        Date endTime = new Date(startTime.getTime() + 3600000);

        adminBot.reserveTable(table, customer, startTime, endTime);

        adminBot.removeTable(table);

        assertFalse(table.isReserved());
        assertNull(table.getReservation());
    }

    @Test
    public void testReserveTable() {
        Table table = new Table(4);
        adminBot.addTable(table);
        customer = new Person("Danil", "Kurmayev", "0987654321");
        startTime = new Date();
        endTime = new Date(startTime.getTime() + 3600000);
        adminBot.reserveTable(table, customer, startTime, endTime);
        assertTrue(table.isReserved());
        assertNotNull(table.getReservation());
        assertEquals(customer, table.getReservation().getCustomer());
        assertEquals(startTime, table.getReservation().getStartTime());
        assertEquals(endTime, table.getReservation().getEndTime());
    }
    @Test
    public void testCancelReservation() {
        Table table = new Table(5);
        adminBot.addTable(table);

        Person customer = new Person("Denis", "Kurmayev", "9876543210");
        Date startTime = new Date();
        Date endTime = new Date(startTime.getTime() + 3600000);//миллисекунд, что эквивалентно одному часу.

        adminBot.reserveTable(table, customer, startTime, endTime);

        int reservationId = table.getReservation().getReservationId();
        adminBot.cancelReservation(reservationId);

        assertFalse(table.isReserved());
        assertNull(table.getReservation());
    }

    @Test
    public void testAddExistingTable() {
        Table table = new Table(1);
        adminBot.addTable(table);

        List<Table> tables = adminBot.getTables();
        assertEquals(2, tables.size());
    }

    @Test
    public void testFormatTime() {
        Date time = new Date(1635379200000L);
        String formattedTime = adminBot.formatTime(time);
        assertEquals("02:00", formattedTime);
    }
}
