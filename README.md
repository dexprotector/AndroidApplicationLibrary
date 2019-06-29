DexProtector (https://dexprotector.com) is one of the **pioneers** in **mobile application and library shielding**. It protects and obfuscates Android and iOS applications and libraries. Our solution helps you to secure your code and assets against unauthorized or illegal use, tampering, reverse engineering, and cracking.

# AndroidApplicationLibrary
 This sample is to demonstrate how the AAR protection works
## Description
https://dexprotector.com/docs#aar-protection

## Requirements
- Android Studio or Gradle
- NDK
- DexProtector Enterpise with a valid license

## Configuring 
- Set path to Android SDK in local.properties
- Set path to DexProtector Enterprise in build.gradle (project’s root) instead of `/Users/developer/DexProtector`

## Building

### Building Sample Android Application Library
```
cd AndroidApplicationLibrary/SampleLibrary/lib
<ndk-dir>/ndk-build
../gradlew clean assembleRelease
cp build/outputs/aar/lib-release.aar ../../SampleApp/app/libs/lib-release.aar
```
### Building Sample APK
```
cd AndroidApplicationLibrary/SampleApp/app
../gradlew clean assembleRelease
```

## Evaluating
```
adb install -r build/outputs/apk/app-release.apk
adb shell am start -n com.dexprotector.aar.app/.MainActivity
```

When the Sample application is started the following protection features are demonstrated:

- Initialization and use of the library’s methods that are protected with
 * String Encryption
 * Hide Access
 * Class Encryption
 * Resource Encryption (available only for files from assets)
 * JNI Obfuscation
 * Native Library Encryption
- Use of the Environment checks and device attestation

Corresponding messages will be displayed on a screen.
