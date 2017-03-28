public class MyQueue {
   
   private Node head;
   private int count=0;
   public void add(Object o) {
      Node newNode = new Node(o);
      if(this.isEmpty())
         head=newNode;
      else {
          Node end = head;
          while (end.getNext() != null) {
              end = end.getNext();
          }
          end.setNext(newNode);

          newNode.setPrev(end);
      }
      count++;
   }
   public Node remove() {
      Node oldHead = head;
      if(head == null)
          return null;
      if(head.getNext()==null){
          count--;
          head = null;
          return oldHead;
      }
      head = head.getNext();
      count--;
      return oldHead;

   }
   public Node peek(){
      return head;
   }
   public boolean isEmpty() {
      return head==null;
   }

   public int size(){
      return count;
   }
   
}