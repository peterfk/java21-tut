/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.java21.tut;

import java.util.Random;

/**
 *
 * @author peterkipping
 */
public class Java21Tut {

	public static void main(String[] args) {
		System.out.println("Hello World!");

		boolean vThreads = true;
		System.out.println("Using vThreads: " + vThreads);

		long start = System.currentTimeMillis();

		Random random = new Random();
		Runnable runnable = () -> {
			double i = random.nextDouble(1000) % random.nextDouble(1000);
		};
		for (int i = 0; i < 50000; i++) {
			if (vThreads) {
				Thread.startVirtualThread(runnable);
			} else {
				Thread t = new Thread(runnable);
				t.start();
			}
		}

		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("Run time: " + timeElapsed);
	}
}
