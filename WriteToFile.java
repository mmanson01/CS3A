import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile{
	public static void main(String[] args) {
		try {

			String content = "";

			content = "<html><body><h1> It is Tuesday </h1></body></html>";

			//	String content = "This is the content to write into file";

			File file = new File("//Users/student/Desktop/output.html");   //output location


			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}


			FileWriter fw = new FileWriter(file);

			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}