import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;


public class FileIO {


	public static void main(String[] args) 
	{


		try{	
			//File data = new File("/Users/Student/Documents/2014-2015/Computer\ Science//all_students_jan.csv");
			Path studentsfile= Paths.get("/Users/Student/Desktop/all_students_jan.csv");
			BufferedReader bf = Files.newBufferedReader(studentsfile, StandardCharsets.ISO_8859_1);


			File data = new File("/Users/Student/Desktop/all_students_jan.csv");
			Scanner file = new Scanner(data);
			file.nextLine();
			ArrayList<Student> students = new ArrayList<Student>();
			int counter = 0;

			//while (file.hasNextLine()){
			while (file.hasNextLine()){
				String line = file.nextLine();
				students.add(new Student(line));
				counter++;
				//System.out.println(line);
				//System.out.println("counter is " + counter);

			}//while

			File file1 = new File("//Users/student/Desktop/output.html");   //output location


			// if file doesn't exists, then create it
			if (!file1.exists()) {
				file1.createNewFile();
			}

			System.out.println("Enter the number of the function you'd like:");
			System.out.println("1) List a student by only last name with associated data" + "\n" + "2) All student with the same last name with same birthday (twins)" + "\n" + "3) All students with same birth month" + "\n" + "4) All student by a specific House" + "\n" + "5) A sorted list of students by last name" + "\n" + "6) A report by gender (totals only)" + "\n" + "7) Total number of fourth-grade vs “K”" + "\n" + "8)  All students born in 2001" + "\n"+ "9)  First name frequency (top 10)" + "\n" + "10) Students by grade");

			Scanner s = new Scanner(System.in);

			FileWriter fw = new FileWriter(file1);

			BufferedWriter bw = new BufferedWriter(fw);
			try{
				int functionchoice = Integer.parseInt(s.nextLine());



				if (functionchoice == 1){
					//System.out.println("1");
					function1(students, bw);
					bw.close();
					System.out.println("Done");
				}

				else if (functionchoice == 2){
					//System.out.println("2");
					function2(students, bw);
					bw.close();
					System.out.println("Done");
				}

				else if (functionchoice == 3){
					//System.out.println("3");
					function3(students, bw);
					bw.close();
					System.out.println("Done");
				}

				else if (functionchoice == 4){
					function4(students, bw);
					bw.close();
					System.out.println("Done");
					//System.out.println("4");
				}

				else if (functionchoice == 5){
					function5(students, bw);
					bw.close();
					System.out.println("Done");
					//System.out.println("5");
				}

				else if (functionchoice == 6){
					function6(students, bw);
					bw.close();
					System.out.println("Done");
					//System.out.println("6");
				}

				else if (functionchoice == 7){
					function7(students, bw);
					bw.close();
					System.out.println("Done");
					//System.out.println("7");
				}

				else if (functionchoice == 8){
					function8(students, bw);
					bw.close();
					System.out.println("Done");
					//System.out.println("8");
				}

				else if (functionchoice == 9){
					function9(students, bw);
					bw.close();
					System.out.println("Done");
					//System.out.println("9");
				}

				else if (functionchoice == 10){
					function10(students, bw);
					bw.close();
					System.out.println("Done");
					//System.out.println("10");
				}


				else {
					System.out.println("Invalid Input. Please run the program and try again.");
				}

			}
			catch (NumberFormatException e){
				System.out.println("Invalid Input. Please run the program and try again.");
			}


		}

		catch(FileNotFoundException F)
		{
			System.out.println("ERROR");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		try {

			String content = "";

			content = "<html><body><h1> It is Tuesday </h1></body></html>";

			//	String content = "This is the content to write into file";

			File file = new File("//Users/student/Desktop/output.html");   //output location


			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			/*
			FileWriter fw = new FileWriter(file);

			BufferedWriter bw = new BufferedWriter(fw);
			functionX(students, bw);

			System.out.println("Done");

			 */
			//func1("meredith", fw);

		}//writer try 
		catch (IOException e) {
			e.printStackTrace();
		}//writer catch

	}//main


	static void functionX(ArrayList<Student> l, BufferedWriter bw){
		for (int i = 0; i < l.size(); i++) {
			try {
				bw.write(l.get(i).cg + ",");
				bw.write(l.get(i).ln + ",");
				bw.write(l.get(i).fn + ",");
				bw.write(l.get(i).mn + ",");
				bw.write(l.get(i).mf + ",");
				bw.write(l.get(i).ge + ",");
				bw.write(l.get(i).cy + ",");
				bw.write(l.get(i).bday + ",");
				bw.write(l.get(i).bmonth + ",");
				bw.write(l.get(i).byr + ",");
				bw.write(l.get(i).advisor + "<br>");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	//Students by grade


	static void function10(ArrayList<Student> l, BufferedWriter bw) {

		ArrayList<Integer> grades = new ArrayList<Integer>();

		for (int i = 0; i < l.size(); i++) {
			if (!grades.contains(Integer.parseInt(l.get(i).cg))){
				grades.add(Integer.parseInt(l.get(i).cg));
			}
		}

		Collections.sort(grades);
		//System.out.println(grades);



		for (int i = 0; i < grades.size(); i++) {
			for (int j = 0; j < l.size(); j++) {
				if ((grades.get(i)==(Integer.parseInt(l.get(j).cg)))){
					try {
						bw.write(l.get(j).cg + ", ");
						bw.write(l.get(j).ln + ", ");
						bw.write(l.get(j).fn + ", ");
						bw.write(l.get(j).mn + ", ");
						bw.write(l.get(j).mf + ", ");
						bw.write(l.get(j).ge + ", ");
						bw.write(l.get(j).cy + ", ");
						bw.write(l.get(j).bday + ", ");
						bw.write(l.get(j).bmonth + ", ");
						bw.write(l.get(j).byr + ", ");
						bw.write(l.get(j).advisor + "<br>");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}


	}

	//First name frequency (top 10)
	static void function9(ArrayList<Student> l, BufferedWriter bw) {
		ArrayList<String> firstnames = new ArrayList<String>();
		HashMap<String,Integer> freq = new HashMap<String,Integer>();
		int counter = 1;
		for (int i = 0; i < l.size(); i++) {
			firstnames.add(l.get(i).fn);
		}

		Collections.sort(firstnames);

		for (int i = 0; i < firstnames.size()-1; i++) {
			if (!firstnames.get(i).equalsIgnoreCase(firstnames.get(i+1))){
				freq.put(firstnames.get(i), counter);
				counter = 1;
			}
			else{
				counter++;
			}
		}

		ArrayList<String> firstnamesdup = new ArrayList<String>();
		for (int i = 0; i < firstnames.size(); i++) {
			if(!firstnamesdup.contains(firstnames.get(i))){
				firstnamesdup.add(firstnames.get(i));
			}
		}

		//System.out.println(freq.toString());
		ArrayList<Integer> values = new ArrayList<Integer>();
		for (int i = 0; i < firstnamesdup.size()-1; i++) {
			values.add(freq.get(firstnamesdup.get(i)));
		}

		Collections.sort(values);
		Collections.reverse(values);

		//System.out.println(values.toString());

		ArrayList<Integer> top10 = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			top10.add(values.get(i));
		}

		//System.out.println(top10.toString());

		ArrayList<String> topnames = new ArrayList<String>();

		for (int i = 0; i < firstnamesdup.size()-1; i++) {
			if (top10.contains(freq.get(firstnamesdup.get(i)))){
				topnames.add(freq.get(firstnamesdup.get(i)) + ", " + firstnamesdup.get(i));

			}
		}

		Collections.sort(topnames);
		Collections.reverse(topnames);
		//System.out.println(topnames.toString());
		String[] answer = new String[2];

		for (int i = 0; i < 10; i++) {
			answer = topnames.get(i).split(", ");
			try {
				bw.write("There are " + answer[0] + " students named " + answer[1] + "<br>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//All students born in 2001
	static void function8(ArrayList<Student> l, BufferedWriter bw) {
		System.out.println("Please enter the birth year you'd like to see");
		Scanner year = new Scanner(System.in);
		int byear = 0;
		byear = year.nextInt();
		int byearcounter = 0;

		for (int i = 0; i < l.size(); i++) {
			if ((l.get(i).byr)==(byear)){
				try {
					bw.write(l.get(i).fn + ", ");
					bw.write(l.get(i).mn + ", ");
					bw.write(l.get(i).ln + ", ");
					bw.write(l.get(i).mf + ", ");
					bw.write(l.get(i).ge + ", ");
					bw.write(l.get(i).cg + ", ");
					bw.write(l.get(i).cy + ", ");
					bw.write(l.get(i).bday + ", ");
					bw.write(l.get(i).bmonth + ", ");
					bw.write(l.get(i).byr + ", ");
					bw.write(l.get(i).advisor+"<br>" );
					byearcounter++;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		if (byearcounter==0){
			try {
				bw.write("Sorry, there are no students born in that year");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).byr == byear){
				byearcounter++;
			}
		}

		if (byearcounter>0){
			try {
				bw.write("There are " + byearcounter+ " students born in " + byear);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else{
			try {
				bw.write("There are no students born in " + byear);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 */
	}


	// Total number of fourth-grade vs “K"
	static void function7(ArrayList<Student> l, BufferedWriter bw) {

		String grade1;
		String grade2;
		int grade1counter = 0;
		int grade2counter = 0;
		Scanner grade = new Scanner(System.in);

		System.out.println("Please enter the first grade from 4-12 that you would like to compare");
		grade1 = grade.nextLine().trim();

		System.out.println("Please enter the second grade from 4-12 you would like to compare");
		grade2 = grade.nextLine().trim();



		for (int i = 0; i < l.size(); i++) {
			if ((l.get(i).cg).equalsIgnoreCase(grade1)){
				grade1counter++;
			}
			else if ((l.get(i).cg).equalsIgnoreCase(grade2)){
				grade2counter++;
			}
		}

		if(Integer.parseInt(grade1)>12||Integer.parseInt(grade1)<4||Integer.parseInt(grade2)>12||Integer.parseInt(grade2)<4){
			try {
				bw.write("Invalid grade. Please rerun the program and try again.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else{
			try {
				bw.write("There are " + grade1counter+ " students in grade "+ grade1 + "<br>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bw.write("There are " + grade2counter+ " students in grade "+ grade2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}




	//A report by gender (totals only)
	static void function6(ArrayList<Student> l, BufferedWriter bw) {
		int girlcounter = 0;
		int boycounter = 0;
		int nocounter = 0;
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).mf.equalsIgnoreCase("M")){
				boycounter++;
			}
			else if (l.get(i).mf.equalsIgnoreCase("F")){
				girlcounter++;
			}
			else {
				nocounter++;
			}
		}
		try {
			bw.write("There are " + boycounter+ " boys" + "<br>");
			bw.write("There are " + girlcounter+ " girls" + "<br>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	//A sorted list of students by last name
	static void function5(ArrayList<Student> l, BufferedWriter bw) {
		ArrayList<String> lastname = new ArrayList<String>();

		for (int i = 0; i < l.size(); i++) {
			if (!lastname.contains(l.get(i).ln)){
				lastname.add(l.get(i).ln);
			}
		}

		Collections.sort(lastname);
		//System.out.println(lastname);



		for (int i = 0; i < lastname.size(); i++) {
			for (int j = 0; j < l.size(); j++) {
				if ((lastname.get(i).equalsIgnoreCase(l.get(j).ln))){
					try {
						bw.write(l.get(j).ln + ", ");
						bw.write(l.get(j).fn + ", ");
						bw.write(l.get(j).mn + ", ");
						bw.write(l.get(j).mf + ", ");
						bw.write(l.get(j).ge + ", ");
						bw.write(l.get(j).cg + ", ");
						bw.write(l.get(j).cy + ", ");
						bw.write(l.get(j).bday + ", ");
						bw.write(l.get(j).bmonth + ", ");
						bw.write(l.get(j).byr + ", ");
						bw.write(l.get(j).advisor + "<br>");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}


	}

	//All student by a specific House
	static void function4(ArrayList<Student> l, BufferedWriter bw) {
		int invalid = 0;
		System.out.println("Please enter one of the advisors from the following list:");
		ArrayList<String> ha = new ArrayList<String>();

		for (int i = 0; i < l.size(); i++) {
			if (!ha.contains(l.get(i).advisor)){
				ha.add(l.get(i).advisor);
			}
		}
		Collections.sort(ha);
		System.out.println(ha.toString().replaceAll("\\[|\\]", "").replaceAll(", ", "\n"));

		Scanner house = new Scanner(System.in);
		String advisor = house.nextLine().trim();

		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).advisor.equalsIgnoreCase(advisor)){
				try {
					bw.write(l.get(i).fn + ", ");
					bw.write(l.get(i).mn + ", ");
					bw.write(l.get(i).ln + ", ");
					bw.write(l.get(i).mf + ", ");
					bw.write(l.get(i).ge + ", ");
					bw.write(l.get(i).cg + ", ");
					bw.write(l.get(i).cy + ", ");
					bw.write(l.get(i).bday + ", ");
					bw.write(l.get(i).bmonth + ", ");
					bw.write(l.get(i).byr + ", ");
					bw.write(l.get(i).advisor + "<br>");
					invalid++;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		if (invalid == 0){
			try {
				bw.write("You have entered an invalid house advisor");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//All students with same birth month
	static void function3(ArrayList<Student> l, BufferedWriter bw) {
		System.out.println("Please enter the month in numerical form (no additional zero is needed)");
		Scanner month = new Scanner(System.in);
		int invalid = 0;
		int bmonth = Integer.parseInt(month.nextLine().trim());

		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).bmonth==(bmonth)){
				try {
					bw.write(l.get(i).fn + ", ");
					bw.write(l.get(i).mn + ", ");
					bw.write(l.get(i).ln + ", ");
					bw.write(l.get(i).mf + ", ");
					bw.write(l.get(i).ge + ", ");
					bw.write(l.get(i).cg + ", ");
					bw.write(l.get(i).cy + ", ");
					bw.write(l.get(i).bday + ", ");
					bw.write(l.get(i).bmonth + ", ");
					bw.write(l.get(i).byr + ", ");
					bw.write(l.get(i).advisor + "<br>");
					invalid++;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		if (invalid ==0){
			try {
				bw.write("You have entered an invalid birth month");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	static void function2(ArrayList<Student> l, BufferedWriter bw) {
		ArrayList<String> twins = new ArrayList<String>();


		for (int i = 0; i < l.size(); i++) {
			for (int j = 0; j < l.size(); j++) {
				if ((l.get(i).ln.equalsIgnoreCase(l.get(j).ln)) && (l.get(i).bmonth==l.get(j).bmonth) && (l.get(i).bday==l.get(j).bday) && (l.get(i).byr==l.get(j).byr) && (i!=j)){
					if ((!twins.contains(l.get(i).fn + " "+l.get(i).ln)&&(!twins.contains(l.get(j).fn + " "+l.get(i).ln)))){
						twins.add(l.get(i).fn + " "+ l.get(i).ln);
						twins.add(l.get(j).fn + " "+l.get(j).ln);
					}
				}

			}
		}

		for (int i = 0; i < twins.size(); i++) {
			try {
				bw.write(twins.get(i) + " and " + twins.get(i+1) + " are twins" + "<br>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
	}

	//List a student by only last name with associated data
	static void function1(ArrayList<Student> l, BufferedWriter bw) {
		System.out.println("Please enter a last name");
		int untrue = 0;
		Scanner ln = new Scanner(System.in);
		String lastname = ln.nextLine().trim();
		//		System.out.println(lastname);

		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).ln.equalsIgnoreCase(lastname)){
				try {
					bw.write(l.get(i).fn + ", ");
					bw.write(l.get(i).mn + ", ");
					bw.write(l.get(i).ln + ", ");
					bw.write(l.get(i).mf + ", ");
					bw.write(l.get(i).ge + ", ");
					bw.write(l.get(i).cg + ", ");
					bw.write(l.get(i).cy + ", ");
					bw.write(l.get(i).bday + ", ");
					bw.write(l.get(i).bmonth + ", ");
					bw.write(l.get(i).byr + ", ");
					bw.write(l.get(i).advisor+"<br>" );
					untrue++;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		if (untrue==0){
			try {
				bw.write("Sorry, there are no students with that last name");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}//class
