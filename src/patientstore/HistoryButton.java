/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientstore;

/**
 *
 * @author Omar
 */
public class HistoryButton extends BButton{
    private PatientStore currentApp;
    public HistoryButton(PatientStore currentApp, String text) {
        super(text);
        setPrefWidth(300);
        this.currentApp = currentApp;
    }
    
    protected void handleClick(){
        new HistoryView(currentApp);
    }

}
