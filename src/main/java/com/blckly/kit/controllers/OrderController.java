package com.blckly.kit.controllers;

import com.blckly.kit.parts.BodyKit;
import com.blckly.kit.parts.Color;
import com.blckly.kit.parts.Engine;
import com.blckly.kit.parts.Finish;
import com.blckly.kit.parts.Kit;
import com.blckly.kit.parts.PowerSource;
import com.blckly.kit.parts.Wheel;
import com.blckly.kit.utils.Inventory;
import java.util.LinkedList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  private Inventory inventory = Inventory.INVENTORY;

  @RequestMapping("/defaultKit")
  public Kit defaultKit(@RequestParam(value="name", defaultValue="AwesomeKit") String name) {
    Kit defaultKit = new Kit(name);
    defaultKit.setBasePrice(Kit.DEFAULTPRICE);
    defaultKit.setBodyKit( new BodyKit(1, "Standard BodyKit", 0.0));
    defaultKit.setColor( new Color("Black"));
    defaultKit.setEngine(new Engine("Rocket"));
    defaultKit.setPowerSource(new PowerSource("3.0V"));
    LinkedList<Wheel> wheels = new LinkedList<>();
    wheels.add(new Wheel("Michelin 10s"));  //uni-cycle kit
    defaultKit.setWheels(wheels);
    defaultKit.setFinish(new Finish("Glitter"));
    inventory.addKit(defaultKit);
    return defaultKit;
  }

  @RequestMapping(path="/kits", method= RequestMethod.GET)
  public LinkedList<Kit> getAvailableKits() {
     return inventory.getKits();
  }

}
