package TalismanBuildUI.CurrnetBuildPanel;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import TalismanBuildUI.TalismanBuildUIContainer;


public class TalismanBuildViewPanelFactory
{
    private static JPanel PreparePanelOfTalismanType(JLabel[] talismanLabels)
    {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        if(talismanLabels != null)
        {
            for(JLabel talisman : talismanLabels)
            {
                panel.add(talisman);
            }
        }

        return panel;
    }

    private static JPanel PrepareCaptionPanel(TalismanBuildUIContainer talCb)
    {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(talCb.selectBuild);

        return panel;
    }

    public static JPanel PrepareTalismanViewPanel(TalismanBuildUIContainer talCb)
    {
        JPanel allTalismanView = new JPanel();
        allTalismanView.setLayout(new BoxLayout(allTalismanView, BoxLayout.PAGE_AXIS));

        allTalismanView.add(PrepareCaptionPanel(talCb));
        allTalismanView.add(PreparePanelOfTalismanType(talCb.headDisplay));
        allTalismanView.add(PreparePanelOfTalismanType(talCb.majorDisplay));
        allTalismanView.add(PreparePanelOfTalismanType(talCb.minorDisplay));
        allTalismanView.add(PreparePanelOfTalismanType(talCb.weaponDisplay));

        return allTalismanView;
    }

}
