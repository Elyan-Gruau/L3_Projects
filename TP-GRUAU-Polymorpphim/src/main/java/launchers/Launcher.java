package launchers;


import java.io.File;
import java.io.IOException;

import shape.IShape;
import svg.SVG;
import svg.reader.SVGReader;

public class Launcher {
	public static void main(String[] args) {
		//Path imagePath = new Path();
		String path = "asset/example.svg";
		SVGReader reader = new SVGReader(new File(path));
		
		SVG svg;
		try {
			svg = reader.readAsSVG();
			//svg.show();
			//Le show ne fonctionne pas.
			System.out.println("Données récupérées");
			for (IShape shape : svg.getShapes()){
				System.out.println(shape);
			}

		} catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
