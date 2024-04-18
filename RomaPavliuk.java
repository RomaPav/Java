package os;
import robocode.*;
import static robocode.util.Utils.normalRelativeAngleDegrees;

//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * RomaPavliuk - a robot by (your name here)
 */
public class RomaPavliuk extends Robot
{
	private double turnGun;
	public void run() {
		while(true) {
			turnGunRight(360);	
		}
	}
	public void onScannedRobot(ScannedRobotEvent e) {
		turnGun = normalRelativeAngleDegrees(e.getBearing() + getHeading() - getGunHeading());
		turnGunRight(turnGun);
		fire(3);
	}
	 public void onHitByBullet(HitByBulletEvent e) {
      if(e.getBearing()<=-80 && e.getBearing()>=-100){
        ahead(100);
      }else if(e.getBearing()>=80 && e.getBearing()<=100){
        ahead(100);
      }else{
          turnRight(normalRelativeAngleDegrees(e.getBearing() + 90 - getHeading()));
        ahead(100);
      }
  	}
	
	public void onHitRobot(HitRobotEvent e) {
		turnGun = normalRelativeAngleDegrees(e.getBearing() + getHeading() - getRadarHeading());
        turnGunRight(turnGun);
        fire(3);
  		turnRight(normalRelativeAngleDegrees(e.getBearing() + 90 - getHeading()));
  		ahead(100);
        
		
    }
	public void onHitWall(HitWallEvent e) {
		if(e.getBearing()>=0){
      		turnLeft(e.getBearing()+100);
			ahead(100);
	    }else{
	      	turnRight(e.getBearing()-100);
	      	ahead(100);
	    }
	}
	
}
