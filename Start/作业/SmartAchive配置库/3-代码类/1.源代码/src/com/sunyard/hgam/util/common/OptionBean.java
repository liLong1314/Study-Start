package com.sunyard.hgam.util.common;


/**
 * A simple bean for use in testing the <code>&lt;html:options&gt;</code> tag
 * in conjunction with the <code>collection</code> attribute.
 *
 * @author  Martin F N Cooper
 * @version $Revision: 1.1.2.1 $ $Date: 2001/10/15 05:56:22 $
 */

public class OptionBean {


	// ----------------------------------------------------------- Constructors


	/**
	 * Construct an instance with the supplied property values.
	 */
	public OptionBean(String label, String value) {
		this.label = label;
		this.value = value;
	}


	// ------------------------------------------------------------- Properties


	/**
	 * The property which supplies the option label visible to the end user.
	 */
	private String label;

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}


	/**
	 * The property which supplies the value returned to the server.
	 */
	private String value;

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}


}
