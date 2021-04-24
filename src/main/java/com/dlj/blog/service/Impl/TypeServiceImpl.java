package com.dlj.blog.service.Impl;

import com.dlj.blog.dao.TypeDao;
import com.dlj.blog.entity.Flag;
import com.dlj.blog.pojo.BlogPageInfo;
import com.dlj.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description: 分类服务层
* @Author: dljdlj
* @Date: 2021/4/3
* @Url: dljdlj.top
* @Remark:
*/
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeDao typeDao;

    @Override
    public List<BlogPageInfo> getTypeBlogPageInfo(String stringFlagId) {
        long flagId;
        if (stringFlagId==null){
            flagId=-1;
        }else {
            flagId=Long.parseLong(stringFlagId);
        }
        return typeDao.getTypeBlogPageInfo(flagId);
    }

    @Override
    public List<Flag> getAllFlag() {
        return typeDao.getAllFlag();
    }
}
