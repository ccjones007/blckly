package com.blckly.kit.controllers;

import com.blckly.kit.parts.Kit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {


  @RequestMapping("/defaultKit")
  public Kit defaultKit(@RequestParam(value="name", defaultValue="AwesomeKit") String name) {
    Kit defaultKit = new Kit(name);
    defaultKit.setBasePrice(Kit.DEFAULTPRICE);
    return defaultKit;
  }



}
