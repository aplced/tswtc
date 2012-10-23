package TalismanBuildUI;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import TSWTalismans.GlyphPool;
import TSWTalismans.Talisman;
import TSWTalismans.TalismanBuild;
import TSWTalismans.TalismanBuildXMLS;
import TSWTalismans.TalismanPool;
import TSWTalismans.TalismanSlot;
import TalismanBuildUI.ActionListeners.SavedBuildSelectionChangedListener;
import TalismanBuildUI.ActionListeners.TalismaSelectionChangedListener;
import TalismanBuildUI.GlpyhEditUI.GlyphEditFrame;
import TalismanBuildUI.GlpyhEditUI.ActionListeners.CreateGlyphDoneListener;
import TalismanBuildUI.TalismanEditUI.TalismanEditFrame;
import TalismanBuildUI.TalismanEditUI.ActionListeners.CreateTalismanDoneListener;

public class TalismanBuildUIContainer
{
    final int HEAD = 0;
    final int FINGER = 0;
    final int NECK = 1;
    final int WRIST = 2;
    final int LUCK = 0;
    final int WAIST = 1;
    final int OCCULT = 2;
    final int WEAPON = 0;

    public TalismanPool talismanPool;
    public GlyphPool glyphPool;
    TalismanBuild crntBuild;
    HashMap<String, TalismanBuild> savedTalismanBuilds = new HashMap<String, TalismanBuild>();
    //TaGlComboBoxRenderer taGlRenderer = new TaGlComboBoxRenderer();
    
    public JTextField talismanBuildName = new JTextField(10);
    public JLabel committedBuildName = new JLabel();
    public JComboBox selectBuild = new JComboBox();

    public JComboBox[] headSelection = new JComboBox[1];
    public JComboBox[] majorSelection = new JComboBox[3];
    public JComboBox[] minorSelection = new JComboBox[3];
    public JComboBox[] weaponSelection = new JComboBox[1];

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
        
        //renderer.setPreferredSize(new Dimension(200, 130));        

        CreateTalismanSelectionComboBoxes(headSelection, 1);
        CreateTalismanSelectionComboBoxes(majorSelection, 3);
        CreateTalismanSelectionComboBoxes(minorSelection, 3);
        CreateTalismanSelectionComboBoxes(weaponSelection, 1);

        CreateTalismanDisplayLabels(headDisplay, 1);
        CreateTalismanDisplayLabels(majorDisplay, 3);
        CreateTalismanDisplayLabels(minorDisplay, 3);
        CreateTalismanDisplayLabels(weaponDisplay, 2);

        talismanBuildName.setText("Generic build");
        selectBuild.addActionListener(new SavedBuildSelectionChangedListener(this));

        RefreshTalismanSlot(TalismanSlot.Head);
        RefreshTalismanSlot(TalismanSlot.Finger);
        RefreshTalismanSlot(TalismanSlot.Neck);
        RefreshTalismanSlot(TalismanSlot.Wrist);
        RefreshTalismanSlot(TalismanSlot.Luck);
        RefreshTalismanSlot(TalismanSlot.Waist);
        RefreshTalismanSlot(TalismanSlot.Occult);
        RefreshTalismanSlot(TalismanSlot.Weapon);

        InitializeBuildSelectionDropDown();
        RefreshCommitedBuildDisplay();
    }
    
    private TalismanBuild GetSelectedBuild()
    {
        return (TalismanBuild) selectBuild.getSelectedItem();
    }

    private void UpdateComparissonView()
    {
        TalismanBuild build = GetSelectedBuild();
        if(build == null)
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
        TalismanBuild committedBuild = GetSelectedBuild();
        if(committedBuild != null)
        {
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
                case Weapon:
                    weaponDisplay[WEAPON].setText(talisman.Name);
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
        
        UpdateBuildSelectionDropDown(crntBuild);

        crntBuild = InitializeNewBuild();
        RefreshCommitedBuildDisplay();
        UpdateComparissonView();
    }
    
    public void RefreshCommitedBuildComparissonView()
    {
    	RefreshCommitedBuildDisplay();
        UpdateComparissonView();
    }
    
    private void InitializeBuildSelectionDropDown()
    {
    	selectBuild.removeAll();
    	for(TalismanBuild build : savedTalismanBuilds.values())
    	{
    		selectBuild.addItem(build);
    	}
    }

    private void UpdateBuildSelectionDropDown(TalismanBuild addedBuild)
    {
        savedTalismanBuilds.put(addedBuild.Name, addedBuild);
        SaveCommittedBuildToFile();
        selectBuild.addItem(addedBuild);
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
    	TaGlComboBoxRenderer taGlRenderer = new TaGlComboBoxRenderer();
        for(int i = 0; i < count; i++)
        {
            comboBoxes[i] = new JComboBox();
            comboBoxes[i].addActionListener(new TalismaSelectionChangedListener(this));
            comboBoxes[i].setRenderer(taGlRenderer);
            comboBoxes[i].addPopupMenuListener(taGlRenderer);
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
        case Weapon:
            RefreshTalismanComboBoxValues(weaponSelection[WEAPON], allTalismans);
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
            {
                comboBox.setSelectedIndex(0);
            }
        }
    }

    public void CreateNewTalisman()
    {
        TalismanEditFrame newTalismanFrame = new TalismanEditFrame("New weapon/talisman", glyphPool);
        newTalismanFrame.AssignDoneActionListener(new CreateTalismanDoneListener(newTalismanFrame, this));
        newTalismanFrame.setVisible(true);
    }

    public void CreateNewGlyph()
    {
        GlyphEditFrame newGlyphFrame = new GlyphEditFrame("New glyph");
        newGlyphFrame.AssignDoneActionListener(new CreateGlyphDoneListener(newGlyphFrame, glyphPool));
        newGlyphFrame.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    private void LoadCommittedBuildFromFile()
    {
        ArrayList<TalismanBuildXMLS> buildsSer = new ArrayList<TalismanBuildXMLS>();

        try
        {
           FileInputStream fileIn = new FileInputStream("TalismansBuild.xml");
           XMLDecoder in = new XMLDecoder(fileIn);
           buildsSer = (ArrayList<TalismanBuildXMLS>) in.readObject();
           in.close();
           fileIn.close();
           
           for(TalismanBuildXMLS buildS : buildsSer)
           {
               TalismanBuild tmpBuild = new TalismanBuild();
               tmpBuild.InitFromSerizlizable(buildS);
               savedTalismanBuilds.put(tmpBuild.Name, tmpBuild);
           }
       }
        catch(IOException i)
       {
           i.printStackTrace();
           savedTalismanBuilds.clear();
       }
    }

    private void SaveCommittedBuildToFile()
    {
        ArrayList<TalismanBuildXMLS> buildsSer = new ArrayList<TalismanBuildXMLS>();
        try
        {
            for(TalismanBuild build : savedTalismanBuilds.values())
            {
                buildsSer.add(build.GetSerializable());
            }
             
            FileOutputStream fileOut = new FileOutputStream("TalismansBuild.xml");
            XMLEncoder out = new XMLEncoder(fileOut);
            out.writeObject(buildsSer);
            out.close();
            fileOut.close();
        }
        catch(IOException i)
        {
            i.printStackTrace();
        }
    }  
}
