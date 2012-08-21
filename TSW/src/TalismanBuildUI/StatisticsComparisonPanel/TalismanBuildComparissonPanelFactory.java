package TalismanBuildUI.StatisticsComparisonPanel;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import TalismanBuildUI.TalismanBuildUIContainer;


public class TalismanBuildComparissonPanelFactory
{
	public static JPanel PrepareTalismanComparissonPanel(TalismanBuildUIContainer talCb)
	{
		JPanel buildComparissonPanel = new JPanel();
		buildComparissonPanel.setLayout(new GridLayout(13, 2));

		buildComparissonPanel.add(new JLabel("Weapon power:"));
		buildComparissonPanel.add(talCb.compWeaponPower);
		buildComparissonPanel.add(new JLabel("Health:"));
		buildComparissonPanel.add(talCb.compHealth);
		buildComparissonPanel.add(new JLabel("Attack rating:"));
		buildComparissonPanel.add(talCb.compAttackRating);
		buildComparissonPanel.add(new JLabel("Heal rating"));
		buildComparissonPanel.add(talCb.compHealRating);
		buildComparissonPanel.add(new JLabel("Crit rating"));
		buildComparissonPanel.add(talCb.compCritRating);
		buildComparissonPanel.add(new JLabel("Crit power"));
		buildComparissonPanel.add(talCb.compCritPower);
		buildComparissonPanel.add(new JLabel("Penetration rating"));
		buildComparissonPanel.add(talCb.compPenetrationRating);
		buildComparissonPanel.add(new JLabel("Hit rating"));
		buildComparissonPanel.add(talCb.compHitRating);
		buildComparissonPanel.add(new JLabel("Block rating"));
		buildComparissonPanel.add(talCb.compBlockRating);
		buildComparissonPanel.add(new JLabel("Evade rating"));
		buildComparissonPanel.add(talCb.compEvadeRating);
		buildComparissonPanel.add(new JLabel("Defence rating"));
		buildComparissonPanel.add(talCb.compDefenceRating);
		buildComparissonPanel.add(new JLabel("Magical protection"));
		buildComparissonPanel.add(talCb.compMagicalProtection);
		buildComparissonPanel.add(new JLabel("Physical protection "));
		buildComparissonPanel.add(talCb.compPhysicalProtection);

		
		return buildComparissonPanel;
	}

}
