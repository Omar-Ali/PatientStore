/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientstore;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Omar
 */
public class PrintButton extends BButton{
    private PatientStore currentApp;
    String id;
    String name;
    String type;
    String rank;
    int count;
    String department;
    
    public PrintButton(PatientStore currentApp, String text) {
        super(text);
        setPrefWidth(300);
        this.currentApp = currentApp;

    }
    
    protected void handleClick(){
        try {
            populateLocalValues();
            if(!validateValues()){
                currentApp.showCompleteFields();
                return;
            }
            save();
            print();
        } catch (SQLException ex) {
            Logger.getLogger(PrintButton.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrintButton.class.getName()).log(Level.SEVERE, null, ex);
        }
        setStyle("-fx-background-color: #73BDA7;"
                + "-fx-font-size: 25;"
                + "-fx-text-fill: #f8f9fa;");
    }
    
    private void save() throws SQLException, ClassNotFoundException{
        new Database().executePatientUpdate(id, name, type, rank);
    }
    
    private void populateLocalValues(){
        this.id = currentApp.getIdFieldText();
        this.name = currentApp.getNameFieldText();
        this.type = currentApp.getTypeFieldText();
        this.rank = currentApp.getRankFieldText();
        this.count = currentApp.getCountFieldValue();
        this.department = currentApp.getDepartmenFieldText();
    }
    
    private void print() throws SQLException, ClassNotFoundException{
        LabelPrinter label = new LabelPrinter(new Patient(Integer.parseInt(id), name, type, rank));
        new Record(Integer.parseInt(id), currentApp.getDepartmenFieldText(), count);
//        label.print(count);
    }
    
    private boolean validateValues(){
        return !id.isEmpty() && !name.isEmpty() && !type.isEmpty() && !rank.isEmpty() && count > 0 && !department.isEmpty();
    }

}
