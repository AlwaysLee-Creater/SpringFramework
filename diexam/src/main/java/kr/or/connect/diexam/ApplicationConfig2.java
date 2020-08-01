package kr.or.connect.diexam;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("kr.or.connect.diexam")
//알아서 니가 여기에 있는 것들 읽어들여가지고 지정해! 반드시 패키지명을 알려줘야함
//@Controller, @Service, @Repository, @Component 어노테이션이 붙은 클래스를 찾아 컨테이너에 등록
public class ApplicationConfig2 {
	
}
