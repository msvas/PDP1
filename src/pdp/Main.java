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
public class Main {

	//private final Semaphore livre = new Semaphore(1, true);
	private ArrayList<Job> jobs;
	private final static int USIZE = 20;
	private final static int PSIZE = 10;

	public static void main(String[] args) {
		Printer mainPrinter = new Printer();
		Controller mainCtrl = new Controller(mainPrinter, USIZE, PSIZE);
		startUsers(mainCtrl);
  }

	public static void startUsers(Controller controller) {
		// Declara os users
		User[] users = new User[USIZE];
		Thread[] threads = new Thread[USIZE];
		for (int i = 0; i < USIZE; i++) {
			users[i] = new User(i, controller);
			threads[i] = new Thread(users[i]);
			threads[i].start();
		}
	}

}
