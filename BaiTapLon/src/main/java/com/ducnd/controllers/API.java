/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.controllers;

import com.ducnd.pojo.IncomeGroupTemp;
import com.ducnd.pojo.Message;
import com.ducnd.service.GroupService;
import com.ducnd.service.IncomeGroupService;
import com.ducnd.service.IncomeGroupTempService;
import com.ducnd.service.IncomeService;
import com.ducnd.service.MessageService;
import com.ducnd.service.SpendingService;
import com.ducnd.service.UserService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DucND
 */

@RestController
public class API {
    @Autowired
    private IncomeGroupTempService incomeGroupTempService;
    @Autowired
    private IncomeGroupService incomeGroupService;
    @Autowired
    private IncomeService incomeService;
    @Autowired
    private SpendingService spendingService;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private GroupService groupService;
    
    @GetMapping("/api/incomeTemp/{groupId}")
    public ResponseEntity<List<IncomeGroupTemp>> getIncomeGroupTemps(@PathVariable(value = "groupId")int groupId){
        return new ResponseEntity<>(this.incomeGroupTempService.getIncomeGroupTemps(groupId), HttpStatus.OK);
    }
    
    @DeleteMapping("/api/incomeTemp/{id}")
    public boolean deleteIncomeGroupTemp(@PathVariable(value = "id")int id){
        return this.incomeGroupTempService.deleteIncomeGroupTemp(id);
    }
    
    @PostMapping("/api/incomeGroup")
    public boolean addIncomeGroup(@RequestBody Map<String, String> body) throws ParseException{
        double money =Double.parseDouble( body.get("money"));
        int userId = Integer.parseInt(body.get("userId"));
        int groupId = Integer.parseInt(body.get("groupId"));
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date date = f.parse(body.get("time"));
        java.sql.Date dateSql = new java.sql.Date(date.getTime());
        String purpose = body.get("purpose");
        return this.incomeGroupService.addIncomeGroupFromTemp(userId, groupId, dateSql, money, purpose);
    }
    
    @DeleteMapping("/api/deleteIncome/{id}")
    public boolean deleteIncome(@PathVariable(value="id") int id){
        return this.incomeService.deleteIncome(id);
    }
    
    @DeleteMapping("/api/deleteSpending/{id}")
    public boolean deleteSpending(@PathVariable(value = "id") int id){
        return this.spendingService.deleteSpending(id);
    }
    
    @PutMapping("/api/updateUser/{id}")
    public boolean updateUser(@PathVariable(value = "id") int id){
        return this.userService.updateActiveUser(id);
    }
    
    @PutMapping("/api/unlockUser/{id}")
    public boolean unlockUser(@PathVariable(value = "id") int id){
        return this.userService.unlockUser(id);
    }
    
    @PostMapping("/api/addMessage")
    public boolean addMessage(@RequestBody Map<String, String> body){
        Message m = new Message();
        int userId = Integer.parseInt(body.get("user_id"));
        int groupId = Integer.parseInt(body.get("group_id"));
        String content = String.valueOf(body.get("content"));
        m.setUserId(this.userService.getUserById(userId));
        m.setGroupId(this.groupService.getGroupById(groupId));
        m.setContent(content);
        return this.messageService.addMessage(m);
    }
    
}
