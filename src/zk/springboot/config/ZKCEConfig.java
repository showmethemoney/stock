package zk.springboot.config;

import org.zkoss.web.util.resource.ClassWebResource;

@Deprecated
public class ZKCEConfig {
	private static final String UPDATE_URI = "/zkau"; // servlet mapping for ZK's update servlet
	private static final String RICHLET_URI = "/richlet";
	private static final String ZUL_FORWARD_URI = UPDATE_URI + ClassWebResource.PATH_PREFIX + "/zul";

	// forward zul files to update/resource servlet (only for jar deployment)
	// @Controller
	public class ZulForwardController {
		// @RequestMapping(value = "/**/*.zul")
		// public String handleTestRequest(HttpServletRequest request) {
		// return "forward:" + ZUL_FORWARD_URI + request.getServletPath();
		// }
	}

	/*
	 * // original zk layout servlet (only for war files)
	 * 
	 * @Bean public ServletRegistrationBean dHtmlLayoutServlet() {
	 * ServletRegistrationBean reg = new ServletRegistrationBean(new
	 * DHtmlLayoutServlet(), "*.zul");
	 * reg.setInitParameters(Collections.singletonMap("update-uri", UPDATE_URI));
	 * return reg; }
	 */

	// @Bean
	// public ServletRegistrationBean dHtmlUpdateServlet() {
	// return new ServletRegistrationBean(new DHtmlUpdateServlet(), UPDATE_URI +
	// "/*");
	// }

	// optional richlet filter configuration (only needed for richlets)
	// @Bean
	// public FilterRegistrationBean richletFilter() {
	// FilterRegistrationBean reg = new FilterRegistrationBean(new RichletFilter());
	// reg.addUrlPatterns(RICHLET_URI + "/*");
	// return reg;
	// }

	// @Bean
	// public HttpSessionListener httpSessionListener() {
	// return new HttpSessionListener();
	// }
}
