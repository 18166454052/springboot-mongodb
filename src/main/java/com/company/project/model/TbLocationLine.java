package com.company.project.model;

import java.util.Date;

public class TbLocationLine {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_location_line.line_id
     *
     * @mbg.generated Fri May 15 12:21:21 CST 2020
     */
    private String lineId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_location_line.company_id
     *
     * @mbg.generated Fri May 15 12:21:21 CST 2020
     */
    private String companyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_location_line.line
     *
     * @mbg.generated Fri May 15 12:21:21 CST 2020
     */
    private String line;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_location_line.create_time
     *
     * @mbg.generated Fri May 15 12:21:21 CST 2020
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_location_line.line_id
     *
     * @return the value of tb_location_line.line_id
     *
     * @mbg.generated Fri May 15 12:21:21 CST 2020
     */
    public String getLineId() {
        return lineId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_location_line.line_id
     *
     * @param lineId the value for tb_location_line.line_id
     *
     * @mbg.generated Fri May 15 12:21:21 CST 2020
     */
    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_location_line.company_id
     *
     * @return the value of tb_location_line.company_id
     *
     * @mbg.generated Fri May 15 12:21:21 CST 2020
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_location_line.company_id
     *
     * @param companyId the value for tb_location_line.company_id
     *
     * @mbg.generated Fri May 15 12:21:21 CST 2020
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_location_line.line
     *
     * @return the value of tb_location_line.line
     *
     * @mbg.generated Fri May 15 12:21:21 CST 2020
     */
    public String getLine() {
        return line;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_location_line.line
     *
     * @param line the value for tb_location_line.line
     *
     * @mbg.generated Fri May 15 12:21:21 CST 2020
     */
    public void setLine(String line) {
        this.line = line;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_location_line.create_time
     *
     * @return the value of tb_location_line.create_time
     *
     * @mbg.generated Fri May 15 12:21:21 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_location_line.create_time
     *
     * @param createTime the value for tb_location_line.create_time
     *
     * @mbg.generated Fri May 15 12:21:21 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}