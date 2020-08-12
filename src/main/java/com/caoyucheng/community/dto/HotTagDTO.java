package com.caoyucheng.community.dto;

import lombok.Data;

/**
 * @author caoyucheng on 2020/8/12
 */
@Data
public class HotTagDTO implements Comparable {
    private String name;
    private Integer priority;

    @Override
    public int compareTo(Object o) {
        return this.getPriority() - ((HotTagDTO) o).getPriority();
    }
}
