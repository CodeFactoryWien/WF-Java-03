package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDataAccess {
    private static Connection conn;
    private static final String crdatabase = "hotel";
    public HotelDataAccess()
            throws SQLException, ClassNotFoundException {



        //STEP 2: Check if JDBC driver is available
        Class.forName("com.mysql.jdbc.Driver");       //STEP 3: Open a connection
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
    /**
     * Get all db records
     * @return
     * @throws SQLException
     */
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

        pstmnt.close(); // also closes related result set
        return list;
    }

}
