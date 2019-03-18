/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientstore;

import javafx.scene.control.ComboBox;

/**
 *
 * @author Omar
 */
public class DepartmentDrop extends ComboBox {
    final String [] departments = {"Hearts", "Bones", "Brains", "Nurals"};
    
    public DepartmentDrop(){
        setStyle("-fx-background: white; -fx-text-fill: -fx-text-base-color; -fx-padding: 8 5 7 12; -fx-cell-size: 3em; ");
        setWidth(400);
        populateMenu();
    }

    private void populateMenu(){
        getItems().addAll(departments);
    }
}
