package com.wuxin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: wuxin001
 * @date: 2022/7/16 11:47
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
    private Integer nid;
    private String title;
    private String content;
    private Date createTime;
}
