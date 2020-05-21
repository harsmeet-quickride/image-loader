# ImagesSubRedditViewer

## Features
 * Asynchronously load the image onto the ImageView.
 * Load the images faster by caching it in memory.
 * Load the images faster by using disk-level caching.

## Installation

```groovy
allprojects {
        repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}

dependencies {
	implementation 'com.github.rajatsangrame:ImagesSubRedditViewer:1.0.0'
}
```

## Usage

```java
        ImageLoader.get(this)
                .loadUrl(url)
                .target(imageView)
                .execute();
```

You can also add a `ImageListener` for the result e.g.

```java
        ImageLoader.get(this)
                ..
                .addListener(new ImageListener(..)
                .execute();
```

## Caching
<img src="cache.png">








