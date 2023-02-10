package com.wuxin.handler;

import com.wuxin.exception.AuthException;
import com.wuxin.exception.UnauthenticatedException;
import com.wuxin.utils.R;
import com.wuxin.utils.StringUtil;
import org.apache.commons.fileupload.FileUploadBase;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author: wuxin001
 * @date: 2022/7/16 11:46
 * @Description: 全局异常处理器
 */
@ControllerAdvice
public class GlobalExceptionController {


    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(Exception e) {

        ModelAndView mv = new ModelAndView("error");
        String message = e.getMessage();

        if (e instanceof NoHandlerFoundException) {
            mv.addAllObjects(R.error(404, "页面未找到！"));
            return mv;
        }

        if (e instanceof AuthException) {
            if (StringUtil.isEmpty(message)) {
                message = "你所访问的页面需要登录，请登录！";
            }
            mv.addAllObjects(R.error(401, message));
            return mv;
        }

        if (e instanceof UnauthenticatedException) {
            if (StringUtil.isEmpty(message)) {
                message = "没有权限执行该操作哦！";
            }
            mv.addAllObjects(R.error(403, message));
            return mv;
        }

        if(e instanceof FileUploadBase.SizeLimitExceededException){
            mv.addAllObjects(R.error(402, "文件过大！"));
            return mv;
        }




        System.err.println("错误日志信息:"+message);

        mv.addAllObjects(R.error(message));
        return mv;

    }


}
