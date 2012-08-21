import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import TSWTalismans.GlyphPool;
import TSWTalismans.TalismanPool;
import TalismanBuildUI.TalismanBuildUIContainer;
import TalismanBuildUI.BuildCreatePanel.TalismanBuildCreatePanelFactory;
import TalismanBuildUI.ButtonPanel.ButtonControlPanelFactory;
import TalismanBuildUI.CurrnetBuildPanel.TalismanBuildViewPanelFactory;
import TalismanBuildUI.StatisticsComparisonPanel.TalismanBuildComparissonPanelFactory;

public class MainWindow extends JFrame
{
	public static void main(String[] args)
	{
		MainWindow win = new MainWindow();
		win.setVisible(true);
	}

	public MainWindow()
	{
		super();

		TalismanBuildUIContainer talCb = new TalismanBuildUIContainer(new TalismanPool(), new GlyphPool());

		setTitle("TSW talisman calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel talismanViewPanel = new JPanel();
		talismanViewPanel.setLayout(new GridLayout(2, 2));

		talismanViewPanel.add(TalismanBuildCreatePanelFactory.PrepareTalismanBuildPanel(talCb));
		talismanViewPanel.add(TalismanBuildViewPanelFactory.PrepareTalismanViewPanel(talCb));
		talismanViewPanel.add(TalismanBuildComparissonPanelFactory.PrepareTalismanComparissonPanel(talCb));
		talismanViewPanel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

		JPanel allPanes = new JPanel();
		allPanes.setLayout(new BoxLayout(allPanes, BoxLayout.Y_AXIS));

		allPanes.add(ButtonControlPanelFactory.PrepareButtonPanel(talCb));
		allPanes.add(talismanViewPanel);

		setContentPane(allPanes);
		pack();
	}

}
