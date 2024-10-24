package com.entity.vo;

import com.entity.XiangmuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 项目
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xiangmu")
public class XiangmuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 专家
     */

    @TableField(value = "zhuanjia_id")
    private Integer zhuanjiaId;


    /**
     * 项目编号
     */

    @TableField(value = "xiangmu_uuid_number")
    private String xiangmuUuidNumber;


    /**
     * 项目名称
     */

    @TableField(value = "xiangmu_name")
    private String xiangmuName;


    /**
     * 项目照片
     */

    @TableField(value = "xiangmu_photo")
    private String xiangmuPhoto;


    /**
     * 项目地点
     */

    @TableField(value = "xiangmu_address")
    private String xiangmuAddress;


    /**
     * 项目开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "xiangmu_kaishi_time")
    private Date xiangmuKaishiTime;


    /**
     * 项目结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "xiangmu_jieshu_time")
    private Date xiangmuJieshuTime;


    /**
     * 项目类型
     */

    @TableField(value = "xiangmu_types")
    private Integer xiangmuTypes;


    /**
     * 项目等级
     */

    @TableField(value = "xiangmu_dengji_types")
    private Integer xiangmuDengjiTypes;


    /**
     * 项目介绍
     */

    @TableField(value = "xiangmu_content")
    private String xiangmuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 审核状态
     */

    @TableField(value = "xiangmu_yesno_types")
    private Integer xiangmuYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "xiangmu_yesno_text")
    private String xiangmuYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "xiangmu_shenhe_time")
    private Date xiangmuShenheTime;


    /**
     * 创建时间  show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：专家
	 */
    public Integer getZhuanjiaId() {
        return zhuanjiaId;
    }


    /**
	 * 获取：专家
	 */

    public void setZhuanjiaId(Integer zhuanjiaId) {
        this.zhuanjiaId = zhuanjiaId;
    }
    /**
	 * 设置：项目编号
	 */
    public String getXiangmuUuidNumber() {
        return xiangmuUuidNumber;
    }


    /**
	 * 获取：项目编号
	 */

    public void setXiangmuUuidNumber(String xiangmuUuidNumber) {
        this.xiangmuUuidNumber = xiangmuUuidNumber;
    }
    /**
	 * 设置：项目名称
	 */
    public String getXiangmuName() {
        return xiangmuName;
    }


    /**
	 * 获取：项目名称
	 */

    public void setXiangmuName(String xiangmuName) {
        this.xiangmuName = xiangmuName;
    }
    /**
	 * 设置：项目照片
	 */
    public String getXiangmuPhoto() {
        return xiangmuPhoto;
    }


    /**
	 * 获取：项目照片
	 */

    public void setXiangmuPhoto(String xiangmuPhoto) {
        this.xiangmuPhoto = xiangmuPhoto;
    }
    /**
	 * 设置：项目地点
	 */
    public String getXiangmuAddress() {
        return xiangmuAddress;
    }


    /**
	 * 获取：项目地点
	 */

    public void setXiangmuAddress(String xiangmuAddress) {
        this.xiangmuAddress = xiangmuAddress;
    }
    /**
	 * 设置：项目开始时间
	 */
    public Date getXiangmuKaishiTime() {
        return xiangmuKaishiTime;
    }


    /**
	 * 获取：项目开始时间
	 */

    public void setXiangmuKaishiTime(Date xiangmuKaishiTime) {
        this.xiangmuKaishiTime = xiangmuKaishiTime;
    }
    /**
	 * 设置：项目结束时间
	 */
    public Date getXiangmuJieshuTime() {
        return xiangmuJieshuTime;
    }


    /**
	 * 获取：项目结束时间
	 */

    public void setXiangmuJieshuTime(Date xiangmuJieshuTime) {
        this.xiangmuJieshuTime = xiangmuJieshuTime;
    }
    /**
	 * 设置：项目类型
	 */
    public Integer getXiangmuTypes() {
        return xiangmuTypes;
    }


    /**
	 * 获取：项目类型
	 */

    public void setXiangmuTypes(Integer xiangmuTypes) {
        this.xiangmuTypes = xiangmuTypes;
    }
    /**
	 * 设置：项目等级
	 */
    public Integer getXiangmuDengjiTypes() {
        return xiangmuDengjiTypes;
    }


    /**
	 * 获取：项目等级
	 */

    public void setXiangmuDengjiTypes(Integer xiangmuDengjiTypes) {
        this.xiangmuDengjiTypes = xiangmuDengjiTypes;
    }
    /**
	 * 设置：项目介绍
	 */
    public String getXiangmuContent() {
        return xiangmuContent;
    }


    /**
	 * 获取：项目介绍
	 */

    public void setXiangmuContent(String xiangmuContent) {
        this.xiangmuContent = xiangmuContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getXiangmuYesnoTypes() {
        return xiangmuYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setXiangmuYesnoTypes(Integer xiangmuYesnoTypes) {
        this.xiangmuYesnoTypes = xiangmuYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getXiangmuYesnoText() {
        return xiangmuYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setXiangmuYesnoText(String xiangmuYesnoText) {
        this.xiangmuYesnoText = xiangmuYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getXiangmuShenheTime() {
        return xiangmuShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setXiangmuShenheTime(Date xiangmuShenheTime) {
        this.xiangmuShenheTime = xiangmuShenheTime;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
