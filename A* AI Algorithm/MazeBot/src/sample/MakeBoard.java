package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**	The class MakeBoard generates the Board, along with other functions needed in the Interface.
 *
 *	@author	Giann Marasigan, Jolo Cansana, Leanne Loyola, Rasheed Jamalul
 */

public class MakeBoard {

    @FXML
    GridPane root;
    @FXML
    Button runAI;
    @FXML
    TextArea coords;

    private MakeBoard mb;
    int size;
    String mazeText[][];

    /**	This constructor method sets the value of size
     */
    public MakeBoard(int size) {
        this.size = size;
    }

    /**	This setter method sets the value of the MakeBoard object mb
     */
    public void setMakeBoard(MakeBoard mb) {
        this.mb = mb;
    }

    /**	This setter method changes the text value of the TextArea coords
     */
    public void setCoords(String text) {
        coords.setText(text);
    }

    /**	This method converts the user input into a String
     */
    public void printMazeText() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(String.format("%s", mazeText[i][j]));

            }
            System.out.print("\n");
        }
    }

    /**
     * Prepares the AI for execution and redesigns the maze for execution
     * @param e
     * @throws Exception
     */
    public void runBot(ActionEvent e) throws Exception {
        for (Node node : root.getChildren()) {
            Rectangle square = (Rectangle) node;
            square.setStroke(square.getFill());
        }

        generateMaze();
    }

    /**	This method generates the maze for the traversal of the bot.
     */
    public void generateMaze() throws Exception, InvalidLetterException, OutOfMemoryError {
        String[] boardFile = new String[size];

        for (int i = 0; i < size; i++) {
            boardFile[i] = "";
            for (int j = 0; j < size; j++) {
                boardFile[i] = boardFile[i].concat(mazeText[i][j]);
            }
        }

        A_StarAlgorithm a = new A_StarAlgorithm();
        a.startAlgorithm(boardFile, size, mb);
    }

    /**
     * This method is called to change the cell's color given its row and col index as the bot traverses through the maze.
     * @param color
     * @param row
     * @param col
     */
    public void changeColor(Color color, int row, int col) {
        Rectangle square = null;
        for (Node node : root.getChildren()) {
            if (GridPane.getColumnIndex(node) != null && GridPane.getColumnIndex(node) != null && GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                square = (Rectangle) node;
            }
        }
        square.setFill(color);
        square.setStroke(color);
    }

    /**	This method generates the board based on the size given by the user in a n x n matrix.
     *
     */
    @FXML
    public void initialize() {
        mazeText = new String[size][size];
        double squareSize = (root.getPrefWidth() / size);
        System.out.println(squareSize);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                Rectangle square = new Rectangle();
                Color color;
                color = Color.BLACK;
                square.setFill(color);
                square.setStroke(Color.GREEN);
                square.setHeight(squareSize);
                square.setWidth(squareSize);
                root.add(square, col, row);
                square.setAccessibleText(String.format("%d/%d", row, col));
                mazeText[row][col] = "X";
                if (row == 0 && col == 0) {
                    square.setFill(Color.RED);
                    mazeText[row][col] = "T";
                } else if (row == size - 1 && col == size - 1) {
                    square.setFill(Color.GREEN);
                    mazeText[row][col] = "G";
                } else {
                    square.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Rectangle selection = ((Rectangle) event.getSource());
                            String[] coords = selection.getAccessibleText().split("/");
                            int sRow = Integer.parseInt(coords[0]);
                            int sCol = Integer.parseInt(coords[1]);
                            System.out.println(String.format("%d %d", sRow, sCol));
                            selection.setFill(selection.getFill().equals(Color.BLACK) ? Color.WHITE : Color.BLACK);
                            mazeText[sRow][sCol] = mazeText[sRow][sCol] == "X" ? " " : "X";
                            printMazeText();
                        }
                    });
                }
            }
        }
    }
}