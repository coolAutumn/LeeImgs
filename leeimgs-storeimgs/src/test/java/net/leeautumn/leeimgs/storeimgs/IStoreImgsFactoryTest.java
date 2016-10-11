package net.leeautumn.leeimgs.storeimgs;

import net.leeautumn.leeimgs.storeimgs.store.IStoreImgsFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by LeeAutumn on 10/11/16.
 * blog: leeautumn.net
 */
public class IStoreImgsFactoryTest {
    @Test
    public void basedirTest(){
        Assert.assertEquals("equals","/home/leeimgs", IStoreImgsFactory.basedir);
    }
}
