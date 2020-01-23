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
    private static final String roomdatabase = "room";
    private static final String userdatabase = "user";
    private static final String  datedatabase = "date";
    private static final String bookingdatabase = "booking";

    public HotelDataAccess()
            throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/triwauwau" +
                        "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" ,
                "root",
                "");

        // we will use this connection to write to a file
        conn.setAutoCommit(true);
        conn.setReadOnly( false);
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
    public static List<Booking> getAllBookings() throws SQLException {

        String sql = "SELECT * FROM " + bookingdatabase + " ORDER BY bookingID" ;
        PreparedStatement pstmnt = conn.prepareStatement(sql);
        ResultSet rs = pstmnt.executeQuery();
        List<Booking> list = new ArrayList<>();

        while  (rs.next()) {
            int i = rs.getInt("bookingID" );
            int fk_userID = rs.getInt("fk_userID");
            int fk_dateID = rs.getInt("fk_dateID");
            boolean humanCage = rs.getBoolean("humanCage");
            boolean breakfast = rs.getBoolean("breakfast");
            boolean wellness = rs.getBoolean("wellness");
            int priceSum = rs.getInt("priceSum");

            list.add(new Booking(i, fk_userID, fk_dateID, humanCage, breakfast, wellness, priceSum));
        }
        System.out.println("I work");
        pstmnt.close();
        return list;
    }

    public static List<User> getAllUser() throws SQLException {

        String sql = "SELECT * FROM " + userdatabase + " ORDER BY userID" ;
        PreparedStatement pstmnt = conn.prepareStatement(sql);
        ResultSet rs = pstmnt.executeQuery();
        List<User> list = new ArrayList<>();

        while  (rs.next()) {
            int i = rs.getInt("userID" );
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            String payment = rs.getString("payment");


            list.add(new User(i, firstName, lastName, phone, email, payment));
        }
        System.out.println("I work too");
        pstmnt.close();
        return list;
    }
    public static List<RoomDate> getAllRoomDate() throws SQLException {

        String sql = "SELECT * FROM " + datedatabase + " ORDER BY dateID" ;
        PreparedStatement pstmnt = conn.prepareStatement(sql);
        ResultSet rs = pstmnt.executeQuery();
        List<RoomDate> list = new ArrayList<>();

        while  (rs.next()) {
            int i = rs.getInt("dateID" );
            LocalDate startDate = rs.getDate("startDate").toLocalDate();
            LocalDate endDate = rs.getDate("endDate").toLocalDate();
            int fk_roomID = rs.getInt("fk_roomID");



            list.add(new RoomDate(i, startDate, endDate, fk_roomID));
        }
        System.out.println("I work also");
        pstmnt.close();
        return list;
    }


    public List<Room> getAllRoom(int hotelID) throws SQLException {

        String sql = "SELECT * FROM " + roomdatabase +"  WHERE room.fk_hotelID = " + hotelID;
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
    //get all Bookings
    public List<BookingDate> getBookingDateHotel() throws SQLException {

        String sql = "SELECT `booking`.`bookingID`, `user`.`firstName`, `user`.`lastName`, `user`.`phone`, `user`.`email`, `user`.`payment`, `booking`.`humanCage`, `booking`.`breakfast`, `booking`.`wellness`, `booking`.`priceSum`, `date`.`startDate`, `date`.`endDate`, `room`.`roomID`,date.dateID FROM `booking` LEFT JOIN `user` ON `booking`.`fk_userID` = `user`.`userID` LEFT JOIN `date` ON `booking`.`fk_dateID` = `date`.`dateID` LEFT JOIN `room` ON `date`.`fk_roomID` = room.roomID WHERE room.roomID";

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

    //Insert Methodes first with some Explanation
    public static int  insertUser(User user)
            throws  SQLException {
        //get the Datebasename form the final Int above and insert the User we get from the TextFields form the FX (7 Parameters First is ID, + 6 we get from Main)
        String dml = "INSERT INTO "  + userdatabase + " VALUES (DEFAULT, ?, ?, ?, ?, ?)" ;
        //Prepare a Statement with a A.I (auto ID) as a Default and than return it
        PreparedStatement pstmnt = conn.prepareStatement(dml,
                PreparedStatement.RETURN_GENERATED_KEYS);
        pstmnt.setString( 1 , user.getFirstName());
        pstmnt.setString( 2 , user.getLastName());
        pstmnt.setString(3, user.getPhone());
        pstmnt.setString(4, user.getEmail());
        pstmnt.setString(5, user.getPayment());
        //Do th Update on the Database, insert it
        pstmnt.executeUpdate(); // returns insert count

        // get identity column value
        //Our Result Set gives us back the new ID - it is awesome because we need it
        ResultSet rs = pstmnt.getGeneratedKeys();
        rs.next();
        //we get the ID form our First Column hurray
        int  id = rs.getInt( 1 );
        //We close the Statement so everything is running fast
        pstmnt.close();
        //We return our ID because we need it for another method in the Main
        return  id;
    }


    public static int  insertIntoDate(RoomDate roomdate) throws SQLException{
        String dml = "INSERT INTO "  + datedatabase + " VALUES (DEFAULT, ?, ?, ?)" ;
        PreparedStatement pstmnt = conn.prepareStatement(dml,
                PreparedStatement.RETURN_GENERATED_KEYS);
        LocalDateTime dt =  LocalDateTime.of(roomdate.getStartDate().getYear(),
                roomdate.getStartDate().getMonthValue(),
                roomdate.getStartDate().getDayOfMonth(),
                0,0,0,0);
        java.sql.Date date = new java.sql.Date(
                dt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        pstmnt.setDate(1, (date));
        LocalDateTime dt1 = LocalDateTime.of(roomdate.getEndDate().getYear(),
                roomdate.getEndDate().getMonthValue(),
                roomdate.getEndDate().getDayOfMonth(),
                0,0,0,0);
        java.sql.Date date1 = new java.sql.Date(
                dt1.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        pstmnt.setDate(2, (date1));
        pstmnt.setInt(3, roomdate.getFk_roomID());

        pstmnt.executeUpdate(); // returns insert count

        // get identity column value
        ResultSet rs = pstmnt.getGeneratedKeys();
        rs.next();
        int  id = rs.getInt( 1 );

        pstmnt.close();
        return  id;
    }



    public static int insertBooking(Booking booking) throws SQLException{
        String dml = "INSERT INTO "  + bookingdatabase + " VALUES (DEFAULT, ?, ?, ?, ?, ?, ?)" ;
        PreparedStatement pstmnt = conn.prepareStatement(dml,
                PreparedStatement.RETURN_GENERATED_KEYS);
        pstmnt.setInt(1,booking.getFk_userID());
        pstmnt.setInt(2, booking.getFk_dateID());
        pstmnt.setBoolean(3, booking.isHumanCage());
        pstmnt.setBoolean(4, booking.isBreakfast());
        pstmnt.setBoolean(5, booking.isWellness());
        pstmnt.setDouble(6, booking.getPriceSum());
        pstmnt.executeUpdate(); // returns insert count

        // get identity column value
        ResultSet rs = pstmnt.getGeneratedKeys();
        rs.next();
        int  id = rs.getInt( 1 );

        pstmnt.close();
        return  id;

    }

    // Update Meth following here
    public static void  updateUser (User user) throws  SQLException {

        String dml = "UPDATE "  + userdatabase +
                " SET firstName = ?, lastName = ?, phone = ?, email = ?, payment = ? "  + " WHERE userId = " + user.getUserID() ;
        PreparedStatement pstmnt = conn.prepareStatement(dml);
        pstmnt.setString( 1 , user.getFirstName());
        pstmnt.setString( 2 , user.getLastName());
        pstmnt.setString(3, user.getPhone());
        pstmnt.setString(4, user.getEmail());
        pstmnt.setString(5, user.getPayment());

        pstmnt.executeUpdate(); // returns update count
        pstmnt.close();
    }

    public static void  updateBooking (Booking booking) throws  SQLException {

        String dml = "UPDATE "  + bookingdatabase +
                " SET humanCage = ? , breakfast = ?, wellness =?, priceSum = ? " + "WHERE bookingID = "+ booking.getBookingID();
        PreparedStatement pstmnt = conn.prepareStatement(dml);
        pstmnt.setBoolean(1,booking.isHumanCage());
        pstmnt.setBoolean(2, booking.isBreakfast());
        pstmnt.setBoolean(3, booking.isWellness());
        pstmnt.setDouble(4, booking.getPriceSum());
        pstmnt.executeUpdate(); // returns update count
        pstmnt.close();
    }
    public static void  updateDate(RoomDate roomdate) throws SQLException{
        String dml = "UPDATE  "  + datedatabase + " SET startDate = ?, endDate = ?, fk_roomID  = ? " + " WHERE dateID = " +  roomdate.getDateID();
        PreparedStatement pstmnt = conn.prepareStatement(dml);

        LocalDateTime dt =  LocalDateTime.of(roomdate.getStartDate().getYear(),
                roomdate.getStartDate().getMonthValue(),
                roomdate.getStartDate().getDayOfMonth(),
                0,0,0,0);
        java.sql.Date date = new java.sql.Date(
                dt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        pstmnt.setDate(1, (date));
        LocalDateTime dt1 = LocalDateTime.of(roomdate.getEndDate().getYear(),
                roomdate.getEndDate().getMonthValue(),
                roomdate.getEndDate().getDayOfMonth(),
                0,0,0,0);
        java.sql.Date date1 = new java.sql.Date(
                dt1.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        pstmnt.setDate(2, (date1));
        pstmnt.setInt(3, roomdate.getFk_roomID());

        pstmnt.executeUpdate(); // returns update count
        pstmnt.close();
    }

    // Delete Meth following here

    public static void  deleteBooking(int bookingID)
            throws  SQLException {


        String dml = "DELETE FROM "  + bookingdatabase + " WHERE bookingID = ?" ;
        PreparedStatement pstmnt = conn.prepareStatement(dml);
        pstmnt.setInt( 1 , bookingID);
        pstmnt.executeUpdate(); // returns delete count (0 for none)

        pstmnt.close();
    }
    public static void  deleteDate(int dateID)
            throws  SQLException {

        String dml = "DELETE FROM "  + datedatabase + " WHERE dateID = ?" ;
        PreparedStatement pstmnt = conn.prepareStatement(dml);
        pstmnt.setInt( 1 , dateID);
        pstmnt.executeUpdate(); // returns delete count (0 for none)

        pstmnt.close();
    }

    //Chck if some Id is the same as the ID I need

    public  boolean userExist(User user) throws SQLException {

        String sql = "SELECT COUNT(id) FROM " + bookingdatabase + " WHERE id <> ?" ;
        PreparedStatement pstmnt = conn.prepareStatement(sql);
        pstmnt.setString( 1 , user.getFirstName());
        pstmnt.setString( 2 , user.getLastName());
        pstmnt.setString(3, user.getPhone());
        pstmnt.setString(4, user.getEmail());
        pstmnt.setString(5, user.getPayment());
        ResultSet rs = pstmnt.executeQuery();
        rs.next();
        int  count = rs.getInt( 1 );
        pstmnt.close();

        if  (count > 0 ) {

            return   true ;
        }

        return   false ;
    }

}
