package sample;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
        VBox vb1 = new VBox(25, hbHotel, newDategrid);



        //   Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("TriWauWau");
        primaryStage.setScene(new Scene(vb1, 600, 275));
        primaryStage.show();
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
    //ChangeListener for Listview Teacher to get Value of the selcected Teacher and fill up my grid1 Labels
    private   class  ListSelectChangeListener implements ChangeListener<Number> {

        @Override
        public   void  changed(ObservableValue<? extends Number> ov,
                               Number old_val, Number new_val) {

            if  ((new_val.intValue() < 0 ) || (new_val.intValue() >= datahotel.size())) {

                return ; // invalid data
            }

            // set name and surename, email fields for the selected Teacher
            Hotel Hotel = datahotel.get(new_val.intValue());
            //parse Int to String for Id
            hotelID.setText(String.valueOf(Hotel.getHotelID()));
            hotelName.setText(Hotel.getHotelName());
            hotelAdress.setText(Hotel.getHotelAdress());
            hotelPhone.setText(Hotel.getHotelPhone());
            hotelEmail.setText(Hotel.getHotelEmail());
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
    private   void  displayException(Exception e) {

        System.out.println( "###### Exception ######" );
        e.printStackTrace();
        System.exit( 0 );
    }
}
