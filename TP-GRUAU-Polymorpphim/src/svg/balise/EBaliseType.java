package svg.balise;

public enum EBaliseType {	
	svg("svg",false),
	rect("rect",false),
	description("desc",false),
	polygon("polygon",true),
	comment("!--",false),
	doctype("!DOCTYPE",false),
	xml("?xml",false);
	
	private String value;
	private boolean displayable; 
	
	private EBaliseType(String stringValue, boolean displayable) {
		this.value = stringValue;
		this.displayable = displayable;
	}
	
	public static EBaliseType getTypeByString(String text) {
		for (EBaliseType type : EBaliseType.values()) {
			if (type.getValue().equals(text)) {
				return type;
			}
		}
		return null;
	}
	
	public String getValue() {
		return value;
	}
	
	public boolean isDisplayble() {
		return displayable;
	}
}
