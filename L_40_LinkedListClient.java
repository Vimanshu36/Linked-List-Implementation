public class L_40_LinkedListClient {
    public static void main(String[] args) throws Exception 
    {
        L_40_LinkedList ll = new L_40_LinkedList();
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.addFirst(5);       
        ll.addAt(3, 66);
        // ll.removeLast();
        // ll.removeAt(1);
        // ll.reverseIteratively();
        // ll.reverseRecursively();                    
        // ll.reverseRecursivelyDeep();
        // // ll.reverseRecursiveOneVar();
        // System.out.println(ll.midPoint());
        // System.out.println(ll.kthfromLast(2));
        // ll.Display();

        ll.createDummyList();

    }
}
