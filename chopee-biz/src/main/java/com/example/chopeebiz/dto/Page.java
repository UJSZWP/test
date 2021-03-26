package com.example.chopeebiz.dto;


public class Page {

    private static int DEFAULT_PAGESIZE = 20;

    private static int DEFAULT_PAGE = 1;

    private int pageNo = DEFAULT_PAGE;

    private int pageSize = DEFAULT_PAGESIZE;

    private int totalCount = 0;

    private int total = 1;

    public Page() {
    }

    public Page(Integer pageNo) {
        this.pageNo = pageNo;
        this.pageSize = DEFAULT_PAGESIZE;
    }

    public Page(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize == null ? DEFAULT_PAGESIZE : pageSize;
    }

    public Page(Integer pageNo, Integer pageSize, Integer totalCount) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    /**
     * 总页数.
     *
     */
    public int getTotal() {
        calculateTotalPageCount();
        return total;
    }

    public int getTotalPageCountNoCalculate() {
        return total;
    }

    public void calculateTotalPageCount() {
        total = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            total++;
        }

        // 校正页码
        if (pageNo > total) {
            pageNo = total;
        }
        if (pageNo < 1) {
            pageNo = 1;
        }
    }

    /**
     * 每页的记录数量.
     *
     */
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 当前页的页号,序号从1开始.
     *
     */
    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int page) {
        this.pageNo = page;
    }

    /**
     * 总记录数量.
     *
     */
    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        // 计算总页数
        calculateTotalPageCount();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Page clone = (Page) super.clone();
        return clone;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

