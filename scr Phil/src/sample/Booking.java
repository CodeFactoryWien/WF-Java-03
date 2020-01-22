package sample;

public class Booking {

    private int bookingID;
    private int fk_userID;
    private int fk_dateID;
    private boolean humanCage;
    private boolean breakfast;
    private boolean wellness;
    private double priceSum;
    public Booking(int bookingID, int fk_userID, int fk_dateID,  boolean humanCage,
                   boolean breakfast, boolean wellness, double priceSum){
        this.bookingID = bookingID;
        this.fk_userID = fk_userID;
        this.fk_dateID = fk_dateID;
        this.humanCage = humanCage;
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

    public int getFk_dateID() {
        return fk_dateID;
    }

    public void setFk_dateID(int fk_dateID) {
        this.fk_dateID = fk_dateID;
    }


    public boolean isHumanCage() {
        return humanCage;
    }

    public void setHumanCage(boolean humanCage) {
        this.humanCage = humanCage;
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

    public double getPriceSum() {
        return priceSum;
    }

    public void setPriceSum(double priceSum) {
        this.priceSum = priceSum;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID=" + bookingID +
                ", fk_userID=" + fk_userID +
                ", fk_dateID=" + fk_dateID +
                ", humanCage=" + humanCage +
                ", breakfast=" + breakfast +
                ", wellness=" + wellness +
                ", priceSum=" + priceSum +
                '}';
    }
}
