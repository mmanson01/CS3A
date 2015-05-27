public class List {

	 public static void main(String[] args){
			List l = new List(6);
			List sublist = new List(4);
			l.add(1);
			l.add(2);
			l.add(3);
			l.add(4);
			l.add(5);
			l.add(6);
			//System.out.println(l.indexOf(4));
			sublist.add(1);
			sublist.add(2);
			sublist.add(3);
			sublist.add(4);
		System.out.println(indexOfSubList(l,sublist));	
		}
	
	private int[] arr;
	int size = 0;

	public List(int default_size) {
		arr = new int[default_size];
	}

	int get(int index) {
		return arr[index];
	}

	void set(int index, int element) {
		arr[index] = element;
	}
	
	int indexOf(int element) {
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (element == get(i)) return i;
		}
		return -1;
	}

	void add(int element) {
		arr[size++] = element;
		if(size==arr.length) resize();
	}

	void add(int index, int element) {
		for(int i = size; i>index; i--) {
			arr[i] = arr[i-1];
		}

		arr[index] = element;

		size++;
		if(size==arr.length) resize();

	}

	void remove(int index) {
		for(int i = index; i<size; i++) {
			arr[i] = arr[i+1];
		}

		size--;
	}

	void resize() {

	}
	

	/*
    indexOfSubList — returns the index of the first sublist of one List that is equal to another.

    1. find the value of the first spot in sublist
    2. find the index of that value in list
    3. see if the next value in sublist is at the next index in list until you've finished the length of the sublist
    4. return index of the value of the first spot in the sublist in List

    mmanson01
	 */
	static int indexOfSubList(List l, List sublist) {
		int index = 0;
		int listnum = 0;
		int subfirstnum = sublist.get(0); //finds value of first spot in sublist
		index = l.indexOf(subfirstnum); // find index of that value in list
		
		int temp =0;
		for (int i = 0; i < sublist.size;) 
		{
			if (l.get(index+i) == sublist.get(i)) i++;
			else if (l.get(index+i) != sublist.get(i)) return -1;
		}
		return index;
	}

}
