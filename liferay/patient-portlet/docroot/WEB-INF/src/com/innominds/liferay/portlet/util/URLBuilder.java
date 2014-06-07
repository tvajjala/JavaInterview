package com.innominds.liferay.portlet.util;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

/**
 * 
 * @author tvajjala this class useful to build renderURL to use it in spring
 *         controllers to move one action to another at server side on success
 */
public class URLBuilder {

	public static PortletURL getRenderURL(ActionRequest actionRequest,
			String paramKey, String paramValue) {
		String portletName = (String) actionRequest
				.getAttribute(WebKeys.PORTLET_ID);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		PortletURL redirectURL = PortletURLFactoryUtil
				.create(PortalUtil.getHttpServletRequest(actionRequest),
						portletName, themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);

		redirectURL.setParameter(paramKey, paramValue);

		System.out.println(" final URL " + redirectURL.toString());
		return redirectURL;
	}

}
