#include<jni.h>
#include<stdio.h>
//#include "TestJni.h"
#include<iostream>
using namespace std;
 void xprint(JNIEnv *env,jobject obj,jstring content)
{  
//	const jbyte *str=(const jbyte*)(env->GetStringUTFChars(env,content,JNI_FALSE));
	//printf("hello--wo%s \n",str);
//	env->ReleaseStringUTFChars(env,content,(const char*)str);
        cout<<"here:"<<content<<endl;
	return;
}
static jstring  native_hello(JNIEnv *env,jobject object)
{ 

	
	return (env)->NewStringUTF("keshixi");
}

static JNINativeMethod method_table[]={
	{ "xprint","(Ljava/lang/String;)V",(void*)xprint},
	{"native_hello","()Ljava/lang/String;",(void*)native_hello}
//    {,,(void*)xprint},{,,(void*)native_hello}
};

 jint JNI_OnLoad(JavaVM *jvm,void *reserved){
	JNIEnv *env;
	if(jvm->GetEnv((void**)&env,JNI_VERSION_1_6)!=JNI_OK){
		return -1;
	}
	jclass clz=env->FindClass("TestJni");
	if(clz==NULL)
	{
		return JNI_FALSE;
	}
	if(env->RegisterNatives(clz,method_table,sizeof(method_table)/sizeof(method_table[0]))==JNI_OK){
		return JNI_VERSION_1_6;
	}
  }


