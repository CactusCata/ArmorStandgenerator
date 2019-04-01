package fr.cactuscata.armorstandgenerator.script;

import fr.cactuscata.armorstandgenerator.box.DataTagsCheckBox;
import fr.cactuscata.armorstandgenerator.enums.DataTags;
import fr.cactuscata.smartapplication.msg.Message;

public class Script {

	public static void start() {
		new DataTagsCheckBox().setVisible(true);
	}

	public static void startSecondStep(DataTagsCheckBox box) {

		ArmorStand armorStand = new ArmorStand(box.getCustomName());
		for (DataTags dataTag : DataTags.values())
			armorStand.addDataTag(dataTag, box.isEnabled(dataTag));

		Message.getMessageInstance().getInput(armorStand.build(), "La commande:");
		box.stop();
	}

}
