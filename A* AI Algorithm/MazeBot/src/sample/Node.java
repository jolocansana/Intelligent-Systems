package sample;

import java.awt.Point;

/***************************************************************************************
 *    Title: IMPLEMENTATION OF PATHFINDING ALGORITHMS (in Java, C, Javascript, C++)
 *    Author: Raptis Dimos
 *    Date: 2014
 *    Code version: 1.0
 *    Availability: https://github.com/dimosr/Pathfinding
 *
 ***************************************************************************************/

/**	The class Node represents a Node object that haas x and y coordinates, a current state, and type
 *	as to whether it is an obstacle or not. the Node object also has a cost and a parent.
 *
 *	@author	Giann Marasigan, Jolo Cansana, Leanne Loyola, Rasheed Jamalul
 */

class Node implements Comparable<Node>{

	private enum State{
		UNVISITED, OPEN, CLOSED
	}
	private enum Type{
		NORMAL, OBSTACLE
	}

	private double costFromStart;
	private double costToTarget;
	private double totalCost;
	private Node parent;
	private State state;
	private Type type;
	private int x;
	private int y;

	/**	This method updates the costs from the starting position to the end goal.
	 */
	public void UpdateCosts(){
		this.totalCost = (this.costFromStart + this.costToTarget);
	}

	/**	This constructor creates the node. It has an x and y coordinate, as well
	 *	as the type of node it is.
	 *
	 *	@param x an integer x coordinate
	 *	@param y an integer y coordinate
	 *	@param type a string indicating type of node
	 */
	public Node(int x, int y, String type){
		this.costFromStart = 0;
		this.costToTarget = 0;
		this.totalCost = 0;
		this.parent = null;
		this.state = State.UNVISITED;
		this.type = Type.valueOf(type);
		this.x = x;
		this.y = y;
	}

	/**	This method gets the position of node.
	 *
	 *	@return position of the node
	 */
	public Point getPosition(){
		return new Point(x, y);
	}

	/**	This method gets the parent of the node
	 *
	 *	@return a parent node
	 */
	public Node getParent(){
		return parent;
	}

	/**	this method sets parameter n as the parent of the node.
	 *
	 *	@param n a Node value
	 */
	public void setParent(Node n){
		this.parent = n;
	}

	/**	This method returns the cost from the starting point.
	 *
	 *	@return a double cost from the starting point value.
	 */
	public double getCostFromStart(){
		return costFromStart;
	}

	/**	This method returns the cost to the Target goal.
	 *
	 *	@return a double cost to the target goal value.
	 */
	public double getCostToTarget(){
		return costToTarget;
	}

	/**	This method sets the parameter cost as the cost from the starting point.
	 *
	 *	@param cost a double cost value
	 */
	public void setCostFromStart(double cost){
		this.costFromStart = cost;
	}

	/**	This method sets the parameter cost as the cost to the target point.
	 *
	 *	@param cost a double cost value
	 */
	public void setCostToTarget(double cost){
		this.costFromStart = cost;
	}

	/**	This method returns the total cost from starting point to the goal.
	 *
	 *	@return a double total cost value
	 */
	public double getTotalCost(){
		return totalCost;
	}

	/**	This method sets the parameter cost as the total cost from starting point to the goal.
	 *
	 *	@param cost a double cost value
	 */
	public void setTotalCost(double cost){
		this.totalCost = cost;
	}

	/**	This method returns a boolean value as to whether the node is an obstacle or not.
	 *
	 *	@return a boolean value
	 */
	public boolean isObstacle(){
		return this.type == Type.OBSTACLE;
	}

	/**	This method returns a boolean value as to whether the node is an open space or not.
	 *
	 *	@return a boolean value
	 */
	public boolean isOpen(){
		return this.state == State.OPEN;
	}

	/**	This method returns a boolean value as to whether the node is a closed node or not.
	 *
	 *	@return a boolean value
	 */
	public boolean isClosed(){
		return this.state == State.CLOSED;
	}

	/**	This method sets the state of the node to an open node.
	 */
	public void setOpen(){
		this.state = State.OPEN;
	}

	/**	This method sets the state of the node to a closed node.
	 */
	public void setClosed(){
		this.state = State.CLOSED;
	}

	/**	This method returns the value of the x coordinate.
	 *
	 *	@return an integer x value
	 */
	public int getX(){
		return x;
	}

	/**	This method returns the value of the y coordinate.
	 *
	 *	@return an integer y value
	 */
	public int getY(){
		return y;
	}

	/**	this method compares the current total cost to the total cost of n
	 *
	 *	@return an integer value
	 */
	@Override
	public int compareTo(Node n){
		if(this.getTotalCost() < n.getTotalCost()){
			return -1;
		}
		else if(this.getTotalCost() > n.getTotalCost()){
			return 1;
		}
		else{
			return 0;
		}
	}

	/**	This method returns a boolean value as to whether parameter o has a null value.
	 *
	 *	@return a boolean value
	 */
	@Override
	public boolean equals(Object o){
		if(o == null)
			return false;
		else{
			Node n = (Node)o;
			Point firstPosition = this.getPosition();
			Point secondPosition = n.getPosition();
			return firstPosition.equals(secondPosition);
		}
	}

}
