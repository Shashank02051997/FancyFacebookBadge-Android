# FancyFacebookBadge-Android
[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg?style=plastic)](https://android-arsenal.com/api?level=19)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![](https://jitpack.io/v/Shashank02051997/FancyFacebookBadge-Android.svg)](https://jitpack.io/#Shashank02051997/FancyFacebookBadge-Android)

<a href="https://play.google.com/store/apps/details?id=com.shashank.sony.fancylibrarybyshashank">
    <img alt="Get it on Google Play"
        height="80"
        src="https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png" />
</a>

## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	implementation 'com.github.Shashank02051997:FancyFacebookBadge-Android:1.6'
}
```
# Fancy Facebook Badge
Fancy Facebook Badge library for android makes you add bades to the text or image.

<img src="https://github.com/Shashank02051997/FancyFacebookBadge-Android/blob/master/Screenshot/20180123_151014.gif" height="420" width="240">

# Usage

First of all, need add FacebookBadge to your xml layout.

```xml
<com.shashank.sony.fancyfacebookbadgelib.FacebookNotificationBadge
        android:id="@+id/badge"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@+id/imageView"
        android:layout_alignEnd="@+id/imageView"
        android:layout_marginBottom="12dp" />
```

Second of all, intract with code in java.
```java
FacebookNotificationBadge mBadge = (FacebookNotificationBadge) findViewById(R.id.badge);
mBadge.setNumber(12); //Set your count
mBadge.setEmoji(Emoji.HAHA); //You can also set Emoji.LIKE, Emoji.WOW etc
//mBadge.setTextColor(Pass ur color);
//mBadge.setText(Pass ur text);
//mBadge.clear(); //Use to remove or clear the badge
//mBadge.getTextColor(); //Gives u text color
//mBadge.isAnimationEnabled(); //Gives u boolean value true or false
//mBadge.setAnimationEnabled(boolean value); //By default it is true 

```


## Screenshots

**Please click the image below to enlarge.**


<img src="https://github.com/Shashank02051997/FancyFacebookBadge-Android/blob/master/Screenshot/HahaSnap.png" hspace="20"><img src="https://github.com/Shashank02051997/FancyFacebookBadge-Android/blob/master/Screenshot/LikeSnap.png">

<img src="https://github.com/Shashank02051997/FancyFacebookBadge-Android/blob/master/Screenshot/AngrySnap.png" hspace="20"><img src="https://github.com/Shashank02051997/FancyFacebookBadge-Android/blob/master/Screenshot/LoveSnap.png">

<img src="https://github.com/Shashank02051997/FancyFacebookBadge-Android/blob/master/Screenshot/WowSnap.png" hspace="20"><img src="https://github.com/Shashank02051997/FancyFacebookBadge-Android/blob/master/Screenshot/SadSnap.png">

## Contributing

Please fork this repository and contribute back using
[pull requests](https://github.com/Shashank02051997/FancyFacebookBadge-Android/pulls).

Any contributions, large or small, major features, bug fixes, are welcomed and appreciated
but will be thoroughly reviewed .

### Contact - Let's become friend
- [Twitter](https://twitter.com/shashank020597)
- [Github](https://github.com/Shashank02051997)
- [Linkedin](https://www.linkedin.com/in/shashank-singhal-a87729b5/)
- [Facebook](https://www.facebook.com/shashanksinghal02)

## Donation
If this project help you reduce time to develop, you can give me a cup of coffee :) 

<a href="https://www.buymeacoffee.com/mXUuDW7" target="_blank"><img src="https://bmc-cdn.nyc3.digitaloceanspaces.com/BMC-button-images/custom_images/orange_img.png" alt="Buy Me A Coffee" style="height: auto !important;width: auto !important;" ></a>

## License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

```
Copyright 2018 Shashank Singhal

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
