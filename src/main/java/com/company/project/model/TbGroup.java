package com.company.project.model;

import java.util.Date;

public class TbGroup {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_group.group_id
     *
     * @mbg.generated Fri May 15 12:20:10 CST 2020
     */
    private String groupId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_group.company_id
     *
     * @mbg.generated Fri May 15 12:20:10 CST 2020
     */
    private String companyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_group.group_name
     *
     * @mbg.generated Fri May 15 12:20:10 CST 2020
     */
    private String groupName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_group.create_time
     *
     * @mbg.generated Fri May 15 12:20:10 CST 2020
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_group.group_id
     *
     * @return the value of tb_group.group_id
     *
     * @mbg.generated Fri May 15 12:20:10 CST 2020
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_group.group_id
     *
     * @param groupId the value for tb_group.group_id
     *
     * @mbg.generated Fri May 15 12:20:10 CST 2020
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_group.company_id
     *
     * @return the value of tb_group.company_id
     *
     * @mbg.generated Fri May 15 12:20:10 CST 2020
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_group.company_id
     *
     * @param companyId the value for tb_group.company_id
     *
     * @mbg.generated Fri May 15 12:20:10 CST 2020
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_group.group_name
     *
     * @return the value of tb_group.group_name
     *
     * @mbg.generated Fri May 15 12:20:10 CST 2020
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_group.group_name
     *
     * @param groupName the value for tb_group.group_name
     *
     * @mbg.generated Fri May 15 12:20:10 CST 2020
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_group.create_time
     *
     * @return the value of tb_group.create_time
     *
     * @mbg.generated Fri May 15 12:20:10 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_group.create_time
     *
     * @param createTime the value for tb_group.create_time
     *
     * @mbg.generated Fri May 15 12:20:10 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}