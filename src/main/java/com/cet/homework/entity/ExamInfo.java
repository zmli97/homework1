package com.cet.homework.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
//白欣宇 实体类考试信息
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ExamInfo {

    public static final int EXAMINFO_NEEDCOUNT = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int examInfoId;
    private LocalDateTime beginTime;   /*起始时间*/
    private LocalDateTime endTime;    /*结束时间*/
    private String classRome;         /*地点*/
    private String className; /*课程*/
    // 在没有声明时默认为1
    private int needCount =1 ;  /*所需人数*/
    private int teacherId;   /*教师编号*/

    public ExamInfo(int id) {
        this.examInfoId= id;
    }
}
