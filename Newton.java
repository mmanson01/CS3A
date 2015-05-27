
public class Newton {

	    // return the square root of c, computed using Newton's method
	    public static double sqrt(double c) {
	        if (c < 0) return Double.NaN;
	        double EPS = 1E-15;
	        double t = c;
	        while (Math.abs(t - c/t) > EPS*t)
	            t = (c/t + t) / 2.0;
	        return t;
	    }

	    // overloaded version in which user specifies the error tolerance EPS
	    public static double sqrt(double c, double EPS) {
	        if (c < 0) return Double.NaN;
	        double t = c;
	        while (Math.abs(t - c/t) > EPS*t)
	            t = (c/t + t) / 2.0;
	        return t;
	    }


	    // test client
	    public static void main(String[] args) {

	        // parse command-line parameters
	        double[] a = new double[args.length];
	        for (int i = 0; i < args.length; i++) {
	            a[i] = Double.parseDouble(args[i]);
	        }
	        
	        System.out.println(sqrt(49));

	    
	}


}
