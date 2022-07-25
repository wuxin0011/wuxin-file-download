package com.wuxin.service;

import com.wuxin.bean.BaseService;
import com.wuxin.pojo.File;
import com.wuxin.utils.PageUtil;
import com.wuxin.vo.FileVo;

import java.util.List;

/**
 * @author: wuxin001
 * @date: 2022/7/16 12:01
 * @Description:
 */
public interface FileService extends BaseService<File> {


    /**
     * 根据cid获取fileList
     *
     * @param cid
     * @return
     */
    List<FileVo> queryListAndCategory(int cid);


    /**
     * 分页获取
     *
     * @param cid
     * @param limit
     * @param size
     * @return
     */
    PageUtil<FileVo, Integer> queryPage(Integer cid, Integer limit, Integer size);


    /**
     * 通过cid删除
     * @param cid cid
     * @return true
     */
    boolean deleteByCid(Integer cid);
}
