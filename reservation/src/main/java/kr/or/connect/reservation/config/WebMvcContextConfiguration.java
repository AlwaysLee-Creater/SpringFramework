package kr.or.connect.reservation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages= {"kr.or.connect.reservation.controller"})
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css").setCachePeriod(31556926);
		registry.addResourceHandler("/img/**").addResourceLocations("/img").setCachePeriod(31556926);
		registry.addResourceHandler("/js/**").addResourceLocations("/js").setCachePeriod(31556926);
	}
	
	//WAS의 default servlet handler를 사용하게 합니다.
	//매핑 정보가 없는 URL 요청이 들어왔을 때 spring의 DefaultServletHttpRequestHandler가 처리하도록 함
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		System.out.println("addViewControllers가 호출됩니다.");
		registry.addViewController("/").setViewName("index");
	}
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/api/**"))
				.build().apiInfo(apiInfo()).useDefaultResponseMessages(false);
	}
	
	private ApiInfo apiInfo() {
		Contact contact=new Contact("dddw","https://www.edwith.org","caram@edwith.org");
		ApiInfo apiInfo=new ApiInfo("Swagger Sample","APIs Sample","Sample Doc 0.1v","",contact,"this sentenc","/");
		return apiInfo;
	}
}