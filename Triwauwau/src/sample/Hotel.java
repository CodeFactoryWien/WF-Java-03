package sample;

public class Hotel {
    private int hotelID;
    private String hotelName;
    private String hotelAdress;
    private String hotelPhone;
    private String hotelEmail;

    public Hotel(int hotelID, String hotelName, String hotelAdress, String hotelPhone, String hotelEmail) {
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.hotelAdress = hotelAdress;
        this.hotelPhone = hotelPhone;
        this.hotelEmail = hotelEmail;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAdress() {
        return hotelAdress;
    }

    public void setHotelAdress(String hotelAdress) {
        this.hotelAdress = hotelAdress;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public String getHotelEmail() {
        return hotelEmail;
    }

    public void setHotelEmail(String hotelEmail) {
        this.hotelEmail = hotelEmail;
    }

    @Override
    public String toString() {
        return   hotelName ;
    }
}
