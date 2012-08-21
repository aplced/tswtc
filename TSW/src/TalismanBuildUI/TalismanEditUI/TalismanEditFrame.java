package TalismanBuildUI.TalismanEditUI;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TSWTalismans.Glyph;
import TSWTalismans.TalismanSlot;
import TalismanBuildUI.TalismanBuildUIContainer;
import TalismanBuildUI.TalismanEditUI.ActionListeners.CreateTalismanDoneListener;

public class TalismanEditFrame extends JFrame
{
	private JComboBox typeJCbx = new JComboBox();
	private JTextField nameJTxt = new JTextField(10);
	private JTextField healthJTxt = new JTextField(10);
	private JTextField attackRatingJTxt = new JTextField(10);
	private JTextField weaponPowerJTxt = new JTextField(10);
	private JTextField healRatingJTxt = new JTextField(10);

	private JComboBox glyphSelection = new JComboBox();

	public TalismanEditFrame(String caption, TalismanBuildUIContainer talCb)
	{
		setTitle(caption);
		setLocationRelativeTo(null);

		setContentPane(PrepareTalismanEditPanel(talCb));
		pack();
	}

	private void RefreshGlyphComboBox(TalismanBuildUIContainer talCb)
	{
		glyphSelection.removeAllItems();
		for(Glyph gph : talCb.glyphPool.GetAvailableGlyphs())
		{
			glyphSelection.addItem(gph);
		}
	}

	private JPanel PrepareTalismanEditPanel(TalismanBuildUIContainer talCb)
	{
		JPanel talismanEditPanel = new JPanel();
		talismanEditPanel.setLayout(new GridLayout(12, 2));


		typeJCbx.addItem(TalismanSlot.Head);
		typeJCbx.addItem(TalismanSlot.Finger);
		typeJCbx.addItem(TalismanSlot.Neck);
		typeJCbx.addItem(TalismanSlot.Wrist);
		typeJCbx.addItem(TalismanSlot.Luck);
		typeJCbx.addItem(TalismanSlot.Waist);
		typeJCbx.addItem(TalismanSlot.Occult);
		typeJCbx.addItem(TalismanSlot.Weapon1);
		typeJCbx.addItem(TalismanSlot.Weapon2);

		typeJCbx.setSelectedIndex(0);
		nameJTxt.setText("Talisman");
		healthJTxt.setText("0");
		attackRatingJTxt.setText("0");
		weaponPowerJTxt.setText("0");
		healRatingJTxt.setText("0");

		RefreshGlyphComboBox(talCb);

		talismanEditPanel.add(new JLabel("Type:"));
		talismanEditPanel.add(typeJCbx);
		talismanEditPanel.add(new JLabel("Name:"));
		talismanEditPanel.add(nameJTxt);
		talismanEditPanel.add(new JLabel("Health:"));
		talismanEditPanel.add(healthJTxt);
		talismanEditPanel.add(new JLabel("Attack rating:"));
		talismanEditPanel.add(attackRatingJTxt);
		talismanEditPanel.add(new JLabel("Weapon power:"));
		talismanEditPanel.add(weaponPowerJTxt);
		talismanEditPanel.add(new JLabel("Heal rating:"));
		talismanEditPanel.add(healRatingJTxt);
		talismanEditPanel.add(new JLabel("Glyph:"));
		talismanEditPanel.add(glyphSelection);

		CreateTalismanDoneListener createTalismanDone = new CreateTalismanDoneListener(this, talCb);
		JButton createDone = new JButton("Ok");
		createDone.addActionListener(createTalismanDone);
		JButton createCancel = new JButton("Cancel");
		createCancel.addActionListener(createTalismanDone);

		talismanEditPanel.add(createDone);
		talismanEditPanel.add(createCancel);

		return talismanEditPanel;
	}

	public TalismanSlot GetSlot()
	{
		return (TalismanSlot)typeJCbx.getSelectedItem();
	}

	public String GetName()
	{
		return nameJTxt.getText();
	}

	public int GetHealth()
	{
		return Integer.parseInt(healthJTxt.getText());
	}

	public int GetAttackRating()
	{
		return Integer.parseInt(attackRatingJTxt.getText());
	}
	
	public int GetWeaponPower()
	{
		return Integer.parseInt(weaponPowerJTxt.getText());
	}

	public int GetHealRating()
	{
		return Integer.parseInt(healRatingJTxt.getText());
	}

	public Glyph GetSlottedGlyph()
	{
		return (Glyph)glyphSelection.getSelectedItem();
	}
}
