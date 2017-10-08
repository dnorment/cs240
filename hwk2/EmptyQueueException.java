/**
 * Thrown by queue methods to indicate the queue is empty. 
 * 
 * @author Daniel J. Norment 
 * @version 1.0
 */
public class EmptyQueueException extends RuntimeException
{
    public EmptyQueueException()
    {
        super("The queue is empty");
    }
}