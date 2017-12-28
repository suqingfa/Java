#include "HelloNative.h"

static jchar* table[] =
{
	(jchar*)"abc",
	(jchar*)"bcd",
	(jchar*)"def"
};

/*
* Class:     jni_HelloNative
* Method:    greeting
* Signature: (I)Ljava/lang/String;
*/
JNIEXPORT jstring JNICALL Java_jni_HelloNative_getString__I
(JNIEnv * env, jobject inst, jint index)
{
	if (index < 0 || index >= sizeof(table))
	{
		return env->NewString(nullptr, 0);
	}

	return env->NewString(table[index], 3);
}

/*
* Class:     jni_HelloNative
* Method:    greeting
* Signature: ()Ljava/lang/String;
*/
JNIEXPORT jstring JNICALL Java_jni_HelloNative_getString__
(JNIEnv * env, jobject inst)
{
	return Java_jni_HelloNative_greeting__I(env, inst, 0);
}