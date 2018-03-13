package com.example.demo.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.UserMapperXml;
import com.example.demo.domain.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.example.demo.dao")
public class UserMapperXMLTest {

	@Autowired
	private UserMapperXml UserMapperXML;

////	@Test
//	public void testInsert() throws Exception {
//		UserEntity user1 = new UserEntity("xxxxx", "xxx123456", UserSexEnum.MAN);
//		UserEntity user2 = new UserEntity("yyyyy", "yyy123456", UserSexEnum.WOMAN);
//		UserEntity user3 = new UserEntity("zzzzz", "zzz123456", UserSexEnum.WOMAN);
//		UserMapperXML.insert(user1);
//		UserMapperXML.insert(user2);
//		UserMapperXML.insert(user3);
//		System.err.println(user1.getId() + "   " + user1.getPassWord());
//		System.err.println(user2.getId() + "   " + user2.getPassWord());
//		System.err.println(user3.getId() + "   " + user3.getPassWord());
//		Assert.assertEquals(6, UserMapperXML.getAll().size());
//	}
//
	@Test
	public void testQuery() throws Exception {
		List<UserEntity> users = UserMapperXML.getAll();
		users = UserMapperXML.getAll();
		if(users==null || users.size()==0){
			System.out.println("is null");
		}else{
			System.out.println(users.toString());
		}
	}
	
//	@Test
//	public void testMaxId() throws Exception {
//		Integer maxId = UserMapperXML.getMaxId();
//		System.out.println(maxId);
//	}
	
//	
//	@Test
//	public void testUpdate() throws Exception {
//		UserEntity user = UserMapperXML.getOne(16L);
//		System.out.println(user.toString());
//		user.setNickName("neo");
//		UserMapperXML.update(user);
//		System.out.println(UserMapperXML.getOne(16L).getNickName());
//		Assert.assertTrue(("neo".equals(UserMapperXML.getOne(16L).getNickName())));
//	}
//	
	
//	@Test
//	public void testQuery() throws Exception {
//		UserEntity user = UserMapperXML.getOneByEntry(new UserEntity(89L));
//		System.out.println("test" + user);
//	}
	
}