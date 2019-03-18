/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientstore;

import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/**
 *
 * @author Omar
 */
public class CountField extends  Spinner {
    public CountField(){
        SpinnerValueFactory valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 50, 1);
        setValueFactory(valueFactory);
        setEditable(true);
        setPrefWidth(200);
        setPrefHeight(40);
    }
}
