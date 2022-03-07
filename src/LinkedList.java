public class LinkedList {
    public class Node
    {
        int data;
        Node next;
        public Node(int data)
        {
            this.data=data;
        }
    }

    Node head;
    Node tail;
    int size;
    private void addAtLast(int data){
        Node nn=new Node(data);
        size++;
        if(head==null)
        {
            head=nn;
            tail=nn;
            return;
        }
        tail.next=nn;
        tail=nn;

    }
    private int size(){
        return size;
    }
    private void display(){
        Node i =head;
        while(i!=null)
        {
            System.out.print(i.data+"->");
            i=i.next;
        }
        System.out.println();

    }
    private void addAtFirst(int data)
    {
        size++;
        Node nn=new Node(data);
        if(head==null)
        {
            head=nn;
            tail=nn;
            return;
        }
        nn.next=head;
        head=nn;
    }
    private Node getNodeAt(int x){

        if(x>size-1 && x<0)
            System.out.println("check Index");

        Node i=head;
        for(int j=1;j<=x;j++)
            i=i.next;
        return i;
    }
    private void addAt(int idx,int data)
    {
        if(idx==0){
       addAtFirst(data);
        return;
        }

        Node pre=getNodeAt(idx-1);
        Node  nn=new Node(data);
        nn.next=pre.next;
        pre.next=nn;
        size++;

    }
    private int getValueAt(int idx){
        return getNodeAt(idx).data;
    }
    private boolean isEmpty()
    {
        return size==0;
    }
    private void removeFirst()
    {

        if(size==1)
        {
            head=null;
            tail=null;
            size--;
            return;

        }
        Node temp=head;
        head=head.next;
        temp.next=null;
        size--;
    }
    private void removeAtLast()
    {
        if(size==0)
        {
            removeFirst();
            return;
        }
        Node second=getNodeAt(size()-2);
        second.next=null;
        tail=second;
        size--;
    }
    private void removeAt(int idx)
    {
        if(size==0)
        {
            removeFirst();
            return;
        }
        Node pre=getNodeAt(idx-1);
        Node next=pre.next.next;
        Node curr=pre.next;
        pre.next=next;
        curr.next=null;
        size--;
    }
    private void reverse()
    {
        Node pre=null;
        Node curr=head;
        while(curr!=null)
        {
            Node cNext=curr.next;
            curr.next=pre;
            pre=curr;
            curr=cNext;
        }
        Node temp=head;
        head=tail;
        tail=temp;
    }

    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.addAtLast(11);
        ll.addAtLast(9);
        ll.display();
        ll.addAtFirst(12);
        ll.display();
        ll.addAt(2,10);
        ll.display();
        ll.removeAt(2);
        ll.display();
        ll.reverse();
        ll.display();


    }
}
