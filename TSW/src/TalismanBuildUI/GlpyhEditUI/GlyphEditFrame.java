package TalismanBuildUI.GlpyhEditUI;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GlyphEditFrame extends JFrame
{
	private JTextField nameJTxt = new JTextField(10);
	private JTextField qualityLevelJTxt = new JTextField(10);
	private JTextField blockRatingJTxt = new JTextField(10);
	private JTextField evadeRatingJTxt = new JTextField(10);
	private JTextField defenceRatingJTxt = new JTextField(10);
	private JTextField magicalProtectionJTxt = new JTextField(10);
	private JTextField physicalProtectionJTxt = new JTextField(10);
	private JTextField critRatingJTxt = new JTextField(10);
	private JTextField critPowerJTxt = new JTextField(10);
	private JTextField penetrationRatingJTxt = new JTextField(10);
	private JTextField hitRatingJTxt = new JTextField(10);
	private JButton createDone = new JButton("Ok");
	private JButton createCancel = new JButton("Cancel");


	public GlyphEditFrame(String caption)
	{
		setTitle(caption);
		setLocationRelativeTo(null);

		setContentPane(PrepareGlyphEditPanel());
		pack();
	}

	private JPanel PrepareGlyphEditPanel()
	{
		JPanel talismanEditPanel = new JPanel();
		talismanEditPanel.setLayout(new GridLayout(12, 2));

		nameJTxt.setText("Glyph");
		blockRatingJTxt.setText("0");
		evadeRatingJTxt.setText("0");
		defenceRatingJTxt.setText("0");
		magicalProtectionJTxt.setText("0");
		physicalProtectionJTxt.setText("0");
		critRatingJTxt.setText("0");
		critPowerJTxt.setText("0");
		penetrationRatingJTxt.setText("0");
		hitRatingJTxt.setText("0");

		talismanEditPanel.add(new JLabel("Name:"));
		talismanEditPanel.add(nameJTxt);
		talismanEditPanel.add(new JLabel("Quality level:"));
		talismanEditPanel.add(qualityLevelJTxt);
		talismanEditPanel.add(new JLabel("Block rating:"));
		talismanEditPanel.add(blockRatingJTxt);
		talismanEditPanel.add(new JLabel("Evade rating"));
		talismanEditPanel.add(evadeRatingJTxt);
		talismanEditPanel.add(new JLabel("Defence rating"));
		talismanEditPanel.add(defenceRatingJTxt);
		talismanEditPanel.add(new JLabel("Magical protection"));
		talismanEditPanel.add(magicalProtectionJTxt);
		talismanEditPanel.add(new JLabel("Physical protection"));
		talismanEditPanel.add(physicalProtectionJTxt);
		talismanEditPanel.add(new JLabel("Crit rating:"));
		talismanEditPanel.add(critRatingJTxt);
		talismanEditPanel.add(new JLabel("Crit power:"));
		talismanEditPanel.add(critPowerJTxt);
		talismanEditPanel.add(new JLabel("Penetration rating:"));
		talismanEditPanel.add(penetrationRatingJTxt);
		talismanEditPanel.add(new JLabel("Hit rating:"));
		talismanEditPanel.add(hitRatingJTxt);

		talismanEditPanel.add(createDone);
		talismanEditPanel.add(createCancel);

		return talismanEditPanel;
	}

	public void AssignDoneActionListener(ActionListener createGlyphDone)
	{
		createDone.addActionListener(createGlyphDone);
		createCancel.addActionListener(createGlyphDone);
	}

	public String GetName()
	{
		return nameJTxt.getText();
	}

	public int GetQualityLevel()
	{
		return Integer.parseInt(qualityLevelJTxt.getText());
	}

	public int GetBlockRating()
	{
		return Integer.parseInt(blockRatingJTxt.getText());
	}

	public int GetEvadeRating()
	{
		return Integer.parseInt(evadeRatingJTxt.getText());
	}

	public int GetDefenceRating()
	{
		return Integer.parseInt(defenceRatingJTxt.getText());
	}

	public int GetMagicalProtection()
	{
		return Integer.parseInt(magicalProtectionJTxt.getText());
	}

	public int GetPhysicalProtection()
	{
		return Integer.parseInt(physicalProtectionJTxt.getText());
	}

	public int GetCritRating()
	{
		return Integer.parseInt(critRatingJTxt.getText());
	}

	public int GetCritPower()
	{
		return Integer.parseInt(critPowerJTxt.getText());
	}

	public int GetPenetrationRating()
	{
		return Integer.parseInt(penetrationRatingJTxt.getText());
	}

	public int GetHitRating()
	{
		return Integer.parseInt(hitRatingJTxt.getText());
	}
}
