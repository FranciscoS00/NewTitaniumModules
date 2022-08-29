/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2018 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package com.francisco.linearacc;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.KrollRuntime;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.util.TiSensorHelper;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;


@Kroll.module(name="Linearacc", id="com.francisco.linearacc")
public class LinearaccModule extends KrollModule implements SensorEventListener
{

	private static final String EVENT_UPDATE = "update";

	// Used by TYPE_ACCELEROMETER
	private boolean accelerometerRegistered = false;
	private long lastSensorEventTimestamp = 0;

	private float[] accellerometerValues = null;
	float[] gravity = new float[3];


	public LinearaccModule()
	{
		super();

		// Set up a listener to be invoked when the JavaScript runtime is about to be terminated/disposed.
		KrollRuntime.addOnDisposingListener(new KrollRuntime.OnDisposingListener() {
			@Override
			public void onDisposing(KrollRuntime runtime)
			{
				// Remove this listener from the runtime's static collection.
				KrollRuntime.removeOnDisposingListener(this);

				// Unregister the sensor listener.
				if (accelerometerRegistered) {
					TiSensorHelper.unregisterListener(Sensor.TYPE_LINEAR_ACCELERATION, LinearaccModule.this);
					accelerometerRegistered = false;
				}
			}
		});
	}

	@Override
	public void eventListenerAdded(String type, int count, final KrollProxy proxy)
	{
		if (!accelerometerRegistered) {
			if (EVENT_UPDATE.equals(type)) {
				TiSensorHelper.registerListener(Sensor.TYPE_LINEAR_ACCELERATION, this, SensorManager.SENSOR_DELAY_UI);
				accelerometerRegistered = true;
			}
		super.eventListenerAdded(type, count, proxy);
		}
	}

	@Override
	public void eventListenerRemoved(String type, int count, KrollProxy proxy)
	{
		if (accelerometerRegistered) {
			if (EVENT_UPDATE.equals(type)) {
				TiSensorHelper.unregisterListener(Sensor.TYPE_LINEAR_ACCELERATION, this);
				accelerometerRegistered = false;
			}
		super.eventListenerRemoved(type, count, proxy);
		}

	}

	public void onAccuracyChanged(Sensor sensor, int accuracy)
	{
	}

	@SuppressWarnings("deprecation") 
	public void onSensorChanged(SensorEvent event)
	{

		if (event.timestamp - lastSensorEventTimestamp > 100) {
			lastSensorEventTimestamp = event.timestamp;
			
			KrollDict data = new KrollDict();
			data.put("type", EVENT_UPDATE);
			data.put("timestamp", lastSensorEventTimestamp);
			data.put("linearacc", event.values);

			fireEvent(EVENT_UPDATE, data);
		}
	}


	@Override
	public String getApiName()
	{
		return "Francisco.LinearaccModule";
	}

	/**
	* Francisco's linear acc
	*
	*/

}

