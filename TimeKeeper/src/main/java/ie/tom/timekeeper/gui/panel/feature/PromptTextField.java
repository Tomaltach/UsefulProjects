package ie.tom.timekeeper.gui.panel.feature;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PromptTextField extends JTextField {

	public PromptTextField(final String promptText) {
    	super(promptText);
        addFocusListener(new FocusListener() {
        	@Override
            public void focusLost(FocusEvent e) {
            	if(getText().isEmpty()) {
                	setText(promptText);
                }
            }
            @Override
            public void focusGained(FocusEvent e) {
            	if(getText().equals(promptText)) {
                	setText("");
                }
            }
        });
    }
}