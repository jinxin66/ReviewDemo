package com.example.demo.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController
public class RedissionController {

//    @Autowired
//    private  Rdission rdission;
//    @Autowired
//    private  StringRedisTemplate stringRedisTemplate;

    @RequestMapping("deductStock")
    public String deductStock(){
        String lockKey = "productYd";
        try{
            //判断是否存在否就添加，并且定时
            //Boolean islock = stringRedisTemplate
            //if(!islock)
            //    return "服务器繁忙请等待";

            //判断库存操作代码段
//            int 库存 = stringRedisTemplate获取库存
//            if(0){
//                int 新库存 = 库存 - 1;
//                stringRedisTemplate 回填库存；
//                System.out.println("输出日志");
//            }else {
//                System.out.println("输出库存不足日志");
//            }
        }finally {
            //解锁
//            stringRedisTemplate
        }
        return "end";
    }
}
