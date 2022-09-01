/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.controllers;

import com.ducnd.pojo.Gr;
import com.ducnd.service.BelongService;
import com.ducnd.service.GroupService;
import com.ducnd.service.StatsService;
import com.ducnd.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DucND
 */

@Controller
public class SummaryController {
    
    @Autowired
    private StatsService statsService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private UserService userService;
    @Autowired
    private BelongService belongService;
    
    @GetMapping("/summary")
    public String summary(Model model, @RequestParam Map<String, String> params){
        int groupId = Integer.parseInt(params.get("groupId"));
        
        model.addAttribute("countMember", this.statsService.countMember(this.groupService.getGroupById(groupId)));
        model.addAttribute("totalMoneyGroup", this.statsService.totalMoneyGroup(this.groupService.getGroupById(groupId)));
//        model.addAttribute("totalMoneyUserIncomeGroup", this.statsService.totalMoneyUserIncomeGroup(this.userService.getUserById(3), this.groupService.getGroupById(groupId)));
        model.addAttribute("userInGroup", this.belongService.getUserInGroup(this.groupService.getGroupById(groupId)));
        model.addAttribute("moneyUserPaid", this.statsService.moneyUserPaid(this.groupService.getGroupById(groupId)));
        model.addAttribute("moneyUserPay", this.statsService.moneyUserPay(this.groupService.getGroupById(groupId)));
        return "summary";
    }
}
