package examples.chat;

import java.io.Serializable;

public class ChatMessage implements Serializable
{
    private final MessageType msgType;
    private final String msg;

    public enum MessageType 
	{
        QUESTION,
        ANSWER,
        STATEMENT
    }

    public MessageType getMsgType() 
	{
        return msgType;
    }

    public String getMsg() 
	{
        return msg;
    }

    public ChatMessage(MessageType msgType, String msg)
	{
        this.msgType = msgType;
        this.msg = msg;
    }

    // example function to test if this works or not
    public static void main (String [] args)
	{
        ChatMessage questionMessage = new ChatMessage(MessageType.QUESTION,"Meet for lunch ?");

        switch (questionMessage.msgType)
        {
            case QUESTION:
                // capture the information with the timestamp information for the question
                break;
            case ANSWER:
                // check if the timestamp associated with the
            default:
                // broadcast;
        }
    }
}