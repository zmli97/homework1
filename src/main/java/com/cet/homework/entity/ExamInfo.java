package com.cet.homework.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
//白欣宇 实体类考试信息
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ExamInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime beginTime;   /*起始时间*/
    private LocalDateTime endTime;    /*结束时间*/
    private String classRome;         /*地点*/
    private String className; /*课程*/
    // 在没有声明时默认为1
    private int needCount =1 ;  /*所需人数*/
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            updatable = false,
            insertable = false)
    private LocalDateTime insertTime;
    @ManyToOne(fetch = FetchType.LAZY)
    private User teacher;
    public ExamInfo(int id) {
        this.id= id;
    }
}
