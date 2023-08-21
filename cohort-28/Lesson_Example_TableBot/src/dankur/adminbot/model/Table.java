package dankur.adminbot.model;

public class Table {
    private int tableNumber;      // Номер стола
    private boolean reserved;     // Зарезервирован ли стол
    private Reservation reservation; // Информация о брони

    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
    }
    public int getTableNumber() {
        return tableNumber;
    }
    public void setTableNumber(int tableNumber) {
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
