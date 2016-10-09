package net.leeautumn.leeimgs.transimgs.output;

import net.leeautumn.leeimgs.transimgs.ITransObject;
import net.leeautumn.leeimgs.transimgs.OutputMode;
import org.springframework.util.Assert;

/**
 * Created by LeeAutumn on 10/9/16.
 * blog: leeautumn.net
 */
public class TransOutput {

    /**
     * 由于不确定给controller返回的对象是什么类型,这里直接用Object类型
     * @return
     */
    public Object output(ITransObject transObject,OutputMode outputMode){

        //调用Srping的Assert工具类来进行判断
        Assert.notNull(transObject,"Please ensure the objected to be transferred is not null");

        switch (outputMode){
            case Object:
                return transObject;
            case Json:
                return transObject.toJson();
            case Xml:
                return transObject.toXml();
            default:
                return null;
        }
    }
}
