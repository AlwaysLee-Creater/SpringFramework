package kr.or.connect.diexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	@Autowired
	private Engine v8;
	//니가 알아서 이런 객체 있으면 Engine 타입의 객체가 생성된 게 있으면 여기에 주입해줘
	//굳이 setter 메서드 필요없음
	
	public Car() {
		System.out.println("Car 생성자");
	}
	
	public void setEngine(Engine e) {
		this.v8=e;
	}
	
	public void run() {
		System.out.println("엔진을 이용하여 달립니다.");
		v8.exec();
	}
	
	public static void main(String[] args) {
//		Engine e=new Engine();
//		Car c=new Car();
//		c.setEngine(e);
//		c.run();
	}
}
