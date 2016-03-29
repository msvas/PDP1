/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdp;

import java.util.ArrayList;

/**
 *
 * @author Marcelo
 */
public class Printer {

  private ArrayList<Job> jobs;

  public Printer() {

  }

  public synchronized void printPacket(Controller controller, ArrayList<Job> packetRcvd) {
    System.out.println("Receiving new packet.");
    this.jobs = packetRcvd;
    for (Job job : packetRcvd) {
      try {
    	   printJob(job);
      }  catch(InterruptedException e) {}
    }
    System.out.println("Packet finished.");
  }

  private void printJob(Job job) throws InterruptedException {
    System.out.println("Printing...");
  	Thread.sleep(5000);
    System.out.println("Printing completed.");
  }

}
