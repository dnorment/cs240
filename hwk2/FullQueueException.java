/**
 * Thrown by queue methods to indicate the queue is full. 
 * 
 * @author Daniel J. Norment 
 * @version 1.0
 */
public class FullQueueException extends RuntimeException
{
    public FullQueueException()
    {
        super("The queue is full");
    }
}