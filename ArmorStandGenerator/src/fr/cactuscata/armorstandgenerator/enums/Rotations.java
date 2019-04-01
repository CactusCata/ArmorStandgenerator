package fr.cactuscata.armorstandgenerator.enums;

import fr.cactuscata.smartapplication.helper.MathHelper;

public enum Rotations {

	HEAD("Head", -35, 35, -60, 60),
	LEFT_LEG("LeftLeg", -60, 60, -30, 30),
	RIGHT_LEG("RightLeg", Rotations.LEFT_LEG),
	LEFT_ARM("LeftArm", -145, 30, -80, 45),
	RIGHT_ARM("RightArm", Rotations.LEFT_ARM);

	private final String rotation;
	private final int min1, max1, min2, max2;

	private Rotations(String rotationName, int min1, int max1, int min2, int max2) {
		this.rotation = rotationName + ":[%df,%df,0.0f],";
		this.min1 = min1;
		this.max1 = max1;
		this.min2 = min2;
		this.max2 = max2;
	}

	private Rotations(String rotationName, Rotations rotation) {
		this(rotationName, rotation.min1, rotation.max1, rotation.min2, rotation.max2);
	}

	public String getRotationText() {
		return String.format(this.rotation, MathHelper.random(min1, max1),
				MathHelper.random(min2, max2));
	}

}
