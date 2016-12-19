package net.leeautumn.leeimgs.psimgs;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by LeeAutumn on 10/9/16.
 * blog: leeautumn.net
 */
public interface ProcessImgs {

    /**
     * 此方法用来对图片进行大小变换  ==  截图
     */
    public void changeSize(InputStream inputStream, OutputStream outputStream,int lefttop_top,int lefttop_left,int width,int height);

    /**
     * 此方法用来对图片进行缩略图变换
     */
    public void scale(InputStream inputStream, OutputStream outputStream,double scalePercentage);

    /**
     * 此方法用来对图片进行缩旋转变换
     */
    public void rotate(InputStream inputStream, OutputStream outputStream,double rotateAngle);

    /**
     * 此方法用来对图片进行水印添加
     */
    public void watermark(InputStream inputStream, OutputStream outputStream);
}
