import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Simple first version of LinkedIntList with just a constructor
// and methods for add and toString.

public class LinkedIntList {
    private ListNode front;  // first value in the list

    // post: constructs an empty list
    public LinkedIntList() {
        front = null;
    }

    // post: returns comma-separated, bracketed version of list
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }
    //Problem 1 Answer: O(N^2) 
 
    //Problem 2
    public static Stack<Integer> copystack(Stack<Integer> st){
    
    		Stack<Integer> copy = new Stack<Integer>();
    		Queue<Integer> stor = new LinkedList<Integer>();
    		
    		// moves all the values in st into copy Stack (reverse order)
    		while(!st.isEmpty()) {
    			copy.add(st.pop());
    		}
    		
    		// moves all the values in the copy Stack into Queue( correct order)
    		while(!copy.isEmpty()) {
    			stor.add(copy.pop());
    		}
    		
    		// moves all the values in queue with correct order back into BOTH
    		// st stack and copy stack.
    		while(!stor.isEmpty()) {
    			int element = stor.remove();
    			st.add(element);
    			copy.add(element);
    		}
    	// now return copy stack, not the original stack
    	return copy;
    }
    
    //Problem 3
    public boolean isSorted() {
    	
    	//empty list is considered to be sorted.
    	if(front == null) return true;
    	
    	//first value in the list = current
    	ListNode current = front;
    	
    	//while it has next value
    	while(current.next !=null) {
    		
    		// if the current value is already greater than the next value,
    		// it's not sorted. Therefore return false
    		if(current.data > current.next.data) {
    			return false;
    			
    			//if not, put next value in current element and check for the next value
    		} current = current.next;
    	}
    	return true;
    }
    
    
    
    
    
    // to test the methods, create lil and stack elements 
    // and test the two methods.
    public static void main(String[] args) {
    	LinkedIntList lil = new LinkedIntList();
    	lil.add(1);
    	lil.add(2);
    	lil.add(3);
    	lil.add(9);
    	lil.add(5);
    	lil.add(6);
    	lil.add(7);
    	
    	System.out.println(lil.isSorted()); // must return false.
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.add(1);
    	stack.add(2);
    	stack.add(3);
    	stack.add(4);
    	stack.add(5);
    	stack.add(6);
    	stack.add(7);
    	stack.add(8);
    	
    	System.out.println(copystack(stack));
    	}
    }
