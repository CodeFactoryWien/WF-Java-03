package sample;

public class Booking {

    private int bookingID;
    private int fk_userID;
    private int fk_roomID;
    private int fk_dateID;
    private int fk_hotelID;
    private boolean humangeCage;
    private boolean breakfast;
    private boolean wellness;
    private int priceSum;
    public Booking(int bookingID, int fk_userID, int fk_roomID, int fk_dateID, int fk_hotelID, boolean humangeCage,
                   boolean breakfast, boolean wellness, int priceSum){
        this.bookingID = bookingID;
        this.fk_userID = fk_userID;
        this.fk_roomID = fk_roomID;
        this.fk_dateID = fk_dateID;
        this.fk_hotelID = fk_hotelID;
        this.humangeCage = humangeCage;
        this.breakfast = breakfast;
        this.wellness = wellness;
        this.priceSum = priceSum;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getFk_userID() {
        return fk_userID;
    }

    public void setFk_userID(int fk_userID) {
        this.fk_userID = fk_userID;
    }

    public int getFk_roomID() {
        return fk_roomID;
    }

    public void setFk_roomID(int fk_roomID) {
        this.fk_roomID = fk_roomID;
    }

    public int getFk_dateID() {
        return fk_dateID;
    }

    public void setFk_dateID(int fk_dateID) {
        this.fk_dateID = fk_dateID;
    }

    public int getFk_hotelID() {
        return fk_hotelID;
    }

    public void setFk_hotelID(int fk_hotelID) {
        this.fk_hotelID = fk_hotelID;
    }

    public boolean isHumangeCage() {
        return humangeCage;
    }

    public void setHumangeCage(boolean humangeCage) {
        this.humangeCage = humangeCage;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public boolean isWellness() {
        return wellness;
    }

    public void setWellness(boolean wellness) {
        this.wellness = wellness;
    }

    public int getPriceSum() {
        return priceSum;
    }

    public void setPriceSum(int priceSum) {
        this.priceSum = priceSum;
    }
}
