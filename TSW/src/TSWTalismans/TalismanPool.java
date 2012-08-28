package TSWTalismans;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class TalismanPool
{
    private ArrayList<Talisman> talismanPool = new ArrayList<Talisman>();

    public TalismanPool()
    {
        LoadFromFile();
    }

    public void AddTalisman(Talisman iTalisman)
    {
        talismanPool.add(iTalisman);
    }

    public void DelTalisman(Talisman iTalisman)
    {
        talismanPool.remove(iTalisman);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Talisman> GetAvailableTalismans()
    {
        return (ArrayList<Talisman>) talismanPool.clone();
    }

    @SuppressWarnings("unchecked")
    public void LoadFromFile()
    {
        ArrayList<TalismanXMLS> serializableTalismans;

        try
        {
           FileInputStream fileIn = new FileInputStream("TalismansPool.xml");
           XMLDecoder in = new XMLDecoder(fileIn);
           serializableTalismans = (ArrayList<TalismanXMLS>) in.readObject();

           talismanPool.clear();
           for(TalismanXMLS serializable : serializableTalismans)
           {
               Talisman tmp = new Talisman(TalismanSlot.Head);
               tmp.InitFromSerizlizable(serializable);
               talismanPool.add(tmp);
           }

           in.close();
           fileIn.close();
       }
        catch(IOException i)
       {
           i.printStackTrace();
           talismanPool = new ArrayList<Talisman>();
       }
    }

    public void SaveToFile()
    {
        ArrayList<TalismanXMLS> serializableTalismans = new ArrayList<TalismanXMLS>();

        for(Talisman talisman : talismanPool)
        {
            serializableTalismans.add(talisman.GetSerializable());
        }

        try
        {
            FileOutputStream fileOut = new FileOutputStream("TalismansPool.xml");
            XMLEncoder out = new XMLEncoder(fileOut);
            out.writeObject(serializableTalismans);
            out.close();
            fileOut.close();
        }
        catch(IOException i)
        {
            i.printStackTrace();
        }
    }
}
