package sample;

import com.mysql.cj.xdevapi.Table;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    private  HotelDataAccess dbaccess;

    //everything for Hotel
    private ListView<Hotel> hotellistView;

    private ObservableList<Hotel> datahotel;
    private Label hotelID;
    private  Label hotelName;
    private Label hotelAdress;
    private Label hotelPhone;
    private Label hotelEmail;

    //Room
    private TableView<RoomCategory> roomTable = new TableView();

    private ListView<Room> roomlistView;
    private ObservableList<RoomCategory> dataRoomCategory;
    private Label roomID;
    private Label roomName;
    private Label roomeCapacity;
    private Label roomSize;

    @Override
    public void start(Stage primaryStage) throws Exception{
        hotellistView = new  ListView<>();
        hotellistView.getSelectionModel().selectedIndexProperty().addListener(
                new  ListSelectChangeListener());
        datahotel = getDbData();
        hotellistView.setItems(datahotel);


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

        //Filling up my second Grid for my middle Part of the Programm with Labels and the Placeholder for my ChangeListener
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

        HBox hbHotel = new HBox(25, hotellistView, grid1);

        DatePicker start = new DatePicker();
        Label startlbl = new Label("Start");
        DatePicker end = new DatePicker();
        Label endlbl = new Label("End");
        GridPane newDategrid = new GridPane();
        newDategrid.setAlignment(Pos.CENTER);
        newDategrid.setHgap( 15);
        newDategrid.setVgap( 20);
        newDategrid.setPadding( new Insets( 25, 25 , 25 , 25 ));
        newDategrid.add(start, 0, 0);
        newDategrid.add(startlbl, 1, 0);
        newDategrid.add(end, 0, 1);
        newDategrid.add(endlbl, 1, 1);
        roomlistView = new  ListView<>();

        //TABLEVIEW
        roomTable.setEditable(true);
        TableColumn<RoomCategory,Integer> roomIDColumn = new TableColumn<>("ID");
        roomIDColumn.setCellValueFactory(new PropertyValueFactory<>("roomID"));

        TableColumn<RoomCategory,String> roomNameColumn = new TableColumn<>("Room Name");
        roomNameColumn.setCellValueFactory(new PropertyValueFactory<>("roomName"));

        //TableColumn<RoomCategory,String> roomCapacityColumn = new TableColumn<>("Capacity");
        //roomCapacityColumn.setCellValueFactory(new PropertyValueFactory<>("roomCapacity"));

        TableColumn<RoomCategory,Double> roomSizeColumn = new TableColumn<>("Size");
        roomSizeColumn.setCellValueFactory(new PropertyValueFactory<>("categorySize"));

        TableColumn<RoomCategory,Double> roomPriceColumn = new TableColumn<>("Price");
        roomPriceColumn.setCellValueFactory(new PropertyValueFactory<>("categoryPrice"));


        TableColumn<RoomCategory,String> roomCategoryColumn = new TableColumn<>("Category");
        roomCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("categoryName"));

        //TableColumn<RoomCategory,Integer> roomHotelIDColumn = new TableColumn<>("Hotel ID");
        //roomHotelIDColumn.setCellValueFactory(new PropertyValueFactory<>("fk_hotelID"));



        roomTable.getColumns().addAll(roomIDColumn,roomNameColumn,roomSizeColumn,roomPriceColumn,roomCategoryColumn);

        VBox vb1 = new VBox(25, hbHotel, newDategrid, roomTable);
        //   Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("TriWauWau");
        primaryStage.setScene(new Scene(vb1, 600, 600));
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
        public   void  changed(ObservableValue<? extends Number> ov,
                               Number old_val, Number new_val) {

            if  ((new_val.intValue() < 0 ) || (new_val.intValue() >= datahotel.size())) {

                return ;
            }


            Hotel hotel = datahotel.get(new_val.intValue());

            hotelID.setText(String.valueOf(hotel.getHotelID()));
            hotelName.setText(hotel.getHotelName());
            hotelAdress.setText(hotel.getHotelAdress());
            hotelPhone.setText(hotel.getHotelPhone());
            hotelEmail.setText(hotel.getHotelEmail());

            dataRoomCategory =  getDbRoomCategory(hotel.getHotelID());
            roomTable.setItems(dataRoomCategory);
            System.out.println(dataRoomCategory);
            System.out.println(hotel.getHotelID());

        }
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
