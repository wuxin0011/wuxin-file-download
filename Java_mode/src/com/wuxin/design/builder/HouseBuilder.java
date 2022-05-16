package com.wuxin.design.builder;

/**
 * @Author: wuxin001
 * @Date: 2022/05/10/10:12
 * @Description:
 */
public class HouseBuilder {

    private AbstractHouse house;

    public HouseBuilder(AbstractHouse house) {
        this.house = house;
    }

    public void builder(){
        this.house.buildBasic();
        this.house.buildWall();
        this.house.buildBaTop();
    }
}
