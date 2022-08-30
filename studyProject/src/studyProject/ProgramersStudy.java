package studyProject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProgramersStudy {

	public static void main(String[] args) {
		
		System.out.println(numToString("one4seveneight"));

	}
	
	public static int numToString(String s) {
		
		int answer = 0;

		String[] toString = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		
		for (int i = 0; i < toString.length; i++) {
			
			s = s.replace(toString[i], String.valueOf(i));
		}
			
		
		return Integer.parseInt(s);
	}
	
	

	public static int emptyNumber(int[] numbers) {
		
		int result = 0;
		int[] numberChk = {1,2,3,4,5,6,7,8,9,0};

		for (int j : numberChk) {
			if (!Arrays.stream(numbers).anyMatch(i -> i == j)) {
				result += j;
			}
		}

		return result;
	}
			
	
	
	public static String keypad(int[] numbers, String hand) {
		String handKey = "";
		
		int leftHand = 10; 
		int rightHand = 12; 

		for (int i : numbers) {
			
			if (i == 0) { i = 11;}
			
			if ( i == 1 ||  i == 4 || i == 7 ) {
				handKey += "L";
				leftHand = i;
			} else if ( i == 3 ||  i == 6 || i == 9 ) {
				handKey += "R";
				rightHand = i;
			} else if (i == 2 ||  i == 5 || i == 8 || i == 11) {

				int leftDis = ( (leftHand - i) / 3 ) + ( (leftHand - i) % 3);
				
				int rightDis = (( rightHand - i) / 3 ) + ( (rightHand - i) % 3);

				if (leftDis == rightDis) {
					handKey += hand == "right" ? "R" : "L";
				} else {
					
					if (Math.abs(rightDis) < Math.abs(leftDis)) {
						rightHand = i;
						handKey += "R";
					} else {
						leftHand = i;
						handKey += "L";
					}
					
				}
				
				
			}
			
		}

		return handKey;
	}
	
}
