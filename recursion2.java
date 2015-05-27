import javax.swing.text.StyledEditorKit.ForegroundAction;


public class recursion2 {

	public static void main (String[] args){

		System.out.println("reverse " + (reverseTest()?"Passed":"Failed"));

	}


	/*
	 * Reverse (2pt)
	 * R(a, i) = a                  (if i >= |a|/2)
	 * R(a, i) = R(b, i+1)
	 * b has the ith and |a|-ith letters swapped
	 */


	/*	static char[] reverse(char[] arr) {
		return reverse(arr,0);	
	}

	static char[] reverse(char[] arr,int i) { 	
		if(i >= (arr.length)/2) return arr;

		char temp = arr[i];
		arr[i] = arr[arr.length-1-i];
		arr[arr.length-1-i] = temp;		

		return reverse(arr, i+1);
	 }
	 */	
	static char[] reverse(char[] a) {
		char[] b = new char[a.length+1];
		return reverse(a, b, 0);
	}	

	static char[] reverse(char [] a, char[] b, int position){
		int length = a.length-1;
		int middle = (a.length+1)/2;
		b[position] = a[length-position];
		b[length-position] = a[position];	
		if (position > middle) return b;
		return reverse(a, b, position+1);
	}

	static boolean reverseTest() {
		char[] test = new char[4];
		char[] answer = new char[4];
		test = "meredith".toCharArray();
		answer = "edcba".toCharArray();

		System.out.println(reverse(test));
		System.out.println(answer);
	//	if((reverse(test).length)!=("edcba".toCharArray())) return false;
		// if(reverse(0,0)!=0) return false;
		//  if(reverse(5,0.01)!=2.236328125) return false;
		//  if(reverse(8,3)!=3) return false;  //recursion check
		//    if(reverse(13,1)!=0) return false;  //error handling check
		return true;
	}
}