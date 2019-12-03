package com.example.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.community.model.User;

@Mapper
public interface UserMapper {

	@Insert("insert into user values(null,#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified})")
	void insert(User user);

	@Select("select * from user where token = #{token}")
	User findByToken(@Param("token") String token);
	
}
