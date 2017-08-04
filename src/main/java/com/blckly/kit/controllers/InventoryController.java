package com.blckly.kit.controllers;

import com.blckly.kit.parts.BodyKit;
import com.blckly.kit.parts.Kit;
import com.blckly.kit.utils.Inventory;
import com.blckly.kit.utils.InventoryStatus;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

  private Inventory inventory = Inventory.INVENTORY;


  private final AtomicInteger bodyKitCounter = new AtomicInteger();
  //private LinkedList<BodyKit> bodyKits = new LinkedList<BodyKit>();


  public InventoryStatus addKit() {
    return new InventoryStatus(InventoryStatus.FAILURE, InventoryStatus.ERROR_CODE_GEN_FAILURE);
  }


  @RequestMapping(path="/inv/bodykit", method= RequestMethod.POST)
  public InventoryStatus addBodyKit(@RequestParam(value="name", defaultValue="BodyKit_1") String name) {
    BodyKit bodyKit = new BodyKit(bodyKitCounter.incrementAndGet(), name);
    inventory.addBodyKit(bodyKit);
    return new InventoryStatus("success", bodyKit.getId());
  }

  @RequestMapping(path="/inv/bodykits", method=RequestMethod.POST)
  public InventoryStatus addBodyKits(@RequestBody LinkedList<BodyKit> bodyKits) {
    int count_added = 0;
    for( BodyKit bk : bodyKits) {
      this.inventory.addBodyKit(bk);
      count_added++;
    }
    return new InventoryStatus(InventoryStatus.SUCCESS, InventoryStatus.ITEM_ADDED, count_added);
  }

  @RequestMapping(path="/inv/bodykits", method=RequestMethod.GET)
  public LinkedList<BodyKit> getBodyKits() {
    return inventory.getBodyKits();
  }


  @RequestMapping(path="/inv/bodykit/{name}", method=RequestMethod.GET)
  public BodyKit getBodyByName(@PathVariable String name) {
    for (BodyKit bk : inventory.getBodyKits()) {
      if (bk.getName().equals(name))
        return bk;
    }
    return null;
  }

  @RequestMapping(path="/inv/kits", method=RequestMethod.POST)
  public InventoryStatus addKits(@RequestBody LinkedList<Kit> kits) {
    int count_added = 0;
    for( Kit kit : kits) {
      this.inventory.addKit(kit);
      count_added++;
    }
    return new InventoryStatus(InventoryStatus.SUCCESS, InventoryStatus.ITEM_ADDED, count_added);
  }

}
