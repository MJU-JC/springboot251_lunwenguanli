package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 课题任务
 *
 * @author 
 * @email
 */
@TableName("ketirenwu")
public class KetirenwuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KetirenwuEntity() {

	}

	public KetirenwuEntity(T t) {
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
    @TableField(value = "id")

    private Integer id;


    /**
     * 指导教师
     */
    @TableField(value = "zhidaojiaoshi_id")

    private Integer zhidaojiaoshiId;


    /**
     * 选题申请
     */
    @TableField(value = "xuantishenqing_id")

    private Integer xuantishenqingId;


    /**
     * 课题任务
     */
    @TableField(value = "ketirenwu_name")

    private String ketirenwuName;


    /**
     * 任务类型
     */
    @TableField(value = "ketirenwu_types")

    private Integer ketirenwuTypes;


    /**
     * 参考文献
     */
    @TableField(value = "ketirenwu_file")

    private String ketirenwuFile;


    /**
     * 阶段文档
     */
    @TableField(value = "ketirenwu_huida_file")

    private String ketirenwuHuidaFile;


    /**
     * 审核结果
     */
    @TableField(value = "ketirenwu_yesno_types")

    private Integer ketirenwuYesnoTypes;


    /**
     * 指导教师打分
     */
    @TableField(value = "ketirenwu_yesno_text")

    private String ketirenwuYesnoText;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：指导教师
	 */
    public Integer getZhidaojiaoshiId() {
        return zhidaojiaoshiId;
    }
    /**
	 * 获取：指导教师
	 */

    public void setZhidaojiaoshiId(Integer zhidaojiaoshiId) {
        this.zhidaojiaoshiId = zhidaojiaoshiId;
    }
    /**
	 * 设置：选题申请
	 */
    public Integer getXuantishenqingId() {
        return xuantishenqingId;
    }
    /**
	 * 获取：选题申请
	 */

    public void setXuantishenqingId(Integer xuantishenqingId) {
        this.xuantishenqingId = xuantishenqingId;
    }
    /**
	 * 设置：课题任务
	 */
    public String getKetirenwuName() {
        return ketirenwuName;
    }
    /**
	 * 获取：课题任务
	 */

    public void setKetirenwuName(String ketirenwuName) {
        this.ketirenwuName = ketirenwuName;
    }
    /**
	 * 设置：任务类型
	 */
    public Integer getKetirenwuTypes() {
        return ketirenwuTypes;
    }
    /**
	 * 获取：任务类型
	 */

    public void setKetirenwuTypes(Integer ketirenwuTypes) {
        this.ketirenwuTypes = ketirenwuTypes;
    }
    /**
	 * 设置：参考文献
	 */
    public String getKetirenwuFile() {
        return ketirenwuFile;
    }
    /**
	 * 获取：参考文献
	 */

    public void setKetirenwuFile(String ketirenwuFile) {
        this.ketirenwuFile = ketirenwuFile;
    }
    /**
	 * 设置：阶段文档
	 */
    public String getKetirenwuHuidaFile() {
        return ketirenwuHuidaFile;
    }
    /**
	 * 获取：阶段文档
	 */

    public void setKetirenwuHuidaFile(String ketirenwuHuidaFile) {
        this.ketirenwuHuidaFile = ketirenwuHuidaFile;
    }
    /**
	 * 设置：审核结果
	 */
    public Integer getKetirenwuYesnoTypes() {
        return ketirenwuYesnoTypes;
    }
    /**
	 * 获取：审核结果
	 */

    public void setKetirenwuYesnoTypes(Integer ketirenwuYesnoTypes) {
        this.ketirenwuYesnoTypes = ketirenwuYesnoTypes;
    }
    /**
	 * 设置：指导教师打分
	 */
    public String getKetirenwuYesnoText() {
        return ketirenwuYesnoText;
    }
    /**
	 * 获取：指导教师打分
	 */

    public void setKetirenwuYesnoText(String ketirenwuYesnoText) {
        this.ketirenwuYesnoText = ketirenwuYesnoText;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Ketirenwu{" +
            "id=" + id +
            ", zhidaojiaoshiId=" + zhidaojiaoshiId +
            ", xuantishenqingId=" + xuantishenqingId +
            ", ketirenwuName=" + ketirenwuName +
            ", ketirenwuTypes=" + ketirenwuTypes +
            ", ketirenwuFile=" + ketirenwuFile +
            ", ketirenwuHuidaFile=" + ketirenwuHuidaFile +
            ", ketirenwuYesnoTypes=" + ketirenwuYesnoTypes +
            ", ketirenwuYesnoText=" + ketirenwuYesnoText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
