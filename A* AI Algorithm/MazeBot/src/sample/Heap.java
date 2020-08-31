package sample;

import java.util.Arrays;
import java.util.PriorityQueue;

/***************************************************************************************
 *    Title: IMPLEMENTATION OF PATHFINDING ALGORITHMS (in Java, C, Javascript, C++)
 *    Author: Raptis Dimos
 *    Date: 2014
 *    Code version: 1.0
 *    Availability: https://github.com/dimosr/Pathfinding
 *
 ***************************************************************************************/

/**	The heap class serves just like an array which handles the list of open nodes in this program.
 *	The heap class also can add and remove nodes from the list. The heap serves as a stack as well.
 *
 *	@author	Giann Marasigan, Jolo Cansana, Leanne Loyola, Rasheed Jamalul
 */

public class Heap<T extends Comparable> extends PriorityQueue<T> {

    private static final int DEFAULT_CAPACITY = 10;
    protected T[] array;
    protected int size;

    /**	This contructor intializes the heap.
     */
    @SuppressWarnings("unchecked")
    public Heap () {
        array = (T[])new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }

    /**	This method returns a boolean value as to whether it can add the parammeter value
     *	to the array.
     *
     *	@param value a T value
     *
     *	@return a boolean value
     */
    public boolean add(T value) {
        // grow array if needed
        if (size >= array.length - 1) {
            array = this.resize();
        }
        // place element into heap at bottom
        size++;
        int index = size;
        array[index] = value;

        bubbleUp();
        return true;
    }

    /**	This method returns a boolean value as to whether the heap is empty or not.
     *
     *	@return a boolean value
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**	This method peeks at the current value at the first index of the array.
     *	note: if the array is empty, it throws the exception.
     *
     *	@return if not empty, returns value at the first index; exception otherwise
     */
    public T peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        return array[1];
    }

    /**	This method removes the the current node inside the array.
     *
     *	return	a T result value
     */
    public T remove() {
        T result = peek();

        array[1] = array[size];
        array[size] = null;
        size--;

        bubbleDown();
        return result;
    }

    /**	This method overrides the toString method of the Heap object.
     *
     *	@return a string concatenation of the Array
     */
    public String toString() {
        return Arrays.toString(array);
    }

    /**	This method swaps the child of the current node in the array.
     */
    protected void bubbleDown() {
        int index = 1;

        while (hasLeftChild(index)) {
            int smallerChild = leftIndex(index);

            if (hasRightChild(index)
                    && array[leftIndex(index)].compareTo(array[rightIndex(index)]) > 0) {
                smallerChild = rightIndex(index);
            }

            if (array[index].compareTo(array[smallerChild]) > 0) {
                swap(index, smallerChild);
            } else {
                break;
            }

            index = smallerChild;
        }
    }

    /**	This method swaps the parents in the heap.
     */
    protected void bubbleUp() {
        int index = this.size;

        while (hasParent(index)
                && (parent(index).compareTo(array[index]) > 0)) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    /**	This method returns a boolean value as to whether the node has a parent or not.
     *	note: if the parameter i is greater than 1, then it is an index of a node that
     *	has a parent. (0 = null, 1 = root node)
     *
     *	@return a boolean value
     */
    protected boolean hasParent(int i) {
        return i > 1;
    }

    /**	This method returns the left index of the node using the index i
     *
     *	@return the left index of the node.
     */
    protected int leftIndex(int i) {
        return i * 2;
    }

    /**	This method returns the right index of the node using the index i
     *
     *	@return the right index of the node.
     */
    protected int rightIndex(int i) {
        return i * 2 + 1;
    }

    /**	This method returns a boolean value as to whether the node with index i has a left
     *	child or not.
     *
     *	@return a boolean value
     */
    protected boolean hasLeftChild(int i) {
        return leftIndex(i) <= size;
    }

    /**	This method returns a boolean value as to whether the node with index i has a right
     *	child or not.
     *
     *	@param i an integer index value
     *
     *	@return a boolean value
     */
    protected boolean hasRightChild(int i) {
        return rightIndex(i) <= size;
    }

    /**	This method returns the parent of the node in the array.
     *
     *	@param i an integer index value
     *
     *	@return a T value (parent)
     */
    protected T parent(int i) {
        return array[parentIndex(i)];
    }

    /**	This method returns the index of the parent node.
     *
     *	@param i an integer index value
     *
     *	@return index of the parent node
     */
    protected int parentIndex(int i) {
        return i / 2;
    }

    /**	This method resizes the T array
     *
     *	@return array twice its current size
     */
    protected T[] resize() {
        return Arrays.copyOf(array, array.length * 2);
    }

    /**	This method swaps the values inside the array
     *
     *	@param	index1 an integer index value
     *	@param	index2 an integer index value
     */
    protected void swap(int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
//class for heap exception
class HeapException extends Exception {
    public HeapException(String message) {
        super(message);
    }
}


