import java.util.ArrayList;
public class IntegerDoublyLinkedList implements IntegerList{
    private Node head;
    private int size;
    private Node tail;
    public IntegerDoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;

    }
    private Node getNodeAt(int index){
        if (index< 0||index >= size){
            throw new IndexOutOfBoundsException("Invalid index "+index);
        }
        Node current;
        if (index < size/2){
            current = head;
            for (int i=0; i<index;i++){
                current=current.next;
            }
        } else {
            current = tail;

            for (int i = size -1; i > index; i--){
                current = current.prev;
            }

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
            tail=newNode;
        }else{
            Node last = getNodeAt(size-1);
            last.next= newNode;
            newNode.prev = last;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, Integer val) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }

        if (index == size) {
            add(val);
            return;
        }

        Node after = getNodeAt(index);
        Node newNode = new Node(val);

        newNode.next = after;
        newNode.prev = after.prev;

        if (after.prev == null) {
            head = newNode;
        } else {
            after.prev.next = newNode;
        }

        after.prev = newNode;
        size++;
    }

    public Integer remove(int index) {
        Node node = getNodeAt(index);

        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }

        if (node.next == null) {
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }

        size--;
        return node.value;
    }

    public int indexOf(Integer val) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (java.util.Objects.equals(current.value, val)) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1;
    }

    public void clear(){
        head = null;
        tail = null;
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
        IntegerDoublyLinkedList list1=new IntegerDoublyLinkedList();
        list1.add(10);
        list1.add(11);
        list1.add(1,13);
        list1.remove(2);

        System.out.println(list1);
        System.out.println(list1.countRecursive(list1.getNodeAt(0)));
        System.out.println(list1.indexOf(17));
        System.out.println(list1.countIterative());
    }


}