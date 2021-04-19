package com.RBAC.atcrowdfunding.bean;

import java.util.List;

public class Page<T> {

    private List<T> datas;
    private int pageno;
    private int totalno;
    private int totalSize;

    public Page() {
    }

    public Page(List<T> datas, int pageno, int totalno, int totalSize) {
        this.datas = datas;
        this.pageno = pageno;
        this.totalno = totalno;
        this.totalSize = totalSize;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public int getPageno() {
        return pageno;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }

    public int getTotalno() {
        return totalno;
    }

    public void setTotalno(int totalno) {
        this.totalno = totalno;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }
}
