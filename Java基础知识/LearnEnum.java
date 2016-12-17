
//default implements java.lang.Enum class
public enum LearnEnum{
	//enum all possible objects of LearnEnum in this line 
	Spring("Warm"),Summer("Hot"),Autumn("cool"),Winter("Cold");

	private String feature;

	//constructors must be decorated with private
	private LearnEnum(String feature){
		this.feature=feature;
	}

	public String getFeature(){
		return this.feature;
	}

	public static void main(String[] args){
		for(LearnEnum season:LearnEnum.values()){
			System.out.println(season+" is "+season.getFeature());
		}
	}
}