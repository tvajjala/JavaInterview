package com.loginhook;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.LastPath;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;

/**
 * 
 * @author ThirupathiReddy
 * 
 */

public class CustomLoginPostAction extends Action {
	private static Log _log = LogFactoryUtil
			.getLog(CustomLoginPostAction.class);

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response)
			throws ActionException {
		try {
			User user = PortalUtil.getUser(request);

			List<Role> roles = user.getRoles();

			for (Iterator<Role> iterator = roles.iterator(); iterator.hasNext();) {
				Role role = iterator.next();
				_log.info(role.getName());
			}

			LastPath lastPath = new LastPath(StringPool.BLANK, "/dashboard",
					new HashMap<String, String[]>());
			HttpSession session = request.getSession();
			session.setAttribute("LAST_PATH", lastPath);
			_log.debug("user redirected to the page " + lastPath);

		} catch (Exception e) {
			_log.error("Exception in napier login hook " + e);
		}

	}
}
