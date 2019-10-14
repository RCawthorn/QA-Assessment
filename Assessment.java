package com.qa.javaAssessment;

import java.util.Arrays;
import java.util.List;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i< input.length(); i++) {
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
		}
		return word;
	}

	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""

	public String getBert(String input) {  //Did need a lot of help with this one
		int getBert = input.toLowerCase().indexOf("bert");
		int getBert2 = input.toLowerCase().indexOf("bert", getBert + 1);

		if(getBert2 == -1)

			return "";

		String middle = input.substring(getBert + 4, getBert2);

		String result = "";

		for(int i = middle.length()-1; i>=0; i--) {

			result += middle.substring(i, i+1);

		}

		return result;
	}


	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) { // Passes Test but i dont know how to print it to screen.
		//a=2; b=4; c=6;
		int Arr[] = {a, b, c};

		Arrays.sort(Arr);

		return ( Arr[2] - Arr[1] == Arr[1] - Arr[0] );

	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {

		int Remove = (input.length() - a) / 2;

		String word = input.substring(0, Remove);

		word += input.substring(Remove+ a, Remove + a + Remove);
		System.out.println(word);

		return word;

		}
	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public int superBlock(String input) {
		int count = 0; int max = 0;

		for (int i=1; i < input.length(); i++) {
			if (input.charAt(i) == input.charAt(i-1)) {
				count++;
				if (count > max) {
					max = count;
				}
			}
			else {

				count = 0;
			}
		}
		if (max > 0) {

			max++;
		}
		return max;
	}

	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") ==> 1
	//amISearch("I am in Amsterdam am I?") ==> 2
	//amISearch("I have been in Amsterdam") ==> 0
		public int amISearch(String am) {
			am = am.toLowerCase();
			int i = 0; int count = 0;
			for (i = 0; i < am.length(); i++) {

				if (am.charAt(i) == 'a') {
					if (i == 0 && am.charAt(i + 1) == 'm' && am.charAt(i + 2) == ' ')
						count++;
					else if (i > 0 && am.charAt(i - 1) == ' ' && am.charAt(i + 1) == 'm' && am.charAt(i + 2) == ' ')
						count++;
					else if (i > 0 && am.charAt(i - 1) == ' ' && am.charAt(i + 1) == 'm' && i + 1 == am.length())
						count++;

				}
				System.out.println(am+count);  //Needs refining with the output
			}
			return count;
		}
/*
	String Word = "", Beta;
	int i = 0;
	int count = 0;
            for (i = 0; i < msg.length(); i++) {
		Beta = msg.substring(i, i + 1);
		if (Beta.equals(lookfor.substring(0, 1))) {

			if (msg.substring(i, i + lookfor.length()).equals(lookfor)) {
				count++;
				i += lookfor.length() - 1;
			}
		}
	}
            System.out.println(count); */
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) ==> "fizz"
	//fizzBuzz(10) ==> "buzz"
	//fizzBuzz(15) ==> "fizzbuzz"
	
	public String fizzBuzz(int arg1) { //Passes test but prints out test results?
		String word = "";
		if (arg1 % 3 == 0) {

			word += "fizz";
		}
		if (arg1 % 5 == 0) {
			word += "buzz";
		}
		if (arg1 % 3 == 0 || arg1 % 5 == 0) {
			System.out.println(word);
		} else {
			System.out.println("Nope");
		}
			return word;
		}

	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") ==> 14
	//largest("15 72 80 164") ==> 11
	//largest("555 72 86 45 10") ==> 15
	
	public int largest(String arg1) {
		//Another one i needed alot of help with
		// Feel like there is a btter way solving this than how i was shown/found

		String[] stringArray = arg1.split(" ");

		int[] intArray = new int[stringArray.length];

		for ( int i = 0; i < stringArray.length; i++) {

			intArray[i] = Integer.parseInt(stringArray[i]);

		}
		int sumArray[] = new int[intArray.length];

		for ( int i = 0; i < intArray.length; i++) {
			int input = intArray[i]; int sum = 0;
			while (input > 0) {

				int add = input % 10;

				sum = sum + add;

				input = input / 10;
			}
			sumArray[i] = sum;
		}
		Arrays.sort(sumArray);
		System.out.println(sumArray);

		return sumArray[sumArray.length - 1];
	}
	}
