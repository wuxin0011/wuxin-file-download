package com.wuxin.utils;

import java.util.List;

/**
 * @author: wuxin001
 * @date: 2022/7/21 23:47
 * @Description: 分页工具类
 */
public class PageUtil<T, E> {
    private E keywords;
    private int limit;
    private int size;
    private int total;
    private int totalPage;
    private List<T> list;

    public PageUtil() {
    }

    public PageUtil(E keywords, int limit, int size, int total, List<T> list) {
        this.keywords = keywords;
        this.limit = limit;
        this.size = size;
        this.total = total;
        this.list = list;
        this.totalPage = (int) ((total) / size) + 1;
    }

    public E getKeywords() {
        return keywords;
    }

    public void setKeywords(E keywords) {
        this.keywords = keywords;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageUtils{" +
                "keywords=" + keywords +
                ", limit=" + limit +
                ", size=" + size +
                ", total=" + total +
                ", totalPage=" + totalPage +
                ", list=" + list +
                '}';
    }
}
