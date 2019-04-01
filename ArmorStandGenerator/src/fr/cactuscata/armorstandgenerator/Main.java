package fr.cactuscata.armorstandgenerator;

import fr.cactuscata.armorstandgenerator.script.Script;
import fr.cactuscata.smartapplication.SmartApplicationBox;
import fr.cactuscata.smartapplication.msg.MessageType;

public class Main {

	public static void main(String[] args) {
		new SmartApplicationBox("ArmorStandGenerator", MessageType.BOX);
		Script.start();

	}

}
