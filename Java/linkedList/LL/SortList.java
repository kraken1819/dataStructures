/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 /*
    Given time complexity O(nlogn). so we have to use merge sort or quick sort . 
*/


class SortList {
    class ListNode { 
        int val ; 
        ListNode next ; 
        ListNode(){};
        ListNode(int val){this.val = val;}
        ListNode(int val,ListNode next) {this.val = val ; this.next = next;}
    }
    public ListNode findMid(ListNode low , ListNode high){
        ListNode first = low ; 
        ListNode second = low ; 
        while(second != high && second.next!=high){
            first = first.next;
            second = second.next.next;
        }
        return first;
    }
    public ListNode Merge(ListNode firstHalf,ListNode secondHalf){
        ListNode i = firstHalf ; 
        ListNode j = secondHalf;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(i!=secondHalf && j!=null){
            if(i.val<j.val){
                temp.next = i;
                i = i.next;
            }else{
                temp.next = j ; 
                j = j.next;
            }
            temp = temp.next;
        }
        while(i!=secondHalf){
            temp.next = i;
            i = i.next;
            temp = temp.next;
        }
        while(j!=null){
            temp.next = j ; 
            j = j.next;
            temp = temp.next;
        }
        return head.next;

    }
    public ListNode MergeSort(ListNode low, ListNode high){
        if(low == high) return low;  

        ListNode mid = findMid(low,high);
        ListNode firstHalf = MergeSort(low,mid);
        ListNode secondHalf = MergeSort(mid.next,high);
        return Merge(firstHalf,secondHalf);

    }
    public ListNode sortList(ListNode head) {
        ListNode low = head ; 
        ListNode high = head ; 
        while(high.next!=null){
            high = high.next;
        }
        return MergeSort(low,high);
    }
}