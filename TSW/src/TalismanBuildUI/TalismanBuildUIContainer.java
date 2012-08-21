package TalismanBuildUI;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import TSWTalismans.GlyphPool;
import TSWTalismans.Talisman;
import TSWTalismans.TalismanBuild;
import TSWTalismans.TalismanBuildXMLS;
import TSWTalismans.TalismanPool;
import TSWTalismans.TalismanSlot;
import TalismanBuildUI.ActionListeners.TalismaSelectionChangedListener;
import TalismanBuildUI.GlpyhEditUI.GlyphEditFrame;
import TalismanBuildUI.TalismanEditUI.TalismanEditFrame;

public class TalismanBuildUIContainer
{
	final int HEAD = 0;
	final int FINGER = 0;
	final int NECK = 1;
	final int WRIST = 2;
	final int LUCK = 0;
	final int WAIST = 1;
	final int OCCULT = 2;
	final int WEAPON1 = 0;
	final int WEAPON2 = 1;

	public TalismanPool talismanPool;
	public GlyphPool glyphPool;
	TalismanBuild crntBuild;
	TalismanBuild committedBuild;

	public JTextField talismanBuildName = new JTextField(10);
	public JLabel committedBuildName = new JLabel();

	public JComboBox[] headSelection = new JComboBox[1];
	public JComboBox[] majorSelection = new JComboBox[3];
	public JComboBox[] minorSelection = new JComboBox[3];
	public JComboBox[] weaponSelection = new JComboBox[2];

	public JLabel[] headDisplay = new JLabel[1];
	public JLabel[] majorDisplay = new JLabel[3];
	public JLabel[] minorDisplay = new JLabel[3];
	public JLabel[] weaponDisplay = new JLabel[2];

	public JLabel compCombatPower = new JLabel();
	public JLabel compHealPower = new JLabel();
	public JLabel compWeaponPower = new JLabel();
	public JLabel compHealth = new JLabel();
	public JLabel compAttackRating = new JLabel();
	public JLabel compHealRating = new JLabel();
	public JLabel compCritRating = new JLabel();
	public JLabel compCritChance = new JLabel();
	public JLabel compCritPower = new JLabel();
	public JLabel compCritPowerMultiplier = new JLabel();
	public JLabel compPenetrationRating = new JLabel();
	public JLabel compHitRating = new JLabel();
	public JLabel compBlockRating = new JLabel();
	public JLabel compEvadeRating = new JLabel();
	public JLabel compEvadeChance = new JLabel();
	public JLabel compDefenceRating = new JLabel();
	public JLabel compMagicalProtection = new JLabel();
	public JLabel compPhysicalProtection = new JLabel();
	public JLabel compEnemyEvadeChance = new JLabel();
	public JLabel compEnemyCritRating = new JLabel();

	public TalismanBuildUIContainer(TalismanPool iTPool, GlyphPool iGPool)
	{
		talismanPool = iTPool;
		glyphPool = iGPool;
		crntBuild = new TalismanBuild();
		LoadCommittedBuildFromFile();

		CreateTalismanSelectionComboBoxes(headSelection, 1);
		CreateTalismanSelectionComboBoxes(majorSelection, 3);
		CreateTalismanSelectionComboBoxes(minorSelection, 3);
		CreateTalismanSelectionComboBoxes(weaponSelection, 2);

		CreateTalismanDisplayLabels(headDisplay, 1);
		CreateTalismanDisplayLabels(majorDisplay, 3);
		CreateTalismanDisplayLabels(minorDisplay, 3);
		CreateTalismanDisplayLabels(weaponDisplay, 2);

		committedBuildName.setText("Generic build");
		talismanBuildName.setText("Generic build");

		RefreshTalismanSlot(TalismanSlot.Head);
		RefreshTalismanSlot(TalismanSlot.Finger);
		RefreshTalismanSlot(TalismanSlot.Neck);
		RefreshTalismanSlot(TalismanSlot.Wrist);
		RefreshTalismanSlot(TalismanSlot.Luck);
		RefreshTalismanSlot(TalismanSlot.Waist);
		RefreshTalismanSlot(TalismanSlot.Occult);
		RefreshTalismanSlot(TalismanSlot.Weapon1);
		RefreshTalismanSlot(TalismanSlot.Weapon2);

		RefreshCommitedBuildDisplay();
	}

