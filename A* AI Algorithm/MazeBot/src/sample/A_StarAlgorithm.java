package sample;

import java.awt.Point;
import java.io.*; 
import java.util.ArrayList;
import java.util.Scanner;

/***************************************************************************************
 *    Title: IMPLEMENTATION OF PATHFINDING ALGORITHMS (in Java, C, Javascript, C++)
 *    Author: Raptis Dimos
 *    Date: 2014
 *    Code version: 1.0
 *    Availability: https://github.com/dimosr/Pathfinding
 *
 ***************************************************************************************/

/**	The class A_StarAlgorithm serves as the main class file in handling the other classes needed in executing
 *	the A* Algorithm. The A_StarAlgorithm class also shows the path towards the goal, if there is a path
 *	towards that Goal.
 *
 *	@author	Giann Marasigan, Jolo Cansana, Leanne Loyola, Rasheed Jamalul
 *
 */
public class A_StarAlgorithm{
	/**	This function starts the A* Algorithm in finding the shortest path possible in a given map.
	 *	The function reads the String array, and checks the placement of the blocks, starting node,
	 *	and the goal state.
	 *	Note: 	the function also throws exceptions with either its out of memory or has an Invalid
	 *			letter in the given String Array.
	 *
	 *	@param	args a String array
	 *	@param	size an integer size of the board
	 *  @param 	mb 	 The MakeBoard object used to display the maze
	 */
	public void startAlgorithm (String[] args, int size, MakeBoard mb) throws Exception, InvalidLetterException, OutOfMemoryError{
	

		InputHandler handler = new InputHandler();
		SquareGraph graph = handler.readMap(args, size);

		ArrayList<Node> path = graph.executeAStar(mb);

		if(path == null){
			String text  = "There is no path to target";
			mb.setCoords(text);
		}
		else{
			String text = " ";
			text = text.concat("The total number of moves from distance to the target are : " + path.size() + "\n");
			text = text.concat("--- Path to target ---\n");
			text = text.concat(graph.printPath(path));
			mb.setCoords(text);
		}

	}
}

