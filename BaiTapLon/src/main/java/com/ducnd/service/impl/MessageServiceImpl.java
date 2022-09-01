/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.service.impl;

import com.ducnd.pojo.Gr;
import com.ducnd.pojo.Message;
import com.ducnd.repository.MessageRepository;

import com.ducnd.service.MessageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DucND
 */

@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public boolean addMessage(Message message) {
        return this.messageRepository.addMessage(message);
    }

    @Override
    public List<Message> loadMessage(Gr groupId) {
        return this.messageRepository.loadMessage(groupId);
    }
    
}
