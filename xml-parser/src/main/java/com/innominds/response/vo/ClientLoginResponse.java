package com.innominds.response.vo;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class ClientLoginResponse implements Serializable {

	private static final long serialVersionUID = 8189179600774039216L;

	private AuthenticationToken authToken;

	@XStreamAlias("x-oasis-meta")
	private Metadata metadata;
	
	

	public AuthenticationToken getAuthToken() {
		return authToken;
	}

	public void setAuthToken(AuthenticationToken authToken) {
		this.authToken = authToken;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

}
