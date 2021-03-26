package com.example.chopeeservice.impl;

import com.example.chopeebiz.domain.UserDomain;
import com.example.chopeebiz.dto.LoginReqDto;
import com.example.chopeedao.po.User;
import com.example.chopeeservice.CommonService;
import com.example.chopeeservice.util.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private UserDomain userDomain;

    @Override
    public Cookie doLogin(LoginReqDto loginReqDto) {
        User user = userDomain.doLogin(loginReqDto);
        Cookie cookie = null;
        if(null != user) {
            cookie = new Cookie("userInfo", EncryptionUtil.base64Encode(user.getUserId().toString()));
        }
        return cookie;
    }

    @Override
    public String uploadFile(MultipartFile file) throws Exception {
        String os = System.getProperty("os.name");
        File fileRealPath;   //文件存放地址

        //获取根目录
        //如果是在本地windows环境下，目录为项目的target\classes下
        //如果是linux环境下，目录为jar包同级目录
        File rootPath = new File(ResourceUtils.getURL("classpath:").getPath());
        if (!rootPath.exists()) {
            rootPath = new File("");
        }
        fileRealPath = new File(rootPath.getAbsolutePath() + "/file/");

        //判断文件夹是否存在
        if (!fileRealPath.exists()) {
            //不存在，创建
            fileRealPath.mkdirs();
        }

        //获取文件名称
        String fileName = UUID.randomUUID().toString()+file.getOriginalFilename();
        //创建文件存放地址
        File resultPath = new File(fileRealPath + "/" + fileName);
        if (resultPath.exists()) {
            return null;
        }
        file.transferTo(resultPath);
        System.out.println("absolutePath:" + fileRealPath.getCanonicalPath());
        System.out.println("resultPath:" + resultPath.getCanonicalPath());
        return "file/"+fileName;
    }


}
