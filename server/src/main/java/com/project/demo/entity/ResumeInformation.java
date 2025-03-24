package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 简历信息：(ResumeInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ResumeInformation")
public class ResumeInformation implements Serializable {

    // ResumeInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_information_id")
    private Integer resume_information_id;

    // 用户信息
    @Basic
    private Integer user_information;
    // 用户姓名
    @Basic
    private String user_name;
    // 用户性别
    @Basic
    private String user_gender;
    // 用户年龄
    @Basic
    private String user_age;
    // 个人学历
    @Basic
    private String personal_education;
    // 联系方式
    @Basic
    private String contact_information;
    // 企业信息
    @Basic
    private Integer enterprise_information;
    // 企业名称
    @Basic
    private String enterprise_name;
    // 招聘岗位
    @Basic
    private String recruitment_position;
    // 个人简历
    @Basic
    private String curriculum_vitae;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
