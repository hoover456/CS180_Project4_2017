public class MyQueue {
   
   private Node head; //first Node in the Queue
   private int count=0; //number of nodes in the Queue


   public void add(Object o) { //add a new node with data of Object o to the end of the queue
      Node newNode = new Node(o); //create Node with data of object o
      if(this.isEmpty()) //if the queue is empty, the new node becomes the head
         head=newNode;
      else { //otherwise, we need to add the new node to the end of the queue
          Node end = head; //Start at the head and traverse queue to the last non-null Node
          while (end.getNext() != null) {
              end = end.getNext();
          }
          end.setNext(newNode); //Set the next node after the end of our queue to be the new node

          newNode.setPrev(end); //set the node previous our new node to be the old end of the queue
      }
      count++; //add one to the count of nodes in the queue
   }
   public Node remove() { //removes the head of the queue and returns it
      Node oldHead = head; //The node to be removed
      if(this.isEmpty())
          return null; //make sure the queue is not empty, if it is return null
      if(head.getNext()==null){ //if head is the only node in the queue, we need a special case to avoid a NullPointerException
          count--;
          head = null;
          return oldHead;
      }
      head = head.getNext(); //set head to the next node in the queue
      count--; //remove one node from the queue size
      return oldHead; //return the old head node that has now been removed

   }
   public Node peek(){
      return head; //returns head without removing it
   }
   public boolean isEmpty() {
      return head==null;
   }

   public int size(){
      return count;
   }
   
}