package studyProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
	
	public static int[] report(String[] id_list, String[] report, int k) {
		
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        
        HashMap<String, Integer> count = new HashMap<>();
        
        for (String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }
        
        
        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();
	}
	
    public static int compress(String dartResult) {
        
		int[] round = new int[3];
		
		char[] carr = dartResult.toCharArray();
		
		// 인덱스 조정을 위해 -1부터 시작 매 반복마다 증가시켜야 하는데 첫 번째 반복에서는 0이 되도록
		int idx = -1;
		
		for (int i=0;i<carr.length;i++) {
		    // n번째 라운드에 쏜 점수가 0~9인 경우
		    if (carr[i] >= '0' && carr[i] <= '9') {
		        idx++; // 이전 라운드에서 현재 라운드로 증가된 것 (-1 -> 0)
		        // 점수 추가
		        round[idx] += Integer.parseInt(String.valueOf(carr[i]));
		        // n번째 라운드에 쏜 점수가 10점인 경우
		        if (i+1!=carr.length-1 && carr[i+1] == '0'&& carr[i] == '1') {
		            round[idx] -= Integer.parseInt(String.valueOf(carr[i]));
		            round[idx] = 10;
		            i++;                    
		        }                
		    } else if (carr[i] == 'D') { // 보너스 Double
		        round[idx] *= round[idx]; // 제곱
		    } else if(carr[i] == 'T') { // 보너스 Triple
		        round[idx] *= round[idx] * round[idx]; // 세제곱
		    } else if (carr[i] == '*') { // 이전 라운드와 현재 라운드에 *2
		        if (idx > 0) round[idx-1] *=2;                
		        round[idx] *= 2;
		    } else if (carr[i] == '#') { // 현재 라운드에 * -1                
		        round[idx] *= -1;
		    }
		}
		return round[0] + round[1] + round[2];
        
    }
    
    public static int[] fail(int N, int[] stages) {

    	int[] answer = new int[N];
            
    		/*
    		 * 1번 0.125 2번 0.428 3번 0.5 4번 0.5 5번 0
    		 */
            Arrays.sort(stages);
            Map<Integer, Double> failed = new HashMap<>();

            HashMap<Integer, Integer> clg = new HashMap<>();
            HashMap<Integer, Integer> fal = new HashMap<>();

            for (int i = 0; i < stages.length; i++) {
            	if (clg.get(stages[i]) != null) {
            		clg.put(stages[i], clg.get(stages[i]) + 1);
            	} else {
            		//if (stages[i] > N) {
            			clg.put(stages[i], 1);
            		//}
            	}
            }

           int[] arr =  Arrays.stream(stages).distinct().toArray();
            
           for (int i = 0; i < arr.length; i++) {
        	   int cnt = 0;
        	   
        	   for (int j = 0; j < stages.length; j++) {
        		   if (arr[i] <= stages[j]) {
        			   cnt++;
        		   }
        	   }
        	   fal.put(arr[i], cnt);
           }
          
           for (int i = 0; i < arr.length; i++) {
        	   if ( i > N) {
        		   failed.put(arr[i -1], (double)clg.get(arr[i]) / (double)fal.get(arr[i]) );
        	   }else {
        		   failed.put(arr[i], (double)clg.get(arr[i]) / (double)fal.get(arr[i]) );
        	   }
        	   
           }

           List<Integer> list = new ArrayList<>(failed.keySet());
           Collections.sort(list, (o1, o2) -> Double.compare( failed.get(o2), failed.get(o1) ) );

           
            return answer;
        }
    	
    public static int[] lotto(int[] lottos, int[] win_nums) {

        int cnt = 0;
        int zeroCnt = 0;
        
        for(int lotto: lottos){

            if(lotto == 0) {
                zeroCnt ++;
                continue;
            }
            
            for(int win_num:win_nums){

                if(win_num == lotto){
                    cnt ++;
                    break;
                }
            }
        }

        return new int[]{7-Math.max(cnt+zeroCnt,1),7-Math.max(cnt,1)};
    }
    
    public static String sameNumber(String[] survey, int[] choices) {
    	
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
