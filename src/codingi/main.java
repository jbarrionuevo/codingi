package codingi;

import java.util.Date;

import ex4.CodingExercise4;

public class main {
	public static void main(String[] argv) {
		long startTime = new Date().getTime(); 
		// some tasks to do
		CodingExercise4 ce4 = new CodingExercise4();
		ce4.main(argv);
		//***
		long endTime = new Date().getTime();
		long difference = endTime - startTime; 
		System.out.println("Elapsed milliseconds: " + difference);
	}
}