package chinmayasharma.com.groupchat;

import java.util.Date;

public class Message {

    private String messageText;
    private String messageUser;
    private long messageTime;

    Message(String messageText, String messageUser) {
        this.messageText = messageText;
        this.messageUser = messageUser;
        messageTime = new Date().getTime();
    }

    String getMessageText() {
        return messageText;
    }

    void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
}