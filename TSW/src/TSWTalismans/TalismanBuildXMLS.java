package TSWTalismans;

import java.util.ArrayList;

public class TalismanBuildXMLS
{
	private String name;
	private ArrayList<TalismanXMLS> buildTalismans = new ArrayList<TalismanXMLS>();

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<TalismanXMLS> getBuildTalismans() {
		return buildTalismans;
	}
	public void setBuildTalismans(ArrayList<TalismanXMLS> buildTalismans) {
		this.buildTalismans = buildTalismans;
	}
}
