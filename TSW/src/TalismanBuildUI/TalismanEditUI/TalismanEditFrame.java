package TalismanBuildUI.TalismanEditUI;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TSWTalismans.Glyph;
import TSWTalismans.GlyphPool;
import TSWTalismans.TalismanSlot;
import TalismanBuildUI.GlpyhEditUI.GlyphEditFrame;
import TalismanBuildUI.TalismanEditUI.ActionListeners.CreateGlyphBtnListener;
import TalismanBuildUI.TalismanEditUI.ActionListeners.CreateGlyphDoneAndRefreshListener;

@SuppressWarnings("serial")
public class TalismanEditFrame extends JFrame
{
    private JComboBox typeJCbx = new JComboBox();
    private JTextField nameJTxt = new JTextField(10);
    private JTextField qualityLevelJTxt = new JTextField(10);
    private JTextField healthJTxt = new JTextField(10);
    private JTextField attackRatingJTxt = new JTextField(10);
    private JTextField weaponPowerJTxt = new JTextField(10);
    private JTextField healRatingJTxt = new JTextField(10);

    private GlyphPool glyphPool;

    private JComboBox glyphSelection = new JComboBox();

    private JButton createGlyph = new JButton("New Glyph");
    private JButton createDone = new JButton("Ok");
    private JButton createCancel = new JButton("Cancel");

    public TalismanEditFrame(String caption, GlyphPool iGlyphPool)
    {
        glyphPool = iGlyphPool;

        setTitle(caption);
        setLocationRelativeTo(null);

        setContentPane(PrepareTalismanEditPanel());
        createGlyph.addActionListener(new CreateGlyphBtnListener(this));
        pack();
    }

    public void CreateNewGlyph()
    {
        GlyphEditFrame newGlyphFrame = new GlyphEditFrame("New glyph");
        newGlyphFrame.AssignDoneActionListener(new CreateGlyphDoneAndRefreshListener(this, newGlyphFrame, glyphPool));
        newGlyphFrame.setVisible(true);
        RefreshGlyphComboBox();
    }

    public void RefreshGlyphComboBox()
    {
        glyphSelection.removeAllItems();
        for(Glyph gph : glyphPool.GetAvailableGlyphs())
        {
            glyphSelection.addItem(gph);
        }
    }

    private JPanel PrepareTalismanEditPanel()
    {
        JPanel talismanEditPanel = new JPanel();
        talismanEditPanel.setLayout(new GridLayout(14, 2));


        typeJCbx.addItem(TalismanSlot.Head);
        typeJCbx.addItem(TalismanSlot.Finger);
        typeJCbx.addItem(TalismanSlot.Neck);
        typeJCbx.addItem(TalismanSlot.Wrist);
        typeJCbx.addItem(TalismanSlot.Luck);
        typeJCbx.addItem(TalismanSlot.Waist);
        typeJCbx.addItem(TalismanSlot.Occult);
        typeJCbx.addItem(TalismanSlot.Weapon);

        typeJCbx.setSelectedIndex(0);
        nameJTxt.setText("Talisman");
        qualityLevelJTxt.setText("0");
        healthJTxt.setText("0");
        attackRatingJTxt.setText("0");
        weaponPowerJTxt.setText("0");
        healRatingJTxt.setText("0");

        RefreshGlyphComboBox();

        talismanEditPanel.add(new JLabel("Type:"));
        talismanEditPanel.add(typeJCbx);
        talismanEditPanel.add(new JLabel("Name:"));
        talismanEditPanel.add(nameJTxt);
        talismanEditPanel.add(new JLabel("Quality level:"));
        talismanEditPanel.add(qualityLevelJTxt);
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
        talismanEditPanel.add(new JLabel(""));
        talismanEditPanel.add(createGlyph);
        talismanEditPanel.add(createDone);
        talismanEditPanel.add(createCancel);

        return talismanEditPanel;
    }

    public void AssignDoneActionListener(ActionListener createTalismanDone)
    {
        createDone.addActionListener(createTalismanDone);
        createCancel.addActionListener(createTalismanDone);
    }

    public TalismanSlot GetSlot()
    {
        return (TalismanSlot)typeJCbx.getSelectedItem();
    }

    public String GetName()
    {
        return nameJTxt.getText();
    }

    public int GetQualityLevel()
    {
        return Integer.parseInt(qualityLevelJTxt.getText());
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
