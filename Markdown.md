# Markdown语法大全
## 分级标题
# 一级标题
## 二级标题
### 三级标题
#### 四级标题
##### 五级标题
###### 六级标题  <!--最多6级标题-->

## 任务列表
- [ ] 任务一 未做任务 `- + 空格 + [ ]`
- [x] 任务二 已做任务 `- + 空格 + [x]`


## 首行缩进
【1】 &emsp;或&#8195; //全角
【2】 &ensp;或&#8194; //半角
【3】 &nbsp;或&#160;  //半角之半角

## 斜体、粗体、删除线、下划线、背景高亮
*斜体*或_斜体_
**粗体**
***加粗斜体***
~~删除线~~
++下划线++
==背景高亮==


## 超链接
欢迎阅读 [github](https://github.com/yandongquan "github")

## 参考式
我经常去的几个网站[Google][1]、[Leanote][2]。

[1]:http://www.google.com 
[2]:http://www.leanote.com

## 注脚
使用 Markdown[^1]可以效率的书写文档, 直接转换成 HTML[^2]。

[^1]:Markdown是一种纯文本标记语言

[^2]:HyperText Markup Language 超文本标记语言

## 锚点（页内超链接）

## 0. 目录{#任务列表}



## 无序列表
* 无序列表项 一
+ 无序列表项 二
- 无序列表项 三

## 有序列表
1. 有序列表项 一
2. 有序列表项 二
3. 有序列表项 三

## 定义型列表
:   轻量级文本标记语言（左侧有一个可见的冒号和四个不可见的空格）


## 图像
<center>  <!--开始居中对齐-->

![GitHub set up](https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590172470427&di=fe2cf87598679407246f9716b4269ee3&imgtype=0&src=http%3A%2F%2Fimg2.imgtn.bdimg.com%2Fit%2Fu%3D156633782%2C4246280560%26fm%3D214%26gp%3D0.jpg "图片Title")
格式: ![图片Alt](图片地址 "图片Title")
</center> <!--结束居中对齐-->

## 多级引用
>>> 请问 Markdwon 怎么用？ - 小白
>> 自己看教程！ - 愤青
> 教程在哪？ - 小白

## 转义字符、字体、字号、颜色
<font face="黑体">我是黑体字</font>
<font face="微软雅黑">我是微软雅黑</font>
<font face="STCAIYUN">我是华文彩云</font>
<font color=#0099ff size=12 face="黑体">黑体</font>
<font color=gray size=5>gray</font>
<font color=#00ffff size=3>null</font>


## 代码块
```
#include &lt;stdio.h&gt;
int main(void)
{
    printf(&#34;Hello world\n&#34;);
}
```

## 表格
|学号|姓名|序号|
|-|-|-|
|小明明|男|5|
|小红|女|79|
|小陆|男|192|

## 分隔线
* * *
***
*****
- - -
-----------












