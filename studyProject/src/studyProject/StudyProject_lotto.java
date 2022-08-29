package studyProject;
//프로그래머스 로또 최고 최저 순위

public class StudyProject_lotto {

	public static void main(String[] args) {
		
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_num = {31, 10, 45, 1, 6, 19};
		
		int[] result = solution(lottos, win_num);

		for (int i : result) {
			System.out.println(i);
		}
		
	}

    public static int[] solution(int[] lottos, int[] win_nums) {

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
    
}
