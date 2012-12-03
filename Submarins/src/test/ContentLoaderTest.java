package test;

import static org.junit.Assert.*;

import org.junit.Test;
import Submarines.*;
public class ContentLoaderTest {

	@Test
	public void testLoad() {
		ContentLoader loader = new ContentLoader("Content");
		Sprite rock = loader.Load("rock");
		
	}

}
