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
				if (s.charAt(i) == s.charAt(j)) {
					s.deleteCharAt(j);
				}
			}
		}
		return s.toString();
	}

	// 1.4 Write a method to decide if two strings are anagrams or not.

	public static boolean isAnagram(StringBuilder s1, StringBuilder s2) {
		boolean anagram = false;
		int i = 0;

		if (s1.length() == s2.length()) {
			anagram = true;
		}

		while (anagram && i < s1.length()) {
			int j = 0;
			while (j < s2.length()) {
				if (s2.charAt(j) == s1.charAt(j)) {
					s2.deleteCharAt(j);
					break;
				} else if (j == (s2.length() - 1)) {
					anagram = false;
				}
				j++;
			}
			i++;
		}

		return anagram;
	}

	// 1.5 Write a method to replace all spaces in a string with ‘%20’.
	public static String replace(String s1) {
		int i = 0;

		while (i < s1.length()) {
			if (s1.charAt(i) == ' ') {
				s1 = s1.substring(0, i) + "%20" + s1.substring(i + 1, s1.length());
			}
			i++;
		}

		return s1;
	}
	
	
	// 1.6 Given an image represented by an NxN matrix, where each pixel in the
	// image is 4 bytes,
	// write a method to rotate the image by 90 degrees. Can you do this in
	// place?
	// TO DO
	public static Integer[][] setToZero(Integer[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					System.out.println("2**************i,j = " + i + ", " + j + " / value = " + matrix[i][j]);
					matrix = setRowFileZero(i, j, matrix);
				}
			}
		}
		return matrix;
	}

	// Write an algorithm such that if an element in an MxN matrix is 0, its
	// entire row and column is set to 0.
	public static Integer[][] setRowFileZero(int i, int j, Integer[][] matrix) {

		for (int k = 0; k < matrix.length; k++) {
			matrix[i][k] = 0;
		}

		for (int h = 0; h < matrix[0].length; h++) {
			matrix[h][j] = 0;
		}

		return matrix;
	}
	
	//Assume you have a method isSubstring which checks if one word is a substring of another. 
	//Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to
	//isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
	public static boolean isRotation(StringBuilder s1, StringBuilder s2) {
		for (int i = 0; i < s2.length()/2; i++) {
			char cf = s2.charAt(i);
			char cl = s2.charAt(s2.length()-(i+1)); 
			s2.setCharAt(i, cl);
			s2.setCharAt(s2.length()-(i+1), cf);
		}
		return isSubstring(s1, s2) && (s1.length() == s2.length());  
	}
	
	public static boolean isSubstring(StringBuilder s1, StringBuilder s2) {
		return s1.toString().contains(s2.toString());
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

		// Character[] c = { 'a', 'n', 'i', 'm', 'a', 'l', null };
		// Character[] d = reverseCStyle(c);
		//
		// for (int i = 0; i < d.length; i++) {
		// System.out.println(d[i]);
		// }

		// StringBuilder s = new StringBuilder("arrasar");
		// System.out.println(removeDuplicates(s));
		// String s2 = "ars";
		// System.out.println(s2.equals(removeDuplicates(s)));

		// StringBuilder s3 = new StringBuilder("ana");
		// StringBuilder s4 = new StringBuilder("naa");

		// StringBuilder s5 = new StringBuilder("casa");
		// StringBuilder s6 = new StringBuilder("saca");

		// System.out.println(isAnagram(s3, s4));
		// System.out.println(isAnagram(s5, s6));

		// String s7 = "ho la chau ";
		// System.out.println(replace(s7));

//		Integer[][] matrix = new Integer[3][3];
//		matrix[0][0] = 0;
//		matrix[0][1] = 1;
//		matrix[0][2] = 1;
//		matrix[1][0] = 1;
//		matrix[1][1] = 1;
//		matrix[1][2] = 1;
//		matrix[2][0] = 1;
//		matrix[2][1] = 1;
//		matrix[2][2] = 1;
//
//		Integer[][] matrix1 = setRowFileZero(0, 0, matrix);
//
//		for (int i = 0; i < matrix1.length; i++) {
//
//			for (int j = 0; j < matrix1.length; j++) {
//				System.out.println("3**************i,j = " + i + ", " + j + " / value = " + matrix[i][j]);
//			}
//
//		}
		StringBuilder s8 = new StringBuilder("casa1");
		StringBuilder s9 = new StringBuilder("1asac");
		System.out.println(isRotation(s8,s9));
	}
}
