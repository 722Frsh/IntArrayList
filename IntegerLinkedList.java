import java.util.ArrayList;

public class IntegerLinkedList implements IntegerList{

    private Node head;
    private int size;

    public IntegerLinkedList(){
        head=null;
        size=0;
    }

    private Node getNodeAt(int index){
        if (index< 0||index >= size){
            throw new IndexOutOfBoundsException("Invalid index "+index);
        }
        Node current = head;
        for (int i=0; i<index;i++){
            current=current.next;
        }
        return current;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Integer get(int index){
        if (index >=  size ){
            throw new IndexOutOfBoundsException("Invalid index "+index);
        } else {
            return getNodeAt(index).value;
        }
    }

    public void add(Integer val){
        Node newNode=new Node(val);
        if(size==0){
            head=newNode;
        }else{
            Node last = getNodeAt(size-1);
            last.next= newNode;
        }
        size++;
    }

    public void add(int index, Integer val){
        Node newNode=new Node(val);
        if (index< 0||index > size){
            throw new IndexOutOfBoundsException("Invalid index "+index);
        }
        if (index==0){
            newNode.next=head;
            head=newNode;
        }else {
            Node before = getNodeAt(index - 1);
            if(index!=size) {
                newNode.next = getNodeAt(index);
            }
            before.next = newNode;
        }

        size++;
    }

    public Integer remove(int index) {
        Integer val = getNodeAt(index).value;
        if(index==0){
            head=head.next;
            size--;
            return val;
        }
        Node before = getNodeAt(index - 1);
        before.next = before.next.next;
        size--;
        return val;
    }

    public int indexOf(Integer val){
        int count = 0;
        Node current = head;

        while (current.value != val){
            count ++ ;
            if (count >= size){
                return -1;
            }
            current = current.next;
            if (current.value == null){
                return -1;
            }
        }
        return count;
    }

    public void clear(){
        head.next = null;
        size = 0;
    }

    public void set(int index, Integer val){
        if (index >=  size ){
            throw new IndexOutOfBoundsException("noo");
        } else {
            getNodeAt(index).value = val;
        }
    }

    public String toString() {
        Node current=head;
        String out="[";
        if (size==1){
            return "["+current.value+"]";
        }
        if(size>1) {
            out += current.value;
            current = current.next;
            while (current != null) {
                out += ", " + current.value.toString();
                current = current.next;
            }
        }
        out+="]";
        return out;
    }

    public boolean contains(Integer val){
        boolean yes = false;
        for (int i = 0; i < size; i++){
            if (val.equals(getNodeAt(i).value)){
                yes = true;
            }
        }
        return yes;
    }

    public boolean containsRecursive(Integer val, Node e) {
        if (e == null) {
            return false;
        }
        if (e.value.equals(val)) {
            return true;
        }
        return containsRecursive(val, e.next);
    }
    public boolean equals(List<Integer> other){
        if (other.size() != size){
            return false;
        }
        for (int i =0;  i <size; i++){
            if (other.get(i) != this.get(i)){return false;}
        }
        return true;
    }

    public int countIterative(){
        int count = 0;
        Node currentNode = head;
        while ( currentNode != null ){
            count ++;
            currentNode =currentNode.next;
        }

        return count;

    }

    public int countRecursive(Node e){
        if(e==null){
            return 0;
        }
        return countRecursive(e.next)+1;
    }

    public String toStringReversed(){
        String s = "";
        ArrayList<Integer> e = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            e.add(getNodeAt(i).value);
        }

        for (int f = size - 1; f >= 0; f--) {
            s = s + " " + e.get(f);
        }

        return s.trim();
    }


    public static void main (String[] args){
        IntegerLinkedList list1=new IntegerLinkedList();
        list1.add(10);
        list1.add(17);
        list1.add(12);
        list1.add(13);
        //list1.add(1, 1);
        System.out.println(list1);
        list1.remove(1);

        System.out.println(list1);
        System.out.println(list1.countRecursive(list1.getNodeAt(1)));
        System.out.println(list1.countIterative());
        //System.out.println(list1.indexOf(17));
    }
}
