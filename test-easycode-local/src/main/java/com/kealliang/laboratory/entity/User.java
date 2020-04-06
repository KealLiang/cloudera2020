package com.kealliang.laboratory.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 用户基本信息表(User)实体类
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User implements Serializable {
    private static final long serialVersionUID = 831013941012967603L;
    /**
    * 用户唯一id
    */
    private Integer id;
    /**
    * 用户名
    */
    private String name;
    /**
    * 电子邮箱
    */
    private String email;
    /**
    * 电话号码
    */
    private String phoneNumber;
    /**
    * 密码
    */
    private String password;
    /**
    * 用户状态 0-正常 1-封禁
    */
    private Integer status;
    /**
    * 用户账号创建时间
    */
    private Date createTime;
    /**
    * 上次登录时间
    */
    private Date lastLoginTime;
    /**
    * 上次更新记录时间
    */
    private Date lastUpdateTime;
    /**
    * 头像
    */
    private String avatar;


}