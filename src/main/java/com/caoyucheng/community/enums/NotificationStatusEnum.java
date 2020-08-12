package com.caoyucheng.community.enums;

/**
 * @author caoyucheng on 2020/8/11
 */
public enum NotificationStatusEnum {
    UNREAD(0), READ(1);
    private int status;

    public int getStatus() {
        return status;
    }

    NotificationStatusEnum(int status) {
        this.status = status;
    }
}