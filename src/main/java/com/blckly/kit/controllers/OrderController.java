package com.blckly.kit.controllers;

import com.blckly.kit.orders.Order;
import com.blckly.kit.orders.OrderStatus;
import com.blckly.kit.parts.BodyKit;
import com.blckly.kit.parts.Color;
import com.blckly.kit.parts.Engine;
import com.blckly.kit.parts.Finish;
import com.blckly.kit.orders.Kit;
import com.blckly.kit.parts.PowerSource;
import com.blckly.kit.parts.Wheel;
import com.blckly.kit.utils.Inventory;
import java.util.LinkedList;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

  final private Inventory inventory = Inventory.INVENTORY;

  final private Logger logger = LogManager.getLogger(OrderController.class);

  // get parts in inventory by part

  /**
   *
   * @return json of available body kits
   */
  @GetMapping("/bodykits")
  public LinkedList<BodyKit> getAvailableBodyKits() {
     return inventory.getBodyKits();
  }

  /**
   *
   * @return json of available colors
   */
  @GetMapping("/colors")
  public LinkedList<Color> getAvailableColors() {
    return inventory.getColors();
  }

  /**
   *
   * @return json of available engines
   */
  @GetMapping("/engines")
  public LinkedList<Engine> getAvailableEngines() {
    return inventory.getEngines();
  }

  /**
   *
   * @return json of available finishes
   */
  @GetMapping("/finishes")
  public LinkedList<Finish> getAvailableFinishes() {
    return inventory.getFinishes();
  }

  /**
   *
   * @return json of available power sources
   */
  @GetMapping("/powersources")
  public LinkedList<PowerSource> getAvailablePowerSources() {
    return inventory.getPowerSources();
  }

  /**
   *
   * @return json of available wheels
   */
  @GetMapping("/wheels")
  public LinkedList<Wheel> getAvailableWheels() {
    return inventory.getWheels();
  }

  /**
   *
   * @param order order information
   * @return json of kit's various parts availability
   */
  @PostMapping("orderkit")
  public OrderStatus orderKitTwo(@RequestBody Order order) {
    OrderStatus orderStatus = new OrderStatus();
    // use the address to determine uniqueness and if not unique then return with
    // order status of NOT_UNIQ.
    // RestTemplate geoLocationService = new RestTemplate();
    // Using elastic search endpoint just for testing.
    // GeoDistance geoDistance = geoLocationService.getForObject("http://localhost:9200/?pretty", GeoDistance.class);
    // logger.info(geoDistance.toString());

    // remove each order piece from inventory and if back ordered then set status as such.
    Kit kit = order.getKit();
    // place order / remove from inventory
    if(inventory.removeBodyKit(kit.getBodyKit()) < 0 ) {
      orderStatus.setStatus(OrderStatus.ORDER_BACKORDERED);  // set the msg with bodykit on backorder (same for other pieces)
      logger.info("Backorder for " + BodyKit.class.getName());
    }
    if(inventory.removeColor(kit.getColor()) < 0 ) {
      orderStatus.setStatus(OrderStatus.ORDER_BACKORDERED);
      logger.info("Backorder for " + Color.class.getName());
    }
    if(inventory.removeEngine(kit.getEngine()) < 0 ) {
      orderStatus.setStatus(OrderStatus.ORDER_BACKORDERED);
      logger.info("Backorder for " + Engine.class.getName());
    }
    if(inventory.removeFinish(kit.getFinish()) < 0 ) {
      orderStatus.setStatus(OrderStatus.ORDER_BACKORDERED);
      logger.info("Backorder for " + Finish.class.getName());
    }
    if(inventory.removePowerSource(kit.getPowerSource()) < 0 ) {
      orderStatus.setStatus(OrderStatus.ORDER_BACKORDERED);
      logger.info("Backorder for " + PowerSource.class.getName());
    }
    if(inventory.removeWheels(kit.getWheels()) < 0 ) {
      orderStatus.setStatus(OrderStatus.ORDER_BACKORDERED);
      logger.info("Backorder for " + Wheel.class.getName());
    }
    if(orderStatus.getStatus() == 0) {
      orderStatus.setStatus(OrderStatus.ORDER_SUCCESS);
    }

    // never added up the base cost plus the surcharges for the premium parts.

    return orderStatus;
  }
}
