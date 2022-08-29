/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2019 by Axway, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 * Warning: This file is GENERATED, and should not be modified
 */
package com.francisco.magnetometer;

import org.appcelerator.kroll.common.KrollSourceCodeProvider;
import org.appcelerator.kroll.util.KrollAssetHelper;

public class CommonJsSourceProvider implements KrollSourceCodeProvider
{
	public String getSourceCode()
	{
		return getSourceCode("com.francisco.magnetometer");
	}

	public String getSourceCode(String module)
	{
		if (module.equals("${moduleid}/com.francisco.magnetometer")) {
			module = "com.francisco.magnetometer";
		}

		return KrollAssetHelper.readAsset("Resources/com.francisco.magnetometer/" + module + ".js");
	}
}
