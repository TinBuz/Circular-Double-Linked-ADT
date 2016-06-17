/* Purpose: Data Structure and Algorithms Lab 4 Problem 1
 * Status: Thouroughly tested
 * Last update: 02/18/2016
 * Submitted: 02/18/2016
 * Comment: Node Class with new fields next and back
 * @author: Tin Buzancic
 * @version: 2015.18.02
 */

public class Node
{
    private Object item;
    private Node next;
    private Node back;

    public Node(Object newItem)
    {
        item = newItem;
        next = null;
        back = null;
    } // end constructor

    public Node(Object newItem, Node nextNode, Node backNode)
    {
        item = newItem;
        next = nextNode;
        back = backNode;
    } // end constructor

    public void setItem(Object newItem)
    {
        item = newItem;
    } // end setItem

    public Object getItem()
    {
        return item;
    } // end getItem

    public void setNext(Node nextNode)
    {
        next = nextNode;
    } // end setNext

    public Node getNext()
    {
        return next;
    } // end getNext

    public void setBack(Node backNode)
    {
        back = backNode;
    } // end setBack

    public Node getBack()
    {
        return back;
    } // end getBack
} // end class Node
