package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 个人用户：(IndividualUsers)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "IndividualUsers")
public class IndividualUsers implements Serializable {

    // IndividualUsers编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "individual_users_id")
    private Integer individual_users_id;

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
