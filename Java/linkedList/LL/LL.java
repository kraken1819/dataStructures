package linkedList.LL ;
class Node {
    public int data ;
    public Node next ;

    public Node(int data) {
        this.data = data ;
        this.next = null ;
    }
    public Node(int data , Node next) {
        this.data = data ;
        this.next = next ;
    }
    public void printLL(Node head) {
        while(head.next!=null){
            System.out.print(head.data) ;
            System.out.print("->") ;
            head = head.next ;
        }
        System.out.print(head.data) ;
    }
}
public class LL {


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5} ;
        Node head = new Node(nums[0]) ;
        Node temp = head ;
        for(int i = 1 ; i< nums.length ; i++) {
            Node n = new Node(nums[i]);
            temp.next = n;
            temp = temp.next;
        }
        head.printLL(head);
    }
}
