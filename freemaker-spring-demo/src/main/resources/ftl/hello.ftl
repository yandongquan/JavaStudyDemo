<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>FreeMarker Demo</title>
</head>
<body>
</body>
1）访问 map 中的 key<br>
${hello}<br>

2）访问 pojo 中的属性<br>
${student.name}<br>

3）取集合中的数据<br>
集合大小:${studentList?size}<br>
遍历集合：<br>
<table>
    <tr><td>学号</td><td>姓名</td><td>年龄</td></tr>
     <#list studentList as student>
     <tr><td>${student.studentNo}</td><td>${student.name}</td><td>${student.age}</td></tr>
     </#list>
</table>

4）取循环中的下标<br>
<table>
    <tr><td>序号</td><td>学号</td><td>姓名</td><td>年龄</td></tr>
     <#list studentList as student>
     <tr><td>${student_index+1}</td><td>${student.studentNo}</td><td>${student.name}</td><td>${student.age}</td></tr>
     </#list>
</table>

5）判断<br>
<table>
    <tr><td>序号</td><td>学号</td><td>姓名</td><td>年龄</td></tr>
     <#list studentList as student>
         <#if student_index % 2 == 0>
         <tr bgcolor="#556b2f">
         <#else>
         <tr bgcolor="#cd5c5c">
         </#if>
     <td>${student_index+1}</td><td>${student.studentNo}</td><td>${student.name}</td><td>${student.age}</td></tr>
     </#list>
</table>

6）日期类型格式化<br>
当前日期：${date?date}<br>
当前时间：${date?time}<br>
当前日期和时间：${date?datetime}<br>
自定义日期格式：${date?string("yyyy-MM-dd HH:mm:ss")}<br>

7）Null 值的处理<br>
null值的处理：${list!"list 为 null"}<br>
null值的处理：
<#if list2??>
    list2 为 null
<#else>
    list2 不为 null
</#if>

<br>
8）Include 标签
<#include "footer.ftl"/>
</html>
