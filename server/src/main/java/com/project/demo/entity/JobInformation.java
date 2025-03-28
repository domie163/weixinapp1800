package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 求职信息：(JobInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "JobInformation")
public class JobInformation implements Serializable {

    // JobInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_information_id")
    private Integer job_information_id;

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
    // 毕业学院
    @Basic
    private String graduation_college;
    // 个人特长
    @Basic
    private String personal_specialty;
    // 联系方式
    @Basic
    private String contact_information;
    // 求职岗位
    @Basic
    private String job_position;
    // 工作经历
    @Basic
    private String work_experience;
    // 个人照片
    @Basic
    private String personal_photos;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
