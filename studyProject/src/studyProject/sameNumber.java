package studyProject;

import java.util.HashMap;

public class sameNumber {

	public static void main(String[] args) {

		String[] sur = {"AN", "CF", "MJ", "RT", "NA"};
		int[] cho = {5, 3, 2, 7, 5};
		
		String result = solution(sur, cho);
		System.out.println(result);

		
	}
	
	
    public static String solution(String[] survey, int[] choices) {
    	
        String answer = "";
        
        //선택 값을 삽입할 map생성
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R', 0);map.put('T', 0);
        map.put('C', 0);map.put('F', 0);
        map.put('J', 0);map.put('M', 0);
        map.put('A', 0);map.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
        	
            if (choices[i] > 4)
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + choices[i] - 4);
            else if (choices[i] < 4) {
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + 4 - choices[i]);
            }
            
        }


        if (map.get('R') >= map.get('T'))
            answer = "R";
        else
            answer = "T";

        if (map.get('C') >= map.get('F'))
            answer += "C";
        else
            answer += "F";

        if (map.get('J') >= map.get('M'))
            answer += "J";
        else
            answer += "M";

        if (map.get('A') >= map.get('N'))
            answer += "A";
        else
            answer += "N";

        return answer;
    }

	

}


	
