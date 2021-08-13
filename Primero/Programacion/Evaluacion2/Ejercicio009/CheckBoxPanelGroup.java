package Ejercicio009;

import java.awt.CheckboxGroup;

public class CheckBoxPanelGroup extends CheckBoxPanel {

	public CheckBoxPanelGroup(String[] opciones, String pregunta) {
		super(opciones, pregunta);

		CheckboxGroup grupo = new CheckboxGroup();

		for (int i = 0; i < checkboxes.length; i++) {
			checkboxes[i].setCheckboxGroup(grupo);
		}
	}
}
