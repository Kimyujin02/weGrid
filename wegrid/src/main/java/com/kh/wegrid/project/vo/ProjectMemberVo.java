package com.kh.wegrid.project.vo;

import lombok.Data;
import org.springframework.scheduling.support.SimpleTriggerContext;

@Data
public class ProjectMemberVo {

    private String no;
    private String projectNo;
    private String empNo;
    private String startDate;
    private String endDate;
    private String delYn;
}
