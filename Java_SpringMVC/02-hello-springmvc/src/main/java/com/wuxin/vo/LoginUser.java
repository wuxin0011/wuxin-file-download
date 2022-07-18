package com.wuxin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: wuxin001
 * @date: 2022/7/17 2:51
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {

    private String email;
    private String password;
    private String username;
}
