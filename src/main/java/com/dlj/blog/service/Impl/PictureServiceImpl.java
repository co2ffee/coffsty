package com.dlj.blog.service.Impl;

import com.dlj.blog.dao.PictureDao;
import com.dlj.blog.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    PictureDao pictureDao;

    @Override
    public int saveAvatar(String avatar, Long id) {
        return pictureDao.saveAvatar(avatar, id);
    }
}
