package com.accolite.assignment.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculator {
    @RequestMapping("/Compute")
    public ModelAndView compute(
            @RequestParam(value = "number1", required = true, defaultValue = "0") double number1,
            @RequestParam(value = "number2", required = true, defaultValue = "0") double number2,
            @RequestParam(value = "operation", required = true, defaultValue = "+") char operation
            //@ModelAttribute("number")Numbers number
    ){
        ModelAndView mv = new ModelAndView("answer");
        String message = "";
        double answer = 0;
        switch(operation){
            case '+' : answer = number1+number2;break;
            case '-' : answer = number1-number2;break;
            case '*' : answer = number1*number2;break;
            case '/' : try{
                answer = number1/number2;
            }catch(Exception e){
                message = "Divide by zero error";
            } break;
            default : answer = 0;
        }
/*
        System.out.println("number1  : " + number1);
        System.out.println("number 2 : " + number2);
        System.out.println("answer : " + answer);
*/
System.out.println("message"  + message);
        mv.addObject("answer", answer);
        mv.addObject("message",message);
        return mv;
    }
}