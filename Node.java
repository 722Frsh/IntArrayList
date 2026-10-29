public class Node {
    public Integer value;
    public Node next;
    public Node prev;

    public Node(Integer value){
        this.value=value;
        next=null;
        prev=null;
    }

    public static void main(String[] args){
        Node head=new Node(3);

        head.next=new Node(7);
        head.next.next=new Node(10);


        Node current=head;
        while(current!=null){


            System.out.println(current.value);
            current=current.next;
        }
    }
}
