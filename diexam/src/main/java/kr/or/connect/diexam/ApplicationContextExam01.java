package kr.or.connect.diexam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam01 {

	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		//공장, 여기에 내가 빈 정보 넣어 놓았으니 이 정보 읽어들여서 공장 세워용
		System.out.println("초기화 완료!!");
		
		Userbean userBean=(Userbean)ac.getBean("userBean");
		//getBean()은 object 타입을 리턴함. 그래서 형변환 해줘야함
		userBean.setName("kang");
		
		System.out.println(userBean.getName());
	
		Userbean userBean2=(Userbean)ac.getBean("userBean");
		if(userBean==userBean2) {
			System.out.println("같은 인스턴스입니다.");
		}
	}
}
