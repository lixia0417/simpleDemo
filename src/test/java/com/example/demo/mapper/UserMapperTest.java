package com.example.demo.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.UserMapper;
import com.example.demo.domain.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.example.demo.dao")
public class UserMapperTest {

	@Autowired
	private UserMapper UserMapper;
//
//	@Test
//	public void testInsert() throws Exception {
//		UserEntity user1 = new UserEntity("aa", "a123456", UserSexEnum.MAN);
//		UserEntity user2 = new UserEntity("bb", "b123456", UserSexEnum.WOMAN);
//		UserEntity user3 = new UserEntity("cc", "b123456", UserSexEnum.WOMAN);
//		UserMapper.insert(user1);
//		UserMapper.insert(user2);
//		UserMapper.insert(user3);
//		System.err.println(user1.getId() + "   " + user1.getNickName());
//		System.err.println(user2.getId() + "   " + user2.getNickName());
//		System.err.println(user3.getId() + "   " + user3.getNickName());
////		Assert.assertEquals(3, UserMapper.getAll().size());
//	}
//
	@Test
	public void testQuery() throws Exception {
		List<UserEntity> users = UserMapper.getAll();
		users = UserMapper.getAll();
		System.out.println(users.toString());
	}
//
//	@Test
//	public void testUpdate() throws Exception {
//		UserEntity user = UserMapper.getOne(30L);
//		System.out.println(user.toString());
//		user.setNickName("neo");
//		UserMapper.update(user);
//		System.out.println(UserMapper.getOne(30L).getNickName());
////		Assert.assertTrue(("neo".equals(UserMapper.getOne(30L).getNickName())));
//	}
	
//	@Test
//	public void testQuery() throws Exception {
//		System.out.println("test");
//	}

}