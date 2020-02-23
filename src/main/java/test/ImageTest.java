package test;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by makang on 2020/2/20.
 */
public class ImageTest {

    @Test
    void test()throws Exception{

//        BufferedImage image = ImageIO.read(new File("C:/idea/1.jpg"));
//        assertNotNull(image);
        BufferedImage images = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/1.gif"));
        assertNotNull(images);

    }
}
