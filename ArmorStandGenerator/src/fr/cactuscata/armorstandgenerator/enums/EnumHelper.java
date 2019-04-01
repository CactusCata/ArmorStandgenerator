package fr.cactuscata.armorstandgenerator.enums;

import fr.cactuscata.armorstandgenerator.utils.GettableByName;
import fr.cactuscata.smartapplication.helper.StringUtils;
import fr.cactuscata.smartapplication.msg.Message;

public class EnumHelper {

	public static <T extends Enum<? extends GettableByName>> String getByName(Class<T> clazz) {
		String commandName = Message.getMessageInstance().getInput("Veuillez choisir une commande parmis: [%s]",
				StringUtils.join(clazz.getEnumConstants(), ", "));
		for (T enumeration : clazz.getEnumConstants()) {
			String name = ((GettableByName) enumeration).getName();
			if (name.equals(commandName)) {
				return name;
			}

		}
		return getByName(clazz);
	}

	@SafeVarargs
	public static <T extends GettableByName> String getByName(T... gettablesByNames) {
		String commandName = Message.getMessageInstance().getInput("Veuillez choisir une commande parmis: [%s]",
				StringUtils.join(gettablesByNames, ", "));
		for (T enumeration : gettablesByNames) {
			String name = enumeration.getName();
			if (name.equals(commandName)) {
				return name;
			}

		}
		return getByName(gettablesByNames);
	}

}
