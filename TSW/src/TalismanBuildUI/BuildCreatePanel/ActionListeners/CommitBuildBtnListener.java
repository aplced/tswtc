package TalismanBuildUI.BuildCreatePanel.ActionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import TalismanBuildUI.TalismanBuildUIContainer;

public class CommitBuildBtnListener implements ActionListener
{
	private TalismanBuildUIContainer talCb;

	public CommitBuildBtnListener(TalismanBuildUIContainer iTalCb)
	{
		talCb = iTalCb;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		talCb.CommitCurrentBuild();
	}

}
