package TalismanBuildUI.ActionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import TalismanBuildUI.TalismanBuildUIContainer;


public class TalismaSelectionChangedListener implements ActionListener
{
	private TalismanBuildUIContainer talCb;

	public TalismaSelectionChangedListener(TalismanBuildUIContainer iTalCb)
	{
		talCb = iTalCb;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		talCb.UpdateTalismanOnBuild();
	}

}
