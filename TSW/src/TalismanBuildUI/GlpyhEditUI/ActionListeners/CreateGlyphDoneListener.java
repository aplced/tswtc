package TalismanBuildUI.GlpyhEditUI.ActionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import TSWTalismans.Glyph;
import TalismanBuildUI.TalismanBuildUIContainer;
import TalismanBuildUI.GlpyhEditUI.GlyphEditFrame;

public class CreateGlyphDoneListener implements ActionListener
{
	private GlyphEditFrame editFrame;
	private TalismanBuildUIContainer talCb;

	public CreateGlyphDoneListener(GlyphEditFrame iEditFrame, TalismanBuildUIContainer iTalCb)
	{
		editFrame = iEditFrame;
		talCb = iTalCb;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(((JButton)arg0.getSource()).getText() == "Ok")
		{
			Glyph tmpGlyph = new Glyph();
			tmpGlyph.Name =	editFrame.GetName();
			tmpGlyph.EvadeRating = editFrame.GetEvadeRating();
			tmpGlyph.BlockRating = editFrame.GetBlockRating();
			tmpGlyph.CritRating = editFrame.GetCritRating();
			tmpGlyph.CritPower = editFrame.GetCritPower();
			tmpGlyph.PenetrationRating = editFrame.GetPenetrationRating();
			tmpGlyph.HitRating = editFrame.GetHitRating();
			tmpGlyph.DefenceRating = editFrame.GetDefenceRating();
            tmpGlyph.MagicalProtection = editFrame.GetMagicalProtection();
            tmpGlyph.PhysicalProtection = editFrame.GetPhysicalProtection();
			
			talCb.glyphPool.AddGlyph(tmpGlyph);
		}
		editFrame.setVisible(false);
		editFrame.dispose();
	}
}