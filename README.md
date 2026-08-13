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

### 2. Initiate LikeMinds Feed SDK
Now pass the following parameters to the `LMFeedClient` and create it in your Application class `onCreate()`.

| VARIABLE   		| DESCRIPTION                                        |
| ----------------- | -------------------------------------------------- |
| application      	| Context of your application. 			             |
| lmCallback  		| Used to implement the `LMCallback` interface.   	 |

#### Create the `client` object by passing the parameters to the `Builder`. You will use this client throughout your Android application to call various functions to fetch data.

```kotlin
val client = LMFeedClient.Builder(application) //Application context
        .lmCallback(LMCallback) 
        .build()
```

### LMCallback

```kotlin
interface LMCallback {
	// This method is called when the user is not logged in or guest
  	// It is called when the user tries to perform an action that requires login
  	// The user should be redirected to your appropriate login screen
    fun login() {}
}
```

## License

Licensed under the Apache License, Version 2.0. See [LICENSE](LICENSE) for details.
