package net.leeautumn.leeimgs.tools.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by LeeAutumn on 10/10/16.
 * blog: leeautumn.net
 */
public class Encrypt {

    public static String Encrypt(String prime, EncryptMode encryptMode){
        switch (encryptMode){
            case MD5:
                return md5(prime);
            case DES:
                return des(prime);
            default:
                return "You need to realize the encryption function by yourself.";
        }
    }
    /**
     * MD5加密
     * @param prime 未被MD5加密前的String
     * @return  返回被MD5加密过后的32位字符串
     */
    public static String md5(String prime){
        return md5(prime.getBytes());
    }

    public static String md5(byte[] bytes){
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String encryption="";
        try {
            MessageDigest md5=MessageDigest.getInstance("MD5");
            md5.update(bytes);
            byte[] md=md5.digest();
            char[] encryption_char=new char[md.length*2];
            int k=0;
            for (int i = 0; i < md.length; i++) {
                byte byte0 = md[i];
                encryption_char[k++] = hexDigits[byte0 >>> 4 & 0xf];
                encryption_char[k++] = hexDigits[byte0 & 0xf];
            }
            encryption=new String(encryption_char);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryption;
    }

    public static String des(String prime){
        return null;
    }
}
