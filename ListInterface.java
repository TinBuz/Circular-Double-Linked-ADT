/*Purpose: Data Structure and Algorithms Lab 4 Problem 1
 *i Status: Complete and thoroughly tested
 * Last update: 02/18/2016
 * Submitted:  02/18/2016
 * Comment: Interface class
 * @author: Tin Buzancic
 * @version: 2016.18.02
 */

public interface ListInterface
{
    boolean isEmpty();
    int size();
    void add(int index, Object item)
    throws ListIndexOutOfBoundsException;
    Object get(int index)
    throws ListIndexOutOfBoundsException;
    void remove(int index)
    throws ListIndexOutOfBoundsException;
    void removeAll();
}  // end ListInterface
