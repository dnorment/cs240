
/**
 * Thrown by stack methods to indicate the stack is empty. 
 * 
 * @author Daniel J. Norment 
 * @version 1.0
 */
public class EmptyStackException extends RuntimeException
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class EmptyStackException
     */
    public EmptyStackException()
    {
        super("The stack is empty");
    }
}
