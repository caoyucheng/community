package com.caoyucheng.community.dto;

import lombok.Data;

/**
 * @author caoyucheng on 2020/8/11
 */
@Data
public class NotificationDTO {
    private Long id;
    private Long notifier;
    private String notifierName;
    private Long outerId;
    private String outerTitle;
    private Integer type;
    private String typeName;
    private Long gmtCreate;
    private Integer status;
}
