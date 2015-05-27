
public class picoBasicASM {
	public static void main (String[]args){
		double eax = 0;
		double ebx = 0;
		double ecx = 0;
		double temp = 0;
		eax = 19508;
		ebx = 16731;
		ecx = 1436;
		temp = ebx-eax;
			
		if (temp>=0){
			ebx = eax * ebx;
			ebx = ebx-eax;
			eax = ebx;
			eax = eax + ecx;
		}
		
		else {
			ebx = eax * ebx;
			ebx = ebx+eax;
			eax = ebx;
			eax = eax - ecx;
			
		}
		
		System.out.println(eax);
		
	
	}
	
}
