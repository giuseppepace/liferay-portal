/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.portal.kernel.search.util;

import org.junit.Assert;
import org.junit.Test;

import com.liferay.portal.kernel.util.StringBundler;

/**
 * @author Tibor Lipusz
 */
public class SearchUtilTest {

	@Test
	public void testHighlight() throws Exception {
		StringBundler sb = new StringBundler(7); 
		
		sb.append(SearchUtil.HIGHLIGHT_1);
		sb.append("Hello");
		sb.append(SearchUtil.HIGHLIGHT_2);
		sb.append(" World ");
		sb.append(SearchUtil.HIGHLIGHT_1);
		sb.append("Liferay");
		sb.append(SearchUtil.HIGHLIGHT_2);
						
		Assert.assertEquals(
			sb.toString(),
			SearchUtil.highlight(
				"Hello World Liferay", new String[] {"Hello","Liferay"}));
	}

}