package com.wuxin.design.builder;

/**
 * @Author: wuxin001
 * @Description:
 */
public class HouseA extends AbstractHouse {
    @Override
    public void buildBasic() {
        System.out.println("houseA打基地");
    }

    @Override
    public void buildWall() {
        System.out.println("houseA楼层");
    }

    @Override
    public void buildBaTop() {
        System.out.println("houseA盖房顶");
    }
}
