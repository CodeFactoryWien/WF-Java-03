package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDataAccess {
    private static Connection conn;
    private static final String crdatabase = "hotel";
    private static final String roomdatabase = "room";

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

}
