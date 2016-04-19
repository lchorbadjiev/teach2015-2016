package org.elsys.robocode;

/**
 * Copyright (c) 2001-2016 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://robocode.sourceforge.net/license/epl-v10.html
 */

import robocode.*;
import robocode.util.Utils;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Crazy - a sample robot by Mathew Nelson.
 * <p/>
 * This robot moves around in a crazy pattern.
 *
 * @author Mathew A. Nelson (original)
 * @author Flemming N. Larsen (contributor)
 */
public class CrazyMoving extends AdvancedRobot {
	boolean movingForward;

	/**
	 * run: Crazy's main run function
	 */
	public void run() {
		// Set colors
		setBodyColor(Color.PINK);

		setAdjustGunForRobotTurn(true);
		setAdjustRadarForGunTurn(true);
		setAdjustRadarForRobotTurn(true);

		setTurnRadarLeft(Double.POSITIVE_INFINITY);
		setAhead(Double.POSITIVE_INFINITY);

		// Loop forever
		while (true) {
			if (getGunTurnRemaining() == 0) {
				setFire(1);
			}
			execute();
		}
	}

	/**
	 * onHitWall: Handle collision with wall.
	 */
	public void onHitWall(HitWallEvent e) {
		// Bounce off!
		reverseDirection();
	}

	/**
	 * reverseDirection: Switch from ahead to back & vice versa
	 */
	public void reverseDirection() {
		if (movingForward) {
			setBack(Double.POSITIVE_INFINITY);
			movingForward = false;
		} else {
			setAhead(Double.POSITIVE_INFINITY);
			movingForward = true;
		}
	}

	/**
	 * onScannedRobot: Fire!
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// double absoluteBearing = getHeadingRadians() + e.getBearingRadians();
		// double turnDegrees =
		// robocode.util.Utils.normalRelativeAngle(absoluteBearing -
		// getGunHeadingRadians());
		// setTurnGunRightRadians(turnDegrees);

		double myX = getX();
		double myY = getY();
		double absoluteBearing = getHeadingRadians() + e.getBearingRadians();
		double enemyX = getX() + e.getDistance() * Math.sin(absoluteBearing);
		double enemyY = getY() + e.getDistance() * Math.cos(absoluteBearing);

		double distance = Point2D.Double.distance(myX, myY, enemyX, enemyY);
		System.out.println("distance: " + distance);
		double bulletPower = Math.min(3.0, getEnergy());
		if (distance > 200) {
			bulletPower = Math.min(3.0 / (distance / 200.0), getEnergy());
		}
		if (distance > 200 && !movingForward) {
			reverseDirection();
		} else if (distance < 50 && movingForward) {
			reverseDirection();
		}
		double enemyHeading = e.getHeadingRadians();
		double enemyVelocity = e.getVelocity();

		double deltaTime = 0;
		double battleFieldHeight = getBattleFieldHeight(), battleFieldWidth = getBattleFieldWidth();
		double predictedX = enemyX, predictedY = enemyY;

		double bulletVelocity = 20 - 3 * bulletPower;

		while ((++deltaTime) * bulletVelocity < Point2D.Double.distance(myX, myY, predictedX, predictedY)) {
			predictedX += Math.sin(enemyHeading) * enemyVelocity;
			predictedY += Math.cos(enemyHeading) * enemyVelocity;
			if (predictedX < 18.0 || predictedY < 18.0 || predictedX > battleFieldWidth - 18.0
					|| predictedY > battleFieldHeight - 18.0) {
				predictedX = Math.min(Math.max(18.0, predictedX), battleFieldWidth - 18.0);
				predictedY = Math.min(Math.max(18.0, predictedY), battleFieldHeight - 18.0);
				break;
			}
		}
		double theta = Utils.normalAbsoluteAngle(Math.atan2(predictedX - getX(), predictedY - getY()));

		setTurnRadarRightRadians(Utils.normalRelativeAngle(absoluteBearing - getRadarHeadingRadians()));
		setTurnLeft(Utils.normalRelativeAngle(getHeadingRadians() - getRadarHeadingRadians()));
		setTurnGunRightRadians(Utils.normalRelativeAngle(theta - getGunHeadingRadians()));
		fire(bulletPower);

	}

	/**
	 * onHitRobot: Back up!
	 */
	public void onHitRobot(HitRobotEvent e) {
		// If we're moving the other robot, reverse!
		if (e.isMyFault()) {
			reverseDirection();
		}
	}

	@Override
	public void onRobotDeath(RobotDeathEvent event) {
		setTurnRadarRightRadians(Double.POSITIVE_INFINITY);
	}
	
	
}
