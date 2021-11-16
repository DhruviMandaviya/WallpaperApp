# WallpaperApp
My first android aaplication using REST API. In this application I used pexels website for creating API and load images from website to local application. As well we can save this images in our local system. 

# Demo

 <img align="left" img src="https://user-images.githubusercontent.com/68688918/141608338-4d4b100f-46e9-4ff4-b36c-e914c48677a5.jpeg" width="250px">
 <img align="left" img src="https://user-images.githubusercontent.com/68688918/141608344-87e6cfc2-e79f-4fb2-9c2b-b09315dbd8ee.jpeg" width="250px">
 <img align="left"img src="https://user-images.githubusercontent.com/68688918/141608491-bd1a9aa9-75c8-45b8-8e1b-782dad61a22f.jpeg" width="250px">
 <img align="LEFT"img src="https://user-images.githubusercontent.com/68688918/141608483-893a9c16-07cb-4abc-beb9-43adff8b6913.jpeg" width="250px">
 <img   img src="https://user-images.githubusercontent.com/68688918/141608488-82512963-b4cb-4509-bfdd-babfb4639fd2.jpeg" width="250px">



 #### SEARCH OPTION
 
 <img  img align="left" src="https://user-images.githubusercontent.com/68688918/141609108-a2e61b06-994d-4ff0-8d3b-dd6e32c5f6e1.jpeg" width="250px">
 <img   img src="https://user-images.githubusercontent.com/68688918/141609109-cd5623bb-cf6d-4c4b-8964-7cd923c36673.jpeg" width="250px">
 <img align="left" img src="https://user-images.githubusercontent.com/68688918/141609111-89b465bf-69ea-4b16-b2d9-d2ebcd8f6da2.jpeg" width="250px">
 <img  img src="https://user-images.githubusercontent.com/68688918/141609112-5c102772-b078-4bb3-bec7-c9acb937bf3c.jpeg" width="250px">


 #### SAVE WALLPAPER
 
 <img  img align="left" src="https://user-images.githubusercontent.com/68688918/141609392-363af117-2565-4cb6-be2c-49c15e501922.jpeg" width="250px">
 <img   img src="https://user-images.githubusercontent.com/68688918/141609396-4fbd0b2c-563b-437f-8845-4403f90d8945.jpeg" width="250px">


#### USED LIBRARYS
# PhotoView
PhotoView aims to help produce an easily usable implementation of a zooming Android ImageView.

## Dependency

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
    repositories {
        maven { url "https://www.jitpack.io" }
    }
}

buildscript {
    repositories {
        maven { url "https://www.jitpack.io" }
    }	
}
```

Then, add the library to your module `build.gradle`
```gradle
dependencies {
    implementation 'com.github.chrisbanes:PhotoView:latest.release.here'
}
```


Glide is a fast and efficient open source media management and image loading framework for Android that wraps media
decoding, memory and disk caching, and resource pooling into a simple and easy to use interface.

Glide supports fetching, decoding, and displaying video stills, images, and animated GIFs. Glide includes a flexible API
that allows developers to plug in to almost any network stack. By default Glide uses a custom `HttpUrlConnection` based
stack, but also includes utility libraries plug in to Google's Volley project or Square's OkHttp library instead.

Glide's primary focus is on making scrolling any kind of a list of images as smooth and fast as possible, but Glide is
also effective for almost any case where you need to fetch, resize, and display a remote image.

use Gradle:

```gradle
repositories {
  google()
  mavenCentral()
}

dependencies {
  implementation 'com.github.bumptech.glide:glide:4.12.0'
  annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'
}
```

