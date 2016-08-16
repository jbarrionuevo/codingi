package ex1;

import java.io.*;
import java.util.StringTokenizer;

public class CodingExercise1 {

	private long sum() {
		long ret = 0;
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader bufferedInput = new BufferedReader(input);
		String line;

		try {
			line = bufferedInput.readLine();
			StringTokenizer tokenizer = new StringTokenizer(line);
			Long a = Long.parseLong(tokenizer.nextToken());
			Long b = Long.parseLong(tokenizer.nextToken());
			if (0 <= a && b <= 10) {
				ret = a + b;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}

	public static void main(String[] args) {
		CodingExercise1 ce = new CodingExercise1();
		System.out.println(ce.sum());
	}
}
