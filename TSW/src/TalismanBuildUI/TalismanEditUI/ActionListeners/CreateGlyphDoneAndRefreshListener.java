package TalismanBuildUI.TalismanEditUI.ActionListeners;
import java.awt.event.ActionEvent;

import TSWTalismans.GlyphPool;
import TalismanBuildUI.GlpyhEditUI.GlyphEditFrame;
import TalismanBuildUI.TalismanEditUI.TalismanEditFrame;
import TalismanBuildUI.GlpyhEditUI.ActionListeners.CreateGlyphDoneListener;

public class CreateGlyphDoneAndRefreshListener extends CreateGlyphDoneListener
{
    private TalismanEditFrame talEditFrame;

    public CreateGlyphDoneAndRefreshListener(TalismanEditFrame iTalEditFrame, GlyphEditFrame iEditFrame, GlyphPool iGlyphPoop)
    {
        super(iEditFrame, iGlyphPoop);
        talEditFrame = iTalEditFrame;
    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        super.actionPerformed(arg0);
        talEditFrame.RefreshGlyphComboBox();
    }
}