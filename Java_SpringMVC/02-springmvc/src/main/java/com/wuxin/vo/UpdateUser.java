package com.wuxin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: wuxin001
 * @date: 2022/7/21 6:57
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUser {

    private Integer id;
    private String email;
    private String password;
    private String repassword;
    private String username;
}
