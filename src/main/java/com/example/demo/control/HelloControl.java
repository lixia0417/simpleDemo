package com.example.demo.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.UserMapper;
import com.example.demo.domain.User;
import com.example.demo.domain.UserEntity;
import com.example.demo.enums.UserSexEnum;

@RestController
@RequestMapping("/con")
public class HelloControl {

	@Autowired
	private UserMapper UserMapper;

	@RequestMapping("/hello")
	public String index() {
		return "Hello World";
	}

	@RequestMapping("/getUser")
	public User getUser() {
		User user = new User();
		user.setUserName("小明");
		user.setPassWord("xxxx");
		return user;
	}

	@RequestMapping("/userInsert")
	public UserEntity insertUser() {
		UserEntity user1 = new UserEntity("aa", "a123456", UserSexEnum.MAN);
		UserEntity user2 = new UserEntity("bb", "b123456", UserSexEnum.WOMAN);
		UserEntity user3 = new UserEntity("cc", "b123456", UserSexEnum.WOMAN);
		UserMapper.insert(user1);
		UserMapper.insert(user2);
		UserMapper.insert(user3);
		System.err.println(user1.getId() + "   " + user1.getUserName());
		System.err.println(user2.getId() + "   " + user2.getUserName());
		System.err.println(user3.getId() + "   " + user3.getUserName());
		return user1;
	}

	@RequestMapping("/fileUpload")
	public String fileUpload(@RequestParam("imagesFile") MultipartFile[] imagesFile, HttpServletRequest request) {
		System.err.println(request.getParameter("name"));
		for (MultipartFile file : imagesFile) {
			if (!file.isEmpty()) {
				System.err.println(file.getOriginalFilename() + " | " + file.getSize());
			}
		}
		return "success";
	}

}
