package org.elsys.robocode;

import java.awt.Color;

import robocode.AdvancedRobot;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;
import robocode.util.Utils;

public class Tuesday extends AdvancedRobot {

	private boolean movingForward = true;

	public Tuesday() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		setBodyColor(Color.PINK);
		setAhead(Double.POSITIVE_INFINITY);

		setAdjustRadarForRobotTurn(true);
		setAdjustGunForRobotTurn(true);

		setTurnRadarRight(Double.POSITIVE_INFINITY);

		while (true) {
			if(getGunTurnRemainingRadians() == 0) {
				fire(1);
			}
			execute();
		}

	}

	private void reverseDirection() {
		if (movingForward) {
			movingForward = false;
			setBack(Double.POSITIVE_INFINITY);
		} else {
			movingForward = true;
			setAhead(Double.POSITIVE_INFINITY);
		}
	}

	@Override
	public void onHitWall(HitWallEvent e) {
		reverseDirection();
	}
	
	@Override
	public void onHitRobot(HitRobotEvent e) {
		reverseDirection();
	}

	@Override
	public void onScannedRobot(ScannedRobotEvent e) {
		double absoluteBearing = 
			getHeadingRadians() + e.getBearingRadians();
		double radians = Utils.normalRelativeAngle(
				absoluteBearing - 
		        getGunHeadingRadians());
		setTurnGunRightRadians(radians);	
		setTurnRightRadians(radians);
	}
}
