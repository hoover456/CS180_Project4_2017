public class Node {
   
    private Object data; //data is of type object so we can have queues of any type. All objects extend object, so this is valid (thanks Java!)
    private Node next;
    private Node prev;

    public Node(Object obj) {
        this.data=obj;
    }
    public void setNext(Node next) {
        this.next=next;
    }

    public void setPrev(Node prev){
        this.prev=prev;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public Object getData() {
        return data;
    }
   
}