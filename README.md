# Android组件化开发 #

**组件化开发**就是将一个app分成多个模块，每个模块都是一个组件（Module），开发的过程中我们可以让这些组件相互依赖或者单独调试部分组件等，但是最终发布的时候是将这些组件合并统一成一个apk。


**插件化开发**插件化开发时将整个app拆分成很多模块（apk），这些模块包括一个宿主和多个插件，每个模块都是一个apk（组件化的每个模块是个lib），最终打包的时候将宿主apk和插件apk分开或者联合打包。


## 为什么要有组件化？ ##

加入一个app工程只有一个组件，随着app业务的壮大模块越来越多，代码量超10万是很正常的，这个时候我们会遇到以下问题

- 稍微改动一个模块的一点代码都要编译整个工程，耗时耗力
- 公共资源、业务、模块混在一起耦合度太高
- 不方便测试

组件化开发简单的说就是根据项目的功能模块进行分module开发，每个module可以单独进行运行测试，（其实也就是让每个module运行起来，就是把pludgin改成 Application 发布的时候合并即可）


## 组件划分 ##
- 新建BaseModule 存放公共的工具类、网络分装等
- 逐一开发其他各个模块的module，引用BaseModule，进行模块的开发


##看看Demo，很简单##

参考文章：
- http://www.jianshu.com/p/b7d4e6612e0c
- https://www.cnblogs.com/android-blogs/p/5703355.html

## 问题##
- 1.module与Application之间调用的问题

- 2.跨module的Activity 或 Fragment 之间的跳转问题
    使用ARouter,也可以自己处理

- 3.AAR 或Library project 重复依赖

- 4.资源名冲突
  :在module中的gradle配置
   resourcePrefix "preview_" 设置了这个值后，所有的资源名必须以指定的字符串做前缀，否则会报错
