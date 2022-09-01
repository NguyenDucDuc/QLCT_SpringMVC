/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.controllers;

import com.ducnd.pojo.BelongTo;
import com.ducnd.pojo.Gr;
import com.ducnd.pojo.IncomeGroupTemp;
import com.ducnd.pojo.User;
import com.ducnd.pojo.UserIncomeGroup;
import com.ducnd.repository.BelongRepository;
import com.ducnd.repository.UserRepository;
import com.ducnd.service.BelongService;
import com.ducnd.service.GroupService;
import com.ducnd.service.IncomeGroupTempService;
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
public class GroupController {

    @Autowired
    private GroupService groupService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BelongService belongService;
    @Autowired
    private IncomeGroupTempService incomeGroupTempService;


    @GetMapping("/create-group")
    public String createGroup(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if(currentUser == null)
            return "redirect:/require-login";
        model.addAttribute("group", new Gr());
//        model.addAttribute("groups", this.groupService.getGroups());

        return "createGroup";
    }

    @PostMapping("/create-group")
    public String createGroup(Model model, HttpSession session, @ModelAttribute(value = "group") @Valid Gr group, BindingResult result) {
        User currentUser = (User) session.getAttribute("currentUser");
        
        if(!result.hasErrors()){
            group.setUserId(currentUser);
            if(this.groupService.addGroup(group)==true)
                return "redirect:/";
        }
        
//        group.setUserId(currentUser);
//        if (this.groupService.addGroup(group) == true) {
//            return "redirect:/";
//        }
        return "createGroup";
    }

    @GetMapping("/my-groups")
    public String myGroups(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if(currentUser == null)
            return "redirect:/require-login";
        model.addAttribute("groups", this.groupService.getGroupByUserId(currentUser));
        
        
        model.addAttribute("users", this.userRepository.getAllUsers());
        model.addAttribute("group", this.groupService.getGroupById(2347));
        
        
        return "myGroups";
    }

    @GetMapping("/add-member")
    public String addMember(Model model, @RequestParam(required = false) Map<String, String> params, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if(currentUser == null)
            return "redirect:/require-login";
        model.addAttribute("users", this.userRepository.getAllUsers());
        model.addAttribute("belongTo", new BelongTo());
        int groupId = Integer.parseInt(params.get("groupId"));
        model.addAttribute("group", this.groupService.getGroupById(groupId));
        return "addMember";
    }

    @PostMapping("/add-member")
    public String addMember(Model model, @ModelAttribute(value = "belongTo") BelongTo belongTo, HttpSession session) {
        
        String err="";
        int groupId = belongTo.getGroupId().getId();
        try{
            this.belongService.addBelongTo(belongTo);
            return "redirect:/my-groups";
        }catch(Exception ex){
            err=ex.getMessage();
            model.addAttribute("err", err);
        }
        

        return "myGroups";
    }
    
    @GetMapping("/member-of")
    public String memberOf(Model model, HttpSession session){
         User currentUser = (User) session.getAttribute("currentUser");
         if(currentUser == null)
            return "redirect:/require-login";
        model.addAttribute("groups", this.belongService.getBelongToByUserId(currentUser));
        return "memberOf";
    }
    
    @GetMapping("/add-income-group")
    public String addIncomeGroup(Model model, @RequestParam Map<String, String> params, HttpSession session){
        
        User currentUser = (User) session.getAttribute("currentUser");
        if(currentUser == null)
            return "redirect:/require-login";
//        IncomeGroupTemp test = new IncomeGroupTemp();
//            test.setUserId(10);
//            test.setGroupId(10);
//            test.setMoney(30000.0);
//            this.incomeGroupTempService.addIncomeGroupTemp(test);
        
        int groupId = Integer.parseInt(params.get("groupId"));
        
        model.addAttribute("group", this.groupService.getGroupById(groupId));
        
        model.addAttribute("incomeGroupTemp", new IncomeGroupTemp());
        return "addIncomeGroup";
    }
    
    @PostMapping("/add-income-group")
    public String addIncomeGroup(@ModelAttribute(value = "incomeGroupTemp") @Valid IncomeGroupTemp incomeGroupTemp, BindingResult result ,Model model, HttpSession session, @RequestParam(value = "groupId") int groupId){
        if(!result.hasErrors()){
            User currentUser = (User) session.getAttribute("currentUser");
            incomeGroupTemp.setUserId(currentUser.getId());
            this.incomeGroupTempService.addIncomeGroupTemp(incomeGroupTemp);
            return "redirect:/member-of";
        }
        if(result.hasErrors()){
            return "redirect:/add-income-group/?groupId="+groupId;
        }
//        try{
//            User currentUser = (User) session.getAttribute("currentUser");
//            incomeGroupTemp.setUserId(currentUser.getId());
//            this.incomeGroupTempService.addIncomeGroupTemp(incomeGroupTemp);
//            return "redirect:/member-of";
//        }catch(Exception ex){
//            err = ex.getMessage();
//            model.addAttribute("err", err);
//        }
        return "memberOf";
    }
    
    @GetMapping("/accept-income")
    public String acceptIncome(Model model, @RequestParam Map<String, String> params, HttpSession session){
        User currentUser = (User) session.getAttribute("currentUser");
        if(currentUser == null)
            return "redirect:/require-login";
        int groupId = Integer.parseInt(params.get("groupId"));
        model.addAttribute("groupid", groupId);
        model.addAttribute("incomes", this.incomeGroupTempService.getIncomeGroupTemps(groupId));
        return "acceptIncome";
    }
    @GetMapping("/chat-group")
    public String chatGroup(Model model, HttpSession session){
        User currentUser = (User) session.getAttribute("currentUser");
        model.addAttribute("belong", this.belongService.loadGroups(currentUser));
        model.addAttribute("groups", this.groupService.getGroupByUserId(currentUser));
        return "chatGroup";
    }

}
