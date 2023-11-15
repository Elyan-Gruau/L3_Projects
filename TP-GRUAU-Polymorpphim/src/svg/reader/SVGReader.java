package svg.reader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import svg.SVG;
import svg.balise.Balise;
import svg.balise.EBaliseType;
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
		ArrayList<Balise> balises = svg.getBalises();
		String[] results = new String[balises.size()];
		for (int i = 0 ; i<balises.size();i++) {
			results[i] = balises.get(i).getText();
		}
		return results;
	}

	public String[] retourneVraiesBalises() {
		ArrayList<Balise> balises = svg.getDisplayableTags();
		String[] results = new String[balises.size()];
		for (int i = 0 ; i<balises.size();i++) {			
			results[i] = balises.get(i).getText();	
		}
		return results;
	}

	public String[] retournePolygones() {
		// TODO Auto-generated method 
		ArrayList<Balise> balises = svg.getTagsByType(EBaliseType.polygon);
		String[] results = new String[balises.size()];
		for (int i = 0 ; i<balises.size();i++) {
			Balise balise = balises.get(i);
			if( balise.getType() == EBaliseType.polygon) {
				results[i] = balise.getText();	
			}
		}
		return results;
	}

	public static Polygone buildPolygon(String string) {
		return  new Polygone(new Balise(string));
	}
	

	
	
	
	
}
