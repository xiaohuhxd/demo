package com.Controller;

import com.Entity.HumanPoistion;

import com.Service.PoistionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
public class PoistionController {
    @Autowired
    PoistionService poistionService;
    @ResponseBody
    @RequestMapping("/selectpoistion")
    public HumanPoistion selectpoistion(){
        return  poistionService.selectpoistion();

    }
}
