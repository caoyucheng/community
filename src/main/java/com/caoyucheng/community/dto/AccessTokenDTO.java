package com.caoyucheng.community.dto;

import lombok.Data;

/**
 * @author caoyucheng on 2020/7/22
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
