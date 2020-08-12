package com.caoyucheng.community.dto;

import lombok.Data;

import java.util.List;

/**
 * @author caoyucheng on 2020/8/10
 */
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
