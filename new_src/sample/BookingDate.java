package sample;

import java.util.Date;

public class BookingDate {
    private int bookingID;
    private int dateID;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String payment;
    private boolean humanCage;
    private boolean breakfast;
    private boolean wellness;
    private Date startDate;
    private Date endDate;
    private double priceSum;

    public BookingDate(int bookingID, int dateID, String firstName, String lastName, String phone, String email, String payment, boolean humanCage, boolean breakfast, boolean wellness, Date startDate, Date endDate, double priceSum) {
        this.bookingID = bookingID;
        this.dateID = dateID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.payment = payment;
        this.humanCage = humanCage;
        this.breakfast = breakfast;
        this.wellness = wellness;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceSum = priceSum;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getDateID() {
        return dateID;
    }

    public void setDateID(int dateID) {
        this.dateID = dateID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getPriceSum() {
        return priceSum;
    }

    public void setPriceSum(double priceSum) {
        this.priceSum = priceSum;
    }

    @Override
    public String toString() {
        return "BookingDate{" +
                "bookingID=" + bookingID +
                ", dateID=" + dateID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", payment='" + payment + '\'' +
                ", humanCage=" + humanCage +
                ", breakfast=" + breakfast +
                ", wellness=" + wellness +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", priceSum=" + priceSum +
                '}';
    }


}
