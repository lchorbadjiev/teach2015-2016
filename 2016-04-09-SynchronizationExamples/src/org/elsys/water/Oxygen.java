package org.elsys.water;

public class Oxygen extends Thread {

	private final WaterConstructor constructor;

	private final int oxygenId;

	public Oxygen(int id, WaterConstructor constructor) {
		this.oxygenId = id;
		this.constructor = constructor;
	}

	@Override
	public void run() {
		System.out.println(this + " created");
		try {
			constructor.proceedOxygen(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Water molecule created with " + this);
	}

	public String toString() {
		return "Oxygen-" + oxygenId;
	}

	public void bond() {
		System.out.println(this + " bonded");
	}
}
