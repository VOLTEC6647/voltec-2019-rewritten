/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6647.robot;

import java.util.ArrayList;

import org.usfirst.frc6647.commands.AlignNext;
import org.usfirst.frc6647.commands.GyroAlign;
import org.usfirst.frc6647.commands.Slide;
import org.usfirst.lib6647.oi.Controller;
import org.usfirst.lib6647.oi.Controller.OIAngleButton;
import org.usfirst.lib6647.oi.Controller.OIButton;
import org.usfirst.lib6647.util.Direction;

/**
 * Class for registering driver input.
 */
public class OI {
	public ArrayList<Controller> joysticks;

	private static OI m_instance = null;

	/**
	 * Creates static OI instance.
	 */
	public static void createInstance() {
		m_instance = new OI();
	}

	/**
	 * Gets static OI instance. If there is none, creates one.
	 * 
	 * @return static OI instance
	 */
	public static OI getInstance() {
		if (m_instance == null) {
			createInstance();
		}
		return m_instance;
	}

	/**
	 * Constructor for the class.
	 * 
	 * Add joysticks and button inputs here. See Lambda declarations for examples.
	 */
	public OI() {
		joysticks.add(new Controller(0));

		oiButton.get(1, 7).whileHeld(new Slide(Direction.LEFT));
		oiButton.get(1, 8).whileHeld(new Slide(Direction.RIGHT));
		oiButton.get(1, 14).whileHeld(new GyroAlign());

		oiPOV.get(1, 1, 270).whileHeld(new AlignNext(Direction.LEFT));
		oiPOV.get(1, 1, 90).whileHeld(new AlignNext(Direction.RIGHT));
	}

	/**
	 * Lambda declaration for getting a joystick button.
	 * 
	 * e.g. oiButton.get(1, 7) gets button 7 from joystick 1.
	 */
	OIButton oiButton = (joystick, button) -> joysticks.get(joystick).buttons.get("Button" + button);

	/**
	 * Lambda declaration for getting a joystick axis button at any angle.
	 * 
	 * e.g. oiAxisButton.get(1, 2) gets button for axis 2 from joystick 1.
	 */
	OIButton oiAxisButton = (joystick, axis) -> joysticks.get(joystick).buttons.get("Axis" + axis);

	/**
	 * Lambda declaration for getting a joystick POV button at any angle.
	 * 
	 * e.g. oiPOVButton.get(1, 2) gets button for POV 2 from joystick 1.
	 */
	OIButton oiPOVButton = (joystick, pov) -> joysticks.get(joystick).buttons.get("POV" + pov);

	/**
	 * Lambda declaration for getting a joystick axis button at a specific angle.
	 * (Only angles 0, 90, 180, and 270 exist).
	 * 
	 * e.g. oiAxis.get(1, 2, 90) gets angle 90 button from axis 2 from joystick 1.
	 */
	OIAngleButton oiAxis = (joystick, axis, angle) -> joysticks.get(joystick).buttons.get("Axis" + axis + "_" + angle);

	/**
	 * Lambda declaration for getting a joystick POV button at a specific angle.
	 * (Only angles 0, 45, 90, 135, 180, 225, 270, and 315 exist).
	 * 
	 * e.g. oiPOV.get(1, 2, 45) gets angle 45 button from POV 2 from joystick 1.
	 */
	OIAngleButton oiPOV = (joystick, pov, angle) -> joysticks.get(joystick).buttons.get("POV" + pov + "_" + angle);
}