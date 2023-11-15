package svg.tag;

public enum ETagType {
	svg("svg",false),
	rect("rect",false),
	description("desc",false),
	polygon("polygon",true),
	comment("!--",false),
	doctype("!DOCTYPE",false),
	xml("?xml",false);
	
	private String value;
	private boolean displayable; 
	
	private ETagType(String stringValue, boolean displayable) {
		this.value = stringValue;
		this.displayable = displayable;
	}
	
	public static ETagType getTypeByString(String text) {
		for (ETagType type : ETagType.values()) {
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
