package TalismanBuildUI.ButtonPanel.ActionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import TalismanBuildUI.TalismanBuildUIContainer;

public class CreateGlyphBtnListener implements ActionListener
{
	private TalismanBuildUIContainer talCb;

	public CreateGlyphBtnListener(TalismanBuildUIContainer iTalCb)
	{
		talCb = iTalCb;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		talCb.CreateNewGlyph();
	}

}
