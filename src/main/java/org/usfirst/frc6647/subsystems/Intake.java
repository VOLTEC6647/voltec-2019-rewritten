package org.usfirst.frc6647.subsystems;

import org.usfirst.lib6647.subsystem.SuperSubsystem;
import org.usfirst.lib6647.subsystem.supercomponents.SuperCompressor;
import org.usfirst.lib6647.subsystem.supercomponents.SuperSolenoid;
import org.usfirst.lib6647.subsystem.supercomponents.SuperVictor;

/**
 * Subsystem for the Intake.
 */
public class Intake extends SuperSubsystem implements SuperCompressor, SuperSolenoid, SuperVictor {
	
	private static Intake m_instance = null;

	/**
	 * Creates static Intake instance.
	 */
	public static void createInstance() {
		m_instance = new Intake();
	}

	/**
	 * Gets static Intake instance. If there is none, creates one.
	 * 
	 * @return static Intake instance
	 */
	public static Intake getInstance() {
		if (m_instance == null)
			createInstance();
		return m_instance;
	}

	/**
	 * Constructor for the subsystem.
	 */
	public Intake() {
		super("intake");

		initCompressors(robotMap, getName());
		initSolenoids(robotMap, getName());
		initVictors(robotMap, getName());
	}

	@Override
	protected void initDefaultCommand() {
	}
}