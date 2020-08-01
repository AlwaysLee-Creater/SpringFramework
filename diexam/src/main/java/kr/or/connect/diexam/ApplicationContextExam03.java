package kr.or.connect.diexam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExam03 {

	public static void main(String[] args) {
		ApplicationContext ac=new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Car car=(Car)ac.getBean("car");
		//Car car=(Car)ac.getBean(Car.class);
		//이 방법은 Car클래스 타입의 메서드를 찾기 때문에 메서드 이름이 맞지 않아도 상관없음
		car.run();
	}

}
