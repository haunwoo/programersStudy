package studyProject;

import java.util.HashMap;

public class studyProject_2 {

	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11}; 
		int[] arr2 = {30, 1, 21, 17, 28}; 

		String[] result = solution(n, arr1, arr2);  

		for ( String val : result) {
			
			System.out.println(val);
		}

		
	}

    public static String[] solution(int n, int[] arr1, int[] arr2) {
    	
        String[] result = new String[n];
        
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        for (int i = 0; i < n; i++) {
            result[i] = String.format("%" + n + "s", result[i]);
            result[i] = result[i].replaceAll("1", "#");
            result[i] = result[i].replaceAll("0", " ");
        }

        return result;
    }	
	
}
