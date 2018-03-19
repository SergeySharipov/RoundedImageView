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
