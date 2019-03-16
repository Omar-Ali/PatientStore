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
public class PrintButton extends BButton{
    private PatientStore currentApp;
    public PrintButton(PatientStore currentApp, String text) {
        super(text);
        setPrefWidth(300);
        this.currentApp = currentApp;
    }
    
    protected void handleClick(){
        try {
            save();
        } catch (SQLException ex) {
            Logger.getLogger(PrintButton.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrintButton.class.getName()).log(Level.SEVERE, null, ex);
        }
        print();
        setStyle("-fx-background-color: #73BDA7;"
                + "-fx-font-size: 25;"
                + "-fx-text-fill: #f8f9fa;");
    }
    
    private void save() throws SQLException, ClassNotFoundException{
        String id = currentApp.getIdFieldText();
        String name = currentApp.getNameFieldText();
        String type = currentApp.getTypeFieldText();
        String rank = currentApp.getRankFieldText();
        if(validateValues(id, name, type, rank)){
            new Database().executeUpdate(id, name, type, rank);
        }
    }
    
    private void print(){
        
    }
    
    private boolean validateValues(String id, String name, String type, String rank){
        return !id.isEmpty() && !name.isEmpty() && !type.isEmpty() && !rank.isEmpty();
    }

}
