package com.sanduo.springboot.message;

/**
 * 响应消息
 * 
 * @author sanduo
 * @date 2018/06/26
 */
public class MessageResponse {

    private String responseMessage;

    /**
     * 
     */
    public MessageResponse() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param responseMessage
     */
    public MessageResponse(String responseMessage) {
        super();
        this.responseMessage = responseMessage;
    }

    /**
     * @return the responseMessage
     */
    public String getResponseMessage() {
        return responseMessage;
    }

    /**
     * @param responseMessage the responseMessage to set
     */
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

}
