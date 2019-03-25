/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientstore;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Omar
 */
public class HistorySearchButton extends BButton {
    
    private HistoryView currentApp;
    public HistorySearchButton(HistoryView currentApp, String text) {
        super(text);
        setPrefWidth(200);
        this.currentApp = currentApp;
    }
    
    protected void handleClick(){
        if(currentApp.getIdFieldText().isEmpty()) currentApp.showCompleteFields();
        try {
            currentApp.handleSearchResult(new Record().getByPatientId(currentApp.getIdFieldText()));
        } catch (SQLException ex) {
            Logger.getLogger(SearchButton.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }
    
}
