/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdp;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcelo
 */
public class Controller {

	private ArrayList<Job> jobs;
  private Printer mainPrinter;
  private static int USIZE;
	private static int PSIZE;

  public Controller(Printer mainPrinter, int USIZE, int PSIZE) {
      this.mainPrinter = mainPrinter;
      this.USIZE = USIZE;
      this.PSIZE = PSIZE;
      this.jobs = new ArrayList<Job>();
  }

	public synchronized void receiveJob(Job newJob) {
		if(jobs.size() < PSIZE) {
			jobs.add(newJob);
      System.out.println("Added job to packet.");
		}
		if(jobs.size() == PSIZE) {
      System.out.println("Sending packet.");
			mainPrinter.printPacket(this, jobs);
			jobs.clear();
		}
	}
}
