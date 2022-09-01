/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.controllers;

import com.ducnd.pojo.User;
import com.ducnd.pojo.Warning;
import com.ducnd.service.GroupService;
import com.ducnd.service.IncomeGroupTempService;
import com.ducnd.service.IncomeService;
import com.ducnd.service.MessageService;
import com.ducnd.service.SpendingService;
import com.ducnd.service.StatsService;
import com.ducnd.service.UserService;
import com.ducnd.service.WarningService;
import java.math.BigDecimal;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DucND
 */
@Controller
@ControllerAdvice
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private StatsService statsService;
    @Autowired
    private WarningService warningService;

    @Autowired
    private IncomeGroupTempService incomeGroupTempService;
    @Autowired
    private IncomeService incomeService;
    @Autowired
    private SpendingService spendingService;
    @Autowired
    private MessageService messageService; 
    @Autowired
    private GroupService groupService; 


    

    @RequestMapping("/")
    public String index(Model model, HttpSession session) {
//        model.addAttribute("users", this.userService.getUsers() );
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser != null) {
            for (int i = 1; i <= 12; i++) {
                BigDecimal totalIncome = this.statsService.totalIncomeMonth(i, currentUser);
                double totalIncome2 = totalIncome.doubleValue();

                BigDecimal totalSpending = this.statsService.totalSpendingMonth(i, currentUser);
                double totalSpending2 = totalSpending.doubleValue();

                if (totalIncome2 * 2.5 < totalSpending2) {
                    String str1 = String.valueOf(i);
                    String str = String.format("Thu nhap thang %s cua ban qua thap so voi chi tieu ", str1);

                    Warning warning = new Warning();

                    warning.setContent(str);
                    warning.setUserId(currentUser);
                    this.warningService.addWarning(warning);
                } else {
                    String str1 = String.valueOf(i);
                    String str = String.format("Thu nhap thang %s cua ban qua thap so voi chi tieu ", str1);
                    this.warningService.deleteWarning(str, currentUser);
                }
            }
        }

        
        
        return "index";
    }
    
    @GetMapping("/chat")
    public String chat(@RequestParam(value = "groupId") int groupId, Model model){
        model.addAttribute("groupId", groupId);
        model.addAttribute("listMessage", this.messageService.loadMessage(this.groupService.getGroupById(groupId)));
        return "chat";
    }
}
