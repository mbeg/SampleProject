package com.mbeg.sample.tool;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.WeakHashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * @author mbeg
 */
public class ResourceAccessor {

	private static volatile ResourceAccessor _instance;

	private final String ROOT_DIR = "/"; // Appending this to all incoming url
											// sets the path relative to the
											// root of the project/jar

	private final Map<String, ImageIcon> iconCache = new WeakHashMap<String, ImageIcon>();

	/**
	 * 
	 */
	private ResourceAccessor() {

	}

	/**
	 * singleton instantiator
	 * 
	 * @return _instance
	 */
	public static ResourceAccessor getInstance() {

		if (_instance == null) {
			synchronized (ResourceAccessor.class) {
				if (_instance == null) {
					_instance = new ResourceAccessor();
				}
			}
		}
		return _instance;
	}

	/**
	 * Get any of the local resources as a stream
	 * 
	 * @param url
	 * @return
	 */
	public InputStream getResourceAsStream(String url) {

		return ResourceAccessor.class.getResourceAsStream(ROOT_DIR + url);
	}

	/**
	 * This code is used to load the images used by our class. If an image has
	 * already been accessed it may be cached, so look in the cache first. If
	 * it's not in the cache, load it from the disk.
	 */
	public ImageIcon loadImage(final String relUri) {

		ImageIcon cachedItem = iconCache.get(ROOT_DIR + relUri);
		if (cachedItem == null) {
			final ImageIcon imageIcon;
			try {
				java.net.URL imgURL = ResourceAccessor.class
						.getResource(ROOT_DIR + relUri);
				imageIcon = new ImageIcon(ImageIO.read(imgURL));
				iconCache.put(ROOT_DIR + relUri, imageIcon);
				return imageIcon;
			} catch (Exception e) {
				try {
					return new ImageIcon(ImageIO.read(ResourceAccessor.class
							.getResource(ROOT_DIR + "icons/logo32.gif")));
				} catch (Exception ex2) {
					return null;
				}
			}
		}
		return cachedItem;
	}

	/**
	 * @param url
	 * @return
	 */
	public BufferedImage loadBufferedImage(final String url) {

		try {
			return ImageIO.read(ResourceAccessor.class.getResource(ROOT_DIR
					+ url));
		} catch (IOException e) {
			try {
				return ImageIO.read(ResourceAccessor.class.getResource(ROOT_DIR
						+ "icons/logo32.gif"));
			} catch (IOException e1) {
			}
		}
		return null;
	}

	/**
	 * Loads a properties file
	 * 
	 * @param path
	 * @return
	 */
	public Properties getProperties(String path) {

		Properties props = new Properties();
		try {
			props.load(getResourceAsStream(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return props;
	}

}
