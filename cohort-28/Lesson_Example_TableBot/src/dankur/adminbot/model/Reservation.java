package dankur.adminbot.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;


public class Reservation {
    private int reservationId;
    private Person customer;
    private Date startTime;
    private Date endTime;
    private List<Table> tables;

    public Reservation() {
    }

    public Reservation(int reservationId, Person customer, Date startTime, Date endTime) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }


    public Person getCustomer() {
        return customer;
    }

    public void setCustomer(Person customer) {
        this.customer = customer;
    }


    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }


    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return reservationId == that.reservationId && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(tables, that.tables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, startTime, endTime, tables);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("ReservationId: ").append(reservationId);
        sb.append(", Person: ").append(customer);
        sb.append(", StartTime: ").append(startTime);
        sb.append(", EndTime: ").append(endTime);
        return sb.toString();
    }
}

