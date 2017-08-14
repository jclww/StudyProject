package com.lww.ssm.util;

/**
 * Created by lenovo on 2017/7/10.
 */
public class Page {
    public static final int pageCounts = 20; // 每页显示记录数
    private int totalPage = 1;         // 总页数
    private int totalResult =0;        // 总记录数
    private int previous = 1;          // 上一页
    private int current = 1;           // 当前页
    private int next = 2;              // 下一页
    public static int getBeginIndex(int page){

        return (((page>0?page:1)-1)*pageCounts);
    }
    public int getEndIndex(int page){
        return (page*pageCounts<totalResult?page*pageCounts:totalResult);
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPrevious() {
        return previous;
    }

    public void setPrevious(int previous) {
        this.previous = previous;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }
}
