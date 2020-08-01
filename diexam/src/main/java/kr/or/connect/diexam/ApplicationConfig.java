package kr.or.connect.diexam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//어노테이션은 jdk5부터 지원. 특수한 의미를 부여하는 역할을 수행
//이 어노테이션을 읽고 아! 이 클래스가 config 파일이구나?! Spring 설정 클래스이다
@Configuration
public class ApplicationConfig {
	@Bean
	public Car car(Engine e) {
		Car c=new Car();
		c.setEngine(e);
		return c;
	}
	//xml 파일이 생소한 이를위해 익숙한 문법인 메서드를 만드는 것처럼 선언을 해줌
	@Bean
	public Engine engine() {
		return new Engine();
	}
}
//외부 라이브러리를 사용할때 사용
//라이브러리에 들어가서 직접 어노테이션을 붙여줄 수는 없으니까
