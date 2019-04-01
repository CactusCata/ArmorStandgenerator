package fr.cactuscata.armorstandgenerator.script;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.cactuscata.armorstandgenerator.enums.DataTags;
import fr.cactuscata.smartapplication.msg.Message;

public class ArmorStand {

	private final double x = Message.getMessageInstance().getInteger("Veuillez choisir l'x:"),
			y = Message.getMessageInstance().getInteger("Veuillez choisir l'y:"),
			z = Message.getMessageInstance().getInteger("Veuillez choisir l'z:"),
			rot = Message.getMessageInstance().getInteger("Veuillez choisir la rotation:");
	private final String customName;
	private final Map<DataTags, Boolean> dataTags = new HashMap<>();

	public ArmorStand(String customName) {
		this.customName = customName;
	}

	public final void addDataTag(DataTags tag, boolean value) {
		this.dataTags.put(tag, value);
	}

	public final String build() {
		return String.format("/summon ArmorStand %f %f %f {Rotation:[%ff],CustomName:%s, %s}", this.x, this.y, this.z,
				this.rot, this.customName, this.convertMapToString());
	}

	private final String convertMapToString() {
		GsonBuilder builder = new GsonBuilder();
		// StringBuilder builder = new StringBuilder();
		Gson gson = builder.create();
		return gson.toJson(this.dataTags);
		// this.dataTags.entrySet().forEach(entry ->
		// builder.append(String.format("%s:%d,", entry.getKey(), entry.getValue() ? 1 :
		// 0)));
		// this.dataTags.entrySet().forEach(System.out::println);
		// return builder.toString();
	}

}
