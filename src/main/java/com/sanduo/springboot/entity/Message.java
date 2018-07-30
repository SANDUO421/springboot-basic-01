package com.sanduo.springboot.entity;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;

/**
 * 消息实体类
 * 
 * @author sanduo
 * @date 2018/06/26
 */
public class Message extends SerializableSerializer {

    /**
     *
     */
    private static final long serialVersionUID = -5773734588415636356L;
    private String name;
    private String content;
    private Integer Code;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the code
     */
    public Integer getCode() {
        return Code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(Integer code) {
        Code = code;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Message [name=" + name + ", content=" + content + ", Code=" + Code + "]";
    }

}
