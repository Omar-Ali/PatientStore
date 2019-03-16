/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientstore;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

/**
 *
 * @author Omar
 */
public class RankDrop extends ComboBox {
    private String [] OFFICERS = {"Second Lieutenant", "Lieutenant", "Captain", "Major", "Lieutenant Colonel", "Colonel", "Brigadier", "Major General"};
    private String [] NON_COMMISSIONED_OFFICERS = {"Private", "Corporal", "Sergeant", "Staff Sergeant", "Sergeant Major", "Senior Warrant Officer"};
    private String [] FAMILY = {"Wife", "Son", "Daughter", "Father", "Mother"};
    private String [] OFFICER_FAMILY = typeFamily("Officers", OFFICERS.length);
    private String [] NON_COMMISSIONED_OFFICER_FAMILY = typeFamily("Non-Commissioned Officers", NON_COMMISSIONED_OFFICERS.length);
    
    public RankDrop(String type){
        setStyle("-fx-background: white; -fx-text-fill: -fx-text-base-color; -fx-padding: 8 5 7 12; -fx-cell-size: 3em; ");
        setWidth(300);
        populateMenu(type);
    }
    
    public void populateMenu(String type){
        if (type == "Officers"){
            getItems().removeAll(getItems());
            getItems().addAll(OFFICERS);
        }
        else if (type == "Officer Family") {
            getItems().removeAll(getItems());
            getItems().addAll(OFFICER_FAMILY);
        }
        else if (type == "Non-Commissioned Officers") {
            getItems().removeAll(getItems());
            getItems().addAll(NON_COMMISSIONED_OFFICERS);
        }
        else if (type == "Non-Commissioned Officer Family") {
            getItems().removeAll(getItems());
            getItems().addAll(NON_COMMISSIONED_OFFICER_FAMILY);
        }
        else if (type == "Civilian") {
            getItems().removeAll(getItems());
            getItems().addAll("Civilian");
        }
        else {
            getItems().removeAll(getItems());
        }
    }
    
    private String [] typeFamily(String type, int typeLength){
        String [] list = new String[typeLength * 5];
        
        for (int i = 0; i < typeLength; i++){
            for(int j=0; j<5; j++){
                if (type == "Officers")
                    list[5 * i + j] = OFFICERS[i] + " " + FAMILY[j];
                else if (type == "Non-Commissioned Officers")
                    list[5 * i + j] = NON_COMMISSIONED_OFFICERS[i] + " " + FAMILY[j];
            }
        }
        return list;
    }
}
