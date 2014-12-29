package net.atos.kawwaportal.components.components;

import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

/**
 * <p>
 * 		This Component is used to generate a GMap
 * </p>
 * <p>
 * 		To use it, call the component as the following:
 * 		<br/>
 * 		"&lt;div t:type="kawwa2/GMap" t:parameter="&lt;&lt;1&gt;&gt;" /&gt;"
 *		<br/><br/>
 *		The fields can be filled with:
 *		<ul>
 *			<li>&lt;&lt;1&gt;&gt; : An array of JSON objects to configure the gmap3 according to the functionnalities of the jquery plugin "gmap3"</li>
 *		</ul>
 * </p>
 * @tapestrydoc
 * @deprecated This component will be removed in a future version compatible with Tapestry 5.4. We will use the component available in Tapestry5-jQuery
 */

public class GMap implements ClientElement {
	
	@Parameter
	@Property
	private JSONObject parameters;
	
	@Property
	private String id;
		
	@Inject
	private JavaScriptSupport javaScriptSupport;
	
	@Inject
    private ComponentResources resources;
	
	@BeginRender
	public void beginRender() {
		id = javaScriptSupport.allocateClientId(resources);
	}
	
	@AfterRender
	public void afterRender() {

		if(parameters == null) parameters = new JSONObject();
	    JSONObject opt = new JSONObject();
	    opt.put("id", id);
	    opt.put("params", parameters);
		javaScriptSupport.require("kawwa/GMap").with(opt);
	}

	public String getClientId() {
		return id;
	}
}
