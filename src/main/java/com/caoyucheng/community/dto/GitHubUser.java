package com.caoyucheng.community.dto;

import lombok.Data;

/**
 * @author caoyucheng on 2020/7/22
 */
@Data
public class GitHubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
