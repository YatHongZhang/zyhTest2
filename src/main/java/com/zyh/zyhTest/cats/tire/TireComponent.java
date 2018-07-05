package com.zyh.zyhTest.cats.tire;

import com.zyh.zyhTest.cats.Component;
import com.zyh.zyhTest.cats.body.BodyComponent;

import java.math.BigDecimal;

/**
 * Created by YatHong on 2018/4/4/0004.
 */
public abstract class TireComponent implements Component{
    protected String tireType;
    protected int HP;
    protected BodyComponent addBodyType;
    protected BigDecimal addRate;

}
