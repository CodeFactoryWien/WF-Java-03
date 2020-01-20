package sample;

public class Employee {
    private String employeeID;
    private String firstName;
    private  String surname;
    private int hotelID;
    private int loginID;

    public Employee(String employeeID, String firstName, String surname, int hotelID, int loginID) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.surname = surname;
        this.hotelID = hotelID;
        this.loginID = loginID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public int getLoginID() {
        return loginID;
    }

    public void setLoginID(int loginID) {
        this.loginID = loginID;
    }
}
