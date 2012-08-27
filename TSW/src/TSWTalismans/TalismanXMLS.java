package TSWTalismans;

public class TalismanXMLS
{
	private String name;
	private TalismanSlot slot;
	private int qualityLevel;
	private int health;
	private int attackRating;
	private int weaponPower;
	private int healRating;
	private GlyphXMLS slottedGlyph;

	public String getName() {return name;}
	public TalismanSlot getSlot() {return slot;}
	public int getQualityLevel() {return qualityLevel;}
	public int getHealth() {return health;}
	public int getAttackRating() {return attackRating;}
	public int getWeaponPower() {return weaponPower;}
	public int getHealRating() {return healRating;}
	public GlyphXMLS getSlottedGlyph() {return slottedGlyph;}

	public void setName(String value) {name = value;}
	public void setSlot(TalismanSlot value) {slot = value;}
	public void setQualityLevel(int value) {qualityLevel = value;}
	public void setHealth(int value) {health = value;}
	public void setAttackRating(int value) {attackRating = value;}
	public void setWeaponPower(int value) {weaponPower = value;}
	public void setHealRating(int value) {healRating = value;}
	public void setSlottedGlyph(GlyphXMLS value) {slottedGlyph = value;}
}
