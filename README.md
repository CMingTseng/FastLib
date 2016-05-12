# FastLib

代码积累-快速开发框架@FanlySff
当前版本  [V1.0.4](https://github.com/FanlySff/FastLib)

###Gradle:

```groovy
compile ('com.fast.library:frame:1.0.4'){
        exclude group: 'glide-parent'
    }
    
设置packagingOptions()
android{
    packagingOptions {
            exclude 'META-INF/services/javax.annotation.processing.Processor'
        }
}
```

### 框架使用

> 在Application中调用onCreate()方法中调用FastFrame.init(this)进行初始化;
> FastFrame.setDebug(true);将开启调试功能，打印网络请求日志，打印错误日志。


### 更新说明
>[V1.0.1](https://github.com/FanlySff/FastLib) 
- Activity管理(ActivityStack) 
- 打造BaseActivity(Activity基类，所有的Activity集成BaseActivity) 
- 工具类积累(LogUtils，DetaUtils，NetUtils...) 
- ListView的万能适配器(BaseListAdapter) 
- RecyclerView的万能适配器(BaseRecyclerAdapter) 
- BackTools双击退出应用(在Activity的onBackPressed方法中调用该方法的onBackPressed) 
- CrashHandler默认的崩溃处理器
 1. 支持上传到服务器
 2. 可以设置是否保存到本地
 3. 可以设置保存崩溃日志的目录
 4. 可以设置日志文件名称
 5. 可以设置崩溃提醒 
- 图片加载使用Glide(封装GlideLoader) 
 1. 添加Glide配置(继承GlideConfig) 
- Bean集成Model
 1. 实现将json转bean
 2. 实现将json转list
- BannerView图片轮播
 1. 支持任何View
 2. 支持任何数据
 3. 支持手动控制自动停止轮播
 4. 支持设置自动轮播
 5. 支持禁止手动控制 
- 网络请求使用OkHttp3    
 1. 网络框架配置(在Application中)      
 //初始化HttpConfig       
 HttpConfig.Builder httpBuilder = new HttpConfig.Builder(this);       
 httpBuilder.build().init();       
 //支持http和https访问      
 //支持配置超时时间，日志打印       
 //支持设置证书       
 //支持设置网络，应用拦截器       
 //支持开启失败重试       
 //支持设置全局参数       
 //支持文件上传，下载，请求取消(如果继承BaseAcitivy,在RequestParams中传入this,支持当Activity销毁时 取消该Activity的所有请求)       
 //......       
 //支持post,put,get,head,delete,patch谓词    
 2. 网络框架使用       
HttpUtils.post(url);       
HttpUtils.post(url,params);       
HttpUtils.post(url,callBack);       
HttpUtils.post(url,params,callBack);       
HttpUtils.cancel(url);       
......    
 3. 网络框架回调
ModelHttpCallBack返回Bean对象       
StringHttpCallBack返回String字符串

>[V1.0.1](https://github.com/FanlySff/FastLib)
- 修改RequestParams设置为json时出错的bug

>[V1.0.3](https://github.com/FanlySff/FastLib)
- 删除setRootView()方法
- 默认使用@ContenView()设置Activity和Fragment布局

>[V1.0.4](https://github.com/FanlySff/FastLib)
-修改Bug

License
-------

    Copyright 2016 Jude

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
