package com.blckly.kit.controllers;

import com.blckly.kit.parts.BodyKit;
import com.blckly.kit.parts.Color;
import com.blckly.kit.parts.Engine;
import com.blckly.kit.parts.Finish;
import com.blckly.kit.parts.PowerSource;
import com.blckly.kit.parts.Wheel;
import com.blckly.kit.utils.Inventory;
import com.blckly.kit.utils.InventoryStatus;
import java.util.LinkedList;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

  private Inventory inventory = Inventory.INVENTORY;

  /**
   *
   * @param bodyKits
   * @return
   */
  @RequestMapping(path="/inv/bodykits", method=RequestMethod.POST)
  public InventoryStatus addBodyKits(@RequestBody LinkedList<BodyKit> bodyKits) {
    int count_added = 0;
    for( BodyKit bk : bodyKits) {
      this.inventory.addBodyKit(bk);
      count_added++;
    }
    return new InventoryStatus(InventoryStatus.SUCCESS, InventoryStatus.ITEM_ADDED, count_added);
  }

  /**
   *
   * @param colors
   * @return
   */
  @RequestMapping(path="/inv/colors", method=RequestMethod.POST)
  public InventoryStatus addBodyColors(@RequestBody LinkedList<Color> colors) {
    int count_added = 0;
    for( Color c : colors) {
      this.inventory.addColor(c);
      count_added++;
    }
    return new InventoryStatus(InventoryStatus.SUCCESS, InventoryStatus.ITEM_ADDED, count_added);
  }

  /**
   *
   * @param engines
   * @return
   */
  @RequestMapping(path="/inv/engines", method=RequestMethod.POST)
  public InventoryStatus addEngines(@RequestBody LinkedList<Engine> engines) {
    int count_added = 0;
    for( Engine e : engines) {
      this.inventory.addEngine(e);
      count_added++;
    }
    return new InventoryStatus(InventoryStatus.SUCCESS, InventoryStatus.ITEM_ADDED, count_added);
  }

  /**
   *
   * @param finishes
   * @return
   */
  @RequestMapping(path="/inv/finishes", method=RequestMethod.POST)
  public InventoryStatus addFinishes(@RequestBody LinkedList<Finish> finishes) {
    int count_added = 0;
    for( Finish f : finishes) {
      this.inventory.addFinish(f);
      count_added++;
    }
    return new InventoryStatus(InventoryStatus.SUCCESS, InventoryStatus.ITEM_ADDED, count_added);
  }

  /**
   *
   * @param powerSources
   * @return
   */
  @RequestMapping(path="/inv/powersources", method=RequestMethod.POST)
  public InventoryStatus addPowerSources(@RequestBody LinkedList<PowerSource> powerSources) {
    int count_added = 0;
    for( PowerSource ps : powerSources) {
      this.inventory.addPowerSource(ps);
      count_added++;
    }
    return new InventoryStatus(InventoryStatus.SUCCESS, InventoryStatus.ITEM_ADDED, count_added);
  }

  /**
   *
   * @param wheels
   * @return
   */
  @RequestMapping(path="/inv/wheels", method=RequestMethod.POST)
  public InventoryStatus addWheels(@RequestBody LinkedList<Wheel> wheels) {
    int count_added = 0;
    for( Wheel w : wheels) {
      this.inventory.addWheel(w);
      count_added++;
    }
    return new InventoryStatus(InventoryStatus.SUCCESS, InventoryStatus.ITEM_ADDED, count_added);
  }
}
