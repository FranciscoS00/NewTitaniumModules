/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011-2018 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

/** This code is generated, do not edit by hand. **/

#include "com.francisco.linearacc.LinearaccModule.h"

#include "JSException.h"
#include "TypeConverter.h"




#include "org.appcelerator.kroll.KrollModule.h"

#define TAG "LinearaccModule"

using namespace v8;

namespace com {
namespace francisco {
namespace linearacc {


Persistent<FunctionTemplate> LinearaccModule::proxyTemplate;
Persistent<Object> LinearaccModule::moduleInstance;
jclass LinearaccModule::javaClass = NULL;

LinearaccModule::LinearaccModule() : titanium::Proxy()
{
}

void LinearaccModule::bindProxy(Local<Object> exports, Local<Context> context)
{
	Isolate* isolate = context->GetIsolate();

	Local<FunctionTemplate> pt = getProxyTemplate(isolate);

	v8::TryCatch tryCatch(isolate);
	Local<Function> constructor;
	MaybeLocal<Function> maybeConstructor = pt->GetFunction(context);
	if (!maybeConstructor.ToLocal(&constructor)) {
		titanium::V8Util::fatalException(isolate, tryCatch);
		return;
	}

	Local<String> nameSymbol = NEW_SYMBOL(isolate, "Linearacc"); // use symbol over string for efficiency
	MaybeLocal<Object> maybeInstance = constructor->NewInstance(context);
	Local<Object> instance;
	if (!maybeInstance.ToLocal(&instance)) {
		titanium::V8Util::fatalException(isolate, tryCatch);
		return;
	}
	exports->Set(context, nameSymbol, instance);
	moduleInstance.Reset(isolate, instance);
}

void LinearaccModule::dispose(Isolate* isolate)
{
	LOGD(TAG, "dispose()");
	if (!proxyTemplate.IsEmpty()) {
		proxyTemplate.Reset();
	}
	if (!moduleInstance.IsEmpty()) {
	    moduleInstance.Reset();
	}

	titanium::KrollModule::dispose(isolate);
}

Local<FunctionTemplate> LinearaccModule::getProxyTemplate(v8::Isolate* isolate)
{
	Local<Context> context = isolate->GetCurrentContext();
	if (!proxyTemplate.IsEmpty()) {
		return proxyTemplate.Get(isolate);
	}

	LOGD(TAG, "LinearaccModule::getProxyTemplate()");

	javaClass = titanium::JNIUtil::findClass("com/francisco/linearacc/LinearaccModule");
	EscapableHandleScope scope(isolate);

	// use symbol over string for efficiency
	Local<String> nameSymbol = NEW_SYMBOL(isolate, "Linearacc");

	Local<FunctionTemplate> t = titanium::Proxy::inheritProxyTemplate(
		isolate,
		titanium::KrollModule::getProxyTemplate(isolate),
		javaClass,
		nameSymbol);

	proxyTemplate.Reset(isolate, t);
	t->Set(titanium::Proxy::inheritSymbol.Get(isolate), FunctionTemplate::New(isolate, titanium::Proxy::inherit<LinearaccModule>));

	// Method bindings --------------------------------------------------------

	Local<ObjectTemplate> prototypeTemplate = t->PrototypeTemplate();
	Local<ObjectTemplate> instanceTemplate = t->InstanceTemplate();

	// Delegate indexed property get and set to the Java proxy.
	instanceTemplate->SetIndexedPropertyHandler(titanium::Proxy::getIndexedProperty,
		titanium::Proxy::setIndexedProperty);

	// Constants --------------------------------------------------------------

	// Dynamic properties -----------------------------------------------------

	// Accessors --------------------------------------------------------------

	return scope.Escape(t);
}

Local<FunctionTemplate> LinearaccModule::getProxyTemplate(v8::Local<v8::Context> context)
{
	return getProxyTemplate(context->GetIsolate());
}

// Methods --------------------------------------------------------------------

// Dynamic property accessors -------------------------------------------------


} // linearacc
} // francisco
} // com
