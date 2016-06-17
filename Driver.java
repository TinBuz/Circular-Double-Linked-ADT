/* Purpose: Data Structure and Algorithms Lab 4 Problem 1
 * Status: Redone and tested
 * Last update: 2/25/2016
 * Submitted:  2/25/2016
 * Comment: test suite and sample run attached
 * @author: Tin Buzancic
 * @version: 2016.25.02
 */
import java.io.*;

public class Driver extends ListCDLSBased
{
    public static BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException
    {
        ListCDLSBased circularList = new ListCDLSBased();
        while(true)
        {
            System.out.println("Select from the following menu: ");
            System.out.println("		1. Insert item to list.");
            System.out.println("		2. Remove item from list.");
            System.out.println("		3. Get item from list.");
            System.out.println("		4. Clear list.");
            System.out.println("		5. Print size and content of list.");
            System.out.println("		6. Exit program.");
            System.out.print("Make your menu selection now: ");
            String response = bReader.readLine().trim();
            System.out.println(response);
            switch(response)
            {
            default:
                System.out.println("Not a valid option. Please enter again.\n");
                break;
            case "1":
                try
                {
                    System.out.println("You are now inserting an item into the list.");
                    System.out.print("		Enter Item: ");
                    String item = bReader.readLine().trim();
                    System.out.println(item);
                    System.out.print("		Enter position to insert item in: ");
                    String position = bReader.readLine().trim();
                    System.out.println(position);
                    circularList.add(Integer.parseInt(position), item);
                    System.out.println("Item " + item + " was inserted in position " + position + " of the list.\n");
                }
                catch(ListIndexOutOfBoundsException e)
                {
                    System.out.println("Position specified is out of range!\n");
                }
                break;
            case "2":
                if(circularList.isEmpty())
                {
                    System.out.println("List is empty.\n");
                }
                else
                {
                    try
                    {
                        System.out.print("		Enter the position to remove item from: ");
                        String position = bReader.readLine().trim();
                        System.out.println(position);
                        System.out.println("Item " + circularList.get(Integer.parseInt(position)) + " was  removed from position " + position + " of the list.\n");
                        circularList.remove(Integer.parseInt(position));
                    }
                    catch(ListIndexOutOfBoundsException e)
                    {
                        System.out.println("Position specified is out of range!\n");
                    }
                }
                break;
            case "3":
                if(circularList.isEmpty())
                {
                    System.out.println("List is empty.\n");
                }
                else
                {
                    try
                    {
                        System.out.print("		Enter position to retrieve item from: ");
                        String position = bReader.readLine().trim();
                        System.out.println(position);
                        circularList.get(Integer.parseInt(position));
                        System.out.println("Item " + circularList.get(Integer.parseInt(position)) + " rests in position " + position + " of the list.\n");
                    }
                    catch(ListIndexOutOfBoundsException e)
                    {
                        System.out.println("Position specified is out of range!\n");
                    }
                }
                break;
            case "4":
                if(circularList.isEmpty())
                {
                    System.out.println("List is empty.\n");
                }
                else
                {
                    circularList.removeAll();
                    System.out.println("All items were removed from the list.\n");
                }
                break;
            case "5":
                if(circularList.isEmpty())
                {
                    System.out.println("List is empty.\n");
                }
                else
                {
                    System.out.println("	The list of size " + circularList.size() + " has the following items: " + circularList.toString() + "\n");
                }
                break;
            case "6":
                System.out.println("Exiting program... Good Bye.\n");
                System.exit(0);
                break;
            }
        }
    }
}
