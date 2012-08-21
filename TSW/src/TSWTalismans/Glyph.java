package TSWTalismans;

public class Glyph
{
	public String Name = "glyph";

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
		BlockRating = glyphS.getBlockRating();
		CritPower = glyphS.getCritPower();
		CritRating = glyphS.getCritRating();
		EvadeRating = glyphS.getEvadeRating();
		Name = glyphS.getName();
		PenetrationRating = glyphS.getPenetrationRating();
		HitRating = glyphS.getHitRating();
	}

	@Override
	public String toString()
	{
		return Name;
	}
}
