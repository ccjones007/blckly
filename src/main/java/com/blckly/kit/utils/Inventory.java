package com.blckly.kit.utils;

import com.blckly.kit.parts.BodyKit;
import com.blckly.kit.parts.Color;
import com.blckly.kit.parts.Engine;
import com.blckly.kit.parts.Finish;
import com.blckly.kit.parts.PowerSource;
import com.blckly.kit.parts.Wheel;
import java.util.LinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Inventory {

  public static final Inventory INVENTORY = new Inventory();

  final private Logger logger = LogManager.getLogger(Inventory.class);

  final private LinkedList<BodyKit> bodyKits = new LinkedList<BodyKit>();
  final private LinkedList<Color> colors = new LinkedList<Color>();
  final private LinkedList<Engine> engines = new LinkedList<Engine>();
  final private LinkedList<Finish> finishes = new LinkedList<Finish>();
  final private LinkedList<PowerSource> powerSources = new LinkedList<PowerSource>();
  final private LinkedList<Wheel> wheels = new LinkedList<Wheel>();

  private Inventory() {
    logger.info("initializing Inventory instance");
  }

  // stocking inventory
  public void addBodyKit(BodyKit bodyKit) {
    int index = this.bodyKits.indexOf(bodyKit);
    logger.info("adding body kit to inventory");
    if(index == -1)
      this.bodyKits.add(bodyKit);
    else
      this.bodyKits.get(index).incrementCount(bodyKit.getCount());
  }

  public void addColor(Color color) {
    int index = this.colors.indexOf(color);
    if(index == -1)
      this.colors.add(color);
    else
      this.colors.get(index).incrementCount(color.getCount());
  }

  public void addEngine(Engine engine) {
    int index = this.engines.indexOf(engine);
    if(index == -1)
      this.engines.add(engine);
    else
      this.engines.get(index).incrementCount(engine.getCount());
  }

  public void addFinish(Finish finish) {
    int index = this.finishes.indexOf(finish);
    if(index == -1)
      this.finishes.add(finish);
    else
      this.finishes.get(index).incrementCount(finish.getCount());
  }

  public void addPowerSource(PowerSource powerSource) {
    int index = this.powerSources.indexOf(powerSource);
    if(index == -1)
      this.powerSources.add(powerSource);
    else
      this.powerSources.get(index).incrementCount(powerSource.getCount());
    }

  public void addWheel(Wheel wheel) {
    int index = this.wheels.indexOf(wheel);
    if(index == -1)
      this.wheels.add(wheel);
    else
      this.wheels.get(index).incrementCount(wheel.getCount());
  }

  // grabbing list of available kit parts
  public LinkedList<BodyKit> getBodyKits() { return bodyKits; }

  public LinkedList<Color> getColors() { return colors; }

  public LinkedList<Engine> getEngines() { return engines; }

  public LinkedList<Finish> getFinishes() { return finishes; }

  public LinkedList<PowerSource> getPowerSources() { return powerSources; }

  public LinkedList<Wheel> getWheels() { return wheels; }


  public long removeBodyKit(BodyKit bodyKit) {
    int index = bodyKits.indexOf(bodyKit);
    logger.info("remove bodykit with index " + index);
    if(index >= 0)
      return bodyKits.get(index).decrementCount();
    // here we could throw inventory item not found.
    return -1;
  }

  public long removeColor(Color color) {
    int index = colors.indexOf(color);
    logger.info("remove color with index " + index);
    if(index >= 0)
      return colors.get(index).decrementCount();
    // here we could throw inventory item not found.
    return -1;
  }

  public long removeEngine(Engine engine) {
    int index = engines.indexOf(engine);
    logger.info("remove engine with index " + index);
    if(index >= 0)
      return engines.get(index).decrementCount();
    // here we could throw inventory item not found.
    return -1;
  }

  public long removeFinish(Finish finish) {
    int index = finishes.indexOf(finish);
    logger.info("remove finish with index " + index);
    if(index >= 0)
      return finishes.get(index).decrementCount();
    // here we could throw inventory item not found.
    return -1;
  }

  public long removePowerSource(PowerSource powerSource) {
    int index = powerSources.indexOf(powerSource);
    logger.info("remove powersource with index " + index);
    if(index >= 0)
      return powerSources.get(index).decrementCount();
    // here we could throw inventory item not found.
    return -1;
  }

  public long removeWheel(Wheel wheel) {
    int index = wheels.indexOf(wheel);
    logger.info("remove wheel with index " + index);
    if(index >= 0)
      return wheels.get(index).decrementCount();
    // here we could throw inventory item not found.
    return -1;
  }

  public long removeWheels(LinkedList<Wheel> wheels) {
    long backOrderCount = 1;
    for(Wheel wheel : wheels) {
      if(removeWheel(wheel) < 0)
        backOrderCount = -1;
    }
    return backOrderCount;
  }
}
