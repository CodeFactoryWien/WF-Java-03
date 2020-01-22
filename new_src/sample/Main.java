        package sample;

                import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
                import javafx.application.Application;
                import javafx.beans.value.ChangeListener;
                import javafx.beans.value.ObservableValue;
                import javafx.collections.FXCollections;
                import javafx.collections.ObservableList;
                import javafx.geometry.Insets;
                import javafx.geometry.Pos;
                import javafx.scene.Scene;
                import javafx.scene.control.*;
                import javafx.scene.control.cell.PropertyValueFactory;
                import javafx.scene.layout.GridPane;
                import javafx.stage.Stage;
                import javafx.scene.layout.HBox;
                import javafx.scene.layout.VBox;
                import javafx.scene.text.Font;
                import javafx.stage.Stage;
                import org.w3c.dom.ls.LSOutput;

                import java.sql.*;
                import java.time.ZoneId;
                import java.util.ArrayList;
                import java.util.Calendar;
                import java.util.Date;
                import java.util.List;
                import java.time.*;

        public class Main extends Application {

            private  HotelDataAccess dbaccess;

            //HOTEL
            private ListView<Hotel> hotellistView;

            private ObservableList<Hotel> datahotel;
            private Label hotelID;
            private Label hotelName;
            private Label hotelAdress;
            private Label hotelPhone;
            private Label hotelEmail;

            //Room
            private TableView<RoomCategory> roomTable = new TableView();


            //BOOKING
            private ObservableList<RoomCategory> dataRoomCategory;
            private TableView<BookingDate> bookingDateTable;
            private ObservableList<BookingDate> dataBookingDate;

            //PRICE SUM METHOD
            public static double pricecalc(LocalDate startDate, LocalDate endDate,boolean cage,boolean breakfast, boolean wellness,double categoryPrice) {
                Date date1 = Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date date2 = Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                double diff = (date2.getTime() - date1.getTime())/(1000*60*60*24);
                double result;
                if (cage&&breakfast==false&&wellness==false)
                    result = diff*(categoryPrice+15);
                else if (breakfast&&cage==false&&wellness==false)
                    result = diff*(categoryPrice+10);
                else if (wellness&&cage==false&&breakfast==false)
                    result = diff*(categoryPrice+35);
                else if (cage&&breakfast&&wellness==false)
                    result = diff*(categoryPrice+25);
                else if (cage&&breakfast&&wellness)
                    result = diff*(categoryPrice+60);
                else if (cage&&wellness&&breakfast==false)
                    result = diff*(categoryPrice+50);
                else if (wellness&&breakfast&&cage==false)
                    result = diff*(categoryPrice+45);
                else
                    result = diff*categoryPrice;
                return result;
            };



            @Override
            public void start(Stage primaryStage) throws Exception{

                hotellistView = new  ListView<>();

                hotellistView.getSelectionModel().selectedIndexProperty().addListener(
                new  ListSelectChangeListener());

                datahotel = getDbData();
                hotellistView.setItems(datahotel);

                bookingDateTable = new TableView<>();

                // HOTELLAYOUT
                Label hotellbl = new Label("Hotel");
                hotellbl.setMaxWidth(Double.MAX_VALUE);
                hotellbl.setAlignment(Pos.CENTER);
                hotellbl.setFont(new Font(14));
                hotellbl.setStyle("-fx-font-weight: bold");

                Label hotelIdlbl = new Label("Hotel-ID: ");
                hotelIdlbl.setStyle("-fx-font-weight: bold");
                Label hotelnamelbl = new  Label( "Name:" );
                hotelnamelbl.setStyle("-fx-font-weight: bold");
                Label hotelAdresslbl = new  Label( "Adress:" );
                hotelAdresslbl.setStyle("-fx-font-weight: bold");
                Label hotelPhonelbl = new Label ("Phone");
                hotelPhonelbl.setStyle("-fx-font-weight: bold");
                Label hotelemaillb = new  Label( "E-Mail:" );
                hotelemaillb.setStyle("-fx-font-weight: bold");
                hotelID  = new Label();
                hotelName  = new Label();
                hotelAdress = new Label();
                hotelPhone = new Label();
                hotelEmail = new Label();


                GridPane grid1 = new GridPane();
                grid1.setAlignment(Pos.CENTER);
                grid1.setHgap( 15);
                grid1.setVgap( 20);
                grid1.setPadding( new Insets( 25, 25 , 25 , 25 ));
                grid1.add(hotelIdlbl, 0, 0);
                grid1.add(hotelID, 1, 0);
                grid1.add(hotelnamelbl, 0, 1);
                grid1.add(hotelName, 1, 1);
                grid1.add(hotelAdresslbl, 0, 2);
                grid1.add(hotelAdress, 1, 2);
                grid1.add(hotelPhonelbl, 0, 3);
                grid1.add(hotelPhone, 1, 3);
                grid1.add(hotelemaillb, 0, 4);
                grid1.add(hotelEmail, 1, 4);





                //ROOM TABLEVIEW
                roomTable.setEditable(true);
                TableColumn<RoomCategory,Integer> roomIDColumn = new TableColumn<>("ID");
                roomIDColumn.setCellValueFactory(new PropertyValueFactory<>("roomID"));

                TableColumn<RoomCategory,String> roomNameColumn = new TableColumn<>("Room Name");
                roomNameColumn.setCellValueFactory(new PropertyValueFactory<>("roomName"));

                TableColumn<RoomCategory,Double> roomSizeColumn = new TableColumn<>("Size");
                roomSizeColumn.setCellValueFactory(new PropertyValueFactory<>("categorySize"));

                TableColumn<RoomCategory,Double> roomPriceColumn = new TableColumn<>("Price");
                roomPriceColumn.setCellValueFactory(new PropertyValueFactory<>("categoryPrice"));

                TableColumn<RoomCategory,String> roomCategoryColumn = new TableColumn<>("Category");
                roomCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("categoryName"));



                roomTable.getColumns().addAll(roomIDColumn,roomNameColumn,roomSizeColumn,roomPriceColumn,roomCategoryColumn);
                roomTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                //BOOKING TABLEVIEW
                bookingDateTable.setEditable(true);

                TableColumn<BookingDate,Integer> bookingIDColumn = new TableColumn<>("ID");
                bookingIDColumn.setCellValueFactory(new PropertyValueFactory<>("bookingID"));

                TableColumn<BookingDate,String> firstNameColumn = new TableColumn<>("firstName");
                firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));


                TableColumn<BookingDate,String> lastNameColumn = new TableColumn<>("lastName");
                lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

                TableColumn<BookingDate,String> phoneColumn = new TableColumn<>("phone");
                phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

                TableColumn<BookingDate,String> emailColumn = new TableColumn<>("email");
                emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

                TableColumn<BookingDate,String> paymentColumn = new TableColumn<>("payment");
                paymentColumn.setCellValueFactory(new PropertyValueFactory<>("payment"));

                TableColumn<BookingDate,Boolean> humanCageColumn = new TableColumn<>("humanCage");
                humanCageColumn.setCellValueFactory(new PropertyValueFactory<>("humanCage"));

                TableColumn<BookingDate,Boolean> breakfastColumn = new TableColumn<>("breakfast");
                breakfastColumn.setCellValueFactory(new PropertyValueFactory<>("breakfast"));

                TableColumn<BookingDate,Boolean> wellnessColumn = new TableColumn<>("wellness");
                wellnessColumn.setCellValueFactory(new PropertyValueFactory<>("wellness"));

                TableColumn<BookingDate, Date> startDateColumn = new TableColumn<>("startDate");
                startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));

                TableColumn<BookingDate, Date> endDateColumn = new TableColumn<>("endDate");
                endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));


                TableColumn<BookingDate, Long> priceSumColumn = new TableColumn<>("Total Price €");
                priceSumColumn.setCellValueFactory(new PropertyValueFactory<>("priceSum"));

                bookingDateTable.getColumns().addAll(bookingIDColumn,firstNameColumn,lastNameColumn,phoneColumn,emailColumn,paymentColumn,humanCageColumn,breakfastColumn,wellnessColumn,startDateColumn,endDateColumn,priceSumColumn);
                bookingDateTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                //INSERT FIELDS

                TextField firstNameTxt = new TextField();
                Label firstNamelbl = new Label("Firstname");
                TextField lastNameTxt = new TextField();
                Label lastNamelbl = new Label("Lastname");

                TextField phoneTxt = new TextField();
                Label phonelbl = new Label("Phone");
                TextField emailTxt = new TextField();
                Label emiallbl = new Label("Email");
                TextField paymentTxt = new TextField();
                Label paymentlbl = new Label("Payment");

                //DATEPICKER
                DatePicker startDateTxt = new DatePicker();
                Label startlbl = new Label("Start");
                DatePicker endDateTxt = new DatePicker();
                Label endlbl = new Label("End");
                GridPane newDategrid = new GridPane();
                newDategrid.setAlignment(Pos.CENTER);
                newDategrid.setHgap( 15);
                newDategrid.setVgap( 20);
                newDategrid.setPadding( new Insets( 25, 25 , 25 , 25 ));
                newDategrid.add(startDateTxt, 0, 0);
                newDategrid.add(startlbl, 1, 0);
                newDategrid.add(endDateTxt, 0, 1);
                newDategrid.add(endlbl, 1, 1);

                //BUTTONS
                Button bookingbtn = new Button("New Booking");
                Button deletebookingbtn = new Button("Delete");
                Button updatebookingbtn = new Button("Update");

                //RADIOBUTTONS
                RadioButton cagebtn = new RadioButton("Humancage");
                RadioButton breakfastbtn = new RadioButton("Breakfast");
                RadioButton wellnessbtn = new RadioButton("Wellness");





                //INSERT BOOKING BUTTON METHOD
                bookingbtn.setOnAction(e-> {
                    try {
                        User u = new User(0, firstNameTxt.getText(),lastNameTxt.getText(),phoneTxt.getText(),paymentTxt.getText(),emailTxt.getText());
                        RoomDate rd = new RoomDate(0, startDateTxt.getValue().plusDays(1), endDateTxt.getValue().plusDays(1), roomTable.getSelectionModel().getSelectedItem().getRoomID());

                        Booking b1 = new Booking(0, HotelDataAccess.insertUser(u), HotelDataAccess.insertIntoDate(rd), cagebtn.isSelected(),breakfastbtn.isSelected(),wellnessbtn.isSelected(),pricecalc(startDateTxt.getValue(),endDateTxt.getValue(),cagebtn.isSelected(),breakfastbtn.isSelected(),wellnessbtn.isSelected(),roomTable.getSelectionModel().getSelectedItem().getCategoryPrice()) );
                        HotelDataAccess.insertBooking(b1);
                        firstNameTxt.clear();lastNameTxt.clear();phoneTxt.clear();paymentTxt.clear();emailTxt.clear();cagebtn.setSelected(false);breakfastbtn.setSelected(false);wellnessbtn.setSelected(false);startDateTxt.setValue(null);endDateTxt.setValue(null);
                        dataBookingDate.clear();
                        dataBookingDate = getDbBookingDate(roomTable.getSelectionModel().getSelectedItem().getRoomID());
                        bookingDateTable.setItems(dataBookingDate);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                });

                //DELETE BOOKING BUTTON MeTHOD
                deletebookingbtn.setOnAction(e-> {
                    try {
                        HotelDataAccess.deleteBooking(bookingDateTable.getSelectionModel().getSelectedItem().getBookingID());
                        dataBookingDate.clear();
                        dataBookingDate =getDbBookingDate(roomTable.getSelectionModel().getSelectedItem().getRoomID());
                        bookingDateTable.setItems(dataBookingDate);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                });

                //UPDATE BOOKING BUTTON METHOD
                updatebookingbtn.setOnAction(e-> {
                    try {
                        //RoomDate rd = new RoomDate(0, startDateTxt.getValue(), endDateTxt.getValue(), roomTable.getSelectionModel().getSelectedItem().getRoomID());

                        Booking booking = new Booking(bookingDateTable.getSelectionModel().getSelectedItem().getBookingID(),0,0,false,false,false,2);
                        HotelDataAccess.updateBooking(booking);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                });

                VBox insertbox = new VBox(firstNamelbl,firstNameTxt,lastNamelbl,lastNameTxt,phonelbl,phoneTxt,paymentlbl,paymentTxt,emiallbl,emailTxt,newDategrid,cagebtn,breakfastbtn,wellnessbtn,bookingbtn,deletebookingbtn,updatebookingbtn);
                HBox hbHotel = new HBox(25, hotellistView, grid1,insertbox);

                VBox vb1 = new VBox(25, hbHotel, roomTable, bookingDateTable);
                //   Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                primaryStage.setTitle("TriWauWau");
                primaryStage.setScene(new Scene(vb1, 950, 600));
                primaryStage.show();

                hotellistView.getSelectionModel().selectFirst();

            }


    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public  void init() {

        try  {
            dbaccess = new  HotelDataAccess();
        }
        catch (Exception e) {

            displayException(e);
        }
    }

    @Override
    public  void stop() {

        try {
            dbaccess.closeDb();
        }
        catch (Exception e) {

            displayException(e);
        }
    }

    //ChangeListener for Listview Hotel
    private   class  ListSelectChangeListener implements ChangeListener<Number> {

        @Override
        public void changed(ObservableValue<? extends Number> ov,
        Number old_val, Number new_val) {

            if ((new_val.intValue() < 0) || (new_val.intValue() >= datahotel.size())) {

                return;
            }


            Hotel hotel = datahotel.get(new_val.intValue());

            hotelID.setText(String.valueOf(hotel.getHotelID()));
            hotelName.setText(hotel.getHotelName());
            hotelAdress.setText(hotel.getHotelAdress());
            hotelPhone.setText(hotel.getHotelPhone());
            hotelEmail.setText(hotel.getHotelEmail());

            dataRoomCategory = getDbRoomCategory(hotel.getHotelID());
            roomTable.setItems(dataRoomCategory);
            roomTable.getSelectionModel().selectedIndexProperty().addListener(
                    new ListSelectChangeListener1());


        }
    }
    private   class  ListSelectChangeListener1 implements ChangeListener<Number> {

        @Override
        public   void  changed(ObservableValue<? extends Number> ov,
        Number old_val, Number new_val) {

            if ((new_val.intValue() < 0) || (new_val.intValue() >= dataRoomCategory.size())) {

                return;
            }


            //roomTable.getSelectionModel().selectFirst();
            RoomCategory roomCategory = dataRoomCategory.get(new_val.intValue());
            dataBookingDate = getDbBookingDate(roomCategory.getRoomID());
            bookingDateTable.setItems(dataBookingDate);

            //Double roomCategoryPrice = roomCategory.getCategoryPrice();
        }
    }


    private   class  ListSelectChangeListener2 implements ChangeListener<Number> {

        @Override
        public   void  changed(ObservableValue<? extends Number> ov,
                               Number old_val, Number new_val) {

            if ((new_val.intValue() < 0) || (new_val.intValue() >= dataBookingDate.size())) {

                return;
            }



        }
    }


    private ObservableList<Hotel> getDbData() {

        List<Hotel> list = null ;

        try  {
            list = dbaccess.getAllHotels();
        }
        catch  (Exception e) {

            displayException(e);
        }

        ObservableList<Hotel> dbData = FXCollections.observableList(list);
        return  dbData;
    }

    private ObservableList<RoomCategory> getDbRoomCategory(int i) {

        List<RoomCategory> list = null ;

        try  {
            list = dbaccess.getRoomCategory(i);
        }
        catch  (Exception e) {

            displayException(e);
        }

    ObservableList<RoomCategory> dataRoomCategory = FXCollections.observableList(list);
    return  dataRoomCategory;
    }

    private ObservableList<BookingDate> getDbBookingDate(int roomID) {

        List<BookingDate> list = null ;


        try  {
            list = dbaccess.getBookingDate(roomID);
        }
        catch  (Exception e) {

            displayException(e);
        }

        ObservableList<BookingDate> dataBookingDate = FXCollections.observableList(list);
        return  dataBookingDate;
    }

    private ObservableList<Room> getDbRoom(int i) {

        List<Room> list = null ;

        try  {
            list = dbaccess.getAllRoom(i);
        }
        catch  (Exception e) {

            displayException(e);
        }

        ObservableList<Room> dataRoom = FXCollections.observableList(list);
        return  dataRoom;
    }

    private ObservableList<Category> getDbCategory() {

        List<Category> list = null ;

        try  {
            list = dbaccess.getAllCategory();
        }
        catch  (Exception e) {

            displayException(e);
        }

        ObservableList<Category> dataCategory = FXCollections.observableList(list);
        return  dataCategory;
    }


    private   void  displayException(Exception e) {

        System.out.println( "###### Exception ######" );
        e.printStackTrace();
        System.exit( 0 );
    }
}