	private void UpdateComparissonView()
	{
		TalismanBuild build;
		if(committedBuild != null)
			build = committedBuild;
		else
			build = crntBuild;

		UpdateComparrissonComponent(compHealth, build.GetHealth(), crntBuild.GetHealth());
		UpdateComparrissonComponent(compAttackRating, build.GetAttackRating(), crntBuild.GetAttackRating());
		UpdateComparrissonComponent(compWeaponPower, build.GetWeaponPower(), crntBuild.GetWeaponPower());
		UpdateComparrissonComponent(compHealRating, build.GetHealRating(), crntBuild.GetHealRating());
		UpdateComparrissonComponent(compBlockRating, build.GetBlockRating(), crntBuild.GetBlockRating());
		UpdateComparrissonComponent(compEvadeRating, build.GetEvadeRating(), crntBuild.GetEvadeRating());
		UpdateComparrissonComponent(compCritRating, build.GetCritRating(), crntBuild.GetCritRating());
		UpdateComparrissonComponent(compCritPower, build.GetCritPower(), crntBuild.GetCritPower());
		UpdateComparrissonComponent(compPenetrationRating, build.GetPenetrationRating(), crntBuild.GetPenetrationRating());
		UpdateComparrissonComponent(compHitRating, build.GetHitRating(), crntBuild.GetHitRating());
		UpdateComparrissonComponent(compDefenceRating, build.GetDefenceRating(), crntBuild.GetDefenceRating());
		UpdateComparrissonComponent(compMagicalProtection, build.GetMagicalProtection(), crntBuild.GetMagicalProtection());
		UpdateComparrissonComponent(compPhysicalProtection, build.GetPhysicalProtection(), crntBuild.GetPhysicalProtection());
		UpdateComparrissonComponent(compCombatPower, build.GetCombatPower(), crntBuild.GetCombatPower());
		UpdateComparrissonComponent(compHealPower, build.GetHealPower(), crntBuild.GetHealPower());
		UpdateComparrissonComponent(compCritChance, build.GetCritChance(), crntBuild.GetCritChance());
		UpdateComparrissonComponent(compCritPowerMultiplier, build.GetCritPowerMultiplier(), crntBuild.GetCritPowerMultiplier());
		UpdateComparrissonComponent(compEvadeChance, build.GetEvadeChance(), crntBuild.GetEvadeChance());
		UpdateComparrissonComponent(compEnemyEvadeChance, build.GetEnemyEvadeChance(), crntBuild.GetEnemyEvadeChance());
		UpdateComparrissonComponent(compEnemyCritRating, build.GetEnemyCritRating(), crntBuild.GetEnemyCritRating());
	}

	private void UpdateComparrissonComponent(JLabel comp, int commitedVal, int crntVal)
	{
		String tmp = "";
		tmp += commitedVal;
		int dif = crntVal - commitedVal;
		if(dif > 0)
			tmp += " (+" + dif + ")";
		else if (dif < 0)
			tmp += " (" + dif + ")";

		comp.setText(tmp);
	}

	private void UpdateComparrissonComponent(JLabel comp, float commitedVal, float crntVal)
	{
		String tmp = "";
		tmp += commitedVal;
		float dif = crntVal - commitedVal;
		if(dif > 0)
			tmp += " (+" + dif + ")";
		else if (dif < 0)
			tmp += " (" + dif + ")";

		comp.setText(tmp);
	}

	private void RefreshCommitedBuildDisplay()
	{
		if(committedBuild != null)
		{
			committedBuildName.setText(committedBuild.Name);

			for(Talisman talisman : committedBuild.GetBuildTalismans())
			{
				switch(talisman.GetTalismanSlot())
				{
				case Head:
					headDisplay[HEAD].setText(talisman.Name);
					break;
				case Finger:
					majorDisplay[FINGER].setText(talisman.Name);
					break;
				case Neck:
					majorDisplay[NECK].setText(talisman.Name);
					break;
				case Wrist:
					majorDisplay[WRIST].setText(talisman.Name);
					break;
				case Luck:
					minorDisplay[LUCK].setText(talisman.Name);
					break;
				case Waist:
					minorDisplay[WAIST].setText(talisman.Name);
					break;
				case Occult:
					minorDisplay[OCCULT].setText(talisman.Name);
					break;
				case Weapon1:
					weaponDisplay[WEAPON1].setText(talisman.Name);
					break;
				case Weapon2:
					weaponDisplay[WEAPON2].setText(talisman.Name);
					break;
				}
			}
		}
	}

	public void UpdateTalismanOnBuild()
	{
		crntBuild = InitializeNewBuild();
		UpdateComparissonView();
	}

	public void CommitCurrentBuild()
	{
		crntBuild.Name = talismanBuildName.getText();
		committedBuild = crntBuild;
		SaveCommittedBuildToFile();
		crntBuild = InitializeNewBuild();
		RefreshCommitedBuildDisplay();
		UpdateComparissonView();
	}

