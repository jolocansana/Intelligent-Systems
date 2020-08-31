package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**	The class Main menu creates the actions for the Graphic User Interface (GUI) in making the board for the game.
 *
 *	@author	Giann Marasigan, Jolo Cansana, Leanne Loyola, Rasheed Jamalul
 */

public class MainMenu {

    @FXML
    private TextField userInput;
    @FXML
    private Button confirmButton;

    /**	This method creates the board in the GUI based on the input of size for the board.
     *
     *	@param	e an Action Event
     */
    public void onConfirm (ActionEvent e) throws Exception
    {
        MakeBoard mb = new MakeBoard(Integer.parseInt(userInput.getText()));
        mb.setMakeBoard(mb);
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MakeBoard.fxml"));
        loader.setController(mb);
        primaryStage.setScene(new Scene(loader.load(), 1200, 1000));
        primaryStage.show();
        Stage selfWindow = (Stage)((Node)e.getSource()).getScene().getWindow();
        selfWindow.close();
    }
}
