package com.zyh.zyhTest.mybatis.dao;

import com.zyh.zyhTest.mybatis.entity.TestUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestUser record);

    int insertSelective(TestUser record);

    TestUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestUser record);

    int updateByPrimaryKey(TestUser record);

    int batchInsert(@Param(value = "list")List<TestUser> list);




}