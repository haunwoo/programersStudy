package studyProject;

import java.util.HashMap;
import studyProject.Person;


public class blogTest {

	public static void main(String[] args) {

		Person p1 = new Person();
		p1.setAddr("주소");
		p1.setAge(2);
		p1.setName("홍길동");
		
		Person p2 = new Person();
		p2.setAddr("주소123123");
		p2.setAge(222);
		p2.setName("룰루");
		
		Person p3 = new Person();
		p3.setAddr("주소는 안알랴줌");
		p3.setAge(33);
		p3.setName("랄라");
		
		//3개의 객체를 map에 저장하자 
		HashMap<String, Person> hm = new HashMap<>();
		
		hm.put("1", p1);
		hm.put("2", p2);
		hm.put("3", p3);
		
		HashMap<String, String> test = new HashMap<>();
		
		test.put("stringTest", null);
		String strTest = "str";
		
		
		if ( test.get("stringTest").equals("공백") ) {
			System.out.println("exception");
		}
		
		if ( "".equals(test.get("stringTest")) ) {
			System.out.println("exception");
		} 
		
		
		
	}

}




