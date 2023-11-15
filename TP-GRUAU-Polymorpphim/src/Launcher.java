import java.io.File;

import shape.utils.ShapeEnum;
import shape.IShape;
import shape.exception.NoMatchingShapeConstructorException;
import svg.reader.SVGReader;
import svg.SVG;
import svg.vector.Vector;

public class Launcher {
	public static void main(String[] args) {
		//Path imagePath = new Path();
		String path = "asset/example.svg";
		SVGReader reader = new SVGReader(new File(path));
		
		SVG svg;
		try {
//			svg = reader.readAsSVG();
			//svg.show();
			//Le show ne fonctionne pas.
			ShapeEnum shapeClass = ShapeEnum.getValueOf("circle");
            assert shapeClass != null : "La valeur n'à pas été trouvée.";

			double radius = 8;
			IShape shape = shapeClass.createShapeInstance(new Vector(255,255),radius);



			System.out.println(shape.getSuperficy());
			
		} catch (InstantiationException | IllegalAccessException | NoMatchingShapeConstructorException e) {
            throw new RuntimeException(e);
        }


	}
}
