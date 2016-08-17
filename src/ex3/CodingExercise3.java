package ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodingExercise3 {
	private Double process() {
		Double ret = new Double(0.00);

		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader bufferedInput = new BufferedReader(input);
		String line;
		try {
			line = bufferedInput.readLine();
			Double c = Double.parseDouble(line);
			ret = getMinNumberCardsToReachC(c);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;

	}

	private Double getMinNumberCardsToReachC(Double c) {
		Double n = 2.00;
		Double tempCardLenght = new Double(0);
		Double ret = new Double(0);

		if (c > 0) {
			while ((tempCardLenght + ((1 / (n + 1)))) < c) {
				tempCardLenght += (1 / n);
				n++;
			}
			ret = n - 1;
		}
		return ret;
	}

	public static void main(String[] args) {
		CodingExercise3 ce = new CodingExercise3();
		System.out.println(ce.process());
	}
}
