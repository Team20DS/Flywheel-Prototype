package org.usfirst.frc.team20.robot;

import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Constants constants = new Constants();
	GroundCollector collector = new GroundCollector(constants);
	FlyWheel flywheel = new FlyWheel(constants);
	Joystick joy = new Joystick(0);
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendablee
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
	}
	

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		Double RPMS = Double.parseDouble(SmartDashboard.getString("DB/String 0"));
		RPMS = RPMS/60/10*4096;
		Double p = Double.parseDouble(SmartDashboard.getString("DB/String 1"));
		Double i = Double.parseDouble(SmartDashboard.getString("DB/String 2"));
		Double f = Double.parseDouble(SmartDashboard.getString("DB/String 4"));
		Double d = Double.parseDouble(SmartDashboard.getString("DB/String 3"));
		int rpms = (int) Math.round(RPMS);
		if(joy.getRawButton(1)){
			collector.intake(1);
		}
		if(joy.getRawButton(2)){
			collector.stopCollector();
		}
		if(joy.getRawButton(3)){
			flywheel.shootWithEncoder(RPMS, p, i, d,f);
			
		}
		if(joy.getRawButton(4)){
			flywheel.stopFlywheel();
		}
		System.out.print(((int)Math.round(flywheel.flywheel.getSpeed()/4096*10*60))+",");
		//System.out.println("RPMS " +RPMS);
		
	}
	
}

