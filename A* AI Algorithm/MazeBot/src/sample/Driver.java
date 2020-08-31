package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;


/**	The class Driver serves as the class for running the A* Algorithm. this also starts the application of the algorithm
 *	for pathfinding.
 *
 *	@author	Giann Marasigan, Jolo Cansana, Leanne Loyola, Rasheed Jamalul
 *
 */
public class Driver extends Application {

    private Stage primaryStage;

    /**	This function displays the Scene where the user will input N where NxN is the size of the square matrix
     *
     *	@param	primaryStage a Stage variable
     */
    public void start (Stage primaryStage) throws Exception
    {
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 200, 200));
        primaryStage.show();
    }

    public static void main (String[] args) { launch(args); }

}
