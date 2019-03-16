package patientstore;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.text.html.ImageView;

/**
 *
 * @author Omar
 */
public class PatientStore extends Application {
    private BButton searchBtn;
    private BButton printBtn;
    private IdField idField;
    private NameField nameField;
    private RankDrop rankDrop;
    private TypeDrop typeDrop;
    @Override
    public void start(Stage primaryStage) throws SQLException, ClassNotFoundException {
        
        searchBtn = new SearchButton(this, "Search");
        BButton printBtn = new PrintButton(this, "Print");
        BButton historyBtn = new HistoryButton("History");
        nameField = new NameField();
        idField = new IdField(this);
        typeDrop = new TypeDrop();
        rankDrop = new RankDrop(typeDrop.getValue().toString());
        typeDrop.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                rankDrop.populateMenu(((TypeDrop)event.getSource()).getValue().toString() );
            }
        });
        

//        HBox headBox = new HBox();
//        headBox.setPadding(new Insets(15, 12, 15, 12));
//        headBox.setSpacing(15);
//        headBox.setStyle("-fx-background-image: url(\"https://i.ebayimg.com/images/g/RIUAAOSw-jhUDE8b/s-l640.jpg\");");
        
        HBox firstHBox = new HBox();
        firstHBox.setPadding(new Insets(15, 12, 15, 12));
        firstHBox.setSpacing(15);
        firstHBox.getChildren().addAll(idField, searchBtn);
        
        HBox secondHBox = new HBox();
        secondHBox.setPadding(new Insets(15, 12, 15, 12));
        secondHBox.setSpacing(15);
        secondHBox.getChildren().add(nameField);
        
        HBox thirdHBox = new HBox();
        thirdHBox.setPadding(new Insets(15, 12, 15, 12));
        thirdHBox.setSpacing(15);
        thirdHBox.getChildren().addAll(typeDrop, rankDrop);
        
        HBox fourthHBox = new HBox();
        fourthHBox.setPadding(new Insets(15, 12, 15, 12));
        fourthHBox.setSpacing(15);
        fourthHBox.getChildren().addAll(historyBtn, printBtn);
        
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(15, 12, 15, 12));
        vBox.setSpacing(15);
        vBox.getChildren().addAll(firstHBox, secondHBox, thirdHBox, fourthHBox);

        StackPane root = new StackPane();
        root.getChildren().addAll(vBox);
        
        Scene scene = new Scene(root, 650, 400);
        searchBtn.relocate(0, 0);
        primaryStage.setTitle("Patient Base");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        launch(args);
        
    }
    
    public String getIdFieldText(){
        return this.idField.getText();
    }
    
    public String getNameFieldText(){
        return this.nameField.getText();
    }
    
    public String getTypeFieldText(){
        return this.typeDrop.getValue().toString();
    }
    
    public String getRankFieldText(){
        return this.rankDrop.getValue().toString();
    }
    
    public BButton getSearchButton(){
        return this.searchBtn;
    }
    
    public void handleSearchResult(Patient patient){
        if(patient.found()){
            this.idField.setText(patient.id + "");
            this.nameField.setText(patient.name);
            this.typeDrop.setValue(patient.type);
            this.rankDrop.setValue(patient.rank);
            searchBtn.setGreen();
        } else {
            clearFields();
            showNotFoundMessage();
        }
    }
    
    public void clearFields(){
        this.idField.clear();
        this.nameField.clear();
        this.rankDrop.setValue("");
        this.typeDrop.setValue("");
    }
    
    public void showNotFoundMessage(){
        new Alert(Alert.AlertType.INFORMATION, "This patient was not found in our Databases!").showAndWait();
    }
    
}
