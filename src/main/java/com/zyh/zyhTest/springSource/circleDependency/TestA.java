package com.zyh.zyhTest.springSource.circleDependency;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by YatHong on 2018/3/20/0020.
 */
public class TestA {
    private TestB b;

    public TestA(){

    }

    public TestB getB() {
        return b;
    }

    public void setB(TestB b) {
        this.b = b;
    }
}

