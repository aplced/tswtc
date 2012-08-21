package TalismanBuildUI.ButtonPanel.ActionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import TalismanBuildUI.TalismanBuildUIContainer;


public class SaveTalismanPoolBtnListener implements ActionListener
{
	private TalismanBuildUIContainer talCb;

	public SaveTalismanPoolBtnListener(TalismanBuildUIContainer iTalCb)
	{
		talCb = iTalCb;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		talCb.talismanPool.SaveToFile();
		talCb.glyphPool.SaveToFile();
	}

}
