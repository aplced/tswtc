package TSWTalismans;

import java.util.ArrayList;
import java.util.HashMap;

public class TalismanBuild
{
    public String Name = "build";

    private HashMap<TalismanSlot, Talisman> buildTalismans = new HashMap<TalismanSlot, Talisman>();

    private float combatPower = 0;
    private float healPower = 0;
    private int weaponPower = 0;
    private int health = 0;
    private int attackRating = 0;
    private int critRating = 0;
    private float critChance = 0;
    private int critPower = 0;
    private float critPowerMultiplier = 0;
    private int penetrationRating = 0;
    private int hitRating = 0;
    private int healRating = 0;
    private int evadeRating = 0;
    private float evadeChance = 0;
    private int blockRating = 0;
    private int defenceRating = 0;
    private int magicalProtection = 0;
    private int physicalProtection = 0;
    private float enemyEvadeChance = 0;
    private float enemyCritChance = 0;


    public boolean SetTalisman(Talisman iTalisman)
    {
        if(buildTalismans.get(iTalisman.GetTalismanSlot()) == null)
        {
            buildTalismans.put(iTalisman.GetTalismanSlot(), iTalisman);
            CalculateBuildSpecs();
            return true;
        }

        return false;
    }

    public Talisman GetTalisman(TalismanSlot slot)
    {
        return buildTalismans.get(slot);
    }

    public Talisman GetTalisman(String talismanName)
    {
        for(Talisman t : buildTalismans.values())
        {
            if(t.Name == talismanName)
                return t;
        }

        return null;
    }

    public boolean RemoveTalisman(String talismanName)
    {
        Talisman delTalisman = GetTalisman(talismanName);

        if(delTalisman != null)
        {
            return RemoveTalisman(delTalisman.GetTalismanSlot());
        }

        return false;
    }

    public boolean RemoveTalisman(TalismanSlot slot)
    {
        Talisman removed = buildTalismans.remove(slot);
        if(removed != null)
        {
            CalculateBuildSpecs();
            return true;
        }

        return false;
    }

    public ArrayList<Talisman> GetBuildTalismans()
    {
        ArrayList<Talisman> tmp = new ArrayList<Talisman>();
        for(Talisman t : buildTalismans.values())
        {
            tmp.add(t);
        }

        return tmp;
    }

    private void NullifyBuildSpecs()
    {
        health = 0;
        combatPower = 0;
        healPower = 0;
        attackRating = 0;
        weaponPower = 0;
        healRating = 0;
        evadeRating = 0;
        evadeChance = 0;
        blockRating = 0;
        critRating = 0;
        critChance = 0;
        critPower = 0;
        critPowerMultiplier = 0;
        penetrationRating = 0;
        hitRating = 0;
        defenceRating = 0;
        magicalProtection = 0;
        physicalProtection = 0;
        enemyEvadeChance = 0;
        enemyCritChance = 0;
    }

    private void CalculateBuildSpecs()
    {
        NullifyBuildSpecs();

        for(Talisman buildTalisman : buildTalismans.values())
        {
            health += buildTalisman.GetHealth();
            attackRating += buildTalisman.GetAttackRating();
            weaponPower += buildTalisman.GetWeaponPower();
            healRating += buildTalisman.GetHealRating();
            evadeRating += buildTalisman.GetEvadeRating();
            blockRating += buildTalisman.GetBlockRating();
            critRating += buildTalisman.GetCritRating();
            critPower += buildTalisman.GetCritPower();
            penetrationRating += buildTalisman.GetPenetrationRating();
            hitRating += buildTalisman.GetHitRating();
            defenceRating += buildTalisman.GetDefenceRating();
            magicalProtection += buildTalisman.GetMagicalProtection();
            physicalProtection += buildTalisman.GetPhysicalProtection();
        }

        CalculateCombatPower();
        CalculateHealPower();
        CalculateCritChance();
        CalculateCritPowerMultiplier();
        CalculateEvadeChance();
    }

    final double CP_BASE = 75;
    final double WP_DIV = 5;

