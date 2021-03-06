package TSWTalismans;

public class Talisman implements TaGlInfoProvider
{
    public String Name = "talisman";

    private TalismanSlot slot;

    private double multiplier = 1;

    private int health = 0;
    private int attackRating = 0;
    private int healRating = 0;
    private int weaponPower = 0;
    private int qualityLevel = 0;

    private Glyph slottedGlyph = new Glyph();

    public Talisman(TalismanSlot iSlot)
    {
        SetTalismanSlot(iSlot);
    }

    public Talisman(TalismanSlot iSlot, String iName)
    {
        SetTalismanSlot(iSlot);
        Name = iName;
    }

    public TalismanXMLS GetSerializable()
    {
        TalismanXMLS talismanS = new TalismanXMLS();

        talismanS.setQualityLevel(qualityLevel);
        talismanS.setAttackRating(attackRating);
        talismanS.setWeaponPower(weaponPower);
        talismanS.setHealRating(healRating);
        talismanS.setHealth(health);
        talismanS.setName(Name);
        talismanS.setSlottedGlyph(slottedGlyph.GetSerializable());
        talismanS.setSlot(slot);

        return talismanS;
    }

    public void InitFromSerizlizable(TalismanXMLS talismanS)
    {
        qualityLevel = talismanS.getQualityLevel();
        attackRating = talismanS.getAttackRating();
        weaponPower = talismanS.getWeaponPower();
        healRating = talismanS.getHealRating();
        health = talismanS.getHealth();
        Name = talismanS.getName();
        slottedGlyph.InitFromSerizlizable(talismanS.getSlottedGlyph());
        slot = talismanS.getSlot();
    }

    public void SetTalismanSlot(TalismanSlot iSlot)
    {
        slot = iSlot;
        switch(slot)
        {
        case Head:
            //multiplier = 0.22;
            break;
        case Finger:
        case Neck:
        case Wrist:
            //multiplier = 0.16;
            break;
        case Luck:
        case Waist:
        case Occult:
            //multiplier = 0.10;
            break;
        case Weapon:
            //multiplier = 0.10;
            break;
        }
        multiplier = 1.0;
    }

    public TalismanSlot GetTalismanSlot()
    {
        return slot;
    }

    public void SlotGlyphIn(Glyph iGlyph)
    {
        if(iGlyph != null)
        {
            slottedGlyph = new Glyph(iGlyph);
        }
        else
        {
            slottedGlyph = new Glyph();
        }
    }

    public int GetHealth()
    {
        return (int)(health*multiplier);
    }

    public void SetHealth(int iHealth)
    {
        health = iHealth;
    }

    public int GetAttackRating()
    {
        return (int)(attackRating*multiplier);
    }

    public void SetAttackRating(int iAttackRating)
    {
        attackRating = iAttackRating;
    }

    public int GetWeaponPower()
    {
        return (int)(weaponPower*multiplier);
    }

    public void SetWeaponPower(int iWeaponPower)
    {
        weaponPower = iWeaponPower;
    }

    public int GetHealRating()
    {
        return (int)(healRating*multiplier);
    }

    public void SetHealRating(int iHealRating)
    {
        healRating = iHealRating;
    }

    public int GetQualityLevel()
    {
        return qualityLevel;
    }

    public void SetQualityLevel(int iQL)
    {
        qualityLevel = iQL;
    }

    public int GetBlockRating()
    {
        return (int)(slottedGlyph.BlockRating*multiplier);
    }

    public int GetEvadeRating()
    {
        return (int)(slottedGlyph.EvadeRating*multiplier);
    }

    public int GetDefenceRating()
    {
        return (int)(slottedGlyph.DefenceRating*multiplier);
    }

    public int GetMagicalProtection()
    {
        return (int)(slottedGlyph.MagicalProtection*multiplier);
    }

    public int GetPhysicalProtection()
    {
        return (int)(slottedGlyph.PhysicalProtection*multiplier);
    }

    public int GetCritRating()
    {
        return (int)(slottedGlyph.CritRating*multiplier);
    }

    public int GetCritPower()
    {
        return (int)(slottedGlyph.CritPower*multiplier);
    }

    public int GetPenetrationRating()
    {
        return (int)(slottedGlyph.PenetrationRating*multiplier);
    }

    public int GetHitRating()
    {
        return (int)(slottedGlyph.HitRating*multiplier);
    }

    public String GetPlainName()
    {
    	return Name + "(" + slottedGlyph.Name + ")";
    }
    
    public String GetSummaryInfo()
    {
        String stats = " QL(" + GetQualityLevel() + ")";

        if(GetWeaponPower() != 0)
            stats += "WP(" + GetWeaponPower() + ")";

        if(GetHealth() != 0)
            stats += "Hp(" + GetHealth() + ")";

        if(GetAttackRating() != 0)
            stats += "AR(" + GetAttackRating() + ")";

        if(GetHealRating() != 0)
            stats += "HR(" + GetHealRating() + ")";

        return Name + stats + " :: " + slottedGlyph.GetSummaryInfo();
    }

    @Override
    public String toString()
    {
        return GetPlainName();
    }
}
