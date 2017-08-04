package com.blckly.kit.utils;

import com.blckly.kit.parts.BodyKit;
import com.blckly.kit.parts.Color;
import com.blckly.kit.parts.Engine;
import com.blckly.kit.parts.Finish;
import com.blckly.kit.parts.Kit;
import com.blckly.kit.parts.PowerSource;
import com.blckly.kit.parts.Wheel;
import java.util.LinkedList;

public class Inventory {

  public static final Inventory INVENTORY = new Inventory();

  private LinkedList<Kit> kits = new LinkedList<Kit>();
  private LinkedList<BodyKit> bodyKits = new LinkedList<BodyKit>();
  private LinkedList<Color> colors = new LinkedList<Color>();
  private LinkedList<Engine> engines = new LinkedList<Engine>();
  private LinkedList<Finish> finishes = new LinkedList<Finish>();
  private LinkedList<PowerSource> powerSources = new LinkedList<PowerSource>();
  private LinkedList<Wheel> wheels = new LinkedList<Wheel>();

  private Inventory() {
  }

  public void addBodyKit(BodyKit bodyKit) { this.bodyKits.add(bodyKit); }

  public void addColor(Color color) { this.colors.add(color); }

  public void addEngine(Engine engine) { this.engines.add(engine);}

  public void addFinish(Finish finish) { this.finishes.add(finish); }

  public void addPowerSource(PowerSource powerSource) { this.powerSources.add(powerSource); }

  public void addWheel(Wheel wheel) { this.wheels.add(wheel); }

  public void addKit(Kit kit) {
    // add the kit as set
    this.kits.add(kit);

    // do we add the individual kit pieces for use creating custom kits.
    this.bodyKits.add(kit.getBodyKit());
    //this.wheels.add(kit.getWheels());
    this.colors.add(kit.getColor());
    this.engines.add(kit.getEngine());
    this.powerSources.add(kit.getPowerSource());
    this.finishes.add(kit.getFinish());
  }

  public LinkedList<BodyKit> getBodyKits() {
    return bodyKits;
  }
}
