
public class LinkedList {
	public static void main(String[] args){
	//	Node first = new Node('a');
	//	Node second = new Node('b');
	//	first.link = second;
	//	Node third = new Node('c');
	//	second.link = third;
		
//		//print:
//		Node temp = first;
//		System.out.print(temp.value + ">");
//		while (temp.link!=null){
//			temp = temp.link;
//			System.out.print(temp.value + ">");
//			}
//		System.out.println("null");
//		}
		
	Node first;	
	
	public LinkedList(){
		first = new Node('0');
	}
	

	
	void set(char c, int i){
		
	}
	
	void add(char c){
		
	}
	

}

class Node {
	Node(char c){
		value = c;
		link  = null;
	}
	
	char value;
	Node link;
}
