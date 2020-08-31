package sample;

import java.awt.Point;
import java.io.*;

/***************************************************************************************
 *    Title: IMPLEMENTATION OF PATHFINDING ALGORITHMS (in Java, C, Javascript, C++)
 *    Author: Raptis Dimos
 *    Date: 2014
 *    Code version: 1.0
 *    Availability: https://github.com/dimosr/Pathfinding
 *
 ***************************************************************************************/

/**	The class InputHandler gets all the inputs made on the String Array. Note that these inputs serve
 *	as the contents of the board. The InputHandler also checks if there is an Invalid Letter in the
 *	String array, and if the path towards the goal is possible.
 *
 *	@author	Giann Marasigan, Jolo Cansana, Leanne Loyola, Rasheed Jamalul
 *
 */

public class InputHandler {

	/**	This method reads the contents of the Map to create the nodes of the paths, start state, goal state,
	 *	and the blocks in the path.	This also checks if there is a wrong character in the map using the
	 *	InvalidLetterException class.
	 *
	 *	@param	filename a String array containing the contents of the map
	 *	@param	size integer size of the board
	 *
	 *	@return a graph containing its contents
	 */
	public SquareGraph readMap(String[] filename, int size) throws InvalidLetterException{

		SquareGraph graph = new SquareGraph(size);

		for(int i=0; i< size; i++){
			for(int j=0; j< size; j++){
				char typeSymbol = filename[i].charAt(j); //this gets the character value inside the array
				if(typeSymbol == ' '){
					Node n = new Node(i,j, "NORMAL"); //this shows that typesymbol is a free path
					graph.setMapCell(new Point(i,j), n);
				}
				else if(typeSymbol == 'X'){
					Node n = new Node(i,j, "OBSTACLE"); //this shows that typesymbol is a blocked path
					graph.setMapCell(new Point(i,j), n);
				}
				else if(typeSymbol == 'T'){
					Node n = new Node(i,j, "NORMAL");
					graph.setMapCell(new Point(i,j), n);
					graph.setStartPosition(new Point(i,j)); //this shows the starting point of the map
				}
				else if(typeSymbol == 'G'){
					Node n = new Node(i,j, "NORMAL");
					graph.setMapCell(new Point(i,j), n);
					graph.setTargetPosition(new Point(i,j)); //this shows the goal/end point of the map
				}
				else{
					throw new InvalidLetterException("There was a wrong character in the text file.The character must be X, ,T or G.");
				}
			}
		}

		return graph;
	}
}
