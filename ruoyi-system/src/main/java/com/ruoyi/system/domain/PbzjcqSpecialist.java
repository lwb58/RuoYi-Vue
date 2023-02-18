package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 pbzjcq_specialist
 * 
 * @author ruoyi
 * @date 2023-02-18
 */
public class PbzjcqSpecialist extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 专家编号 */
    private Long id;

    /** 专家姓名 */
    @Excel(name = "专家姓名")
    private String name;

    /** 专业类别 */
    @Excel(name = "专业类别")
    private String type;

    /** 移动电话 */
    @Excel(name = "移动电话")
    private String phone;

    /** 地址 */
    @Excel(name = "地址")
    private String addr;

    /** 跟进状态 */
    @Excel(name = "跟进状态")
    private String status;

    /** 被抽取专业 */
    @Excel(name = "被抽取专业")
    private String zhuanye;

    /** 固定电话 */
    @Excel(name = "固定电话")
    private String tel;

    /** 专家单位 */
    @Excel(name = "专家单位")
    private String company;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setAddr(String addr) 
    {
        this.addr = addr;
    }

    public String getAddr() 
    {
        return addr;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setZhuanye(String zhuanye) 
    {
        this.zhuanye = zhuanye;
    }

    public String getZhuanye() 
    {
        return zhuanye;
    }
    public void setTel(String tel) 
    {
        this.tel = tel;
    }

    public String getTel() 
    {
        return tel;
    }
    public void setCompany(String company) 
    {
        this.company = company;
    }

    public String getCompany() 
    {
        return company;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("type", getType())
            .append("phone", getPhone())
            .append("addr", getAddr())
            .append("status", getStatus())
            .append("zhuanye", getZhuanye())
            .append("createTime", getCreateTime())
            .append("tel", getTel())
            .append("company", getCompany())
            .toString();
    }
}
