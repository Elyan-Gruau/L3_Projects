package svg.reader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import svg.SVG;
import svg.tag.Tag;
import svg.tag.ETagType;
import svg.polygone.model.Polygone;

public class SVGReader {
	private File imageFile ;
	private String imageString;
	private SVG svg;
	
	public SVGReader(File file) {
		assert file != null: "file is null";
		assert file.exists(): "file not found";
		assert file.isFile() :"file is not a file";
		this.imageFile = file;
		try {
			this.svg = readAsSVG();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public SVGReader(String string) {
		this.imageFile = null;
		this.imageString = string;
		try {
			this.svg = readAsSVG();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String readAsString()  throws IOException {		
		byte[] encoded = Files.readAllBytes(Paths.get(imageFile.getAbsolutePath()));
		this.imageString =  new String(encoded, Charset.defaultCharset());
		return imageString;			
	}

	public SVG readAsSVG() throws IOException {
		if (imageString == null || imageString.isEmpty()) {
			readAsString();
		}
		
		this.svg = new SVG(imageString);
		return svg;
	}

	public int compteBalises() {
		return svg.getBalises().size();
	}

	public String[] retourneBalises() {
		ArrayList<Tag> tags = svg.getBalises();
		String[] results = new String[tags.size()];
		for (int i = 0; i< tags.size(); i++) {
			results[i] = tags.get(i).getText();
		}
		return results;
	}

	public String[] retourneVraiesBalises() {
		ArrayList<Tag> tags = svg.getDisplayableTags();
		String[] results = new String[tags.size()];
		for (int i = 0; i< tags.size(); i++) {
			results[i] = tags.get(i).getText();
		}
		return results;
	}

	public String[] retournePolygones() {
		// TODO Auto-generated method 
		ArrayList<Tag> tags = svg.getTagsByType(ETagType.polygon);
		String[] results = new String[tags.size()];
		for (int i = 0; i< tags.size(); i++) {
			Tag tag = tags.get(i);
			if( tag.getType() == ETagType.polygon) {
				results[i] = tag.getText();
			}
		}
		return results;
	}

	public static Polygone buildPolygon(String string) {
		return  new Polygone(new Tag(string));
	}
	

	
	
	
	
}
