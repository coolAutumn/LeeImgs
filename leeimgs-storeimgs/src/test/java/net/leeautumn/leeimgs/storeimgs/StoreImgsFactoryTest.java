package net.leeautumn.leeimgs.storeimgs;

import net.leeautumn.leeimgs.storeimgs.store.StoreImgsFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by LeeAutumn on 10/11/16.
 * blog: leeautumn.net
 */
public class StoreImgsFactoryTest {
//    @Test
    public void basedirTest(){
        Assert.assertEquals("equals","/home/leeimgs", StoreImgsFactory.basedir);
    }
}
