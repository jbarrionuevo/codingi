package cracking.dataStructures;

import java.util.HashSet;
import java.util.Set;

public class ArraysStrings {

	// 1.1
	public static boolean hasUniqueCharacters(Character[] s) {
		boolean hasUniqueChars = true;
		Set<Character> c = new HashSet<Character>();

		for (Character tempChar : s) {
			if (c.contains(tempChar)) {
				hasUniqueChars = false;
				break;
			} else {
				c.add(tempChar);
			}
		}

		return hasUniqueChars;
	}

	public static void main(String[] args) {
		Character[] s1 = {'a','s','s','a'};
		Character[] s2 = {'a','s','1','2'};
		Character[] s3 = {'a','w','s','a'};
		Character[] s4 = {'z','x','c','d'};
		System.out.println(hasUniqueCharacters(s1));
		System.out.println(hasUniqueCharacters(s2));
		System.out.println(hasUniqueCharacters(s3));
		System.out.println(hasUniqueCharacters(s4));
	}
}
