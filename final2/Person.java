import java.util.Iterator;

/*************************************************************************
  Winter 2017 CS 240 Programming Exam : Person

 Author: Daniel J. Norment      

 Dependencies: Stack, Queue, Dictionary

 Description:  Models a person, a list of messages that they can
               read, and a list of their friends, so that when you
               post a message, all your friends can read it too.

**************************************************************************/

public class Person implements Comparable<Person>{ 
    public String name;
    public StackLinkedData<String> messages;
    public DictionarySortedLinked<Person, String> friends;

    // Create a new Person with this name.
    public Person(String name) {
        this.name = name;
        messages = new StackLinkedData<String>();
        friends = new DictionarySortedLinked<Person, String>();
    }

    // Make these two people become friends with each other.
    // Throw an exception if you try to meet yourself.
    // We are allowed to assume we didn't meet this person yet.
    public void meet(Person otherPerson) {
        if (this == otherPerson)
        {
            throw new RuntimeException("You can't be your own friend");
        }
        else
        {
            friends.add(otherPerson, otherPerson.name);
            otherPerson.friends.add(this, this.name);
        }
    }

    // Are these two people friends?
    // Throw an exception if you ask about knowing yourself.
    public boolean knows(Person otherPerson) {
        if (this == otherPerson)
        {
            throw new RuntimeException("You can't be your own friend");
        }
        else
        {
            return friends.contains(otherPerson);
        }
    }

    // Post a message to my list and the lists of all my friends
    public void post(String message) {
        messages.push(message);
        Iterator<Person> fr = friends.getKeyIterator();
        while (fr.hasNext())
        {
            Person friend = fr.next();
            friend.messages.push(message);
        }
    }

    // Print a header, then all messages this Person can read, newest first
    public void listMessages() {
        System.out.println("== The wall of " + name + " ==");
        StackLinkedData<String> tempMsg = new StackLinkedData<String>();
        while (!messages.isEmpty())
        {
            String msg = messages.pop();
            tempMsg.push(msg);
            System.out.println(msg); 
        }
        while (!tempMsg.isEmpty())
        {
            messages.push(tempMsg.pop());
        }
    }
    
    public static void main(String[] args) {
    
        /**Person first = new Person("Kim");
        Person second = new Person("Pat");
        first.post("Only Kim can read this");
    
        first.meet(second);
        second.post("Friends are awesome");
        first.post("I agree");
    
        first.listMessages();
        second.listMessages();*/
            
        Person first = new Person("Kim");
        Person second = new Person("Pat");
        
        System.out.println(first.knows(second));   // should print "false"
        
        first.meet(second);
        
        System.out.println(first.knows(second));   // should print "true"
        System.out.println(second.knows(first));   // should print "true"
        
        first.knows(first);                    // should throw a RuntimeException
        
    }
    
    public int compareTo(Person otherPerson)
    {
        return this.name.compareTo(otherPerson.name);
    }
       
}