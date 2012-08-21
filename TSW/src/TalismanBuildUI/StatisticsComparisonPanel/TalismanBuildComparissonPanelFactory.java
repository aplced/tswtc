package TalismanBuildUI.StatisticsComparisonPanel;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import TalismanBuildUI.TalismanBuildUIContainer;


public class TalismanBuildComparissonPanelFactory
{
	private static JPanel CommonStats(TalismanBuildUIContainer talCb)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(7, 2));

		panel.add(new JLabel("--Common stats--"));
		panel.add(new JLabel());

		panel.add(new JLabel("Health:"));
		panel.add(talCb.compHealth);
		panel.add(new JLabel("Weapon power:"));
		panel.add(talCb.compWeaponPower);
		panel.add(new JLabel("Crit rating"));
		panel.add(talCb.compCritRating);
		panel.add(new JLabel("Crit chance:"));
		panel.add(new JLabel("Crit chance placeholder"));
		panel.add(new JLabel("Crit power rating"));
		panel.add(talCb.compCritPower);
		panel.add(new JLabel("Crit power:"));
		panel.add(new JLabel("Crit power placeholder"));

		return panel;
	}

	private static JPanel OffensiveStats(TalismanBuildUIContainer talCb)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6, 2));

		panel.add(new JLabel("--Offensive stats--"));
		panel.add(new JLabel());

		panel.add(new JLabel("Combat power:"));
		panel.add(new JLabel("Combat power placeholder"));
		panel.add(new JLabel("Attack rating:"));
		panel.add(talCb.compAttackRating);
		panel.add(new JLabel("Hit rating"));
		panel.add(talCb.compHitRating);
		panel.add(new JLabel("Enemy evade chance:"));
		panel.add(new JLabel("Enemy evade chance placeholder"));
		panel.add(new JLabel("Penetration rating"));
		panel.add(talCb.compPenetrationRating);

		return panel;
	}

	private static JPanel DefensiveStats(TalismanBuildUIContainer talCb)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(8, 2));

		panel.add(new JLabel("--Defensive stats--"));
		panel.add(new JLabel());

		panel.add(new JLabel("Evade rating"));
		panel.add(talCb.compEvadeRating);
		panel.add(new JLabel("Evade chance"));
		panel.add(new JLabel("Evade chance placeholder"));
		panel.add(new JLabel("Physical protection "));
		panel.add(talCb.compPhysicalProtection);
		panel.add(new JLabel("Magical protection"));
		panel.add(talCb.compMagicalProtection);
		panel.add(new JLabel("Defence rating"));
		panel.add(talCb.compDefenceRating);
		panel.add(new JLabel("Enemy crit rating:"));
		panel.add(new JLabel("Enemy crit rating placeholder"));
		panel.add(new JLabel("Block rating"));
		panel.add(talCb.compBlockRating);

		return panel;
	}

	private static JPanel HealingStats(TalismanBuildUIContainer talCb)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));

		panel.add(new JLabel("--Healing stats--"));
		panel.add(new JLabel());

		panel.add(new JLabel("Heal power:"));
		panel.add(new JLabel("Heal power placeholder"));
		panel.add(new JLabel("Heal rating"));
		panel.add(talCb.compHealRating);

		return panel;
	}

	public static JPanel PrepareTalismanComparissonPanel(TalismanBuildUIContainer talCb)
	{
		JPanel buildComparissonPanel = new JPanel();
		buildComparissonPanel.setLayout(new BoxLayout(buildComparissonPanel, BoxLayout.Y_AXIS));

		JPanel common = CommonStats(talCb);
		JPanel offensive = OffensiveStats(talCb);
		JPanel defensive = DefensiveStats(talCb);
		JPanel healing = HealingStats(talCb);

		Insets tmpInst = new Insets(5, 15, 5, 15);

		common.setBorder(new EmptyBorder(tmpInst));
		offensive.setBorder(new EmptyBorder(tmpInst));
		defensive.setBorder(new EmptyBorder(tmpInst));
		healing.setBorder(new EmptyBorder(tmpInst));

		buildComparissonPanel.add(common);
		buildComparissonPanel.add(offensive);
		buildComparissonPanel.add(defensive);
		buildComparissonPanel.add(healing);

		return buildComparissonPanel;
	}

}
