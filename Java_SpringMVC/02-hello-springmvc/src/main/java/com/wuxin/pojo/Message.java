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
public class Message {
    private Integer mid;
    private String content;
    private String email;
    private Integer status;
    private Date createTime;
}
