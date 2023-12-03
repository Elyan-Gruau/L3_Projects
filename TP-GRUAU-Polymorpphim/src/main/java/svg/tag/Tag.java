package svg.tag;

import shape.IShape;
import shape.exception.NoMatchingShapeConstructorException;
import shape.exception.NoMatchingShapeException;
import shape.utils.ESVGShape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tag {
	private String text;
	private String name;
	private HashMap<String,String> attributes;
	private ETagType type;
	private boolean isEnd; 
	
	public Tag(String text) {
		assert text != null && !text.isBlank() : "le texte donné est vide.";
		this.text = text;
		System.out.println(text);
		
		
		isEnd = text.trim().substring(0,5).contains("/");
		
	
        type = extractType(text);
        name = type.toString();
		
		attributes = parseAttributes();
	}
	
	
	private ETagType extractType(String text) {
		for(ETagType type: ETagType.values()) {
			int length = text.length() < 10 ? text.length() : 10; 
			
			if (text.substring(0,length).contains(type.getValue())) {
				return type;
			}
		}
		return null;
	}
	
	public static ArrayList<Tag> parse(String text) {
		ArrayList<Tag> result = new ArrayList<>();
		String[] split = text.split("<.*?>");
		for (String s:split) {
			result.add(new Tag(s));
			
		}
		return result;
	}
	
	private HashMap<String,String> parseAttributes(){
		HashMap<String,String> result = new HashMap<>();
		
		//Attribut
        Pattern pattern = Pattern.compile("\\s(\\w+)=\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            String attributeName = matcher.group(1);
            String attributeValue = matcher.group(2);
            result.put(attributeName, attributeValue);
        }
		return result;
	}
	
	
	public boolean constainsAttribute(String search) {
		for (String attribute: attributes.keySet()) {
			if (attribute.equals(search)) {
				return true;
			}
		}
		return false;
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getAttribute(String key) {
		return attributes.get(key);
	}
	
	public String getText() {
		return text;
	}


	public ETagType getType() {
		return type;
	}
	
	public void displayAttributes() {
		if(attributes.isEmpty()) {
			System.out.println("No attributes");
		}
		else {
			for (String key : attributes.keySet()) {
				System.out.println(key+":"+attributes.get(key));
			}
		}

	}
	
	public boolean isEnd() {
		return isEnd;
	}


	public Set<String> getAttributeKeys() {
		return attributes.keySet();
	}


	public IShape toShape() {
		ESVGShape shapeClass = null;
		try {
			shapeClass = ESVGShape.getValueOf(this.getType().toString());
			return shapeClass.createShapeInstance(attributes);
		} catch (NoMatchingShapeException | IllegalAccessException | InstantiationException |
				 NoMatchingShapeConstructorException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean isDisplayable() {
		return type.isDisplayble();
	}
}
