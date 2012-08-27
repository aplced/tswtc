package TalismanBuildUI.TalismanEditUI.ActionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import TSWTalismans.Talisman;
import TalismanBuildUI.TalismanBuildUIContainer;
import TalismanBuildUI.TalismanEditUI.TalismanEditFrame;

public class CreateTalismanDoneListener implements ActionListener
{
	private TalismanEditFrame editFrame;
	private TalismanBuildUIContainer talCb;

	public CreateTalismanDoneListener(TalismanEditFrame iEditFrame, TalismanBuildUIContainer iTalCb)
	{
		editFrame = iEditFrame;
		talCb = iTalCb;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(((JButton)arg0.getSource()).getText() == "Ok")
		{
			Talisman tmpTalisman = new Talisman(editFrame.GetSlot(), editFrame.GetName());

			tmpTalisman.SetQualityLevel(editFrame.GetQualityLevel());
			tmpTalisman.SetHealth(editFrame.GetHealth());
			tmpTalisman.SetAttackRating(editFrame.GetAttackRating());
			tmpTalisman.SetHealRating(editFrame.GetHealRating());
			tmpTalisman.SetWeaponPower(editFrame.GetWeaponPower());
			tmpTalisman.SlotGlyphIn(editFrame.GetSlottedGlyph());

			talCb.talismanPool.AddTalisman(tmpTalisman);
			talCb.RefreshTalismanSlot(editFrame.GetSlot());
		}
		editFrame.setVisible(false);
		editFrame.dispose();
	}
}