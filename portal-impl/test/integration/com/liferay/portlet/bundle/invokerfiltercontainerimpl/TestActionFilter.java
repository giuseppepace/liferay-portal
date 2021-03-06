/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.bundle.invokerfiltercontainerimpl;

import java.util.concurrent.atomic.AtomicBoolean;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.filter.ActionFilter;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.PortletFilter;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Philip Jones
 * @author Peter Fellwock
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=InvokerFilterContainerImplTest",
		"preinitialized.filter=false",
		"service.ranking:Integer=" + Integer.MAX_VALUE
	},
	service = PortletFilter.class
)
public class TestActionFilter implements ActionFilter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(
		ActionRequest actionRequest, ActionResponse actionResponse,
		FilterChain filterChain) {
	}

	@Override
	public void init(FilterConfig filterConfig) {
		_atomicBoolean.set(Boolean.TRUE);
	}

	@Reference(target = "(test=AtomicState)")
	protected void setAtomicBoolean(AtomicBoolean atomicBoolean) {
		_atomicBoolean = atomicBoolean;
	}

	private AtomicBoolean _atomicBoolean;

}