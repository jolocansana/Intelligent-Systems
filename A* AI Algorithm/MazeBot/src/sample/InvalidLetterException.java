package sample;
/***************************************************************************************
 *    Title: IMPLEMENTATION OF PATHFINDING ALGORITHMS (in Java, C, Javascript, C++)
 *    Author: Raptis Dimos
 *    Date: 2014
 *    Code version: 1.0
 *    Availability: https://github.com/dimosr/Pathfinding
 *
 ***************************************************************************************/

/**	The class InvalidLetterException serves as an additional exception when reading the the String array.
 *	When there is an Invalid Letter in the string array, this class throws the exception.
 *
 *	@author	Giann Marasigan, Jolo Cansana, Leanne Loyola, Rasheed Jamalul
 *
 */

class InvalidLetterException extends Exception
{
	/**	This throws the exception if there is an InvalidLetter.
	 *
	 *	@param	paramString	A string Parameter
	 */
	public InvalidLetterException(String paramString)
	{
		super(paramString);
	}
}
