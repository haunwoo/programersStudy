package studyProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class studyProject_failPer {

	public static void main(String[] args) {
		
		int N = 5;
		int[] stage = {2, 1, 2, 6, 2, 4, 3, 3};
		
		//[3,4,2,1,5]
		
		int[] result = solution(N, stage);
			//System.out.println(result.toString());
		
		
	}
	

    public static int[] solution(int N, int[] stages) {

        int[] answer = new int[N];

        double[] stage = new double[N+1];      // 스테이지마다 머물러 있는 사용자수를 담을 배열


        // stage배열에 머물러있는 사용자수를 담는다 , 인덱스값이 스테이지번호
        for(int i : stages){

            if(i == N+1){

                continue;

            }

            stage[i]++;

        }


        // 실패율을 계산해 담을 list
        ArrayList<Double> fail = new ArrayList<Double>();

        //스테이지에 도달한 명수
        double num =stages.length;
        //다음 스테이지로 올라갈때 줄어드는 사용자수를 계산하기 위해 사용
        double tmp = 0;


        //실패율을 구한 후 다시 stage배열에 담고, fail 리스트에도 담아준다.
        for(int i=1; i<stage.length; i++){

            tmp = stage[i];
            // 도달한 사용자 수가 0 일때, 실패율도 0
            if(num == 0){

                stage[i]=0;

            }else{

                stage[i] = stage[i]/num;

                num = num - tmp;

            }

            fail.add(stage[i]);

      }


     //  fail 리스트를 내림차순으로 정렬해준다.
     Collections.sort(fail,Collections.reverseOrder());


     //정렬된 fail리스트 값과 stage값을 비교해서 같으면 stage의 인덱스번호(스테이지번호)를 가져옴으로써
     //실패율이 높은 순으로 answer배열에 넣어준다.
     for(int i=0; i<fail.size(); i++){

         for(int j=1; j<stage.length; j++){

             if(fail.get(i) == stage[j]){

                 answer[i] = j;

                 stage[j] = -1;

                 break;

            }

        }

    }

    return answer;

    }	
	
	
    public static int[] solution_(int N, int[] stages) {
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
	
}
