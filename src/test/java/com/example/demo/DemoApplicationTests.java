package com.example.demo;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.ibatis.executor.resultset.DefaultResultSetHandler;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.TypeHandler;
import org.elasticsearch.index.mapper.MapperBuilders;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.control.HelloControl;
import com.mysql.jdbc.PreparedStatement;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

//	private MockMvc mvc;
//
////	@Before
//	public void setUp() throws Exception {
//		mvc = MockMvcBuilders.standaloneSetup(new HelloControl()).build();
//	}
//
////	@Test
////	public void getHello() throws Exception {
////		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
////				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
////	}
//
////	@Test
//	public void getUser() throws Exception {
//		mvc.perform(MockMvcRequestBuilders.get("/getUser").accept(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
//	}
//	
	
	@Test
	public void testQuery() throws Exception {
//		System.out.println("201708311015341504145734999fvNErf".length());
//		System.err.println("{\"h5_info\":{\"type\":\"Wap\",\"wap_url\":\"https://pay.qq.com\",\"wap_name\":\"腾讯充值\"}}");
		System.err.println("http://www.1717h5.com/?token=xxx".indexOf("?"));
		Class<DemoApplicationTests> c = DemoApplicationTests.class;
	}
	
}
