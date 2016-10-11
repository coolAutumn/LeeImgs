package net.leeautumn.leeimgs.tools.conf;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by LeeAutumn on 10/11/16.
 * blog: leeautumn.net
 */
public class ConfPropertyReader {

    //缓存所有已经读到的Properties对象
    public static final HashMap<String,Properties> propertiesCache = new HashMap<String, Properties>();

    /**
     * 根据filePath来读取k-v配置文件,默认采用latin1编码格式来解析property文件
     * @param propertyFile  配置文件的File对象
     * @return  返回包含所有k-v的Properties对象
     */
    public static Properties read(File propertyFile,String encode){

        if(propertiesCache.containsKey(propertyFile.getAbsolutePath())){
            return propertiesCache.get(propertyFile.getAbsolutePath());
        }
        //默认采用latin1编码格式解析文件
        if(encode == null){
            encode = "latin1";
        }

        if(propertyFile == null){
            throw new IllegalArgumentException("propertyFile对象为空,请确认.");
        }

        if(!propertyFile.exists()){
            throw new IllegalArgumentException("配置文件不存在,请确认.");
        }

        if(!propertyFile.isFile()){
            throw new IllegalArgumentException("配置文件类型不合法,请确认.");
        }

        //开始读取文件
        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream(propertyFile);
            //采用面向字符的Reader来读取文件
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,encode));
            properties.load(inputStream);

            //把Properties存储到cache中
            propertiesCache.put(propertyFile.getAbsolutePath(),properties);

            return properties;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static Properties read(File propertyFile){
        if(propertiesCache.containsKey(propertyFile.getAbsolutePath())){
            return propertiesCache.get(propertyFile.getAbsolutePath());
        }
        return read(propertyFile,null);
    }

    public static Properties read(String filepath){
        if(propertiesCache.containsKey(filepath)){
            return propertiesCache.get(filepath);
        }
        return read(new File(filepath),null);
    }

    public static Properties read(String filepath,String encode){
        if(propertiesCache.containsKey(filepath)){
            return propertiesCache.get(filepath);
        }
        return read(new File(filepath),encode);
    }


    public static void clear(){
        propertiesCache.clear();
    }


    public static void refresh(String filepath,String encode){
        //首先移除缓存中的Properties
        if(propertiesCache.containsKey(filepath)){
            propertiesCache.remove(filepath);
        }
        read(new File(filepath),encode);
    }
    public static void refresh(String filepath){
        refresh(filepath,null);
    }
}
