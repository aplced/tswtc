package TalismanBuildUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import TSWTalismans.TaGlInfoProvider;

@SuppressWarnings("serial")
public class TaGlComboBoxRenderer extends JLabel implements ListCellRenderer, PopupMenuListener
{
	Boolean onDropDown = false;
	
    public TaGlComboBoxRenderer() 
    {
        setOpaque(true);
        setVerticalAlignment(CENTER);
        setHorizontalAlignment(LEFT);
    }

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) 
	{
		TaGlInfoProvider sum = (TaGlInfoProvider)value;

        if (isSelected) 
        {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } 
        else
        {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

		if(sum != null)
		{
			if(onDropDown)
				setText(sum.GetSummaryInfo());
			else
				setText(sum.GetPlainName());
		}
		else if(value != null)
		{
			setText("Error reading data of: " + value.toString());
		}
		else
		{
			setText("");
		}
		
        return this;
	}

	@Override
	public void popupMenuCanceled(PopupMenuEvent arg0) 
	{
		onDropDown = false;
	}

	@Override
	public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) 
	{
		onDropDown = false;
	}

	@Override
	public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) 
	{
		SetPopUpSize((JComboBox)arg0.getSource());
		onDropDown = true;
	}
	
	private Dimension CalcItemLength(JComboBox cBox)
	{
		int displayedItms = 5;
		int maxStringLen = 0;
		Graphics cBoxGfx = null;
		FontMetrics fontMetrics = null;
		
		cBoxGfx = cBox.getGraphics();
		if(cBoxGfx != null)
		{
			fontMetrics = cBoxGfx.getFontMetrics(cBox.getFont());
		
			for(int i = 0; i < cBox.getItemCount(); i++)
			{
				TaGlInfoProvider itm = (TaGlInfoProvider)cBox.getItemAt(i);
				int itmStrLen = fontMetrics.stringWidth(itm.GetSummaryInfo());
				if(itmStrLen > maxStringLen)
					maxStringLen = itmStrLen;
			}
			
			if(cBox.getItemCount() < displayedItms)
				displayedItms = cBox.getItemCount();
	
			return new Dimension(maxStringLen, fontMetrics.getHeight()*(displayedItms + 1));
		}
		else
		{
			return new Dimension(0, 0);
		}
	}
	
	private void SetPopUpSize(JComboBox cBox)
	{
        Object comp = cBox.getUI().getAccessibleChild(cBox, 0); 
        if (!(comp instanceof JPopupMenu)) 
        { 
            return; 
        } 
        
        JPopupMenu popup = (JPopupMenu) comp; 
        JScrollPane scrollPane = (JScrollPane) popup.getComponent(0); 
        Dimension size = CalcItemLength(cBox);
        
        //popup.setSize(size);
        //popup.setPreferredSize(size);
        //popup.setMaximumSize(size);
        //popup.revalidate();
        
        //this.setPreferredSize(size);
        //this.setMaximumSize(size);
        //this.revalidate();
        
        scrollPane.setHorizontalScrollBar(new JScrollBar(JScrollBar.HORIZONTAL)); 
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);     
        //scrollPane.setSize(size);
        scrollPane.setPreferredSize(size);
        scrollPane.setMaximumSize(size);
        //scrollPane.revalidate();
	}  	
}
