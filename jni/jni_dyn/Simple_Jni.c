#include <jni.h>
#include<stdio.h>
const char *classPathName="com/bt/jni/SimpleJni";

jint myadd(JNIEnv *env,jobject thiz,jint a,jint b)
{
	return a+b;
}
static JNINativeMethod methods[]={
	{"add","(II)I",(void*)myadd},};
int registerNatives(JNIEnv *env)
{
	jclass clazz;

	clazz=(*env)->FindClass(env,classPathName);
	if(NULL==clazz){
	   printf("[C] FindClass fail\n");
	   goto failed;
	}
	 if (0>(*env)->RegisterNatives(env,clazz,methods,sizeof(methods)/sizeof(methods[0]))){
		 printf("RegisterNatives fail.\n");
		 goto failed;
	 }
	 return JNI_TRUE;
failed:
	 return JNI_FALSE;
}


jint JNI_OnLoad(JavaVM *vm,void *reserved)
{
	JNIEnv *env=NULL;
	jint result=-1;
	void **env_p=NULL;

	printf("start register native func\n");
	env_p=(void**)&env;

	if(JNI_OK!=(*vm)->GetEnv(vm,env_p,0x00010006)){
		printf("get env failed..\n");
		goto err;
	}
	if(JNI_TRUE!=registerNatives(env)){
		printf("register fail...exit....\n");
		goto err;
	}
	result=0x00010006;
err:
	return result;
}
