package com.woosan.root.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.woosan.root.service.ChatService;
import com.woosan.root.dto.ChatMessage;
import com.woosan.root.dto.ChatRoom;
import com.woosan.root.dto.ChatSession;
import com.fp.neezit.product.model.service.ProductService;
import com.fp.neezit.user.model.vo.UserMaster;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
 
@Controller
public class ChatController {
    
    @Autowired
    ChatService cService;
    
    @Autowired
    ProductService pService;
    
    @Autowired
    private ChatSession cSession;
    
    /**
     * �ش� ä�ù��� ä�� �޼��� �ҷ�����
     * @param roomId
     * @param model
     * @param response
     * @throws JsonIOException
     * @throws IOException
     */
    @RequestMapping(value="{roomId}.do")
    public void messageList(@PathVariable String roomId, String userEmail, Model model, HttpServletResponse response) throws JsonIOException, IOException {
        
        List<ChatMessage> mList = cService.messageList(roomId);
        response.setContentType("application/json; charset=utf-8");
 
        // ������ �޼����� ���� 0���� �ٲ��
        ChatMessage message = new ChatMessage();
        message.setEmail(userEmail);
        message.setRoomId(roomId);
        cService.updateCount(message);
        
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        gson.toJson(mList,response.getWriter());
    }
    
    /**
     * ä�� ���� ���� �� ����
     * @param room
     * @param userEmail
     * @param masterNickname
     * @return
     */
    @ResponseBody
    @RequestMapping("createChat.do")
    public String createChat(ChatRoom room, String userName, String userEmail, String masterNickname){
        
        UserMaster m = pService.getProductDetail(masterNickname);
        
        room.setUserEmail(userEmail);
        room.setUserName(userName);
        room.setMasterEmail(m.getEmail());
        room.setMasterName(m.getmNickname());
        room.setMasterPic(m.getmProPicRe());
 
        ChatRoom exist  = cService.searchChatRoom(room);
        
        // DB�� ���� ���� ��
        if(exist == null) {
            System.out.println("���� ����!!");
            int result = cService.createChat(room);
            if(result == 1) {
                System.out.println("�� �������!!");
                return "new";
            }else {
                return "fail";
            }
        }
        // DB�� ���� ���� ��
        else{
            System.out.println("���� �ִ�!!");
            return "exist";
        }
    }
    
    /**
     * ä�� �� ��� �ҷ�����
     * @param room
     * @param userEmail
     * @param response
     * @throws JsonIOException
     * @throws IOException
     */
    @RequestMapping("chatRoomList.do")
    public void createChat(ChatRoom room, ChatMessage message, String userEmail, HttpServletResponse response) throws JsonIOException, IOException{
        List<ChatRoom> cList = cService.chatRoomList(userEmail);
        
        for(int i = 0; i < cList.size(); i++) {
            message.setRoomId(cList.get(i).getRoomId());
            message.setEmail(userEmail);
            int count = cService.selectUnReadCount(message);
            cList.get(i).setUnReadCount(count);
        }
        
        response.setContentType("application/json; charset=utf-8");
 
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        gson.toJson(cList,response.getWriter());
    }
    
    @RequestMapping("chatSession.do")
    public void chatSession( HttpServletResponse response) throws JsonIOException, IOException{
        
        ArrayList<String> chatSessionList = cSession.getLoginUser();
        
        response.setContentType("application/json; charset=utf-8");
 
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        gson.toJson(chatSessionList,response.getWriter());
    }
    
}