    final double RATC_A = -0.000000001482;
    final double RATC_B =  0.0000329;
    final double RATC_C = -0.0024;
    final double RATC_D = 700.29;

    //Used formula and estimates from http://forums.thesecretworld.com/showthread.php?p=1361035

    private double RatingCubicPowerCalc(double x)
    {
        return RATC_A*(x*x*x) + RATC_B*(x*x) + RATC_C*x + RATC_D;
    }

    private void CalculateCombatPower()
    {
        double cp = (CP_BASE + weaponPower/5)*(1 + attackRating/RatingCubicPowerCalc(attackRating));
        combatPower = Math.round(cp*10)/10f;
    }

    private void CalculateHealPower()
    {
        double hp = (CP_BASE + weaponPower/5)*(1 + healRating/RatingCubicPowerCalc(healRating));
        healPower = Math.round(hp*10)/10f;
    }

    final double CC_BASE = 5;
    final int CC_DR = 750;

    final double CC_A = 0.0206;

    //Used formula and estimates from http://dulfy.net/2012/07/27/fistblood-healing-build/#3

    private double CritChanceLinearCalc(int x)
    {
        if(x > CC_DR)
        {
            return CC_A*CC_DR + CC_A*((x - CC_DR)/2) + CC_BASE;
        }
        else
        {
            return CC_A*x + CC_BASE;
        }
    }

    private void CalculateCritChance()
    {
        double cc = CritChanceLinearCalc(critRating);
        critChance = Math.round(cc*10)/10f;
    }

    private void CalculateCritPowerMultiplier()
    {
        critPowerMultiplier = 25;
    }

    private void CalculateEvadeChance()
    {
        evadeChance = 5;
    }

    public int GetHealth()
    {
        return health;
    }

    public int GetAttackRating()
    {
        return attackRating;
    }

    public int GetWeaponPower()
    {
        return weaponPower;
    }

    public int GetHealRating()
    {
        return healRating;
    }

    public int GetBlockRating()
    {
        return blockRating;
    }

    public int GetEvadeRating()
    {
        return evadeRating;
    }

    public int GetCritRating()
    {
        return critRating;
    }

    public int GetCritPower()
    {
        return critPower;
    }

    public int GetPenetrationRating()
    {
        return penetrationRating;
    }

    public int GetHitRating()
    {
        return hitRating;
    }

    public int GetDefenceRating()
    {
        return defenceRating;
    }

    public int GetMagicalProtection()
    {
        return magicalProtection;
    }

    public int GetPhysicalProtection()
    {
        return physicalProtection;
    }

    public float GetCombatPower()
    {
        return combatPower;
    }

    public float GetHealPower()
    {
        return healPower;
    }

    public float GetCritChance()
    {
        return critChance;
    }

    public float GetCritPowerMultiplier()
    {
        return critPowerMultiplier;
    }

    public float GetEvadeChance()
    {
        return evadeChance;
    }

    public float GetEnemyEvadeChance()
    {
        return enemyEvadeChance;
    }

    public float GetEnemyCritRating()
    {
        return enemyCritChance;
    }

    public TalismanBuildXMLS GetSerializable()
    {
        TalismanBuildXMLS serializable = new TalismanBuildXMLS();
        ArrayList<TalismanXMLS> serializableTalismans = new ArrayList<TalismanXMLS>();

        serializable.setName(Name);

        for(Talisman talisman : buildTalismans.values())
            serializableTalismans.add(talisman.GetSerializable());

        serializable.setBuildTalismans(serializableTalismans);

        return serializable;
    }

    public void InitFromSerizlizable(TalismanBuildXMLS serializable)
    {
        Name = serializable.getName();
        buildTalismans.clear();

        for(TalismanXMLS talismanS : serializable.getBuildTalismans())
        {
            Talisman tmp = new Talisman(TalismanSlot.Head);
            tmp.InitFromSerizlizable(talismanS);
            buildTalismans.put(tmp.GetTalismanSlot(), tmp);
        }
    }

    @Override
    public String toString()
    {
        return Name;
    }

}
