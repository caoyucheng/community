package com.caoyucheng.community.enums;
/**
 * @author caoyucheng on 2020/8/6
 */
public enum CommentTypeEnum {
    QUESTION(1),
    COMMENT(2);
    private final Integer type;


    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum commentTypeEnum : CommentTypeEnum.values()) {
            if (commentTypeEnum.getType().equals(type)) {
                return true;
            }
        }
        return false;
    }
}
