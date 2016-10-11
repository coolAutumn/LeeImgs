package net.leeautumn.leeimgs.storeimgs.store;

import net.leeautumn.leeimgs.storeimgs.SotreImgsConstants;
import net.leeautumn.leeimgs.tools.conf.ConfPropertyReader;
import net.leeautumn.leeimgs.tools.encrypt.Encrypt;
import net.leeautumn.leeimgs.users.UserEntity;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by LeeAutumn on 10/10/16.
 * blog: leeautumn.net
 *
 * 运用线程池来管理线程,多线程存储图片
 */
public class IStoreImgsFactory implements IStoreImgs {

    public static IStoreImgsFactory storeImgsFactory = new IStoreImgsFactory();
    public static IStoreImgsFactory instanceOf(){
        return storeImgsFactory;
    }

    //获得存储图片文件的基础地址,并将properties存储起来
    public static final String basedir = ConfPropertyReader.read((storeImgsFactory.getClass().getResource("./../../../../..").toString()+"storeimgs-conf.properties").substring(5),"utf8").getProperty(SotreImgsConstants.BASE_IMG_DIR);

    //线程池
    private static ExecutorService threadPool = Executors.newFixedThreadPool(8);

    /**
     * 拟采用多线程的方法来实现文件存储,控制层只需要交付给存储工厂就可以直接返回了,存储工厂负责成功存储图片
     * 参数需要图片对象和用户信息
     * @param bytes
     * @param userEntity
     * @return 返回获取图片的图片名
     */
    public String storeImg(byte[] bytes , UserEntity userEntity) {

        //对图片取md5值
        String imgAfterMD5 = Encrypt.md5(bytes);


        //将用户名进行MD5加密
        String nameAfterMd5 = Encrypt.md5(userEntity.name);
        nameAfterMd5 = nameAfterMd5.substring(0,5);

        String imgFileName = nameAfterMd5 + imgAfterMD5;

        //如果文件存在就直接返回
        if(new File(basedir+imgFileName).exists()){
            return imgFileName;
        }

        threadPool.execute(new StoreImgsThread(imgFileName,bytes));

        return imgFileName;
    }
}

class StoreImgsThread implements Runnable{

    public String filename;
    public byte[] bytes;

    public StoreImgsThread(String filename,byte[] bytes){
        this.filename = filename;
        this.bytes = bytes;
    }

    public void run() {
        if(filename == null){
            throw new IllegalArgumentException("被存储文件的文件名为空,请确认.");
        }
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(IStoreImgsFactory.basedir+filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            dataOutputStream.write(bytes);
            dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
