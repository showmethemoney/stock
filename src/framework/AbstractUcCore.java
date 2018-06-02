package framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import framework.login.LCLoginRecord;
import framework.login.UC_ADM_LO_USERLOGIN;
import framework.login.UC_TOOL_FT_VOCABULARYFREEUPDATE;

public abstract class AbstractUcCore {

	public static final Logger logger = LoggerFactory.getLogger(AbstractUcCore.class);

	public LCLoginRecord login() {
		LCLoginRecord result = null;

		try {
			if (null == result) {
				result = new LCLoginRecord();

				result.setTargetpassword("");
				result.setUsername("R14");
				result.setPassword("lancer123");
				result.setTargetIP("140.136.155.8:1299");
				result.setTenant("007_CERPS_SOLOMO");

				logger.info("{}", new UC_ADM_LO_USERLOGIN().isAllowed(result));

				result.loginSuccess("127.0.0.1");

				new UC_TOOL_FT_VOCABULARYFREEUPDATE().QRYVOCABULARYFREEUPDATE(result);
			}
		} catch (Throwable cause) {
			logger.error(cause.getMessage(), cause);
		}

		return result;
	}

}
