package net.leeautumn.leeimgs.users;

/**
 * Created by LeeAutumn on 10/10/16.
 * blog: leeautumn.net
 */
public class UserEntity {
    public String name;
    public String inviteId;
    public String imgStoreNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInviteId() {
        return inviteId;
    }

    public void setInviteId(String inviteId) {
        this.inviteId = inviteId;
    }

    public String getImgStoreNum() {
        return imgStoreNum;
    }

    public void setImgStoreNum(String imgStoreNum) {
        this.imgStoreNum = imgStoreNum;
    }
}
