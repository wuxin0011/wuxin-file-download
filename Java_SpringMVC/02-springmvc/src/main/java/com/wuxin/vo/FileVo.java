package com.wuxin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: wuxin001
 * @date: 2022/7/17 2:30
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileVo {
    private Integer fid;
    private String url;
    private String name;
    private Date createTime;
    private Integer cid;
    private String cname;
}
