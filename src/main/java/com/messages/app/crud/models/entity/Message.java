package com.messages.app.crud.models.entity;

public class Message {
    private int idMessage;
    private String messageContent;
    private String messageAuthor;
    private String messageDate;

    public Message() {
    }

    public Message(int idMessage, String messageContent, String messageAuthor, String messageDate) {
        this.idMessage = idMessage;
        this.messageContent = messageContent;
        this.messageAuthor = messageAuthor;
        this.messageDate = messageDate;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageAuthor() {
        return messageAuthor;
    }

    public void setMessageAuthor(String messageAuthor) {
        this.messageAuthor = messageAuthor;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }
}
