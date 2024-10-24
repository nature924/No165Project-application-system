package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 项目
 *
 * @author 
 * @email
 */
@TableName("xiangmu")
public class XiangmuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XiangmuEntity() {

	}

	public XiangmuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 专家
     */
    @ColumnInfo(comment="专家",type="int(11)")
    @TableField(value = "zhuanjia_id")

    private Integer zhuanjiaId;


    /**
     * 项目编号
     */
    @ColumnInfo(comment="项目编号",type="varchar(200)")
    @TableField(value = "xiangmu_uuid_number")

    private String xiangmuUuidNumber;


    /**
     * 项目名称
     */
    @ColumnInfo(comment="项目名称",type="varchar(200)")
    @TableField(value = "xiangmu_name")

    private String xiangmuName;


    /**
     * 项目照片
     */
    @ColumnInfo(comment="项目照片",type="varchar(200)")
    @TableField(value = "xiangmu_photo")

    private String xiangmuPhoto;


    /**
     * 项目地点
     */
    @ColumnInfo(comment="项目地点",type="varchar(200)")
    @TableField(value = "xiangmu_address")

    private String xiangmuAddress;


    /**
     * 项目开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="项目开始时间",type="timestamp")
    @TableField(value = "xiangmu_kaishi_time")

    private Date xiangmuKaishiTime;


    /**
     * 项目结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="项目结束时间",type="timestamp")
    @TableField(value = "xiangmu_jieshu_time")

    private Date xiangmuJieshuTime;


    /**
     * 项目类型
     */
    @ColumnInfo(comment="项目类型",type="int(11)")
    @TableField(value = "xiangmu_types")

    private Integer xiangmuTypes;


    /**
     * 项目等级
     */
    @ColumnInfo(comment="项目等级",type="int(11)")
    @TableField(value = "xiangmu_dengji_types")

    private Integer xiangmuDengjiTypes;


    /**
     * 项目介绍
     */
    @ColumnInfo(comment="项目介绍",type="longtext")
    @TableField(value = "xiangmu_content")

    private String xiangmuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 审核状态
     */
    @ColumnInfo(comment="审核状态",type="int(11)")
    @TableField(value = "xiangmu_yesno_types")

    private Integer xiangmuYesnoTypes;


    /**
     * 审核意见
     */
    @ColumnInfo(comment="审核意见",type="longtext")
    @TableField(value = "xiangmu_yesno_text")

    private String xiangmuYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "xiangmu_shenhe_time")

    private Date xiangmuShenheTime;


    /**
     * 创建时间   listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Xiangmu{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", zhuanjiaId=" + zhuanjiaId +
            ", xiangmuUuidNumber=" + xiangmuUuidNumber +
            ", xiangmuName=" + xiangmuName +
            ", xiangmuPhoto=" + xiangmuPhoto +
            ", xiangmuAddress=" + xiangmuAddress +
            ", xiangmuKaishiTime=" + DateUtil.convertString(xiangmuKaishiTime,"yyyy-MM-dd") +
            ", xiangmuJieshuTime=" + DateUtil.convertString(xiangmuJieshuTime,"yyyy-MM-dd") +
            ", xiangmuTypes=" + xiangmuTypes +
            ", xiangmuDengjiTypes=" + xiangmuDengjiTypes +
            ", xiangmuContent=" + xiangmuContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", xiangmuYesnoTypes=" + xiangmuYesnoTypes +
            ", xiangmuYesnoText=" + xiangmuYesnoText +
            ", xiangmuShenheTime=" + DateUtil.convertString(xiangmuShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
