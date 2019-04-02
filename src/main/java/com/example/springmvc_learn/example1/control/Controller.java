package com.example.springmvc_learn.example1.control;


import com.example.springmvc_learn.example1.entity.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/api/mvc_learn/example1")

public class Controller {
    @GetMapping("/login")
    public Map getIndex(){
        return Map.of("name","GT");
    }

    @GetMapping("/addresses")
    public List getAddresses(){
        Address address1=new Address(1,"301");
        Address address2=new Address(2,"402");
        return List.of(address1,address2);
    }

    @PostMapping("/addresses")
    public Map postLogin(@RequestBody Address address){
        log.debug("{}",address.getDetail());
        address.setInsertTime(LocalDateTime.now());
        return Map.of("address", address);
    }

    @GetMapping("/news/{nid}")
    public Map getNews(@PathVariable int nid){
        log.debug("{}", nid);
        return Map.of("nid",nid);
    }

    //模拟GitHub标准地址参数
    @GetMapping("repos/{owner}/{issue}")
    public void getComments(@PathVariable String owner,
                            @PathVariable String issue){
        log.debug("owner:{};issue:{}", owner,issue);
    }

    @GetMapping("addresses/{aid}")
    public Map getAddresses(@PathVariable int aid){
        return Map.of("address", new Address(aid,"302"));
    }

    @PatchMapping("/addresses")
    public Map patchAddresses(@RequestBody Address address){
        log.debug("userID:{}", address.getUser().getId());
        return Map.of("address", address);
    }

}
