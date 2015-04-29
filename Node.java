/** Represents one node to be used in a linked list
    Contains data (object) and reference to next in list
*/

public class Node {
  private Card item;
  private Node next;

  /** Create new node with specified data
      Have it reference null
      @param newItem is data to added to new node
  */
  public Node(Card newItem) {
    item = newItem;
    next = null;
  } 
  
  /** Create new node with specified data
      Have it reference nextNode
      @param newItem is data to added to new node
      @param nextNode is reference that new Node's next will hold
      
  */
  public Node(Card newItem, Node nextNode) {
    item = newItem;
    next = nextNode;
  } 
  /** set data field (item) of Node
      @param newItem, to set item field to
  */
  public void setItem(Card newItem) {
    item = newItem;
  } // end setItem

  /** get data field (item) of Node
      @return item field
  */
  public Card getItem() {
    return item;
  } 

  /** set next field  of Node
      @param nextNode, to set next field to
  */
  public void setNext(Node nextNode) {
    next = nextNode;
  } 

  /** get next field  Node
      @return next field
  */
  public Node getNext() {
    return next;
  }
} 