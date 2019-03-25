/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientstore;

import java.sql.Timestamp;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Omar
 */
public class HistoryView {
    private BButton historySearchBtn;
    private IdField idField;
    private ListView<String> table;
    
    public HistoryView(PatientStore currentApp){
        
        historySearchBtn = new HistorySearchButton(this, "Search");
        table = new ListView<String>();
        idField = new IdField(this);
        
        table.setPrefWidth(600);
        HBox firstHBox = new HBox();
        firstHBox.setPadding(new Insets(15, 12, 15, 12));
        firstHBox.setSpacing(15);
        firstHBox.getChildren().addAll(idField, historySearchBtn);
        
        HBox secondHBox = new HBox();
        secondHBox.setPadding(new Insets(15, 12, 15, 12));
        secondHBox.setSpacing(15);
        secondHBox.getChildren().addAll(table);
        
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(15, 12, 15, 12));
        vBox.setSpacing(15);
        vBox.getChildren().addAll(firstHBox, secondHBox);
        
        
        Stage historyStage = new Stage();
        StackPane root = new StackPane();
        root.getChildren().addAll(vBox);
        
        Scene scene = new Scene(root, 650, 480);
        historyStage.setTitle("History");
        historyStage.setScene(scene);
        historyStage.show();
    }
    
    public BButton getSearchButton(){
        return this.historySearchBtn;
    }
    
    public IdField getIdField(){
        return this.idField;
    }

    public void setTableData(final ObservableList<String> data){
        this.table.setItems(data);
    }
    
    public String getIdFieldText(){
        return this.idField.getText();
    }
    
    public void handleSearchResult(ObservableList<String> data){
        if(data.size() == 0) showNotFoundMessage();
        this.setTableData(data);
    }
    
    public void showNotFoundMessage(){
        new Alert(Alert.AlertType.INFORMATION, "This patient was not found in our Databases!").showAndWait();
    }
    
    public void showCompleteFields(){
        new Alert(Alert.AlertType.INFORMATION, "Some of the fields are missing!").showAndWait();
    }

}
