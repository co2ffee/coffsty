package com.dlj.blog.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@Slf4j
public class GetPathUtils {
    public String getPath() {
        String path = System.getProperties().getProperty("user.dir");
        path = path + File.separator + "userimg";
        File folder = new File(path);
        if (!folder.exists() && !folder.isDirectory()) {
            folder.mkdirs();
            log.info("文件夹不存在，创建文件夹");
        } else {
            log.info("文件夹已存在");
        }
        path = path + File.separator;
        log.info("path:{}", path);
        return path;
    }

    public String getPathBySlash() {
        String path = getPath();
//        path.replaceAll("\\\\", "/");
//        path.replace(":/", "://");
        log.info("pathSlash:{}", path);
        return path;
    }
}
