package launchers;


import java.io.File;
import java.io.IOException;

import shape.IShape;
import shape.exception.NoMatchingShapeConstructorException;
import shape.exception.NoMatchingShapeException;
import svg.SVG;
import shape.utils.ESVGShape;
import svg.reader.SVGReader;
import svg.vector.Vector;

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
			System.out.println("666666666666666666666666666666666");
			for (IShape shape : svg.getShapes()){
				System.out.println(shape);
			}



			
		} catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
