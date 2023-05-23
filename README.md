# LikeMinds-Android-Feed-SDK

The LikeMinds Android Feed SDK empowers you to integrate personalized and engaging feeds into your Android application, enhancing user experiences and driving user engagement. The detailed guide for Feed-SDK is available [here](https://docs.likeminds.community/category/feed).

## Getting started

### 1. Add Dependency

Implement the LikeMinds Feed SDK dependency to setup the Feed SDK. 
1. Add Jitpack Maven Repository in your root level `build.gradle` file

```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

2. Add the dependency in app level `build.gradle` file

```groovy
dependencies {
	...
	implementation 'com.github.NateshR.LikeMinds-Android-Feed-SDK:likemindsfeed:v1.2.0'
}
```
