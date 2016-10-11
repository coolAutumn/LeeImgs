package net.leeautumn.leeimgs.tools.uniqueid;

import java.util.UUID;

/**
 * Created by LeeAutumn on 10/10/16.
 * blog: leeautumn.net
 */
public class UniqueIDFactory {
    /**
     * 利用java自带的UUID类来产生UUID
     * @return
     */
    public static String createUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    /**
     * GUID是微软对散列码的称呼,Java称之为UUID
     * @return
     */
    public static String createGUID(){
        return createUUID();
    }
}
