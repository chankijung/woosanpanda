package com.woosan.root.dto;

public class ChatRoom {
    
    private String roomId;        // �� ��ȣ
    
    private String userEmail;    // ����� �̸���
    private String userName;    // ����� �̸�
    private String userPic;        // ����� ����
    
    private String masterEmail; // ���� �̸���
    private String masterName;    // ���� �̸�
    private String masterPic;    // ���� ����
    
    private int unReadCount;    // �� ���� �޼��� ��
    
    public ChatRoom() {
        super();
    }
 
    public ChatRoom(String roomId, String userEmail, String userName, String userPic, String masterEmail,
            String masterName, String masterPic, int unReadCount) {
        super();
        this.roomId = roomId;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPic = userPic;
        this.masterEmail = masterEmail;
        this.masterName = masterName;
        this.masterPic = masterPic;
        this.unReadCount = unReadCount;
    }
 
    public String getRoomId() {
        return roomId;
    }
 
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
 
    public String getUserEmail() {
        return userEmail;
    }
 
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
 
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getUserPic() {
        return userPic;
    }
 
    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }
 
    public String getMasterEmail() {
        return masterEmail;
    }
 
    public void setMasterEmail(String masterEmail) {
        this.masterEmail = masterEmail;
    }
 
    public String getMasterName() {
        return masterName;
    }
 
    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }
 
    public String getMasterPic() {
        return masterPic;
    }
 
    public void setMasterPic(String masterPic) {
        this.masterPic = masterPic;
    }
 
    public int getUnReadCount() {
        return unReadCount;
    }
 
    public void setUnReadCount(int unReadCount) {
        this.unReadCount = unReadCount;
    }
 
    @Override
    public String toString() {
        return "ChatRoom [roomId=" + roomId + ", userEmail=" + userEmail + ", userName=" + userName + ", userPic="
                + userPic + ", masterEmail=" + masterEmail + ", masterName=" + masterName + ", masterPic=" + masterPic
                + ", unReadCount=" + unReadCount + "]";
    }
}