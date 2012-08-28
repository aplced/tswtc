package TSWTalismans;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class GlyphPool
{
    private ArrayList<Glyph> glyphPool = new ArrayList<Glyph>();

    public GlyphPool()
    {
        LoadFromFile();
    }

    public void AddGlyph(Glyph iGlyph)
    {
        glyphPool.add(iGlyph);
    }

    public void DelGlyph(Glyph iGlyph)
    {
        glyphPool.remove(iGlyph);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Glyph> GetAvailableGlyphs()
    {
        return (ArrayList<Glyph>) glyphPool.clone();
    }

    @SuppressWarnings("unchecked")
    public void LoadFromFile()
    {
        ArrayList<GlyphXMLS> serializableGlyphs;

        try
        {
           FileInputStream fileIn = new FileInputStream("GlyphPool.xml");
           XMLDecoder in = new XMLDecoder(fileIn);
           serializableGlyphs = (ArrayList<GlyphXMLS>) in.readObject();

           glyphPool.clear();
           for(GlyphXMLS serializable : serializableGlyphs)
           {
               Glyph tmp = new Glyph();
               tmp.InitFromSerizlizable(serializable);
               glyphPool.add(tmp);
           }

           in.close();
           fileIn.close();
       }
        catch(IOException i)
       {
           i.printStackTrace();
           glyphPool = new ArrayList<Glyph>();
       }
    }

    public void SaveToFile()
    {
        ArrayList<GlyphXMLS> serializableGlyphs = new ArrayList<GlyphXMLS>();

        for(Glyph glyph : glyphPool)
        {
            serializableGlyphs.add(glyph.GetSerializable());
        }

        try
        {
            FileOutputStream fileOut = new FileOutputStream("GlyphPool.xml");
            XMLEncoder out = new XMLEncoder(fileOut);
            out.writeObject(serializableGlyphs);
            out.close();
            fileOut.close();
        }
        catch(IOException i)
        {
            i.printStackTrace();
        }
    }
}
