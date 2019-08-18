/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6647.commands;

import org.usfirst.frc6647.subsystems.Lift;
import org.usfirst.lib6647.subsystem.hypercomponents.HyperVictor;
import org.usfirst.lib6647.util.MoveDirection;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command for manually moving Lift.
 */
public class MoveLiftManual extends Command {

	private MoveDirection direction;
	private HyperVictor liftMain;
	private String victorName;

	/**
	 * Constructor for the command.
	 * 
	 * @param direction
	 * @param victorName
	 */
	public MoveLiftManual(MoveDirection direction, String victorName) {
		requires(Lift.getInstance());

		this.direction = direction;
		this.victorName = victorName;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		liftMain = Lift.getInstance().getVictor(victorName);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		switch (direction) {
		case UP:
			liftMain.set(0.6);
			break;
		case DOWN:
			liftMain.set(-0.3);
			break;
		default:
			end();
			break;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		liftMain.stopMotor();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
