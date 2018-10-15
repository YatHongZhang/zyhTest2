package com.zyh.zyhTest.mybatis;

import com.zyh.zyhTest.mybatis.dao.TestUserMapper;
import com.zyh.zyhTest.mybatis.entity.TestUser;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author YatHong on 2018/10/11/0011
 */
public class Test {
    public static SqlSession getSqlSession() throws FileNotFoundException {
        //配置文件
        InputStream configFile = new FileInputStream(
                "E:\\projects\\zyhTest\\src\\main\\resources\\mybatis-config2.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configFile);
        //加载配置文件得到SqlSessionFactory
        return sqlSessionFactory.openSession();
    }

    public static void main(String[] args) throws FileNotFoundException {
        TestUserMapper mapper = getSqlSession().getMapper(TestUserMapper.class);
        TestUser user = mapper.selectByPrimaryKey(1);
        System.out.println(user);
    }

}
