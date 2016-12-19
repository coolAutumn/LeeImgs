package net.leeautumn.leeimgs.web.controller;

import net.leeautumn.leeimgs.fetchimgs.fetchimgs.FetchImgs;
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
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by coolAutumn on 10/11/16.
 */
@Controller
public class FetchImgController {

    String imgurl = null;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private HttpServletResponse httpServletResponse;

    /**
     * 该请求包含两个参数 request和service
     * @return  根据request的值来返回对应的wmts规范文档
     */
    @RequestMapping(value="fetchimg")
    public void fetchimg(){
        //判断文件类型

        //获取用户名
        imgurl = httpServletRequest.getParameter("imgurl");
        //设置返回类型
        httpServletResponse.setContentType("image/*");

        byte[] bytes = new FetchImgs().fetchimgInSystem(imgurl);

        BufferedOutputStream outputStream = null;
        try {
            outputStream = new BufferedOutputStream(httpServletResponse.getOutputStream());
            outputStream.write(bytes);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

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
