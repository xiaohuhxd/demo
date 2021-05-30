package com.Controller;

import com.Entity.poistion;
import com.Service.WebsocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.extern.slf4j.Slf4j;
@Controller
@Slf4j
public class WebsocketController {
    @Autowired
    WebsocketService websocketService;
    @RequestMapping("pushpoistion")
    public void  pushpoistion(@RequestParam double x,@RequestParam double y, @RequestParam double z){
        log.info("调用服务");
        poistion p=new poistion();
        double[] p1=new double[]{x,y,z};
        p.setPoistion(p1);
        websocketService.sendInfo(p);
        log.info("调用服务结束");

    }

}
