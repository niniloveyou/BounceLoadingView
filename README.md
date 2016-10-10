# BounceLoadingView
模仿饿了么加载效果

![](https://github.com/niniloveyou/BounceLoadingView/blob/master/bounceLoadingView.gif)

#System Requirement

Android API 11+， Because of the use of ValueAnimation， if you want use it on API 8, please use NineoldAndroids library in your project.

#Usage
        
       
        
        loadingView.addBitmap(R.mipmap.v4);
        
        or
        
        loadingView.addBitmap(bitmap);
        
        or
        
        loadingView.addBitmaps(mBitmapList);
        
        //set the shadow color
        loadingView.setShadowColor(Color.LTGRAY);
        
        //set the duration of animation
        loadingView.setDuration(800);
 
        loadingView.start();
