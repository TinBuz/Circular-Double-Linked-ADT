/* Purpose: Data Structure and Algorithms Lab 4 Problem 1
 * Status: Redone and tested
 * Last update: 02/25/2016
 * Submitted:  02/25/2016
 * Comment: test suite and sample run attached
 * @author: Tin Buzancic
 * @version: 2016.25.02
 */

public class ListCDLSBased implements ListInterface
{
    // reference to linked list of items
    private Node head;		//will reference the first instance in the collection
    private int numItems;	//will keep track of the number of items in the collection

    public ListCDLSBased()
    {
        head = null;
        numItems = 0;
    }  // end default constructor

    public boolean isEmpty()
    {
        return (head == null);
    }  // end isEmpty

    public int size()
    {
        return numItems;
    }  // end size

    private Node find(int index)
    {
        Node curr = head;
        if(index >= 0 && index <= numItems)
        {
            if(index <= (numItems/2))
            {
                for(int i = 0; i < index; i++)		// traverses the circular list forwardly
                {   // if the index is in the second half of the list
                    curr = curr.getNext();
                } // end for
            }
            else
            {
                for(int i = numItems; i > index; i--)	// traverses the circular list backwards
                {   // if the index is in the first half of the list
                    curr = curr.getBack();
                }
            } // end for
        }
        return curr;
    } // end find

    public Object get(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            Node curr = find(index);			// use find method to retrieve node at index
            Object result = curr.getItem();		// set Object return from .getITem to Object result
            return result;
        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds exception on get");
        } // end if
    } // end get

    public void add(int index, Object item)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index <= numItems)
        {
            if (index == 0)
            {
                if(numItems == 0)
                {
                    Node newNode = new Node(item, head, head);		// create new Node with desired item which self references
                    head = newNode;						// creats the collection
                }
                else
                {
                    Node first = find(index);				// gets the node at index 0
                    Node last = find(numItems - 1);				// gets the node at last position, which is linked to index 0 as well.
                    Node newNode = new Node(item, first, last);
                    first.setBack(newNode);					// sets the old index 0 to index 1
                    last.setNext(newNode);					// sets thenode at last positions Next ref to the new node.
                    head = newNode;
                } // end if
            }
            else
            {
                Node prev = find(index - 1);					// stores the previous node which will have its Next ref linked to new node w/ new item
                Node next = find(index);					// stores the node after the previous node which will have its Back ref linked to new node w/ new item
                Node newNode = new Node(item, prev, next);
                prev.setNext(newNode);						// links the prev node with the new node which contains the new item
                next.setBack(newNode);						// links the curr node with the node node which contains the new item
            }
            numItems++;
        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds exception on add");
        } // end if
    }  // end add

    public void remove(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            if (index == 0)
            {
                // delete the first node from the list
                Node prev = head.getBack();		// get ref of heads prev reference
                head = head.getNext();			// set head to "index 1"
                head.setBack(prev);			// set the prev reference to new head.
            }
	    else if(index == 1)
	    {
		head = null;
	    }
            else
            {
                Node prev = find(index - 1);
                Node curr = prev.getNext();
                prev.setNext(curr.getNext());
                prev.setBack(prev.getBack());
            } // end if
            numItems--;
        } // end if
        else
        {
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds exception on remove");
        } // end if
    }   // end remove

    public void removeAll()
    {
        numItems = 0;		// resets numItems
        head = null;		// wipes the reference, wipiing the collection.
    } // end removeAll

    public String toString()
    {
        String result = "";
	Node curr = head;
        for(int i = 0; i <= numItems - 1; i++)	// traverses through the list and gets string representation of each item.
        {
	    result += curr.getItem() + " ";
	    curr = curr.getNext();
        }
        return result;
    }
}
// end ListCDLSBased
