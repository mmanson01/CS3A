public class github {
    
	public static void main(String[] args) {
		
		//System.out.println(arrayequals(mergeSort(new int[]{1,2,3}),new int[] {1,2,3})?"pass":"fail");
		System.out.println(arrayequals(mergeSort(new int[]{3,2,1}),new int[] {1,2,3})?"pass":"fail");
		//System.out.println(arrayequals(mergeSort(new int[]{1}),new int[] {1})?"pass":"fail");
		//System.out.println(arrayequals(mergeSort(new int[]{1,1,1,1}),new int[] {1,1,1,1})?"pass":"fail");		
		System.out.println(arrayequals(mergeSort(new int[]{27,3,4,5,1000}),new int[] {3,4,5,27,1000})?"pass":"fail");
		System.out.println(mergeSort(new int[]{3,2,1}));
		System.out.println(mergeSort(new int[]{27,3,4,5,1000}));
	}
	
	public static boolean arrayequals(int[] a, int[] b) {
		if(a.length!=b.length) return false;
		for (int i = 0; i < b.length; i++) {
			if(a[i]!=b[i]) return false;
		}
		return true;
	}
	
    
    public static int[] mergeSort(int [] list) {
        if (list.length <= 1) {
            return list;
        }
        
        // Split the array in half
        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);
        
        // Sort each half
        mergeSort(first);
        mergeSort(second);
        
        // Merge the halves together, overwriting the original array
        merge(first, second, list);
        return list;
    }
    
    private static void merge(int[] first, int[] second, int [] result) {
        result = first;
    }
    
}
