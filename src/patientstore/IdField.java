/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientstore;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Omar
 */
public class IdField extends TextField {
    PatientStore currentApp;
    HistoryView historyView;
    public IdField(PatientStore currentApp){
        setStyle("-fx-font-size: 25;"
                + "-fx-text-fill: #aaaaaa;");
        setPrefWidth(400);
        this.currentApp = currentApp;
        setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                handleKeyPressed(event);
            }
        });
    }
    
    public IdField(HistoryView historyView){
        setStyle("-fx-font-size: 25;"
                + "-fx-text-fill: #aaaaaa;");
        setPrefWidth(400);
        this.historyView = historyView;
        setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                handleHistoryKeyPressed(event);
            }
        });
    }
    
    private void handleKeyPressed(KeyEvent event){
        if(event.getCode().toString().equals("ENTER")){
            currentApp.getSearchButton().fire();
        }
    }
    
    private void handleHistoryKeyPressed(KeyEvent event){
        if(event.getCode().toString().equals("ENTER")){
            historyView.getSearchButton().fire();
        }
    }
}
