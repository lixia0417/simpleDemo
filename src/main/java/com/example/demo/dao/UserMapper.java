package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Options.FlushCachePolicy;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.UserEntity;
import com.example.demo.enums.UserSexEnum;

@CacheNamespace
public interface UserMapper {

	@Select("SELECT * FROM users")
	@Options(useCache = true, flushCache = FlushCachePolicy.FALSE)
	@Results({ @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
			@Result(property = "nickName", column = "nick_name") })
	List<UserEntity> getAll();

	@Select("SELECT * FROM users WHERE id = #{id}")
	@Results({ @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
			@Result(property = "nickName", column = "nick_name") })
	UserEntity getOne(Long id);

	@Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") // 添加该行，user中的id将被自动添加
	void insert(UserEntity user);

	@Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
	void update(UserEntity user);

	@Delete("DELETE FROM users WHERE id =#{id}")
	void delete(Long id);

}