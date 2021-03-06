/*
 * Copyright 2006-2011 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.springframework.security.oauth2.provider.approval;

import java.util.HashMap;

import org.junit.Test;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.oauth2.provider.DefaultAuthorizationRequest;

/**
 * @author Dave Syer
 * 
 */
public class TestDefaultUserApprovalHandler {

	private DefaultUserApprovalHandler handler = new DefaultUserApprovalHandler();

	@Test
	public void testBasicApproval() {
		DefaultAuthorizationRequest request =new DefaultAuthorizationRequest(new HashMap<String, String>());
		request.setApproved(true);
		handler.isApproved(request , new TestAuthentication("marissa", true));
	}

	protected static class TestAuthentication extends AbstractAuthenticationToken {
		private String principal;

		public TestAuthentication(String name, boolean authenticated) {
			super(null);
			setAuthenticated(authenticated);
			this.principal = name;
		}

		public Object getCredentials() {
			return null;
		}

		public Object getPrincipal() {
			return this.principal;
		}
	}

}
