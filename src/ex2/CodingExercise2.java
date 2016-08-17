package ex2;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CodingExercise2 {

	private String process() {
		Float ret = new Float(0.00);
		for (int i = 0; i < 12; i++) {
			System.out.println("Please enter closing balance for month " + (i + 1) + "\n");
			InputStreamReader input = new InputStreamReader(System.in);
			BufferedReader bufferedInput = new BufferedReader(input);
			String line;
			try {
				line = bufferedInput.readLine();
				// StringTokenizer tokenizer = new StringTokenizer(line);
				Float a = Float.parseFloat(line);
				ret += a;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		ret = ret / 12;

		BigDecimal bigDecimalRet = new BigDecimal(ret);
		bigDecimalRet = bigDecimalRet.setScale(2, RoundingMode.HALF_UP);

		//System.out.println("No rounding: " + ret);
		//System.out.println("Rounded: " + bigDecimalRet);

		return "$" + bigDecimalRet.toString() + "\n";
	}

	public static void main(String[] args) {
		CodingExercise2 ce = new CodingExercise2();
		System.out.println(ce.process());
	}
}