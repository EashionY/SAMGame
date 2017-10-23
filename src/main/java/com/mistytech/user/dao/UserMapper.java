package com.mistytech.user.dao;

import org.apache.ibatis.annotations.Param;

import com.mistytech.user.bean.User;

public interface UserMapper {
	
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User findByUsername(@Param("username")String username);
}