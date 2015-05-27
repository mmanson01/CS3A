	 
	import java.math.BigInteger;
import java.util.Scanner;
	/*
	 * Sample java source code convert hexadecimal to decimal
	 */
	 
	public class hextodecimal {
	 
		public static void main(String[] args) {
			System.out.print("Hexadecimal Input:");
			// read the hexadecimal input from the console
			Scanner s = new Scanner(System.in);
			String inputHex = s.nextLine();
			try{
				// actual conversion of hex to decimal
				Long outputDecimal = Long.parseLong(inputHex, 16);
				System.out.println("Decimal Equivalent : "+outputDecimal);
			}
			catch(NumberFormatException ne){
				// Printing a warning message if the input is not a valid hex number
				System.out.println("Invalid Input");
			}
			finally{
				s.close();
			}
	 
		}
	 
	}


