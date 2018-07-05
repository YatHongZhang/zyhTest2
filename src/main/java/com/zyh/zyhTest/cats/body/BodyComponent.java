package com.zyh.zyhTest.cats.body;


import com.zyh.zyhTest.cats.Component;
import com.zyh.zyhTest.cats.assist.AssistComponent;
import com.zyh.zyhTest.cats.tire.TireComponent;
import com.zyh.zyhTest.cats.weapon.WeaponComponent;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by YatHong on 2018/4/4/0004.
 */
public abstract class BodyComponent implements Component {
    protected int HP;
    protected int power;
    protected int atk;
    protected List<WeaponComponent> weapons;
    protected List<AssistComponent> assists;
    protected List<TireComponent> tires;
    protected String bodyType;
    protected Component addComponent;
    protected BigDecimal addRate;



}
