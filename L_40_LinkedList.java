public class L_40_LinkedList {
    
    private class Node                  //private as we want to only use Node class in this file , there will be a space allocated in memory named as Node
    {
        int data;
        Node next;                      // next is storing the address of the next node

        Node(int data)                      //constructor
        {
            this.data = data;
        }
        Node()                              //default constructor
        {

        }
    }

    private Node head;                  //It is an variable of node type ( It is not really storing the starting address of node we are making it to store)

    public void Display()
    {
        Node temp = head;                           //we need to store the head in a variable

        while(temp != null)                                 //loop for traversing the LL
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public int size()
    {
        Node temp = head;               
        int count = 0;
        while(temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public boolean isEmpty()
    {
        // return size() == 0;             //It will affect the T.C as it will call size function which will traverse the whole LL resulting in O(n) complexity
        return head == null;                //if head is equals to null then LL is empty
    }

    public int getFirst() throws Exception
    {
        if(isEmpty())          
        {
            throw new Exception("Linked list is empty");
        }
        return head.data;
    }

    public int getLast() throws Exception
    {
        if(isEmpty())          
        {
            throw new Exception("Linked list is empty");
        }
        
        Node temp = head;

        while(temp.next != null)
        {
            temp = temp.next;
        }
        return temp.data;                       //we will get the last value as temp is at last of LL
    }

    public int getAt(int idx) throws Exception
    {
        if(isEmpty())          
        {
            throw new Exception("Linked list is empty");
        }
        if(idx < 0 || idx > size()-1)
        {
            throw new Exception("Invalid index");
        }
        if(idx == 0)
        {
            return getFirst();
        }
        else if(idx == size()-1)
        {
            return getLast();
        }

        Node temp = head;

        for(int i = 1 ; i <= idx ; i++)
        {
            temp = temp.next;
        }
        
        return temp.data;
    }

    private Node getNodeAt(int idx) throws Exception
    {
        if(isEmpty())          
        {
            throw new Exception("Linked list is empty");
        }
        if(idx < 0 || idx > size()-1)
        {
            throw new Exception("Invalid index");
        }
        
        Node temp = head;

        for(int i = 1 ; i <= idx ; i++)
        {
            temp = temp.next;
        }
        
        return temp;                    //we need to return the address of the node
    }

    public void addLast(int item) throws Exception
    {
        //Creating a new node with data as item
        Node nn = new Node();
        nn.data = item;             //store the item at this particular node
        nn.next = null;             //can be skipped

        if(isEmpty())               //LL is empty and adding a value first time
        {
            head = nn;
        }
        else
        {
            //linking the node
            Node last = getNodeAt(size()-1);            //will give the address of the "last" node 
            last.next = nn;                             //storing the address of nn in last.next
        }
    }

    public void addFirst(int item) throws Exception
    {
        //create a new node
        Node nn = new Node();
        nn.data = item;
        nn.next = null;

        //linking , even if the lisked list is empty there will be no effect as there is null on nn.next
        nn.next = head;
        head = nn;              //now address of new node will be the head of the LL
    }

    public void addAt(int idx , int item) throws Exception
    {
        if(idx < 0 || idx > size())
        {
            throw new Exception("Invalid Syntax");
        }

        if(idx == 0)
        {
            addFirst(item);
        }
        else if(idx == size())
        {   
            addLast(item);
        }
    
        else
        {
            //Creating a new node with data as item
            Node nn = new Node();
            nn.data = item;             //store the item at this particular node
            nn.next = null;             //can be skipped
            
            //linking
            Node n1 = getNodeAt(idx-1);
            Node n2 = getNodeAt(idx);
            
            n1.next = nn;
            nn.next = n2;
        } 
    }

    public int removeLast() throws Exception
    {
        if(isEmpty())
        {
            throw new Exception("Linked List empty");
        }

        int rv = getLast();                                 //storing the last value

        if(size()==1)                       //as there will be no size() - 2
        {
            head = null;
        }
        else
        {
            Node sm2 = getNodeAt(size()-2);                     //getting the address of secpnd last node
            sm2.next = null;                                    //removing the address of last node from second last node
        }

        return rv;
    }

    public int removeFirst() throws Exception
    {
        if(isEmpty())
        {
            throw new Exception("Linked List empty");
        }
        int rv = getFirst();

        if(size()==1)
        {
            head = null;
        }
        else
        {
            head = head.next;                       //by this there will be no way of reaching to the startng node
        }

        return rv;
    }

    public int removeAt(int idx) throws Exception
    {
        if(isEmpty())
        {
            throw new Exception("Linked List empty");
        }

        if(idx < 0 || idx >= size())
        {
            throw new Exception("Invalid index");
        }

        if(idx == 0)
        {
            return removeFirst();
        }

        if(idx == size() - 1)
        {
            return removeLast();
        }

        else
        {
            Node im1 = getNodeAt(idx - 1);              //getting the address of previous node
            Node i = im1.next;              //creating a node which stores the node has to be deleted
            Node ip1 = i.next;              //ip1's address is stored in i.next node (written here just for pointing)

            im1.next = ip1;
            
            return i.data;
        }
        
    }

    public void reverseIteratively()
    {
        Node prev = null;                   //just one extra call and everything is same
        Node curr = head;
        //Node prev = head;
        //Node curr = prev.next;

        while(curr!=null)
        {
            Node ahead = curr.next;        //this will store the address of next node before reverse by which there will be way of reaching to that particular node
            curr.next = prev;              //putting the prev address in curr   

            //updation
            prev = curr;                   //prev move forward 
            curr = ahead;                  //curr move forward 
        }

        head.next = null;                  //currently head is storing the address of 2k, we have to break the loop hence we need to do this 
        head = prev;                       // as prev is at the last of the LL 
    }
    
    private void reverseRecursively(Node prev , Node curr) 
    {
        if(curr == null)
        {
            head = prev;    
            return;
        }
        reverseRecursively(curr, curr.next);    
        curr.next = prev;                       //will execute after the hitting base case
    }

    public void reverseRecursively()        //When we need to run a public function which requires private parameters to run then we will use this method known as abstraction
    {         
        reverseRecursively(null , head);
    }

    private void reverseRecursivelyDeep(Node prev , Node curr) 
    {
        if(curr == null)
        {
            head = prev;    
            return;
        }
        Node ahead = curr.next;             //used for preserving the curr.next
        curr.next = prev;
        reverseRecursivelyDeep(curr, ahead);    
    }

    public void reverseRecursivelyDeep()        //When we need to run a public function which requires private parameters to run then we will use this method known as abstraction
    {         
        reverseRecursivelyDeep(null , head);
    }

    private void reverseRecursiveOneVar(Node curr) 
    {
        //last node
        if(curr.next == null)
        {
            head = curr;                    //setting the head at last node
            return; 
        }
        reverseRecursiveOneVar(curr.next);    

        curr.next.next = curr;              //put curr in address(next) part of curr.next
    }

    public void reverseRecursiveOneVar()
    {
        Node temp = head;                       //created for making the 1ks next null
        reverseRecursiveOneVar(head);
        temp.next = null;
    }
    
    public int midPoint()
    {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null)                //condition for even and odd nodes (This order should be followed)
        {
            slow = slow.next;
            fast = fast.next.next;                              //jumping one node
        }

        return slow.data;
    }

    public int kthfromLast(int k)
    {
        Node slow = head;
        Node fast = head;

        for(int i = 1 ; i <= k ; i++)
        {
            fast = fast.next;
        }

        while(fast != null)
        {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }

    public void createDummyList() 
    {
        Node n1 = new Node(1);   
        Node n2 = new Node(2);   
        Node n3 = new Node(3);   
        Node n4 = new Node(4);   
        Node n5 = new Node(5);   
        Node n6 = new Node(6);   
        Node n7 = new Node(7);   
        Node n8 = new Node(8);   
        Node n9 = new Node(9);   
        Node n10 = new Node(10);   
        Node n11 = new Node(11);   
        Node n12 = new Node(12);   
        Node n13 = new Node(13);   

        //creating LL1
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;

        //Creating LL2
        n13.next = n12;
        n12.next = n11;
        n11.next = n7;

        System.out.println(intersection(n1,n13)); 
    }

    private int intersection(Node h1, Node h2) 
    {
        Node fp = h1;
        Node sp = h2;

        while(fp != sp)
        {
            if(fp == null)
            {
                fp = h2;
            }
            else
            {
                fp = fp.next;
            }

            if(sp == null)
            {
                sp = h1;
            }
            else
            {
                sp = sp.next;
            }            
        }

        return fp.data;
    }
}


