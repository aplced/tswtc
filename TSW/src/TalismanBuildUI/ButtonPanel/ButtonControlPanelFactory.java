package TalismanBuildUI.ButtonPanel;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import TalismanBuildUI.TalismanBuildUIContainer;
import TalismanBuildUI.ButtonPanel.ActionListeners.CreateGlyphBtnListener;
import TalismanBuildUI.ButtonPanel.ActionListeners.CreateTalismanBtnListener;
import TalismanBuildUI.ButtonPanel.ActionListeners.SaveTalismanPoolBtnListener;


public class ButtonControlPanelFactory
{
	public static JPanel PrepareButtonPanel(TalismanBuildUIContainer talCb)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		JButton saveTalismanPool = new JButton("Save talisman pool");
		JButton createNewTalisman = new JButton("New weapon/talisman");
		JButton createNewGlyph = new JButton("New glyph");

		createNewTalisman.addActionListener(new CreateTalismanBtnListener(talCb));
		createNewGlyph.addActionListener(new CreateGlyphBtnListener(talCb));
		saveTalismanPool.addActionListener(new SaveTalismanPoolBtnListener(talCb));

		panel.add(createNewTalisman);
		panel.add(createNewGlyph);
		panel.add(saveTalismanPool);

		panel.setBorder(new EmptyBorder(new Insets(2, 20, 20, 20)));

		return panel;
	}
}
