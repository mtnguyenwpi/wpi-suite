package edu.wpi.cs.wpisuitetng.modules.planningpoker.view;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Loads images given the file name keeping track of loaded images so that they
 * don't need to be loaded multiple times.
 * 
 * @author Akshay
 * 
 */
public class ImageLoader {

	private static final String modifiedPath = "/res/";

	private static HashMap<String, BufferedImage> images;
	
	static {
		images = new HashMap<String, BufferedImage>();
	}

	/**
	 * Returns a BufferedImage loaded from a file
	 * 
	 * @param file
	 * @return
	 */
	public static BufferedImage getImage(String file) {
		BufferedImage bImg = null;
		if (images.containsKey(file)) {
			bImg = images.get(file);
		} else {
			try {
				URL u = ImageLoader.class.getResource(modifiedPath+file);
				System.out.println(u.toString());
				bImg = ImageIO.read(ImageLoader.class.getResource(modifiedPath
						+ file));
				if (bImg != null) {
					images.put(file, bImg);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bImg;
	}

	/**
	 * Returns an ImageIcon loaded from a file
	 * 
	 * @param file
	 *            the file to load from
	 * @return
	 */
	public static ImageIcon getIcon(String file) {
		ImageIcon icon = null;
		BufferedImage image = getImage(file);
		if (image != null) {
			icon = new ImageIcon(image);
		}
		return icon;
	}

}
