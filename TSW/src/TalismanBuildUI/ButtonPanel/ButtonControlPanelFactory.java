package TalismanBuildUI.ButtonPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import TalismanBuildUI.TalismanBuildUIContainer;
import TalismanBuildUI.ButtonPanel.ActionListeners.CreateGlyphBtnListener;
import TalismanBuildUI.ButtonPanel.ActionListeners.CreateTalismanBtnListener;
import TalismanBuildUI.ButtonPanel.ActionListeners.SaveTalismanPoolBtnListener;


public class ButtonControlPanelFactory
{
	public static JPanel PrepareButtonPanel(TalismanBuildUIContainer talCb)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		JButton saveTalismanPool = new JButton("Save talisman pool");
		JButton createNewTalisman = new JButton("New weapon/talisman");
		JButton createNewGlyph = new JButton("New glyph");

		createNewTalisman.addActionListener(new CreateTalismanBtnListener(talCb));
		createNewGlyph.addActionListener(new CreateGlyphBtnListener(talCb));
		saveTalismanPool.addActionListener(new SaveTalismanPoolBtnListener(talCb));

		panel.add(createNewTalisman);
		panel.add(createNewGlyph);
		panel.add(saveTalismanPool);

		return panel;
	}
}
