package org.elsys.robocode;

import java.awt.Color;

import robocode.Robot;
import robocode.ScannedRobotEvent;

public class MyRobot extends Robot {

	public MyRobot() {
	}

	
	@Override
	public void run() {
		setBodyColor(Color.PINK);
		while(true) {
			ahead(100);
			turnGunRight(360);
			back(100);
			turnGunLeft(360);
		}
	}
	


	@Override
	public void onScannedRobot(ScannedRobotEvent e) {
		System.out.println("scanned robot event: " + e);
		if(e.getDistance()> 50) {
			fire(.5);
		} else {
			fire(3);
		}
	}
}
