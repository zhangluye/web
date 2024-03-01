package com.syxy.utils;

//分页工具类
public class PageSupport {
    //当前页码
    private int currentPageNo = 1;
    //总表数
    private int totalCount = 0;
    //页面大小
    private int pageSize = 0;
    //总页数-totalCount/pageSize(+1)
    private int totalPageCount = 1;

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        if (currentPageNo > 0) this.currentPageNo = currentPageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize>0){
            this.pageSize = pageSize;
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount > 0){
            this.totalCount = totalCount;
            this.setTotalPageCountByRs();
        }
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public void setTotalPageCountByRs(){
        if (this.totalCount % this.pageSize == 0){
            this.totalPageCount = this.totalCount/this.pageSize;
        }else if(this.totalCount % this.pageSize >0){
            this.totalPageCount = this.totalCount / this.pageSize + 1;
        }else {
            this.totalPageCount = 0;
        }
    }
}
