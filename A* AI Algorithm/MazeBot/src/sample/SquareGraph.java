package sample;

	/**************************************************
    Copyright (C) 2014  Raptis Dimos <raptis.dimos@yahoo.gr>


    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
	**************************************************/

	/***************************************************************************************
	 *    Title: IMPLEMENTATION OF PATHFINDING ALGORITHMS (in Java, C, Javascript, C++)
	 *    Author: Raptis Dimos
	 *    Date: 2014
	 *    Code version: 1.0
	 *    Availability: https://github.com/dimosr/Pathfinding
	 *
	 ***************************************************************************************/


import javafx.animation.PauseTransition;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.awt.Point;
import java.util.*;

/**	The class SquareGraph represents a SquareGraph object which has the contents of the map.
 *	The SquareGraph object also initiates the A* Algorithm, along with reconstructing the path
 *	towards the goal.
 *
 *	@author	Giann Marasigan, Jolo Cansana, Leanne Loyola, Rasheed Jamalul
 *
 */

public class SquareGraph {
	
	private Node[][] map;
	private Point startPosition;
	private Point targetPosition;
	private Heap<Node> openNodes;
	private Set<Node> closedNodes;
	private MakeBoard mb;
	private Duration delay = Duration.seconds(.25);

	/**	This constructor sets the contents of the square Graph, receiving the dimensions/size of
	 *	the map
	 *
	 *	@param mapDimension an integer size of the board
	 */
	public SquareGraph(int mapDimension){
		map = new Node[mapDimension][mapDimension];
		startPosition = new Point();
		targetPosition = new Point();
		openNodes = new Heap<Node>();
		closedNodes = new HashSet<Node>();
	}

	/**	This method returns the coordinates of the node
	 *
	 *	@return the map coordinate of the node
	 */
	public Node getMapCell(Point coord){
		return map[(int)coord.getX()][(int)coord.getY()];
	}

	/**	This method sets the map coordinate of the node using parameters
	 *	coord and n
	 *
	 *	@param coord a point value
	 *	@param n a node value
	 */
	public void setMapCell(Point coord, Node n){
		map[(int)coord.getX()][(int)coord.getY()] = n;
	}

	/**	This method returns the start position in the map
	 *
	 *	@return a Point start position value
	 */
	public Point getStartPosition(){
		return startPosition;
	}

	/**	This method returns the target/goal position in the map
	 *
	 *	@return a Point goal position value
	 */
	public Point getTargetPosition(){
		return targetPosition;
	}

	/**	This method sets the parameter coord as the starting position in the map.
	 *
	 *	@param coord a point value
	 */
	public void setStartPosition(Point coord){
		startPosition.setLocation(coord);
	}

	/**	This method sets the parameter coord as the target/goal position in the map
	 *
	 *	@param coord a point value
	 */
	public void setTargetPosition(Point coord){
		targetPosition.setLocation(coord);
	}

	/**	This method returns the dimensions of the board
	 *
	 *	@return an integer size value
	 */
	public int getDimension(){
		return map.length;
	}

	/**	This method adds parameter n to the list of open nodes.
	 *
	 *	@param n a node value
	 */
	public void addToOpenNodes(Node n){
		n.setOpen();
		openNodes.add(n);
	}

	/**	This method pops the current open node inside the list.
	 *
	 *	@return a node value
	 */
	public Node popBestOpenNode(){
		return openNodes.remove();
	}

	/**	This method adds parameter n to the list of closed nodes.
	 *
	 *	@param n a node value
	 */
	public void addToClosedNodes(Node n){
		n.setClosed();
		closedNodes.add(n);
	}

	/**	This method returns a boolean value as to whether the point coordinate is inside the map or not.
	 *
	 *	@return a boolean value
	 */
	public boolean isInsideMap(Point p){
		return ( (p.getX() >= 0) && (p.getX() < getDimension())  && (p.getY() >= 0) && (p.getY() < getDimension()) );
	}

