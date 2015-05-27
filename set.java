import java.util.HashSet;

public class set {

	public  HashSet<Integer> s;

	public void set() {
		s = new HashSet<Integer>();
	}

	public void add(int i) {
		s.add(i);
	}

	public void  remove(int i) {
		s.remove(i);
	}

	boolean contains(int i) {
		return s.contains(i);
	}
	
	public static void main(String[] args){
		HashSet set1 = new HashSet();
		HashSet set2 = new HashSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set2.add(1);
		set2.add(2);
		System.out.println(set1.containsAll(set2));
	}

	//BULK FUNCTIONS:

	/*
	      returns true if s is a subset of set
	      mmanson01
	 */
	boolean containsAll(set s) {
		Integer [] setcopy = (Integer []) s.s.toArray();
		for(int i = 0; i< setcopy.length; i++) {
			if (s.contains(setcopy[i])){
				return true;
			}
		}
		return false;
	} 
}




