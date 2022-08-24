package studyProject;


class Calcu{
	
	public static int su(int num1, int num2) {
		
		return num1+num2;
		
	}
	
	public static int multi(int num1, int num2) {
		
		return num1 * num2;
		
	}
	
	public static int div(int num1, int num2) {
		
		return num1 / num2;
		
	}
	
}

public class blogTest {

	public static void main(String[] args) {

		Calcu ca = new Calcu();

		try {
			
			//더하기
			System.out.println(ca.su(10, 0));
			
			//곱하기
			System.out.println(ca.multi(10, 0));
			
			//나누기
			System.out.println(ca.div(10, 0));
			
		} catch (Exception e) {
			System.out.println("Calcu 클래스 메서드중 하나에서 오류가 발생했음 내용은 " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}

}