	/**	This method gets the adjacent nodes of the parameter node n to see all the possible paths to go to.
	 *
	 *	@param n a node value
	 *
	 *	@return a Set of nodes containing the adjacent nodes of the parameter n
	 */
	public Set<Node> getNeighbours(Node n){
		Set<Node> neighbours = new HashSet<Node>();
		for(int i=-1; i<=1; i++){
			for(int j=-1; j<=1; j++){
				if( !(i==0 && j==0) && (i-j==1||j-i==1))
					if(isInsideMap(new Point(n.getX() + i,n.getY() + j))){
						Node temp = getMapCell(new Point(n.getX() + i,n.getY() +  j));
						if(!temp.isObstacle())
							neighbours.add(temp);
					}
					
			}
		}
		return neighbours;
	}

	/**	This method gets the distance of the parameters from and to
	 *
	 *	@param from a point value
	 *	@param to a point value
	 *
	 *	@return a double value of the distance
	 */
	static double calculateDistance(Point from, Point to){
		return Math.pow(Math.pow(from.getX()-to.getX(), 2) + Math.pow(from.getY() - to.getY(), 2) , 0.5);
	}

	/**	This method reconstructs the path from the starting point towards the goal.
	 *
	 *	@param target a node value
	 *
	 *	@return an arraylist of nodes that serves as the path towards the goal
	 */
	public ArrayList<Node> reconstructPath(Node target) throws Exception{
		ArrayList<Node> path = new ArrayList<Node>();
		Node current = target;
		
		while(current.getParent() != null){
			path.add(current.getParent());
			current = current.getParent();
		}

		for (Node node : path)
		{
			PauseTransition pause = new PauseTransition(Duration.seconds(1));
			pause.setOnFinished(event -> {
				mb.changeColor(Color.GREEN, node.getX(), node.getY());
			});
			pause.setDelay(delay);
			System.out.println(delay.toSeconds());
			pause.play();
		}

		Collections.reverse(path);
		return path;
	}

	/**	This method shows the path towards the goal.
	 *
	 *	@param path an Arraylist of nodes towards the goal
	 */
	public String printPath(ArrayList<Node> path){
		String text = " ";
		for(int i=0; i<path.size(); i++){
			Node node = path.get(i);
			text = text.concat("node : (" + node.getX() + "," + node.getY() + ")\n");
		}
		return text;
	}

	/**	This method executes the A* Algorithm in finding the best path possible towards the goal.
	 *
	 *	@return the reconstructed path towards the goal if possible; otherwise, a null value
	 */
	public ArrayList<Node> executeAStar(MakeBoard mb) throws Exception{
		this.mb = mb;
		Node start = getMapCell(getStartPosition());
		Node target = getMapCell(getTargetPosition());
		addToOpenNodes(start);
		start.setCostFromStart(0);
		start.setTotalCost( start.getCostFromStart() + calculateDistance(start.getPosition(), target.getPosition()) );
		while(!openNodes.isEmpty()){
			Node current = popBestOpenNode();
			if(current.equals(target)){
				return reconstructPath(target);
			}
			
			addToClosedNodes(current);

			PauseTransition pause = new PauseTransition(Duration.seconds(1));
			pause.setOnFinished(event -> {
				mb.changeColor(Color.GREY, current.getX(), current.getY());
			});
			pause.setDelay(delay);
			delay = delay.add(Duration.seconds(.25));
			System.out.println(delay.toSeconds());
			pause.play();

			Set<Node> neighbours = getNeighbours(current);
			for(Node neighbour : neighbours){
				if(!neighbour.isClosed()){
					double tentativeCost = current.getCostFromStart() + calculateDistance(current.getPosition(), neighbour.getPosition());
					
					if( (!neighbour.isOpen()) || (tentativeCost < neighbour.getCostFromStart()) ){
						neighbour.setParent(current);
						neighbour.setCostFromStart(tentativeCost);
						neighbour.setTotalCost(neighbour.getCostFromStart() + calculateDistance(neighbour.getPosition(), start.getPosition()));
						if(!neighbour.isOpen())
							addToOpenNodes(neighbour);
					}
				}
					
			}
		}
		
		return null;
	}
	
}
