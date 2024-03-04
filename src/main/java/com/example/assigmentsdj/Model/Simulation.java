package com.example.assigmentsdj.Model;

public class Simulation implements Runnable
{
  private final Model model;
  public Simulation(Model model)
  {
    this.model  =model;
  }

  @Override public void run()
  {
    try {
      Person bob = new Person("Bob");
      Person wendy = new Person("Wendy");

        model.reserve(model.getVinyl(1),bob);
        Thread.sleep(2000);
        model.borrow(model.getVinyl(1),bob);
        Thread.sleep(2000);
        model.reserve(model.getVinyl(1),wendy);
        Thread.sleep(2000);
        model.returnIt(model.getVinyl(1),bob);
        Thread.sleep(2000);
        model.borrow(model.getVinyl(1),wendy);
        Thread.sleep(2000);
        model.reserve(model.getVinyl(4),bob);
        Thread.sleep(2000);
        model.returnIt(model.getVinyl(1),wendy);
        Thread.sleep(2000);
        model.remove(model.getVinyl(4));
        Thread.sleep(2000);
        model.borrow(model.getVinyl(4),bob);
        model.returnIt(model.getVinyl(4),bob);

        

    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
