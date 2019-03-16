package patientstore;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Omar
 */
public class BButton extends Button {

    public BButton(String text) {
        setText(text);
        setStyle("-fx-background-color: #244c66;"
                + "-fx-font-size: 25;"
                + "-fx-text-fill: #f8f9fa;");
        setOnActions();
    }

    protected void setOnActions(){
        setOnClick();
        setOnMouseEntered();
        setOnMouseExited();
        setOnMouseMoved();
    }

    protected void setOnClick(){
        setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                setStyle("-fx-background-color: #244c66;"
                + "-fx-font-size: 25;"
                + "-fx-text-fill: #f8f9fa;");
                handleClick();
            }
        });
    }

    protected void setOnMouseEntered(){
        setOnMouseEntered(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                setStyle("-fx-background-color: #011a22;"
                + "-fx-font-size: 25;"
                + "-fx-text-fill: #f8f9fa;");
            }
            
        });
    }

    protected void setOnMouseExited(){
        setOnMouseExited(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                setStyle("-fx-background-color: #244c66;"
                + "-fx-font-size: 25;"
                + "-fx-text-fill: #f8f9fa;");
            }
            
        });
    }

    protected void setOnMouseMoved(){
        setOnMouseMoved(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                setStyle("-fx-background-color: #011a22;"
                + "-fx-font-size: 25;"
                + "-fx-text-fill: #f8f9fa;");
            }
            
        });
    }

    protected void handleClick(){}
    
    protected void setGreen(){
        setStyle("-fx-background-color: #73BDA7;"
                + "-fx-font-size: 25;"
                + "-fx-text-fill: #f8f9fa;");
    }

}
