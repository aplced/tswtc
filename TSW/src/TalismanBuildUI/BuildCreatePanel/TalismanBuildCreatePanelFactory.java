package TalismanBuildUI.BuildCreatePanel;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import TalismanBuildUI.TalismanBuildUIContainer;
import TalismanBuildUI.BuildCreatePanel.ActionListeners.CommitBuildBtnListener;


public class TalismanBuildCreatePanelFactory
{
	private static JPanel PreparePanelOfTalismanType(JComboBox[] comboBoxes)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		if(comboBoxes != null)
		{
			for(JComboBox box : comboBoxes)
			{
				panel.add(box);
			}
		}

		return panel;
	}

	private static JPanel PrepareCaptionPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		panel.add(new JLabel("Current talisman selection"));

		return panel;
	}

	private static JPanel PrepareCommitBuildPanel(TalismanBuildUIContainer talCb)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		JButton commitBuild = new JButton("Commit build");
		commitBuild.addActionListener(new CommitBuildBtnListener(talCb));
		panel.add(commitBuild);

		return panel;
	}

	private static JPanel PrepareBuildNamePanel(TalismanBuildUIContainer talCb)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		panel.add(talCb.talismanBuildName);

		return panel;
	}

	public static JPanel PrepareTalismanBuildPanel(TalismanBuildUIContainer talCb)
	{
		JPanel allTalismanView = new JPanel();
		allTalismanView.setLayout(new BoxLayout(allTalismanView, BoxLayout.PAGE_AXIS));

		allTalismanView.add(PrepareCaptionPanel());
		allTalismanView.add(PreparePanelOfTalismanType(talCb.headSelection));
		allTalismanView.add(PreparePanelOfTalismanType(talCb.majorSelection));
		allTalismanView.add(PreparePanelOfTalismanType(talCb.minorSelection));
		allTalismanView.add(PreparePanelOfTalismanType(talCb.weaponSelection));
		allTalismanView.add(PrepareBuildNamePanel(talCb));
		allTalismanView.add(PrepareCommitBuildPanel(talCb));

		return allTalismanView;
	}

}
