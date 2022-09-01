/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.controllers;

import com.ducnd.pojo.Income;
import com.ducnd.pojo.User;
import com.ducnd.pojo.Warning;
import com.ducnd.service.IncomeService;
import com.ducnd.service.StatsService;
import com.ducnd.service.WarningService;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class IncomeController {

    @Autowired
    private IncomeService incomeService;
    @Autowired
    private StatsService statsService;
    @Autowired
    private WarningService warningService;

    @GetMapping("/add-income")
    public String addIncome(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/require-login";
        }

        model.addAttribute("inCome", new Income());
//        model.addAttribute("totalIncome", this.statsService.totalIncomeMonth(7, currentUser));
//        model.addAttribute("totalSpending", this.statsService.totalSpendingMonth(8, currentUser));

//            for (int i = 1; i <= 12; i++) {
//                    BigDecimal totalIncome = this.statsService.totalIncomeMonth(i, currentUser);
//                    double totalIncome2 = totalIncome.doubleValue();
//
//                    BigDecimal totalSpending = this.statsService.totalSpendingMonth(i, currentUser);
//                    double totalSpending2 = totalSpending.doubleValue();
//
//                    if (totalIncome2 < totalSpending2) {
//                        String str1 = String.valueOf(i);
//                        String str = String.format("Thu nhap thang %s ", str1);
//
//                        Warning warning = new Warning();
//
//                        warning.setContent(str);
//                        warning.setUserId(currentUser);
//                        this.warningService.addWarning(warning);
//                    }
//                }
        return "addIncome";
    }

    @PostMapping("/add-income")
    public String addIncome(Model model, @ModelAttribute(value = "inCome") @Valid Income inCome, BindingResult result, HttpSession session) {

//        if (!result.hasErrors()) {
//
//            String err = "";
//            User currentUser = (User) session.getAttribute("currentUser");
//
//            if (this.incomeService.addInCome(inCome) == true) {
//
//                return "redirect:/";
//            } else {
//                err = "Them thu nhap that bai!";
//            }
//
//            model.addAttribute("err", err);
//            
//        }
//        return "addIncome";
            String err="";
            if(!result.hasErrors()){
                if(this.incomeService.addInCome(inCome)==true){
                    return "redirect:/";
                }
            }
            err="Sai ding dang date-time. Hay nhap yyyy-MM-dd";
            model.addAttribute("err", err);
            
            return "addIncome";
    }

    @GetMapping("/view-income")
    public String viewIncome(Model model, HttpSession session, @RequestParam Map<String, String> params) throws ParseException {

        User currentUser = (User) session.getAttribute("currentUser");

        if (currentUser == null) {
            return "redirect:/require-login";
        }

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

        model.addAttribute("incomes", this.incomeService.loadIncomes(currentUser.getId(), params, page, pageSize));
//        model.addAttribute("countIncome", this.incomeService.countIncome(currentUser.getId()));

        model.addAttribute("pageSize", pageSize);

        model.addAttribute("countIncome", this.incomeService.countIncome(currentUser));

        model.addAttribute("statsIncome", this.statsService.incomeStatsForDay(currentUser.getId(), fromDate, toDate));

        return "viewIncome";
    }
}
