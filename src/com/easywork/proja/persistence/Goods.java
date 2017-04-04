package com.easywork.proja.persistence;

import java.util.Date;
import javax.persistence.*;

public class Goods {
    /**
     * 否是通过验证,0表示未通过，1表示通过
     */
    @Id
    private Long id;

    private String name;

    /**
     * 商品保投周期，单位为天
     */
    private Integer preiod;

    private Long createid;

    private String createname;

    private Date createtime;

    private Double price;

    /**
     * 团购：每多购买一份，基给予折扣
     */
    private Integer discount;

    /**
     * 底价，60 为6折
     */
    private Integer buttomprice;

    /**
     * 定金价，10 为1折
     */
    private Integer bookprice;

    /**
     * 1为上架，0为下架
     */
    private Integer state;

    /**
     * 人个还是企业
     */
    private String type;

    private String memo;

    /**
     * 获取否是通过验证,0表示未通过，1表示通过
     *
     * @return id - 否是通过验证,0表示未通过，1表示通过
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置否是通过验证,0表示未通过，1表示通过
     *
     * @param id 否是通过验证,0表示未通过，1表示通过
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取商品保投周期，单位为天
     *
     * @return preiod - 商品保投周期，单位为天
     */
    public Integer getPreiod() {
        return preiod;
    }

    /**
     * 设置商品保投周期，单位为天
     *
     * @param preiod 商品保投周期，单位为天
     */
    public void setPreiod(Integer preiod) {
        this.preiod = preiod;
    }

    /**
     * @return createid
     */
    public Long getCreateid() {
        return createid;
    }

    /**
     * @param createid
     */
    public void setCreateid(Long createid) {
        this.createid = createid;
    }

    /**
     * @return createname
     */
    public String getCreatename() {
        return createname;
    }

    /**
     * @param createname
     */
    public void setCreatename(String createname) {
        this.createname = createname;
    }

    /**
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取团购：每多购买一份，基给予折扣
     *
     * @return discount - 团购：每多购买一份，基给予折扣
     */
    public Integer getDiscount() {
        return discount;
    }

    /**
     * 设置团购：每多购买一份，基给予折扣
     *
     * @param discount 团购：每多购买一份，基给予折扣
     */
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    /**
     * 获取底价，60 为6折
     *
     * @return buttomprice - 底价，60 为6折
     */
    public Integer getButtomprice() {
        return buttomprice;
    }

    /**
     * 设置底价，60 为6折
     *
     * @param buttomprice 底价，60 为6折
     */
    public void setButtomprice(Integer buttomprice) {
        this.buttomprice = buttomprice;
    }

    /**
     * 获取定金价，10 为1折
     *
     * @return bookprice - 定金价，10 为1折
     */
    public Integer getBookprice() {
        return bookprice;
    }

    /**
     * 设置定金价，10 为1折
     *
     * @param bookprice 定金价，10 为1折
     */
    public void setBookprice(Integer bookprice) {
        this.bookprice = bookprice;
    }

    /**
     * 获取1为上架，0为下架
     *
     * @return state - 1为上架，0为下架
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置1为上架，0为下架
     *
     * @param state 1为上架，0为下架
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取人个还是企业
     *
     * @return type - 人个还是企业
     */
    public String getType() {
        return type;
    }

    /**
     * 设置人个还是企业
     *
     * @param type 人个还是企业
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", preiod=" + preiod + ", createid=" + createid + ", createname="
				+ createname + ", createtime=" + createtime + ", price=" + price + ", discount=" + discount
				+ ", buttomprice=" + buttomprice + ", bookprice=" + bookprice + ", state=" + state + ", type=" + type
				+ ", memo=" + memo + "]";
	}
}