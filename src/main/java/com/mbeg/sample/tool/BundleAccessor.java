package com.mbeg.sample.tool;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author mbeg
 * 
 */
public class BundleAccessor {

	private static volatile BundleAccessor _instance;

	private transient ResourceBundle resourceBundle;

	private transient ResourceBundle englishBundle;

	/**
	 * private contructor
	 */
	private BundleAccessor() {

	}

	/**
	 * singleton instantiator
	 * 
	 * @return _instance
	 */
	public static BundleAccessor getInstance() {

		if (_instance == null) {
			synchronized (BundleAccessor.class) {
				if (_instance == null) {
					_instance = new BundleAccessor();
				}
			}
		}
		return _instance;
	}

	/**
	 * Init once, use always, should make the getting of resources faster
	 */
	public void initResourceBundles() {

		try {
			resourceBundle = ResourceBundle.getBundle("language/SampleProject",
					Locale.getDefault());
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				resourceBundle = ResourceBundle.getBundle(
						"language/SampleProject", new Locale("en", ""));
			} catch (Exception ex2) {
				ex.printStackTrace();
			}
		}

	}

	/**
	 * @param nm
	 * @return
	 */
	public String getResourceString(final String nm) {

		if (resourceBundle == null || englishBundle == null) {
			initResourceBundles();
		}
		try {
			return resourceBundle.getString(nm);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				return englishBundle.getString(nm);
			} catch (Exception e2) {
				e2.printStackTrace();
				return nm;
			}
		}
	}

}
