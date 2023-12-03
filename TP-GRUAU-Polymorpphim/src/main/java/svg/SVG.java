package svg;

import java.util.ArrayDeque;
import java.util.ArrayList;

import svg.polygone.model.Polygone;
import shape.IShape;
import svg.tag.Tag;
import svg.tag.ETagType;

public class SVG {
	private int width;
	private int height;
	private String xmlVerison;
	private ArrayList<Tag> tags;
	private ArrayList<IShape> shapes;
	
	
	public SVG(String xml ) {
		assert isXMLCorrect(xml) : "le XML n'est pas correct.";

		this.shapes = new ArrayList<>();
		this.tags = new ArrayList<>();
	    for (String tagString : parse(xml)) {
	        //System.out.println("Balise XML ou contenu : " + tagString);
	    	String trimmedTag = tagString.trim();
	    	
	    	Tag tag = new Tag(tagString);
	    	if (!tag.isEnd()) {
	    		tags.add(tag);
				if (tag.isDisplayable()){
					tag.toShape();
				}

	    	}
	    }

		//Getting infos about the SVG
		Tag svgTag = findBaliseByType(ETagType.svg);
	    String viewBox = svgTag.getAttribute("viewBox");
	    String[] splitViewBox = viewBox.split(" ");
	    this.width = Integer.parseInt(splitViewBox[2]) ;
	    this.height = Integer.parseInt(splitViewBox[3]) ;
	    
	    //System.out.println(viewBox);
	    
	    
	    for (Tag b: tags) {
	    	System.out.println(b.getText());
	    }
	}
	

	
	private boolean isXMLCorrect(String xml) {
		int oppening = 0;
		int closing = 0;
		for (char c: xml.toCharArray()) {
			if (c == '<') {
				oppening += 1;
			}else if(c == '>'){
				closing += 1;
			}
		}
		return oppening == closing;
	}
	
	private ArrayList<String> parse(String xml) {
		 ArrayList<String> tagList = new ArrayList<>();
		    StringBuilder currentTag = new StringBuilder();
		    boolean insideTag = false; 

		    ArrayDeque<String> tagStack = new ArrayDeque<>(); //Used for open tag

		    for (char c : xml.toCharArray()) {
		        if (c == '<') {
		            if (insideTag) {//Inside an embeded tag
		                currentTag.append(c);
		            } else { // New tag is starting
		                currentTag = new StringBuilder();
		                currentTag.append(c);
		                insideTag = true;
		            }
		        } else if (c == '>') {
		            if (insideTag) { // End of a tag
		                currentTag.append(c);
		                insideTag = false;
		                String tag = currentTag.toString();
		                if (!tagStack.isEmpty() && tag.startsWith("</" + tagStack.peek())) { //Closing tag corresponding to a tag on top a the stack (Deque)
		                    String openedTag = tagStack.pop();
		                    // Extracting the content
		                    String content = tagList.get(tagList.size() - 1);
		                    tagList.set(tagList.size() - 1, openedTag + content + tag);
		                } else { // Opening tag
		                  
		                    tagStack.push(tag.substring(1, tag.length() - 1));
		                    tagList.add(tag);
		                }
		            }
		        } else if (insideTag) {//Inside of a tag
		           
		            currentTag.append(c);
		        } else if (!tagList.isEmpty()) { // Exterior of a tag
		            String lastTag = tagList.get(tagList.size() - 1);
		            tagList.set(tagList.size() - 1, lastTag + c);
		        }
		    }
		    return tagList;
	}
	
	
	
	public void show() {
		System.out.println("DISPLAYING");
		System.out.println("width :"+width);
		System.out.println("height :"+height);
		 //new frame.FrameHelper(width, height).draw(g -> {
		//		//cabV1.show(g);
		//	ArrayList<Polygone> polygones = new ArrayList<Polygone>();
			
			for(Tag tag : tags) {
				if (!tag.getType().isDisplayble()) continue;
				
				Polygone polygone = new Polygone(tag);
			//	DessinePolygone.drawPolygone(g, polygone);
			}
			 
		 //});
	}
	
	public Tag findBaliseByName(String name) {
		for (Tag tag : tags) {
			if (tag.getName().equals(name)) {
				return tag;
			}
		}
		return null;
	}
	
	public Tag findBaliseByType(ETagType type) {
		for (Tag tag : tags) {
			if (tag.getType() == type) {
				return tag;
			}
		}
		return null;
	}
	
	public ArrayList<Tag> getBalises(){
		return tags;
	}
	
	public int countTagOfType(ETagType type) {
		int counter = 0;
		for (Tag tag : tags) {
			if (tag.getType() ==type ) {
				counter ++;
			}
		}
		return counter;
	}
	
	public ArrayList<Tag> getDisplayableTags(){
		ArrayList<Tag> results = new ArrayList<Tag>() ;
		for (Tag tag : tags) {
			if (tag.getType().isDisplayble()) {
				results.add(tag);
			}
		}
		return results;
	}
	
	public ArrayList<Tag> getTagsByType(ETagType type){
		ArrayList<Tag> results = new ArrayList<Tag>() ;
		for (Tag tag : tags) {
			if (tag.getType() == type) {
				results.add(tag);
			}
		}
		return results;
	}


}
