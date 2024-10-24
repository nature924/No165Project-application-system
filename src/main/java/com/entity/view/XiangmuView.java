package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XiangmuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 项目
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xiangmu")
public class XiangmuView extends XiangmuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 项目类型的值
	*/
	@ColumnInfo(comment="项目类型的字典表值",type="varchar(200)")
	private String xiangmuValue;
	/**
	* 项目等级的值
	*/
	@ColumnInfo(comment="项目等级的字典表值",type="varchar(200)")
	private String xiangmuDengjiValue;
	/**
	* 审核状态的值
	*/
	@ColumnInfo(comment="审核状态的字典表值",type="varchar(200)")
	private String xiangmuYesnoValue;

	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
	//级联表 专家
		/**
		* 专家姓名
		*/

		@ColumnInfo(comment="专家姓名",type="varchar(200)")
		private String zhuanjiaName;
		/**
		* 专家手机号
		*/

		@ColumnInfo(comment="专家手机号",type="varchar(200)")
		private String zhuanjiaPhone;
		/**
		* 专家身份证号
		*/

		@ColumnInfo(comment="专家身份证号",type="varchar(200)")
		private String zhuanjiaIdNumber;
		/**
		* 专家头像
		*/

		@ColumnInfo(comment="专家头像",type="varchar(200)")
		private String zhuanjiaPhoto;
		/**
		* 专家邮箱
		*/

		@ColumnInfo(comment="专家邮箱",type="varchar(200)")
		private String zhuanjiaEmail;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer jinyongTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String jinyongValue;


	public XiangmuView() {

	}

	public XiangmuView(XiangmuEntity xiangmuEntity) {
		try {
			BeanUtils.copyProperties(this, xiangmuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 项目类型的值
	*/
	public String getXiangmuValue() {
		return xiangmuValue;
	}
	/**
	* 设置： 项目类型的值
	*/
	public void setXiangmuValue(String xiangmuValue) {
		this.xiangmuValue = xiangmuValue;
	}
	//当前表的
	/**
	* 获取： 项目等级的值
	*/
	public String getXiangmuDengjiValue() {
		return xiangmuDengjiValue;
	}
	/**
	* 设置： 项目等级的值
	*/
	public void setXiangmuDengjiValue(String xiangmuDengjiValue) {
		this.xiangmuDengjiValue = xiangmuDengjiValue;
	}
	//当前表的
	/**
	* 获取： 审核状态的值
	*/
	public String getXiangmuYesnoValue() {
		return xiangmuYesnoValue;
	}
	/**
	* 设置： 审核状态的值
	*/
	public void setXiangmuYesnoValue(String xiangmuYesnoValue) {
		this.xiangmuYesnoValue = xiangmuYesnoValue;
	}


	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}
	//级联表的get和set 专家

		/**
		* 获取： 专家姓名
		*/
		public String getZhuanjiaName() {
			return zhuanjiaName;
		}
		/**
		* 设置： 专家姓名
		*/
		public void setZhuanjiaName(String zhuanjiaName) {
			this.zhuanjiaName = zhuanjiaName;
		}

		/**
		* 获取： 专家手机号
		*/
		public String getZhuanjiaPhone() {
			return zhuanjiaPhone;
		}
		/**
		* 设置： 专家手机号
		*/
		public void setZhuanjiaPhone(String zhuanjiaPhone) {
			this.zhuanjiaPhone = zhuanjiaPhone;
		}

		/**
		* 获取： 专家身份证号
		*/
		public String getZhuanjiaIdNumber() {
			return zhuanjiaIdNumber;
		}
		/**
		* 设置： 专家身份证号
		*/
		public void setZhuanjiaIdNumber(String zhuanjiaIdNumber) {
			this.zhuanjiaIdNumber = zhuanjiaIdNumber;
		}

		/**
		* 获取： 专家头像
		*/
		public String getZhuanjiaPhoto() {
			return zhuanjiaPhoto;
		}
		/**
		* 设置： 专家头像
		*/
		public void setZhuanjiaPhoto(String zhuanjiaPhoto) {
			this.zhuanjiaPhoto = zhuanjiaPhoto;
		}

		/**
		* 获取： 专家邮箱
		*/
		public String getZhuanjiaEmail() {
			return zhuanjiaEmail;
		}
		/**
		* 设置： 专家邮箱
		*/
		public void setZhuanjiaEmail(String zhuanjiaEmail) {
			this.zhuanjiaEmail = zhuanjiaEmail;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getJinyongTypes() {
			return jinyongTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
			}
				public String getJinyongValue() {
				return jinyongValue;
				}
				public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
				}

	@Override
	public String toString() {
		return "XiangmuView{" +
			", xiangmuValue=" + xiangmuValue +
			", xiangmuDengjiValue=" + xiangmuDengjiValue +
			", xiangmuYesnoValue=" + xiangmuYesnoValue +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", zhuanjiaName=" + zhuanjiaName +
			", zhuanjiaPhone=" + zhuanjiaPhone +
			", zhuanjiaIdNumber=" + zhuanjiaIdNumber +
			", zhuanjiaPhoto=" + zhuanjiaPhoto +
			", zhuanjiaEmail=" + zhuanjiaEmail +
			"} " + super.toString();
	}
}
