package application;
import Application.Cookie;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Application.Cookie;
import javafx.scene.Node;

	public class Start implements EventHandler<ActionEvent> {

	    @Override
	    public void handle(ActionEvent arg0) {
	       Cookie.main(null);
	       
	       ((Node)(arg0.getSource())).getScene().getWindow().hide();
	    }
	}
