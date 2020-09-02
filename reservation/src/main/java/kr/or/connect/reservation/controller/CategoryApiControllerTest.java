//package kr.or.connect.reservation.controller;
//
//import java.util.Arrays;
//import java.util.List;
//
//import javax.inject.Inject;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import kr.or.connect.reservation.config.ApplicationConfig;
//import kr.or.connect.reservation.config.WebMvcContextConfiguration;
//import kr.or.connect.reservation.dto.Category;
//import kr.or.connect.reservation.service.CategoryService;
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(classes= {WebMvcContextConfiguration.class,ApplicationConfig.class})
//public class CategoryApiControllerTest {
//	@Inject
//	public CategoryController categoryController;
//	
//	@Mock
//	CategoryService categoryService;
//	
//	private MockMvc mockMvc;
//	
//	@Before
//	public void createController() {
//		MockitoAnnotation.initMocks(this);
//		mockMvc=MockMvcBuilders.standaloneSetup(categoryController).build();
//	}
//	
//	@Test
//	public void getCategory() throws Exception{
//		Category category1=new Category();
//		category1.setId(1);
//		category1.setName("lee");
//		category1.setCount(10);
//		
//		List<Category> list=Arrays.asList(category1);
//		when(categoryService.getCategory().thenReturn(list));
//		
//		RequestBuilder reqBuilder=MockMvcRequestBuilders.get("/category").contentType(MediaType.APPLICATION_JSON);
//		mockMvc.perform(reqBuilder).andExpect(status().isOk()).andDo(print());
//		
//		verify(categoryService).getCategory();
//	}
//}