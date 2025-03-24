package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 招聘信息：(RecruitmentInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "RecruitmentInformation")
public class RecruitmentInformation implements Serializable {

    // RecruitmentInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruitment_information_id")
    private Integer recruitment_information_id;

    // 企业信息
    @Basic
    private Integer enterprise_information;
    // 企业名称
    @Basic
    private String enterprise_name;
    // 招聘岗位
    @Basic
    private String recruitment_position;
    // 招聘人数
    @Basic
    private String number_of_recruiters;
    // 办公地点
    @Basic
    private String office_location;
    // 薪资范围
    @Basic
    private String salary_range;
    // 岗位要求
    @Basic
    private String job_requirements;
    // 企业封面
    @Basic
    private String enterprise_cover;

    // 点击数
    @Basic
    private Integer hits;













    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
