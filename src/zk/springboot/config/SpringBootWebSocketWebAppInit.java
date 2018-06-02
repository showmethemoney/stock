package zk.springboot.config;

import org.zkoss.zk.ui.WebApp;
import org.zkoss.zk.ui.util.WebAppInit;

/**
 * obsolete after ZK-3799 is implemented (8.5.1 ?)
 */
@Deprecated
public class SpringBootWebSocketWebAppInit implements WebAppInit {

    public void init(WebApp wapp) throws Exception {
//        String url = getWebSocketUrl();
//
//        wapp.setAttribute("websocketUrl", url);
//        ServerEndpointConfig config = ServerEndpointConfig.Builder.create(WebSocketEndPoint.class, url).configurator(new ZKWebSocket()).build();
//        ServerContainer serverContainer = (ServerContainer) wapp.getServletContext().getAttribute("javax.websocket.server.ServerContainer");
//        serverContainer.addEndpoint(config);
//        wapp.getConfiguration().addListener(WebSocketDesktopInit.class);
    }

    public static String getWebSocketUrl() {
		// String url =
		// Library.getProperty("org.zkoss.zkmax.au.websocket.WebSocketEndPoint.urlPattern");
		// if (url == null) {
		// url = "/zkwm";
		// } else if (url.endsWith("/")) {
		// url = url.substring(0, url.length() - 1);
		// }
		//  return url;
    	return "";
    }
}
