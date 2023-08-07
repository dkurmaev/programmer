package dankur.adminbot.model;

public class Table {
    private String tableNumber;
    private boolean reserved;
    private Reservation reservation;
    public Table(String tableNumber) {
        this.tableNumber = tableNumber;
    }
    public String getTableNumber() {
        return tableNumber;
    }
    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }
    public boolean isReserved() {
        return reserved;
    }
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
    public Reservation getReservation() {
        return reservation;
    }
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
    @Override
    public String toString() {
        String sb = "Table Number:  " + tableNumber;
        return sb;
    }
}