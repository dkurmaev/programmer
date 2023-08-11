package dankur.adminbot.dao;
import dankur.adminbot.model.Person;
import dankur.adminbot.model.Reservation;
import dankur.adminbot.model.Table;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
public class AdminBotImpl implements AdminBot {
    public List<Table> tables;
    public AdminBotImpl(List<Table> tables) {
        this.tables = tables;
    }

    @Override
    public void addTable(Table table) {
        if (!tables.contains(table)) {
            tables.add(table);
        }
    }
    @Override
    public void removeTable(Table table) {
        if (tables.remove(table)) {
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
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        return sdf.format(date);
    }

    public List<Table> getTables() {
        return tables;
    }
    @Override
    public void reserveTable(Table table, Person customer, Date startTime, Date endTime) {
        Reservation reservation = new Reservation(generateReservationId(), customer, startTime, endTime);
        table.setReserved(true);
        table.setReservation(reservation);
        System.out.println("Reservation for Table " + table.getTableNumber() + " created.");
    }
    @Override
    public void cancelReservation(int reservationId) {
        for (Table table : tables) {
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


}