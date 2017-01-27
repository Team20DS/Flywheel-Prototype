package org.usfirst.frc.team20.robot;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

public class FlyWheel {
	CANTalon flywheel = new CANTalon(Constants.FLYWHEEL_MOTOR_PORT);
	
	Constants constants;
	public FlyWheel(Constants c){
		constants = c;
		flywheel.configPeakOutputVoltage(0.0f, -12.0f);
	}	
	public void shoot(double speed){
		flywheel.changeControlMode(TalonControlMode.Voltage);
		flywheel.set(-speed);
	}
	public void setF(double f){
		flywheel.setF(f);
	}
	public void shootWithEncoder(Double RPMS,Double p, Double i, Double d, Double f){
		//System.out.println(RPMS);
		flywheel.changeControlMode(TalonControlMode.Speed);
		flywheel.setP(p);
		flywheel.setI(i);
		flywheel.setD(d);
		flywheel.setF(f);
		//flywheel.setP(5.0);
		//flywheel.setI(.00001);
		//flywheel.setD(.00001);
			
//		double cps = RPMS/60*1024;	//cycles per second
		//double cps = RPMS;	//15900
		//System.out.println(cps + "CPS");
		flywheel.set(RPMS);
//f = -0.04
	}
	public void stopFlywheel(){
		flywheel.set(0);
	}
}