	private TalismanBuild InitializeNewBuild()
	{
		TalismanBuild appBuild = new TalismanBuild();

		ApplyAllSelectedOnBuild(appBuild, headSelection);
		ApplyAllSelectedOnBuild(appBuild, majorSelection);
		ApplyAllSelectedOnBuild(appBuild, minorSelection);
		ApplyAllSelectedOnBuild(appBuild, weaponSelection);

		return appBuild;
	}

	private void ApplyAllSelectedOnBuild(TalismanBuild appBuild, JComboBox[] talismanSelection)
	{
		for(JComboBox selection : talismanSelection)
		{
			Talisman tmpTalisman = (Talisman)selection.getSelectedItem();
			if(tmpTalisman != null)
				appBuild.SetTalisman(tmpTalisman);
		}
	}

	private void CreateTalismanSelectionComboBoxes(JComboBox[] comboBoxes, int count)
	{
		for(int i = 0; i < count; i++)
		{
			comboBoxes[i] = new JComboBox();
			comboBoxes[i].addActionListener(new TalismaSelectionChangedListener(this));
		}
	}

	private void CreateTalismanDisplayLabels(JLabel[] labels, int count)
	{
		for(int i = 0; i < count; i++)
		{
			labels[i] = new JLabel();
			labels[i].setText("N/A");
		}
	}

	private ArrayList<Talisman> GetAllTalismansOfType(TalismanPool talismanPool, TalismanSlot slot)
	{
		ArrayList<Talisman> talismans = new ArrayList<Talisman>();

		for(Talisman t : talismanPool.GetAvailableTalismans())
		{
			if(t.GetTalismanSlot() == slot)
				talismans.add(t);
		}

		return talismans;
	}

	public void RefreshTalismanSlot(TalismanSlot slot)
	{
		ArrayList<Talisman> allTalismans = GetAllTalismansOfType(talismanPool, slot);
		switch(slot)
		{
		case Head:
			RefreshTalismanComboBoxValues(headSelection[HEAD], allTalismans);
			break;
		case Finger:
			RefreshTalismanComboBoxValues(majorSelection[FINGER], allTalismans);
			break;
		case Neck:
			RefreshTalismanComboBoxValues(majorSelection[NECK], allTalismans);
			break;
		case Wrist:
			RefreshTalismanComboBoxValues(majorSelection[WRIST], allTalismans);
			break;
		case Luck:
			RefreshTalismanComboBoxValues(minorSelection[LUCK], allTalismans);
			break;
		case Waist:
			RefreshTalismanComboBoxValues(minorSelection[WAIST], allTalismans);
			break;
		case Occult:
			RefreshTalismanComboBoxValues(minorSelection[OCCULT], allTalismans);
			break;
		case Weapon1:
			RefreshTalismanComboBoxValues(weaponSelection[WEAPON1], allTalismans);
			break;
		case Weapon2:
			RefreshTalismanComboBoxValues(weaponSelection[WEAPON2], allTalismans);
			break;
		}
	}

	private void RefreshTalismanComboBoxValues(JComboBox comboBox, ArrayList<Talisman> availableTalismans)
	{
		if(availableTalismans != null)
		{
			comboBox.removeAllItems();

			for(Talisman t : availableTalismans)
			{
				comboBox.addItem(t);
			}

			if(availableTalismans.size() > 0)
				comboBox.setSelectedIndex(0);
		}
	}

	public void CreateNewTalisman()
	{
		TalismanEditFrame newTalismanFrame = new TalismanEditFrame("New weapon/talisman", this);
		newTalismanFrame.setVisible(true);
	}

	public void CreateNewGlyph()
	{
		GlyphEditFrame newGlyphFrame = new GlyphEditFrame("New glyph", this);
		newGlyphFrame.setVisible(true);
	}

	private void LoadCommittedBuildFromFile()
	{
		TalismanBuildXMLS serialziedBuild;
        try
        {
           FileInputStream fileIn = new FileInputStream("TalismansBuild.xml");
           XMLDecoder in = new XMLDecoder(fileIn);
           serialziedBuild = (TalismanBuildXMLS) in.readObject();
           committedBuild = new TalismanBuild();
           committedBuild.InitFromSerizlizable(serialziedBuild);
           in.close();
           fileIn.close();
       }
        catch(IOException i)
       {
           i.printStackTrace();
           committedBuild = null;
       }
	}

	private void SaveCommittedBuildToFile()
	{
	      try
	      {
	         FileOutputStream fileOut = new FileOutputStream("TalismansBuild.xml");
	         XMLEncoder out = new XMLEncoder(fileOut);
	         out.writeObject(committedBuild.GetSerializable());
	         out.close();
	         fileOut.close();
	      }
	      catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
}
