package net.leeautumn.leeimgs.storeimgs.store;

import net.leeautumn.leeimgs.users.UserEntity;

import java.io.InputStream;

/**
 * Created by LeeAutumn on 10/10/16.
 * blog: leeautumn.net
 */
public interface IStoreImgs {
    public String storeImg(byte[] bytes, UserEntity userEntity);
}
