# ScreenShotUtils

# Uses
Use for surfaceview
```
ScreenShotUtils.request(*Activity*, *SurfaceView*, new ScreenShotUtils.OnScreenShotFinishedListener() {
    @Override
    public void onScreenShotFinished(int resultCode, Bitmap bitmap) {
        if(resultCode==ScreenShotUtils.SUCCESS){
            // Do your code
        }
    }
});
```
Use for window
```
ScreenShotUtils.request(*Activity*, getWindow(), new ScreenShotUtils.OnScreenShotFinishedListener() {
    @Override
    public void onScreenShotFinished(int resultCode, Bitmap bitmap) {
        if(resultCode==ScreenShotUtils.SUCCESS){
            // Do your code
        }
    }
});
```
Use for view
```
ScreenShotUtils.request(*View*, new ScreenShotUtils.OnScreenShotFinishListener() {
    @Override
    public void onScreenShotFinished(Bitmap bitmap) {
       // Do your code
    }
});
```

# Download

Gradle:
```
allprojects {
    repositories {
    ...
    maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.dhimant1990:ScreenShotUtils:v1.0'
}
```
