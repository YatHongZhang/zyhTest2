package com.zyh.zyhTest.mybatis;

import com.zyh.zyhTest.mybatis.dao.TestUserMapper;
import com.zyh.zyhTest.mybatis.entity.TestUser;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

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
        SqlSession sqlSession = getSqlSession();
        TestUserMapper mapper = sqlSession.getMapper(TestUserMapper.class);
        //1.找到sql 2.设置参数 3.执行sql 4.结果映射
        batchInsert(mapper);
        sqlSession.commit();
    }


    public static void batchInsert(TestUserMapper mapper){
        List<TestUser> list = new ArrayList<>();
        list.add(new TestUser(System.currentTimeMillis()+"a",new Byte("10"),new Date()));
        list.add(new TestUser(System.currentTimeMillis()+"a",new Byte("18"),new Date()));
        int count = mapper.batchInsert(list);
        System.out.println(count);
    }


    public static void insert(TestUserMapper mapper){
        mapper.insert(new TestUser("zyhtest",new Byte("10"),new Date()));
    }

    public static void selectById(TestUserMapper mapper){
        System.out.println(mapper.selectByPrimaryKey(15));
    }

}
