package com.woosan.root.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
 
@Component("cSession")
public class ChatSession {
    
    // static���� �ʵ庯���� �����Ͽ� ���� ArrayList�� �̿� �� �� �ֵ��� �����մϴ�.
    private static ArrayList<String> loginUser = new ArrayList<String>();
    
    // �α��� �� ArrayList�� �߰��մϴ�.
    public void addLoginUser(String email) {
        loginUser.add(email);
    }
    
    // �α׾ƿ� �� ArrayList���� �����մϴ�.
    public void removeLoginUser(String email) {
        loginUser.remove(email);
    }
 
    // ���� �α��� �Ǿ� �ִ� ���� ����� �����ɴϴ�.
    public static ArrayList<String> getLoginUser() {
        return loginUser;
    }
 
    // �ڵ� setter. ������� �ʾҽ��ϴ�.
    public static void setLoginUser(ArrayList<String> loginUser) {
        ChatSession.loginUser = loginUser;
    }
}
