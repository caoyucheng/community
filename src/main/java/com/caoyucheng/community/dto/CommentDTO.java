package com.caoyucheng.community.dto;

import com.caoyucheng.community.model.User;
import lombok.Data;

/**
 * @author caoyucheng on 2020/8/5
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private Integer commentCount;
    private String content;
    private User user;
}