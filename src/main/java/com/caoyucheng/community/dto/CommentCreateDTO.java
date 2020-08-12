package com.caoyucheng.community.dto;

import lombok.Data;

/**
 * @author caoyucheng on 2020/8/7
 */
@Data
public class CommentCreateDTO {
    private Long parentId;
    private String content;
    private Integer type;
}