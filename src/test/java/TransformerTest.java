import java.awt.Rectangle;

import org.stavros.json.Transformer;

import junit.framework.TestCase;


public class TransformerTest extends TestCase {
	
	public void testString() {
		System.out.println(Transformer.toJson("Hello world"));
		
		System.out.println(Transformer.toJson(1L));
		
		System.out.println(Transformer.toJson(new Rectangle(11,12,13,14)));
	}

}
