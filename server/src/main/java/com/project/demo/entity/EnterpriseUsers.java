package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 企业用户：(EnterpriseUsers)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "EnterpriseUsers")
public class EnterpriseUsers implements Serializable {

    // EnterpriseUsers编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enterprise_users_id")
    private Integer enterprise_users_id;

    // 企业名称
    @Basic
    private String enterprise_name;
    // 用户姓名
    @Basic
    private String user_name;
    // 用户性别
    @Basic
    private String user_gender;
    // 用户年龄
    @Basic
    private String user_age;












    // 用户编号
    @Id
    @Column(name = "user_id")
    private Integer userId;


    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
