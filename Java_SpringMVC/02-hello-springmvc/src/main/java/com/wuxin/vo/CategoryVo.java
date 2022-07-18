package com.wuxin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: wuxin001
 * @date: 2022/7/17 12:27
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVo {
    private Integer cid;
    private String name;
    private Integer count;
}
