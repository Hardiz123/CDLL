public class Cdll {

    Node head;
    Node tail;

    public Cdll(){
        this.head=null;
        this.tail=null;
    }

    public void addNode(int data) {
        Node newNode = new Node(data);
        if(head==null && tail==null){
            head=tail=newNode;
            head.previous=tail;
            tail.next=head;
        }else{
            tail.next= newNode;
            newNode.previous=tail;
            tail=newNode;
            tail.next=head;
            head.previous=tail;
        }
    }
    
    public void addAtFirst(int data) {
        Node newNode = new Node(data);
        if(isEmpty()){
            head = tail = newNode;
        }else{
            head.previous=newNode;
        }
        newNode.next=head;
        head=newNode;
        tail.next=head;
        head.previous=tail;
    }

    public void insertAtpos(int pos , int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            System.out.println("Cannot insert in middle the list is empty"); //If list is empty
        }else if(pos==1){
            addAtFirst(data);
        }else if(pos>length()){
            System.out.println("cannot add the position is wrong");
        }else{
            // int mid = (length() % 2 == 0) ? (length()/2) : ((length()+1)/2); // this ill give the mid point
            Node current =head; //point to the head
            Node temp=null;
            for(int i=1;i<pos-1;i++){
                current =current.next; //point to the element to the next we want to add new node
            }
            temp = current.next; // assigned to the next of current node
            temp.previous = current; // next will point to the previous node

            current.next = newNode; // current will point to the new node
            newNode.previous = current; // new node will point to the previous node
            newNode.next = temp; // new node will point to the next node
            temp.previous = newNode; // next node will point to the new Node
        }
    }

    public void sort() {

        Node temp =head;
        Node current = head;
        do {
            if(current==head){

            do {
                if(temp.data<current.data){
                    int val = temp.data;
                    temp.data =current.data;
                    current.data=val;
                }
                current=current.next;
            } while (current!=head);
        }
        temp=temp.next;
        } while (temp!=head);
    }

    public void deleteAtmiddle() {
        if(length()==1){
            deleteAtFirst();
        }else if(length()==2){
            deleteAtLast();
        }
        else{
        int mid = (length() % 2 == 0) ? (length()/2) : ((length()+1)/2);

        Node t;
        t =head;
        for(int i=1;i<mid;i++)
        {
            t = t.next;
        }
        t.previous.next=t.next;
        t.next.previous=t.previous;
        t=t.next;
        }
    }

    public void deleteAtpos(int pos) {
        if(pos==1){
            deleteAtFirst();
        }else if(pos==length()){
            deleteAtLast();
        }
        else if(pos>1 && pos<length()){
        Node t;
        t =head;
        for(int i=1;i<pos;i++)
        {
            t = t.next;
        }
        t.previous.next=t.next;
        t.next.previous=t.previous;
        t=t.next;
        }
    }

    public void deleteByValue(int val) {
        if(head.data==val){
            deleteAtFirst();
        }else if(tail.data==val){
            deleteAtLast();
        }else{
            Node temp=head;
            while (temp!=null && temp.data!=val) {
                temp = temp.next;
            }
            temp.previous.next = temp.next;
            temp.next.previous = temp.previous;
            temp = temp.next;
        }
    }


    public void deleteAtFirst() {
        if(head==null && tail==null){
            return;
        }
        head=head.next;
        head.previous=tail;
        tail.next =head;
    }

    public void deleteAtLast() {
        if(!isEmpty()){
            tail=tail.previous;
            tail.next=head;
            head.previous=tail;
        }
    }

    public void printList(){
        Node temp = head;

        do {
            System.out.print(temp.data+"-->");
            temp = temp.next;
        } while (temp!=head);
    }


    public void printreverse(){
        Node temp = tail;

        do {
            System.out.print(temp.data+"-->");
            temp = temp.previous;
        } while (temp!=tail);
    }

    public boolean isEmpty() {
      return head==null && tail==null;
    }

    public int length(){
        int len=0;
        Node temp=head;
        do {
            len++;
            temp = temp.next;
        } while (temp!=head);

        return len;
    }
    
}