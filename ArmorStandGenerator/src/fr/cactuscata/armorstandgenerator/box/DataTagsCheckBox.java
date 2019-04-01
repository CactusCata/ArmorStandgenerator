package fr.cactuscata.armorstandgenerator.box;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;

import fr.cactuscata.armorstandgenerator.enums.DataTags;
import fr.cactuscata.armorstandgenerator.script.Script;
import fr.cactuscata.smartapplication.api.Settings;

public final class DataTagsCheckBox extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private final JToggleButton[] buttons = new JToggleButton[9];
	private final TextArea textArea = new TextArea("Nom de l'armorstand", 1, 55);

	public DataTagsCheckBox() {
		super.pack();
		super.setLocationRelativeTo(null);
		super.setTitle(String.format("%s - Choisissez les datatags:", Settings.getInstance().getApplicationName()));
		super.setSize(500, 200);
		super.setResizable(false);
		super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container container = super.getContentPane();
		container.add(this.textArea);
		container.setLayout(new FlowLayout());
		for (int i = 0, maxSize = this.buttons.length; i < maxSize; i++) {
			DataTags tag = DataTags.values()[i];
			this.buttons[i] = new JToggleButton(tag.getName(), tag.isDefaultValue());
			container.add(this.buttons[i]);
		}
		JButton button = new JButton("OK");
		container.add(button);
		button.addActionListener(this);
	}

	public final String getCustomName() {
		return this.textArea.getText();
	}

	public final boolean isEnabled(DataTags dataTag) {
		for (JToggleButton button : this.buttons)
			if (button.getText().equals(dataTag.getName()))
				return button.isEnabled();
		return false;
	}

	public final void stop() {
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		super.setVisible(false);
		Script.startSecondStep(this);
	}

}
