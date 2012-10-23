package TalismanBuildUI;

import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

import javax.swing.JScrollPane;

public class ScrollPanePropertyLocker implements PropertyChangeListener
{
	String[] propertyWatchAr = new String[]{"preferredSize", "maximumSize"};
	HashMap<String, Boolean> internalChangeMap = new HashMap<String, Boolean>(); 
	
	public ScrollPanePropertyLocker()
	{	
		for(String propertyWatch : propertyWatchAr)
		{
			internalChangeMap.put(propertyWatch, false);
		}
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent arg0) 
	{
		String propCh = arg0.getPropertyName(); 
		for(String propertyWatch : propertyWatchAr)
		{
			if(propertyWatch == propCh)
			{
				if(!internalChangeMap.get(propertyWatch))
				{
					internalChangeMap.put(propertyWatch, true);
					
					JScrollPane scrollPane = (JScrollPane)arg0.getSource();
					
					if(propertyWatchAr[0] == propertyWatch)
						scrollPane.setPreferredSize((Dimension)arg0.getOldValue());
					else if(propertyWatchAr[1] == propertyWatch)
						scrollPane.setMaximumSize((Dimension)arg0.getOldValue());
				}
				else
				{
					internalChangeMap.put(propertyWatch, false);
				}
			}
		}
	}
	
	public void EnableChange(String enablePropertySet)
	{
		if(internalChangeMap.containsKey(enablePropertySet))
		{
			internalChangeMap.put(enablePropertySet, true);
		}
	}
}
