import java.util.Stack;


public class stack {
	public static void main(String[] args) {
       Stack s = new Stack(5);
       // s.push(2);
       //s.push(3);
        System.out.println(s.pop());
        resize();
    }



    private int[] arr;
    private int top;

    public Stack(int size) {
        arr = new int[size];
        top = 0;
    }

    public void push(int i) {
        arr[top++] = i;
        if(top>=arr.length) resize();
    }

    public int pop() {
        if(isEmpty()) return -1;
        return arr[--top];
    }

    public boolean isEmpty() {
        return top==0;
    }

    public int peek() {
        if(isEmpty()) return -1;
        return arr[top-1];
    }


	
	 private void resize() {
	      //make a new array that is twice as large
	      int[] arrcopy = new int[arr.length*2];

	      //copy everything over
	      
	      for(int i = 0; i < arr.length; i++){
	        arr[i]=arrcopy[i];
	    }

	      //set arr to that array
	      arr=arrcopy;
	    }


}
