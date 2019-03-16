/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientstore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SingleSelectionModel;

/**
 *
 * @author Omar
 */
public class TypeDrop extends ComboBox {
    public TypeDrop(){
        setStyle("-fx-background: white; -fx-text-fill: -fx-text-base-color; -fx-padding: 8 5 7 12; -fx-cell-size: 3em; ");
        setWidth(300);
        populateMenu();
        setValue("Officers");
    }
    
    private void populateMenu(){
        getItems().addAll("Officers",
            "Officer Family",
            "Non-Commissioned Officers",
            "Non-Commissioned Officer Family",
            "Civilian");
    }
}
