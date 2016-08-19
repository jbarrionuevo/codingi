package cracking.dataStructures;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ArraysStrings {

	// 1.1
	// Implement an algorithm to determine if a string has all unique
	// characters. What if you can not use additional data structures?
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

	public static boolean hasUniqueCharacters2(Character[] s) {
		boolean hasUniqueChars = true;
		int i = 0;

		while (i < s.length && hasUniqueChars == true) {
			int j = 0;
			while (j < s.length) {
				if (j != i && (s[i] == s[j])) {
					hasUniqueChars = false;
				}
				j++;
			}
			i++;
		}

		return hasUniqueChars;
	}

	// 1.2 Write code to reverse a C-Style String. (C-String means that “abcd”
	// is represented as five characters, including the null character.)
	// A C-style string is simply an array of characters that uses a null
	// terminator. A null terminator is a special character
	// (‘\0’, ascii code 0) used to indicate the end of the string. More
	// generically, A C-style string is called a null-terminated string.

	public static Character[] reverseCStyle(Character[] s) {
		int i = 0;
		int j = s.length - 2;

		for (i = 0; i < (s.length - 1) / 2; i++) {
			Character tmpChar = s[i];
			s[i] = s[j];
			s[j] = tmpChar;
			j--;
		}
		return s;
	}

	// Design an algorithm and write code to remove the duplicate characters in
	// a string without using any additional buffer. NOTE: One or two additional
	// variables are fine. An extra copy of the array is not.
	// FOLLOW UP
	// Write the test cases for this method.
	public static String removeDuplicates(StringBuilder s) {
		for (int i = 0; i < s.length(); i++) {
			Character tempChar = s.charAt(i);
			for (int j = i + 1; j < s.length(); j++) {
				if(s.charAt(i)==s.charAt(j)){
					s.deleteCharAt(j);
				}	
			}
		}
		return s.toString();
	}
	
	public static void main(String[] args) {
		// Character[] s1 = { 'a', 's', 's', 'a' };
		// Character[] s2 = { 'a', 's', '1', '2' };
		// Character[] s3 = { 'a', 'w', 's', 'a' };
		// Character[] s4 = { 'z', 'x', 'c', 'd' };
		// System.out.println(hasUniqueCharacters(s1));
		// System.out.println(hasUniqueCharacters(s2));
		// System.out.println(hasUniqueCharacters(s3));
		// System.out.println(hasUniqueCharacters(s4));
		//
		// System.out.println(hasUniqueCharacters2(s1));
		// System.out.println(hasUniqueCharacters2(s2));
		// System.out.println(hasUniqueCharacters2(s3));
		// System.out.println(hasUniqueCharacters2(s4));

		// System.out.println(getIterationScope(3).toString());

//		Character[] c = { 'a', 'n', 'i', 'm', 'a', 'l', null };
//		Character[] d = reverseCStyle(c);
//
//		for (int i = 0; i < d.length; i++) {
//			System.out.println(d[i]);
//		}
		
		StringBuilder s = new StringBuilder("arrasar");
		System.out.println(removeDuplicates(s));
		String s2 = "ars";
		System.out.println(s2.equals(removeDuplicates(s)));
	}
}
