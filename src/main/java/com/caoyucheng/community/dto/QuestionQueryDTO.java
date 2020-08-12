package com.caoyucheng.community.dto;

import lombok.Data;

/**
 * @author caoyucheng on 2020/8/12
 */
@Data
public class QuestionQueryDTO {
    private String search;
    private String sort;
    private Long time;
    private String tag;
    private Integer page;
    private Integer size;
}
