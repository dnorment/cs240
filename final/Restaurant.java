import java.util.Iterator;
import java.util.Random;

/**
 * Simulates an In-N-Out restaurant for the month of December.
 *
 * @author Daniel J. Norment
 * @version 1.2
 */
public class Restaurant
{
    //random number generator rng
    private static Random rng = new Random();
    
    //intialize food stacks
    private static final int SHIPMENT_SIZE = 1000;
    private static StackFixedArray<Integer> bun = new StackFixedArray<Integer>(SHIPMENT_SIZE);
    private static StackFixedArray<Integer> patty = new StackFixedArray<Integer>(SHIPMENT_SIZE);
    private static StackFixedArray<Integer> lettuce = new StackFixedArray<Integer>(SHIPMENT_SIZE);
    private static StackFixedArray<Integer> tomato = new StackFixedArray<Integer>(SHIPMENT_SIZE);
    private static StackFixedArray<Integer> onion = new StackFixedArray<Integer>(SHIPMENT_SIZE);
    private static StackFixedArray<Integer> cheese = new StackFixedArray<Integer>(SHIPMENT_SIZE);
    
    //initialize menu & counter
    private static ListFixedSize<StackFixedArray<Integer>> orderOne = new ListFixedSize<StackFixedArray<Integer>>(5); //bun patty lettuce tomato onion
    private static ListFixedSize<StackFixedArray<Integer>> orderTwo = new ListFixedSize<StackFixedArray<Integer>>(6); //cheese bun patty lettuce tomato onion
    private static ListFixedSize<StackFixedArray<Integer>> orderThree = new ListFixedSize<StackFixedArray<Integer>>(4); //lettuce lettuce tomato onion
    private static ListFixedSize<StackFixedArray<Integer>> orderFour = new ListFixedSize<StackFixedArray<Integer>>(4); //bun patty lettuce tomato
    private static ListFixedSize<StackFixedArray<Integer>> orderFive = new ListFixedSize<StackFixedArray<Integer>>(5); //cheese bun patty lettuce tomato
    private static ListFixedSize<StackFixedArray<Integer>> orderSix = new ListFixedSize<StackFixedArray<Integer>>(4); //bun patty lettuce onion
    
    public static ListFixedSize<StackFixedArray<Integer>> menu(int order)
    {
        switch(order)
        {
            case 0: return orderOne;
            case 1: return orderTwo;
            case 2: return orderThree;
            case 3: return orderFour;
            case 4: return orderFive;
            case 5: return orderSix;
            default: return null;
        }
    }
    
