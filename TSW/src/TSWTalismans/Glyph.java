package TSWTalismans;

public class Glyph
{
	public String Name = "glyph";

	public int QualityLevel = 0;

	public int EvadeRating = 0;
	public int BlockRating = 0;
	public int DefenceRating = 0;

	public int CritRating = 0;
	public int CritPower = 0;

	public int PenetrationRating = 0;
	public int HitRating = 0;

	public int MagicalProtection = 0;
	public int PhysicalProtection = 0;

	public Glyph()
	{
	}

	public Glyph(Glyph iGlyph)
	{
		Name = iGlyph.Name;
		QualityLevel = iGlyph.QualityLevel;
		EvadeRating = iGlyph.EvadeRating;
		BlockRating = iGlyph.BlockRating;
		CritRating = iGlyph.CritRating;
		CritPower = iGlyph.CritPower;
		PenetrationRating = iGlyph.PenetrationRating;
		HitRating = iGlyph.HitRating;
		DefenceRating = iGlyph.DefenceRating;
		MagicalProtection = iGlyph.MagicalProtection;
		PhysicalProtection = iGlyph.PhysicalProtection;
	}

	public GlyphXMLS GetSerializable()
	{
		GlyphXMLS glyphS = new GlyphXMLS();

		glyphS.setQualityLevel(QualityLevel);
		glyphS.setBlockRating(BlockRating);
		glyphS.setCritPower(CritPower);
		glyphS.setCritRating(CritRating);
		glyphS.setEvadeRating(EvadeRating);
		glyphS.setName(Name);
		glyphS.setPenetrationRating(PenetrationRating);
		glyphS.setHitRating(HitRating);

		return glyphS;
	}

	public void InitFromSerizlizable(GlyphXMLS glyphS)
	{
		QualityLevel = glyphS.getQualityLevel();
		BlockRating = glyphS.getBlockRating();
		CritPower = glyphS.getCritPower();
		CritRating = glyphS.getCritRating();
		EvadeRating = glyphS.getEvadeRating();
		Name = glyphS.getName();
		PenetrationRating = glyphS.getPenetrationRating();
		HitRating = glyphS.getHitRating();
	}

	public String GetSummaryInfo()
	{
		String stats = "";
		String summary = "QL(" + QualityLevel + ")";

		if(EvadeRating != 0)
			stats += "ER(" + EvadeRating + ")";
		if(BlockRating != 0)
			stats += "BR(" + BlockRating + ")";
		if(DefenceRating != 0)
			stats += "DR(" + DefenceRating + ")";
		if(MagicalProtection != 0)
			stats += "MP(" + MagicalProtection + ")";
		if(PhysicalProtection != 0)
			stats += "PP(" + PhysicalProtection + ")";
		if(CritRating != 0)
			stats += "CR(" + CritRating + ")";
		if(CritPower != 0)
			stats += "CP(" + CritPower + ")";
		if(PenetrationRating != 0)
			stats += "PR(" + PenetrationRating + ")";
		if(HitRating != 0)
			stats += "HR(" + HitRating + ")";

		if(stats.length() > 0)
			return summary + " {" + stats + "}";
		else
			return summary;
	}

	@Override
	public String toString()
	{
		return Name + " : " + GetSummaryInfo();
	}
}
