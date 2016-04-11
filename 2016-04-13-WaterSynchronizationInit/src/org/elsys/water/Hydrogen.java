package org.elsys.water;

public class Hydrogen extends Thread {

	private final WaterConstructor constructor;

	private final int hydrogenId;

	public Hydrogen(int id, WaterConstructor constructor) {
		this.hydrogenId = id;
		this.constructor = constructor;
	}

	@Override
	public void run() {
		System.out.println(this + " created");
		try {
			constructor.proceedHydrogen(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Water molecule created with " + this);
	}

	public String toString() {
		return "Hydrogen-" + hydrogenId;
	}

	public void bond() {
		System.out.println(this + " bonded");
	}
}
