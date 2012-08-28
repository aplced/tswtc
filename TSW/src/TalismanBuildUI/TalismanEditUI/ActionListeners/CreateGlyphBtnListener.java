package TalismanBuildUI.TalismanEditUI.ActionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import TalismanBuildUI.TalismanEditUI.TalismanEditFrame;

public class CreateGlyphBtnListener implements ActionListener
{
    private TalismanEditFrame talEF;

    public CreateGlyphBtnListener(TalismanEditFrame iTalEF)
    {
        talEF = iTalEF;
    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        talEF.CreateNewGlyph();
    }

}
