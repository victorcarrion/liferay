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

package com.liferay.taglib.util;

import com.liferay.portal.kernel.servlet.taglib.TagSupport;

import javax.servlet.jsp.JspException;

/**
 * @author Brian Wing Shun Chan
 */
public class PropertyTag extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		PropertyAncestorTag propertyAncestorTag =
			(PropertyAncestorTag)findAncestorWithClass(
				this, PropertyAncestorTag.class);

		if (propertyAncestorTag == null) {
			throw new JspException();
		}

		propertyAncestorTag.addProperty(_name, _value);

		return SKIP_BODY;
	}

	public void setName(String name) {
		_name = name;
	}

	public void setValue(String value) {
		_value = value;
	}

	private String _name;
	private String _value;

}