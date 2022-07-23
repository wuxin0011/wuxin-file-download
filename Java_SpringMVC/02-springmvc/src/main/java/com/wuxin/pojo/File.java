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
public class File {
    private Integer fid;
    private String name;
    private String url;
    private Integer cid;
    private Integer status;
    private Date createTime;
}
