
public class Card 
{
	public static enum Type
	{
		WEAPON,
		EQUIPMENT,
		SPELL, 
		POTION
	}
	private Type type;
	private String name;
	private int iD;
	private int damage;
	// private SpecialAffect sA;
	private int level; 
	// private Actions actions;
	private int manaCost;
	private String description;
	
	
	
	public Card(Type type, String name, int iD, int damage, int level, int manaCost, String description) 
	{
		super();
		this.type = type;
		this.name = name;
		this.iD = iD;
		this.damage = damage;
		this.level = level;
		this.manaCost = manaCost;
		this.description = description;
	}



}
