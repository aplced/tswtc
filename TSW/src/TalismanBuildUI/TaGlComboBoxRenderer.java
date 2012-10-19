package TalismanBuildUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import TSWTalismans.TaGlInfoProvider;

@SuppressWarnings("serial")
public class TaGlComboBoxRenderer extends JLabel implements ListCellRenderer, PopupMenuListener
{
	Boolean onDropDown = false;
	JComboBox caller;
	FontMetrics fontMetrics;
	
    public TaGlComboBoxRenderer(JComboBox icaller) 
    {
        setOpaque(true);
        setVerticalAlignment(CENTER);
        setHorizontalAlignment(CENTER);
                
        caller = icaller;
        caller.addPopupMenuListener(this);
        caller.setRenderer(this);
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
		SetDimensionsCollapsed();
		onDropDown = false;
	}

	@Override
	public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) 
	{
		SetDimensionsCollapsed();
		onDropDown = false;
	}

	@Override
	public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) 
	{
		SetDimensionsExpanded();
		onDropDown = true;
	}
	
	private Dimension CalculateDropDownSize()
	{
		int displayedItms = 5;
		int maxStringLen = 0;
		
		if(fontMetrics == null)
			fontMetrics = getGraphics().getFontMetrics(getFont());
		
		for(int i = 0; i < caller.getItemCount(); i++)
		{
			TaGlInfoProvider itm = (TaGlInfoProvider)caller.getItemAt(i);
			int itmStrLen = fontMetrics.stringWidth(itm.GetSummaryInfo());
			if(itmStrLen > maxStringLen)
				maxStringLen = itmStrLen;
		}
		
		if(caller.getItemCount() < displayedItms)
			displayedItms = caller.getItemCount();

		this.setPreferredSize(new Dimension(maxStringLen, fontMetrics.getHeight()));
		//this.setSize(new Dimension(maxStringLen, fontMetrics.getHeight()/2));
		return new Dimension(maxStringLen + 20, fontMetrics.getHeight()*displayedItms/2);
	}

	private void SetDimensionsCollapsed()
	{	
		setHorizontalAlignment(CENTER);
	}
	
	private void SetDimensionsExpanded()
	{
        Object comp = caller.getUI().getAccessibleChild(caller, 0); 
        if (!(comp instanceof JPopupMenu)) 
        { 
            return; 
        } 
        
		setHorizontalAlignment(LEFT);
        
        JPopupMenu popup = (JPopupMenu) comp; 
        JScrollPane scrollPane = (JScrollPane) popup.getComponent(0); 
        Dimension size = CalculateDropDownSize();

        //popup.setSize(size);
        //popup.setPreferredSize(size);
        //popup.setAutoscrolls(true);
        
        //popup.revalidate();
        
        //scrollPane.setSize(size);
        scrollPane.setPreferredSize(size); 
        //scrollPane.setAutoscrolls(true);
        
        scrollPane.revalidate();
        //popup.revalidate();
	}
}
