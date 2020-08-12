package com.caoyucheng.community.mapper;

import com.caoyucheng.community.model.Comment;

/**
 * @author caoyucheng on 2020/8/9
 */
public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}
