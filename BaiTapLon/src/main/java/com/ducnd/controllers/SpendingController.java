/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.controllers;

import com.ducnd.pojo.Spending;
import com.ducnd.pojo.User;
import com.ducnd.pojo.Warning;
import com.ducnd.service.SpendingService;
import com.ducnd.service.StatsService;
import com.ducnd.service.WarningService;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DucND
 */
@Controller
@ControllerAdvice
public class SpendingController {

    @Autowired
    private SpendingService spendingService;
    @Autowired
    private StatsService statsService;
    @Autowired
    private WarningService warningService;

    @GetMapping("/add-spending")
    public String addSpending(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        
        if(currentUser == null)
            return "redirect:/require-login";
        model.addAttribute("spending", new Spending());
       


        return "addSpending";
    }

    @PostMapping("/add-spending")
    public String addSpending(Model model, @ModelAttribute(value = "spending") @Valid Spending spending, BindingResult result ,HttpSession session) {
        String err = "";
        User currentUser = (User) session.getAttribute("currentUser");

        if(!result.hasErrors()){
            if(this.spendingService.addSpending(spending)==true)
                return "redirect:/";
        }
        err="Loi dinh dang date-time. Hay nhap yyyy-MM-dd";
        model.addAttribute("err", err);
        return "addSpending";
    }

    @GetMapping("/view-spending")
    public String viewSpending(Model model, @RequestParam Map<String, String> params, HttpSession session) throws ParseException {

        User currentUser = (User) session.getAttribute("currentUser");
        if(currentUser == null)
            return "redirect:/require-login";
        int page = Integer.parseInt(params.getOrDefault("page", "1"));

        int pageSize = Integer.parseInt(params.getOrDefault("pageSize", "2"));

        //Xu ly tim kiem theo ngay thang nam
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

        Date fromDate = null;
        String from = params.getOrDefault("fromDate", null);
        if (from != null && from != "") {
            fromDate = f.parse(from);
//            java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
        }

        Date toDate = null;
        String to = params.getOrDefault("toDate", null);
        if (to != null && to != "") {
            toDate = f.parse(to);
//            java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());
        }

        model.addAttribute("countSpending", this.spendingService.countIncome(currentUser));
        model.addAttribute("spendings", this.spendingService.loadSpendings(currentUser.getId(), params, page, pageSize));
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("statsSpending", this.statsService.spendingStatsForDay(currentUser.getId(), fromDate, toDate));
        
         
        return "viewSpending";
    }
}