    public static void main(String[] args)
    {
        //add food stacks to menu item lists
        orderOne.add(bun); orderOne.add(patty); orderOne.add(lettuce); orderOne.add(tomato); orderOne.add(onion);
        orderTwo.add(cheese); orderTwo.add(bun); orderTwo.add(patty); orderTwo.add(lettuce); orderTwo.add(tomato); orderTwo.add(onion);
        orderThree.add(lettuce); orderThree.add(lettuce); orderThree.add(tomato); orderThree.add(onion);
        orderFour.add(bun); orderFour.add(patty); orderFour.add(lettuce); orderFour.add(tomato);
        orderFive.add(cheese); orderFive.add(bun); orderFive.add(patty); orderFive.add(lettuce); orderFive.add(tomato); 
        orderSix.add(bun); orderSix.add(patty); orderSix.add(lettuce); orderSix.add(onion); 
        
        DictionarySortedLinked<Integer, Integer> dict = new DictionarySortedLinked<Integer, Integer>(); //initialize order dictionary
        QueueFixedArray<Integer> customerQueue = new QueueFixedArray<Integer>(50); //initialize customer queue
        
        int daysUntilShipment = 0;
        int lostCustomerDay, wasteCheese, wasteBun, wastePatty, wasteLettuce, wasteTomato, wasteOnion; //initialize counters
        int countItemOne, countItemTwo, countItemThree, countItemFour, countItemFive, countItemSix; //displayed at end ^
        
        int month = 12;
        for (int day=1; day<=31; day++) //store operates 12/1 to 12/31
        {
            int today = month*100 + day; //store date as int for simplification
            lostCustomerDay = wasteCheese = wasteBun = wastePatty = wasteLettuce = wasteTomato = wasteOnion = 0;
            countItemOne = countItemTwo = countItemThree = countItemFour = countItemFive = countItemSix = 0;
            dict.clear(); //reset info printed for each day
            
            for (int hour=9; hour<=21; hour++) //store operates 0900 to 2100
            {
                if (hour == 9 && daysUntilShipment == 0) //shipments arrive at 0900
                {
                    System.out.println("Shipment today");
                    int newShipment = SHIPMENT_SIZE - rng.nextInt(3*(SHIPMENT_SIZE/10)); //generate between 3... and 10... items for shipment
                    for (int i=newShipment; i>0; i--)
                    {
                        int item = rng.nextInt(6); //choose random item and push it
                        switch (item)
                        {
                            case 0: bun.push(today);
                                break;
                            case 1: patty.push(today);
                                break;
                            case 2: lettuce.push(today);
                                break;
                            case 3: tomato.push(today);
                                break;
                            case 4: onion.push(today);
                                break;
                            case 5: cheese.push(today);
                                break;
                        }
                    }
                    daysUntilShipment = 6 - rng.nextInt(4); //next shipment between 3 and 6 days
                }
                else if (hour >= 10 && hour <= 19) //customers arrive 1000 to 1900
                {
                    int customers = rng.nextInt(100) + 1; //number of customers each hour (1-100)
                    if (customers > 50)
                    {
                        lostCustomerDay += customers - 50; //lose all customers after 50
                        customers = 50;
                    }
                    //loop through min(customers, 50) and take orders
                    for (int i=0; i<customers; i++)
                    {
                        int customerNum = hour*100 + i; //concatenate hour and customer number (unique for dict each day)
                        customerQueue.enqueue(customerNum);
                    }
                    for (int i=0; i<customers; i++)
                    {
                        int order = rng.nextInt(6); //not +1 because used for array indices
                        boolean enoughIngredients = true; //assume enough until check
                        for (int j=0; j<menu(order).getLength(); j++) //for each ingredient in menu item
                        {
                            enoughIngredients = enoughIngredients && menu(order).view(j).getSize() > 1; //stays true if each food stack has more than 1 item
                        }
                        int customerNum = customerQueue.dequeue();
                        if (enoughIngredients)
                        {
                            for (int j=0; j<menu(order).getLength(); j++) //pop off ingredients needed
                            {
                                menu(order).view(j).pop();
                            }
                            switch (order)
                            {
                                case 0: countItemOne++;
                                    break;
                                case 1: countItemTwo++;
                                    break;
                                case 2: countItemThree++;
                                    break;
                                case 3: countItemFour++;
                                    break;
                                case 4: countItemFive++;
                                    break;
                                case 5: countItemSix++;
                                    break;
                            }
                            dict.add(customerNum, order + 1); //add (customerNum, orderNum) to dict
                        } 
                        else
                        {
                            lostCustomerDay++;
                        }
                    }
                }
                else if (hour == 21) //end of day 2100
                {
                    MergeRecursive.sort(bun.toArray(), 0, bun.getSize()-1); //generic toArray() causes ClassCastException, shouldn't because Integer is passed as generic, so should return Integer array
                    MergeRecursive.sort(lettuce.toArray(), 0, lettuce.getSize()-1);
                    MergeRecursive.sort(patty.toArray(), 0, patty.getSize()-1);
                    MergeRecursive.sort(tomato.toArray(), 0, tomato.getSize()-1);
                    MergeRecursive.sort(onion.toArray(), 0, onion.getSize()-1);
                    MergeRecursive.sort(cheese.toArray(), 0, cheese.getSize()-1);
                    
                    
                    while (!bun.isEmpty() && bun.peek() < today) //pop expired items off stack - since sorted, will pop all off
                    {
                        bun.pop();
                        wasteBun++;
                    }
                    while (!patty.isEmpty() && patty.peek() < today)
                    {
                        patty.pop();
                        wastePatty++;
                    }
                    while (!lettuce.isEmpty() && lettuce.peek() < today)
                    {
                        lettuce.pop();
                        wasteLettuce++;
                    }
                    while (!tomato.isEmpty() && tomato.peek() < today)
                    {
                        tomato.pop();
                        wasteTomato++;
                    }
                    while (!onion.isEmpty() && onion.peek() < today)
                    {
                        onion.pop();
                        wasteOnion++;
                    }
                    while (!cheese.isEmpty() && cheese.peek() < today)
                    {
                        cheese.pop();
                        wasteCheese++;
                    }
                }
            }
            //end of day
            daysUntilShipment--;
            System.out.printf("December %d%n", day); 
            System.out.printf("Customers lost: %d%n", lostCustomerDay);
            System.out.printf("Wasted cheese: %d%n", wasteCheese);
            System.out.printf("Wasted buns: %d%n", wasteBun);
            System.out.printf("Wasted patties: %d%n", wastePatty);
            System.out.printf("Wasted lettuce: %d%n", wasteLettuce);
            System.out.printf("Wasted tomato: %d%n", wasteTomato);
            System.out.printf("Wasted onion: %d%n", wasteOnion);
            System.out.printf("#1 ordered %d times%n", countItemOne);
            System.out.printf("#2 ordered %d times%n", countItemTwo);
            System.out.printf("#3 ordered %d times%n", countItemThree);
            System.out.printf("#4 ordered %d times%n", countItemFour);
            System.out.printf("#5 ordered %d times%n", countItemFive);
            System.out.printf("#6 ordered %d times%n", countItemSix);
            if (!dict.isEmpty())
            {
                Iterator keys = dict.getKeyIterator();
                Iterator values = dict.getValueIterator();
                while (keys.hasNext()) //print all key-value pairs
                {
                    System.out.printf("Customer %d → #%d%n", keys.next(), values.next());
                }
            }

            System.out.println("------------------------");
        }
    }
}
