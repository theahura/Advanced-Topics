/**
 *  A testing and debugging class.
 *  
 *  Basic assertion testing facilities. Allow for testing of conditions that must be right at certain 
 *  parts of the code. Contains static methods that do nothing if the condition holds, or throw an 
 *  error if it does not. Contains methods that allow testing of pre, post, and general conditions.
 *  Also includes a method that auto generates an error.  
 * 
 * @author akapoor
 * @version 1.0
 */

public class Assert
    {
		/**
		 * Method provides basic debugging system for testing preconditions
		 * @param test: takes in the results of the precondition
		 * @param message: error message that is printed to user
		 * @pre: result of precondition test
         * @post: does nothing if test true, otherwise abort w/message
		 */
        static public void pre(boolean test, String message)
        {
        	assert test == true : message; //This is alright, though I had asked you to use
        									// Error instead of assert.
        }

        /**
         * Method provides basic debugging system for testing postconditions
         * @param test: takes in the results of the postcondition
         * @param message: error message that is printed to user
         * @pre: result of postcondition test
         * @post: does nothing if test true, otherwise abort w/message
         */
        static public void post(boolean test, String message)
        {
        	assert test == true : message;
        }

        /**
         * Methods provides basic debugging system for testing general conditions.
         * @param test: takes in result of general condition
         * @param message: error message that is printed to user
         * @pre: result of general condition test
         * @post: does nothing if test true, otherwise abort w/message
         */
        static public void condition(boolean test, String message)
        {
        	assert test == true : message;
        }


        /**
         * Method provides system for calling error at any point in code
         * @param message: error message that is printed to user
         * @post: throws error with message
         */
        static public void fail(String message)
        {
        	assert false : message; 
        }

    }

