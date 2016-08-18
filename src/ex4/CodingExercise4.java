package ex4;

import java.util.ArrayList;
import java.util.List;

public class CodingExercise4 {

//	public List<String> process(List<String> input) {
//
//	}

	private Integer getUnorderness(char[] sequence) {
		Integer unorderness = 0;
		for (int i = 0; i < sequence.length; i++) {
			char first = sequence[i];
			for (int j = i + 1; j < sequence.length; j++) {
				char second = sequence[j];
				if (first > second) {
					System.out.println(first + "," + second + "*" + unorderness + 1);
					unorderness++;
				}
			}
		}
		return unorderness;
	}

	public static void main(String[] args) {
		CodingExercise4 ce4 = new CodingExercise4();
		char[] seq = { 'D', 'A', 'A', 'B', 'E', 'C' };
		System.out.println(ce4.getUnorderness(seq));

		List<String> input = new ArrayList();
		input.add("");
	}
}
