
public class Student {
	String fn;
	String mn;
	String ln;
	String mf;
	String ge;
	String cg;
	int cy;
	int bday;
	int bmonth; 
	int byr; 
	String advisor;


	public Student(String input) {
		
		String[] line = input.split(",");

		fn = line[0];
		mn = line[1];
		ln = line[2];
		mf = line[3];
		ge = line[4];
		cg = line[5];
		cy = Integer.parseInt(line[6]);
		bday = Integer.parseInt(line[7]);
		bmonth = Integer.parseInt(line[8]); 
		byr = Integer.parseInt(line[9]); 
		advisor = line[10];
	}
}