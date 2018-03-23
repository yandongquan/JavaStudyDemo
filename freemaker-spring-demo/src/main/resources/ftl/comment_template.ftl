<table>
    <tr><td>学号</td><td>姓名</td><td>年龄</td></tr>
     <#list studentList as student>
     <tr><td>${student.studentNo}</td><td>${student.name}</td><td>${student.age}</td></tr>
     </#list>
</table>