package svg;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

import svg.balise.Balise;
import svg.balise.EBaliseType;
import svg.polygone.model.Polygone;
import svg.polygone.view.DessinePolygone;

public class SVG {
	private int width;
	private int height;
	private String xmlVerison;
	private ArrayList<Balise> balises;
	
	
	public SVG(String xml ) {
		assert isXMLCorrect(xml) : "le XML n'est pas correct.";
	    
	    this.balises = new ArrayList<>();
	    for (String tag : parse(xml)) {
	        //System.out.println("Balise XML ou contenu : " + tag);
	    	String trimmedTag = tag.trim();
	    	
	    	Balise balise = new Balise(tag);
	    	if (!balise.isEnd()) {
	    		balises.add(balise);
	    	}
	    	
	    
	    }
	    Balise svgBalise = findBaliseByType(EBaliseType.svg);
	    
	    
	    String viewBox = svgBalise.getAttribute("viewBox");
	    String[] splitViewBox = viewBox.split(" ");
	    this.width = Integer.parseInt(splitViewBox[2]) ;
	    this.height = Integer.parseInt(splitViewBox[3]) ;
	    
	    //System.out.println(viewBox);
	    
	    
	    for (Balise b:balises) {
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
		 new frame.FrameHelper(width, height).draw(g -> {
				//cabV1.show(g);
			ArrayList<Polygone> polygones = new ArrayList<Polygone>();
			
			for(Balise balise: balises) {
				if (!balise.getType().isDisplayble()) continue;
				
				Polygone polygone = new Polygone(balise);
				DessinePolygone.drawPolygone(g, polygone);
			}
			 
		 });
	}
	
	public Balise findBaliseByName(String name) {
		for (Balise balise:balises) {
			if (balise.getName().equals(name)) {
				return balise;
			}
		}
		return null;
	}
	
	public Balise findBaliseByType(EBaliseType type) {
		for (Balise balise:balises) {
			if (balise.getType() == type) {
				return balise;
			}
		}
		return null;
	}
	
	public ArrayList<Balise> getBalises(){
		return balises;
	}
	
	public int countTagOfType(EBaliseType type) {
		int counter = 0;
		for (Balise balise:balises) {
			if (balise.getType() ==type ) {
				counter ++;
			}
		}
		return counter;
	}
	
	public ArrayList<Balise> getDisplayableTags(){
		ArrayList<Balise> results = new ArrayList<Balise>() ;
		for (Balise balise: balises) {
			if (balise.getType().isDisplayble()) {
				results.add(balise);
			}
		}
		return results;
	}
	
	public ArrayList<Balise> getTagsByType(EBaliseType type){
		ArrayList<Balise> results = new ArrayList<Balise>() ;
		for (Balise balise: balises) {
			if (balise.getType() == type) {
				results.add(balise);
			}
		}
		return results;
	}


}
