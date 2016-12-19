package net.leeautumn.leeimgs.fetchimgs.fetchimgs;

import net.leeautumn.leeimgs.fetchimgs.menorycache.Memcache;
import net.leeautumn.leeimgs.storeimgs.store.StoreImgsFactory;

import java.io.*;
import java.nio.ByteBuffer;

/**
 * Created by LeeAutumn on 10/11/16.
 * blog: leeautumn.net
 */
public class FetchImgs implements IFetchImgs {

    public byte[] fetchimgs(String imgFileName) {

        byte[] bytes = null;

        //去图片缓存中找
        if((bytes = Memcache.contains(imgFileName)) != null){
            return bytes;
        }

        //去文件系统中找
        bytes = fetchimgInSystem(imgFileName);

        return null;
    }

    public byte[] fetchimgInSystem(String imgFileName){
        byte[] bytes = null;

        File file = new File(StoreImgsFactory.basedir+"/"+imgFileName.substring(0,5)+"/"+imgFileName.substring(5));

        if(!file.exists()){
            return null;
        }

        //从字节流中读取
        try {
            BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(file));
            bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return bytes;
        }
    }


}
