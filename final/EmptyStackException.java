
/**
 * Thrown by stack methods to indicate the stack is empty. 
 * 
 * @author Daniel J. Norment 
 * @version 1.1
 */
public class EmptyStackException extends RuntimeException
{
    public EmptyStackException()
    {
        super("The stack is empty");
    }
}
