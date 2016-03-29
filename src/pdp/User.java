/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilherme
 */
public class User implements Runnable {
  private final int id;
  private Controller controller;

  public User(int id, Controller controller) {
      this.id = id;
      this.controller = controller;
  }

  public int getId() {
      return id;
  }

  @Override
  public void run() {
    Job newJob = new Job();
    controller.receiveJob(newJob);
  }

}
