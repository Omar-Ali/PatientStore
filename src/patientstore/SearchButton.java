/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientstore;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Omar
 */
public class SearchButton extends BButton{
    private PatientStore currentApp;
    public SearchButton(PatientStore currentApp, String text){
        super(text);
        setPrefWidth(200);
        this.currentApp = currentApp;
    }

    protected void handleClick(){
        try {
            currentApp.handleSearchResult(new Patient().getById(currentApp.getIdFieldText()));
        } catch (SQLException ex) {
            Logger.getLogger(SearchButton.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }

}
