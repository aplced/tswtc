import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import TSWTalismans.GlyphPool;
import TSWTalismans.TalismanPool;
import TalismanBuildUI.TalismanBuildUIContainer;
import TalismanBuildUI.BuildCreatePanel.TalismanBuildCreatePanelFactory;
import TalismanBuildUI.ButtonPanel.ButtonControlPanelFactory;
import TalismanBuildUI.CurrnetBuildPanel.TalismanBuildViewPanelFactory;
import TalismanBuildUI.StatisticsComparisonPanel.TalismanBuildComparissonPanelFactory;

@SuppressWarnings("serial")
public class MainWindow extends JFrame
{
    public static void main(String[] args)
    {
        MainWindow win = new MainWindow();
        win.setVisible(true);
    }

    public MainWindow()
    {
        super();
        
        try
        { 
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
        }
        catch (Exception e)
        {
        } 


        TalismanBuildUIContainer talCb = new TalismanBuildUIContainer(new TalismanPool(), new GlyphPool());

        setTitle("TSW talisman calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel allPanes = new JPanel();
        allPanes.setLayout(new BorderLayout());

        allPanes.add(ButtonControlPanelFactory.PrepareButtonPanel(talCb), BorderLayout.NORTH);
        allPanes.add(TalismanBuildCreatePanelFactory.PrepareTalismanBuildPanel(talCb), BorderLayout.WEST);
        allPanes.add(TalismanBuildViewPanelFactory.PrepareTalismanViewPanel(talCb), BorderLayout.EAST);
        allPanes.add(TalismanBuildComparissonPanelFactory.PrepareTalismanComparissonPanel(talCb), BorderLayout.CENTER);

        setContentPane(allPanes);
        pack();
    }

}