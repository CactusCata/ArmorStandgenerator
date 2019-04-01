package fr.cactuscata.armorstandgenerator.enums;

import fr.cactuscata.armorstandgenerator.utils.GettableByName;

public enum DataTags implements GettableByName {

	NO_GRAVITY("NoGravity", false),
	INVISIBLE("Invisible", false),
	SHOW_ARMS("ShowArms", true),
	SMALL("Small", false),
	NO_BASE_PLATE("NoBasePlate", true),
	INVULNERABLE("Invulnerable", true),
	PERSISTENCE_REDQUIRED("PersistenceRequired", true),
	CUSTOM_NAME_VISIBLE("CustomNameVisible", true),
	DISABLED_SLOTS("DisabledSlots", true);
	
	private final String nameOfDataTag;
	private final boolean defaultValue;
	
	private DataTags(final String nameOfDatatag, final boolean defaultValue) {
		this.nameOfDataTag = nameOfDatatag;
		this.defaultValue = defaultValue;
	}

	@Override
	public final String getName() {	
		return this.nameOfDataTag;
	}
	
	@Override
	public final String toString() {
		return this.getName();
	}

	public boolean isDefaultValue() {
		return this.defaultValue;
	}

}
