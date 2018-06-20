package com.logictech.mapper;

import com.logictech.entity.dto.CustomerInfo;

public interface CustomerInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_info
     *
     * @mbggenerated
     */
    int insert(CustomerInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_info
     *
     * @mbggenerated
     */
    int insertSelective(CustomerInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_info
     *
     * @mbggenerated
     */
    CustomerInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CustomerInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CustomerInfo record);
    /**
     * 根据客户code查询
     */
    CustomerInfo selectByCustomerCode(String  customerCode);
}