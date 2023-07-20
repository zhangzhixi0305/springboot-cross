package com.example.crossdemo.controller;

import com.example.crossdemo.entity.Result;
import com.example.crossdemo.entity.User;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.*;

/***
 * @Author 徐庶
 * @Slogan 致敬大师，致敬未来的你
 */
@RestController
@RequestMapping("/cors")
public class CorsController {

    @GetMapping("/jsonp/{id}")
    public JSONPObject getUser(@PathVariable Integer id,String callback) {
        User user = new User("xushu","jsonp");
        // xushu(data)
        return new JSONPObject(callback,new Result<>(200, "SUCCESS", user));
    }


    /**
     * 设置允许跨域的域名，*代表所有域名
     */
    @GetMapping("{id}")
    @CrossOrigin("http://localhost:8081")
    public Result<Object> getUser2(@PathVariable Integer id) {
        User user = new User("xushu","@CrossOrigin");
        return  new Result<>(200, "SUCCESS", user);
    }

}
