package com.wuxin.design.builder;

/**
 * @Author: wuxin001
 * @Description:
 */
public class HouseB extends AbstractHouse{

    @Override
    public void buildBasic() {
        System.out.println("HouseB打基地");
    }

    @Override
    public void buildWall() {
        System.out.println("HouseB楼层");
    }

    @Override
    public void buildBaTop() {
        System.out.println("HouseB盖房顶");
    }
}
