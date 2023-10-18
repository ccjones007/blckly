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

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InventoryController {

  final private Inventory inventory = Inventory.INVENTORY;

  /**
   *
   * @param bodyKits json of body kits to add to inventory
   * @return json of order status for body kits
   */
  @PostMapping("/inv/bodykits")
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
   * @param colors json of colors to add to inventory
   * @return json of order status for colors
   */
  @PostMapping("/inv/colors")
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
   * @param engines json of engines to add to inventory
   * @return json of order status for engines
   */
  @PostMapping("/inv/engines")
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
   * @param finishes json of finishes to add to inventory
   * @return json of order status for finishes
   */
  @PostMapping("/inv/finishes")
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
   * @param powerSources json of power sources to add to inventory
   * @return json of order status for power sources
   */
  @PostMapping("/inv/powersources")
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
   * @param wheels json of wheels to add to inventory
   * @return json of order status for wheels
   */
  @PostMapping("/inv/wheels")
  public InventoryStatus addWheels(@RequestBody LinkedList<Wheel> wheels) {
    int count_added = 0;
    for( Wheel w : wheels) {
      this.inventory.addWheel(w);
      count_added++;
    }
    return new InventoryStatus(InventoryStatus.SUCCESS, InventoryStatus.ITEM_ADDED, count_added);
  }
}
