import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/*********
 * 
 * @author James Konigsberg
 * Goal: Complete FASCL
 * Date: 11/18/14
 *
 */

public class FASCL {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] input = s.nextLine().split(",");
		int size = Integer.parseInt(input[0]); 
		char [] data = new char[size];
		int collisioncounter = 0;
		int inputstuff = 0;
		for(int i = 1; i< data.length; i++)
		{
			char a = input[i].charAt(0);
			int q = a - 'a';
			if(data[q%size] == 0) 
			{
				data[q%size] = a; 
				inputstuff++;
			}
			else 
			{
				data[q%size] = a;
				collisioncounter++;
				inputstuff++;
			}
		}
		int collisionrate = (collisioncounter/inputstuff);
		DecimalFormat df = new DecimalFormat(".00");
		System.out.println(df.format(collisionrate)); // USE DM ROUNDING 
		for(int i = 0; i < data.length; i++)
		{
			if(data[i]!= 0) 
			{
				System.out.print("x");
			}
			else System.out.print("-");
		}
		System.out.println();
		System.out.println(inputstuff-collisioncounter);
		NumberFormat nf = NumberFormat.getInstance(); 
		nf.setRoundingMode(RoundingMode.HALF_UP); 
		nf.setMaximumFractionDigits(3); 
		System.out.println((nf.format(((inputstuff-collisioncounter)*100/size))) + "%"); 
	}
}
