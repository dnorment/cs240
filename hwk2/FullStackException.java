/**
 * Thrown by stack methods to indicate the stack is full. 
 * 
 * @author Daniel J. Norment 
 * @version 1.0
 */
public class FullStackException extends RuntimeException
{
    public FullStackException()
    {
        super("The stack is full");
    }
}