package sample;

import java.time.LocalDate;

public class RoomDate<LocaleDate> {
    private int dateID;
    private LocalDate startDate;
    private LocalDate endDate;
    private int fk_roomID;

    public RoomDate(int dateID, LocalDate startDate, LocalDate endDate, int fk_roomID) {
        this.dateID = dateID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.fk_roomID = fk_roomID;
    }

    public int getDateID() {
        return dateID;
    }

    public void setDateID(int dateID) {
        this.dateID = dateID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getFk_roomID() {
        return fk_roomID;
    }

    public void setFk_roomID(int fk_roomID) {
        this.fk_roomID = fk_roomID;
    }
}
