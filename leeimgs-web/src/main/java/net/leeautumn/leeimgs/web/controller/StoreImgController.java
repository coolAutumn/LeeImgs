package net.leeautumn.leeimgs.web.controller;

import net.leeautumn.leeimgs.storeimgs.store.StoreImgsFactory;
import net.leeautumn.leeimgs.users.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by coolAutumn on 10/11/16.
 */
@Controller
public class StoreImgController {

    String username = null;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private HttpServletResponse httpServletResponse;

    /**
     * 该请求包含两个参数 request和service
     * @return  根据request的值来返回对应的wmts规范文档
     */
    @RequestMapping(value="/uploadimg")
    @ResponseBody
    public ModelAndView storeimg(@RequestParam(value = "upimgs",required = true)MultipartFile multipartFile){
        //判断文件类型

        //获取用户名
        username = httpServletRequest.getParameter("username");
        if(username == null || username.length() == 1){
            //默认存储到basedir下的default文件夹下
            username = "default";
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setName(username);

        String imgurl = "";
        try {
            //交给storeimgs模块来存储图片文件
            imgurl = StoreImgsFactory.instanceOf().storeImg(multipartFile.getBytes(),userEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //跳转View
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("storesucceed");
        modelAndView.addObject("imgurl",imgurl);
        return modelAndView;
    }


    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public HttpServletResponse getHttpServletResponse() {
        return httpServletResponse;
    }

    public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }
}
