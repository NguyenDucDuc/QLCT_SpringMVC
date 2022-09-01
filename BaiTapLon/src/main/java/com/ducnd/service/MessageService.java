/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ducnd.service;

import com.ducnd.pojo.Gr;
import com.ducnd.pojo.Message;
import java.util.List;

/**
 *
 * @author DucND
 */
public interface MessageService {
    public boolean addMessage(Message message);
    public List<Message> loadMessage(Gr groupId);
}
