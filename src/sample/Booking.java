package sample;

public class Booking {
    private int bookingID;
    private String firstName;
    private String surName;
    private String email;
    private String phone;
    private String payment;
    private boolean humaneCage;
    private boolean breakfast;
    private boolean wellness;
    private double priceSum;
    public Booking(int bookingID, String firstName, String surName, String email, String phone, String payment, boolean humaneCage, boolean breakfast, boolean wellness, double priceSum){
        this.bookingID = bookingID;
        this.firstName = firstName;
        this.surName = surName;
        this.email = email;
        this.phone = phone;
        this.payment = payment;
        this.humaneCage = humaneCage;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public boolean isHumaneCage() {
        return humaneCage;
    }

    public void setHumaneCage(boolean humaneCage) {
        this.humaneCage = humaneCage;
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
}
