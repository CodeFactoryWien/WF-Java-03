package sample;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class HotelDataAccess {
    private static Connection conn;
    private static final String crdatabase = "hotel";

    public HotelDataAccess()
            throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/triwauwau" +
                        "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" ,
                "root",
                "");
    }
    public void closeDb() throws SQLException {
        conn.close();
    }

    public List<Hotel> getAllHotels() throws SQLException {

        String sql = "SELECT * FROM " + crdatabase + " ORDER BY hotelName" ;
        PreparedStatement pstmnt = conn.prepareStatement(sql);
        ResultSet rs = pstmnt.executeQuery();
        List<Hotel> list = new ArrayList<>();

        while  (rs.next()) {
            int i = rs.getInt("HotelID" );
            String hotelName = rs.getString("hotelName");
            String hotelAdress = rs.getString("hotelAdress");
            String hotelPhone = rs.getString("hotelPhone");
            String hotelEmail = rs.getString("hotelEmail");
            list.add(new Hotel(i, hotelName, hotelAdress, hotelPhone, hotelEmail));
        }

        pstmnt.close();
        return list;
    }

    public List<Room> getAllRoom(int hotelID) throws SQLException {

        String sql = "SELECT * FROM room  WHERE room.fk_hotelID = " + hotelID;
        PreparedStatement pstmnt = conn.prepareStatement(sql);
        ResultSet rs = pstmnt.executeQuery();
        List<Room> list = new ArrayList<>();

        while  (rs.next()) {
            int i = rs.getInt("roomID" );
            String roomName = rs.getString("roomName");
            //String roomCapacity = rs.getString("roomCapacity");
            //String roomSize = rs.getString("roomSize");
            int fk_categoryID = rs.getInt("fk_categoryID");
            int fk_hotelID = rs.getInt("fk_hotelID");
            list.add(new Room(i, roomName,fk_categoryID, fk_hotelID));
        }

        pstmnt.close();
        return list;
    }

    public List<Category> getAllCategory() throws SQLException {

        String sql = "SELECT * FROM category" ;
        PreparedStatement pstmnt = conn.prepareStatement(sql);
        ResultSet rs = pstmnt.executeQuery();
        List<Category> list = new ArrayList<>();

        while  (rs.next()) {
            int i = rs.getInt("categoryID" );
            String categoryName = rs.getString("categoryName");
            double categorySize = rs.getDouble("categorySize");
            double categoryPrice = rs.getDouble("categoryPrice");
            list.add(new Category(i,categoryName, categorySize, categoryPrice));
        }

        pstmnt.close();
        return list;
    }

    public List<RoomCategory> getRoomCategory(int hotelID) throws SQLException {

        String sql = "SELECT room.roomID, room.roomName, category.categoryName, category.categorySize, category.categoryPrice\n" +
                "FROM room \n" +
                "\tINNER JOIN category ON room.fk_categoryID = category.categoryID \n" +
                "\tINNER JOIN hotel ON room.fk_hotelID = hotel.hotelID WHERE hotel.hotelID ="+ hotelID;
        PreparedStatement psmnt = conn.prepareStatement(sql);
        ResultSet rs = psmnt.executeQuery();
        List<RoomCategory> list = new ArrayList<>();

        while  (rs.next()) {
            int i = rs.getInt("roomID" );
            String roomName = rs.getString("roomName");
            String categoryName = rs.getString("categoryName");
            double categorySize = rs.getDouble("categorySize");
            double categoryPrice = rs.getDouble("categoryPrice");
            list.add(new RoomCategory(i,roomName,categoryName, categorySize, categoryPrice));
        }
        psmnt.close();
        return list;

    }

    public List<BookingDate> getBookingDate(int roomID) throws SQLException {

        String sql = "SELECT `booking`.`bookingID`, `user`.`firstName`, `user`.`lastName`, `user`.`phone`, `user`.`email`, `user`.`payment`, `booking`.`humanCage`, `booking`.`breakfast`, `booking`.`wellness`, `booking`.`priceSum`, `date`.`startDate`, `date`.`endDate`, `room`.`roomID`,date.dateID FROM `booking` LEFT JOIN `user` ON `booking`.`fk_userID` = `user`.`userID` LEFT JOIN `date` ON `booking`.`fk_dateID` = `date`.`dateID` LEFT JOIN `room` ON `date`.`fk_roomID` = room.roomID WHERE room.roomID ="+ roomID;

        PreparedStatement psmnt = conn.prepareStatement(sql);
        ResultSet rs = psmnt.executeQuery();
        List<BookingDate> list = new ArrayList<>();

        while  (rs.next()) {
            int bookingID = rs.getInt("bookingID" );
            int dateID = rs.getInt("dateID" );
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            String payment = rs.getString("payment");
            boolean humanCage = rs.getBoolean("humanCage");
            boolean breakfast = rs.getBoolean("breakfast");
            boolean wellness = rs.getBoolean("wellness");
            Date startDate = rs.getDate("startDate");
            Date endDate = rs.getDate("endDate");
            double priceSum = rs.getDouble("priceSum");

            list.add(new BookingDate(bookingID, dateID, firstName, lastName, phone, email, payment, humanCage, breakfast, wellness, startDate, endDate, priceSum));
        }
        psmnt.close();
        return list;

    }
    //String firstName, String lastName, String phone, String payment, String email
    public static void insertIntoUser(User u) throws SQLException {

        String sql = "INSERT INTO user (userID, firstName, lastName, phone, email, payment )" + " values (?,?,?,?,?,?)";
        PreparedStatement pstmnt = conn.prepareStatement(sql);
        pstmnt.setInt(1, u.getUserID());

        pstmnt.setString(2, u.getFirstName());
        pstmnt.setString(3, u.getLastName());
        pstmnt.setString(4, u.getPhone());
        pstmnt.setString(5, u.getEmail());
        pstmnt.setString(6, u.getPayment());

        pstmnt.executeUpdate();
        pstmnt.close();

    }
    public static void insertIntoDate(LocalDate startDate, LocalDate endDate, int i) throws SQLException{
        String sql = "INSERT INTO date (startDate, endDate, fk_roomID)" + "values (?,?,?)";
        PreparedStatement pstmnt = conn.prepareStatement(sql);
        LocalDateTime dt = LocalDateTime.of(startDate.getYear(),
                startDate.getMonth(),
                startDate.getDayOfMonth(), 0,0,0,0);
        java.sql.Date date = new java.sql.Date(
                dt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        pstmnt.setDate(1, (date));
        LocalDateTime dt1 = LocalDateTime.of(endDate.getYear(),
                endDate.getMonth(),
                endDate.getDayOfMonth(), 0,0,0,0);
        java.sql.Date date1 = new java.sql.Date(
                dt1.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        pstmnt.setDate(2, (date1));
        pstmnt.setInt(3, i);

        pstmnt.executeUpdate();
        pstmnt.close();
    }

    public static void insertBooking(int userID, int dateID, boolean cage, boolean breakfast, boolean well,double priceSum) throws SQLException{
        String sql = "INSERT INTO booking (fk_userID, fk_dateID, humanCage, breakfast, wellness,priceSum)" + "values (?,?,?,?,?,?)";
        PreparedStatement pstmnt = conn.prepareStatement(sql);

        pstmnt.setInt(1,userID);
        pstmnt.setInt(2,dateID);
        pstmnt.setBoolean(3,cage);
        pstmnt.setBoolean(4,breakfast);
        pstmnt.setBoolean(5,well);
        pstmnt.setDouble(6,priceSum);


        pstmnt.executeUpdate();
        pstmnt.close();

    }

}
