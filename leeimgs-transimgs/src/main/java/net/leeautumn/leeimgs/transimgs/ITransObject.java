package net.leeautumn.leeimgs.transimgs;

/**
 * Created by LeeAutumn on 10/9/16.
 * blog: leeautumn.net
 * 这个
 */
public interface ITransObject {

    /**
     * 默认使用Json数据格式返回普通对象信息
     */
    public OutputMode outputMode = OutputMode.Json;

    /**
     * 用来判断这个类是否用来代表图片(不包含图片信息)
     * @return
     */
    public boolean isImage();

    /**
     * 将用来描述普通信息的类转换成Json数据格式输出
     * @return
     */
    public String  toJson();

    /**
     * 将用来描述普通信息的类转换成Xml数据格式输出
     * @return
     */
    public String  toXml();

    /**
     * 不做任何改变,向web中的中的controller直接返回对象类型
     * @return
     */
    public Object toObject();
}
