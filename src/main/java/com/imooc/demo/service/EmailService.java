package com.imooc.demo.service;

public interface EmailService {
    public void sendSimpleMail(String to,String title,String content);
    //public void sendAttachmentsMail(String to, String title, String content, List<File> fileList);
}
