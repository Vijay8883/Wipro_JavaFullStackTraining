package Day12Assignments;

	public class RemoveDuplicates {
	    public Listnode removeDuplicates(Listnode head) {
	        Listnode current = head;
	        while (current != null && current.next != null) {
	            if (current.val == current.next.val) {
	                current.next = current.next.next;
	            } else {
	                current = current.next;
	            }
	        }
	        return head;
	    }

	    // Example usage
	    public static void main(String[] args) {
	        Listnode head = new Listnode(11);
	        head.next = new Listnode(11);
	        head.next.next = new Listnode(11);
	        head.next.next.next = new Listnode(13);
	        head.next.next.next.next = new Listnode(13);
	        head.next.next.next.next.next = new Listnode(20);

	        RemoveDuplicates remover = new RemoveDuplicates();
	        Listnode result = remover.removeDuplicates(head);

	        // Print the modified linked list
	        while (result != null) {
	            System.out.print(result.val + " ");
	            result = result.next;
	        }
	    }
	}