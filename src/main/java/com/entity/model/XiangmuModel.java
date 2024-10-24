package com.entity.model;

import com.entity.XiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 项目
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XiangmuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 专家
     */
    private Integer zhuanjiaId;


    /**
     * 项目编号
     */
    private String xiangmuUuidNumber;


    /**
     * 项目名称
     */
    private String xiangmuName;


    /**
     * 项目照片
     */
    private String xiangmuPhoto;


    /**
     * 项目地点
     */
    private String xiangmuAddress;


    /**
     * 项目开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date xiangmuKaishiTime;


    /**
     * 项目结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date xiangmuJieshuTime;


    /**
     * 项目类型
     */
    private Integer xiangmuTypes;


    /**
     * 项目等级
     */
    private Integer xiangmuDengjiTypes;


    /**
     * 项目介绍
     */
    private String xiangmuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 审核状态
     */
    private Integer xiangmuYesnoTypes;


    /**
     * 审核意见
     */
    private String xiangmuYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date xiangmuShenheTime;


    /**
     * 创建时间  show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：专家
	 */
    public Integer getZhuanjiaId() {
        return zhuanjiaId;
    }


    /**
	 * 设置：专家
	 */
    public void setZhuanjiaId(Integer zhuanjiaId) {
        this.zhuanjiaId = zhuanjiaId;
    }
    /**
	 * 获取：项目编号
	 */
    public String getXiangmuUuidNumber() {
        return xiangmuUuidNumber;
    }


    /**
	 * 设置：项目编号
	 */
    public void setXiangmuUuidNumber(String xiangmuUuidNumber) {
        this.xiangmuUuidNumber = xiangmuUuidNumber;
    }
    /**
	 * 获取：项目名称
	 */
    public String getXiangmuName() {
        return xiangmuName;
    }


    /**
	 * 设置：项目名称
	 */
    public void setXiangmuName(String xiangmuName) {
        this.xiangmuName = xiangmuName;
    }
    /**
	 * 获取：项目照片
	 */
    public String getXiangmuPhoto() {
        return xiangmuPhoto;
    }


    /**
	 * 设置：项目照片
	 */
    public void setXiangmuPhoto(String xiangmuPhoto) {
        this.xiangmuPhoto = xiangmuPhoto;
    }
    /**
	 * 获取：项目地点
	 */
    public String getXiangmuAddress() {
        return xiangmuAddress;
    }


    /**
	 * 设置：项目地点
	 */
    public void setXiangmuAddress(String xiangmuAddress) {
        this.xiangmuAddress = xiangmuAddress;
    }
    /**
	 * 获取：项目开始时间
	 */
    public Date getXiangmuKaishiTime() {
        return xiangmuKaishiTime;
    }


    /**
	 * 设置：项目开始时间
	 */
    public void setXiangmuKaishiTime(Date xiangmuKaishiTime) {
        this.xiangmuKaishiTime = xiangmuKaishiTime;
    }
    /**
	 * 获取：项目结束时间
	 */
    public Date getXiangmuJieshuTime() {
        return xiangmuJieshuTime;
    }


    /**
	 * 设置：项目结束时间
	 */
    public void setXiangmuJieshuTime(Date xiangmuJieshuTime) {
        this.xiangmuJieshuTime = xiangmuJieshuTime;
    }
    /**
	 * 获取：项目类型
	 */
    public Integer getXiangmuTypes() {
        return xiangmuTypes;
    }


    /**
	 * 设置：项目类型
	 */
    public void setXiangmuTypes(Integer xiangmuTypes) {
        this.xiangmuTypes = xiangmuTypes;
    }
    /**
	 * 获取：项目等级
	 */
    public Integer getXiangmuDengjiTypes() {
        return xiangmuDengjiTypes;
    }


    /**
	 * 设置：项目等级
	 */
    public void setXiangmuDengjiTypes(Integer xiangmuDengjiTypes) {
        this.xiangmuDengjiTypes = xiangmuDengjiTypes;
    }
    /**
	 * 获取：项目介绍
	 */
    public String getXiangmuContent() {
        return xiangmuContent;
    }


    /**
	 * 设置：项目介绍
	 */
    public void setXiangmuContent(String xiangmuContent) {
        this.xiangmuContent = xiangmuContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getXiangmuYesnoTypes() {
        return xiangmuYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setXiangmuYesnoTypes(Integer xiangmuYesnoTypes) {
        this.xiangmuYesnoTypes = xiangmuYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getXiangmuYesnoText() {
        return xiangmuYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setXiangmuYesnoText(String xiangmuYesnoText) {
        this.xiangmuYesnoText = xiangmuYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getXiangmuShenheTime() {
        return xiangmuShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setXiangmuShenheTime(Date xiangmuShenheTime) {
        this.xiangmuShenheTime = xiangmuShenheTime;
    }
    /**
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
