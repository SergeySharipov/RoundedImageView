# RoundedImageView
A simple way to create RoundedImageView using ImageView and CardView

# Screenshot
<p float="left">
  <img src="https://github.com/SergeySharipov/RoundedImageView/blob/master/screenshot_1.jpg" width="200"/>
</p>

# Instruction
- The CardView widget is part of the v7 Support Libraries. 
  To use it in your project, add the following dependency to your app module's build.gradle file:
```gradle
dependencies {
        implementation 'com.android.support:cardview-v7:27.1.0'
}
```
- Add the code to your layout and change "YOUR_PICTURE"
```xml
<android.support.v7.widget.CardView
        android:id="@+id/card_view_for_image"
        android:layout_margin="2dp"
        android:layout_width="200dp"
        android:layout_height="200dp"
        app:cardCornerRadius="100dp">

        <ImageView
            android:id="@+id/rounded_image_view"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:scaleType="centerCrop"
            android:src="@drawable/YOUR_PICTURE" />

</android.support.v7.widget.CardView>
```
- For changing size you can use:
```java
void setRoundedImageViewSize(int size) {
        CardView cardViewForImage = findViewById(R.id.card_view_for_image);
        
        cardViewForImage.setRadius(size / 2);

        ViewGroup.LayoutParams params = cardViewForImage.getLayoutParams();
        params.width = size;
        params.height = size;
        cardViewForImage.setLayoutParams(params);
}
```
# License 
This is free and unencumbered software released into the public domain.

Anyone is free to copy, modify, publish, use, compile, sell, or
distribute this software, either in source code form or as a compiled
binary, for any purpose, commercial or non-commercial, and by any
means.

In jurisdictions that recognize copyright laws, the author or authors
of this software dedicate any and all copyright interest in the
software to the public domain. We make this dedication for the benefit
of the public at large and to the detriment of our heirs and
successors. We intend this dedication to be an overt act of
relinquishment in perpetuity of all present and future rights to this
software under copyright law.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.

For more information, please refer to <http://unlicense.org>
