<html>
<head>
    <meta charset="utf-8"/>
    <title>Freemarker入门小demo</title>
</head>
<body>
<#--引入外部页面-->
<#include "head.ftl"/>
<#--我只是一个注释我不会有任何的输出-->
姓名:${name} <br>
简述：${message}  <br/>
<#assign linkman="李四">
<#assign linkman="王五">
联系人：${linkman}
<#assign info={"mobile":"1588888","address":"这是一个地址XXXXX"}>
电话：${info.mobile} 地址：${info.address}


<#--去List集合数据-->
<#list personList as person>
    <#if person_index==0>
        这是第一次循环
    <#else>
        这是第${person_index+1}次循环
    </#if>
    集合索引 ${person_index}
    ${person}
</#list>
共${personList?size}条记录

<#--获取map集合中的数据-->
<#list personMap?keys as key>
    map中的key为：${key} map中的value为：${personMap[key]}
</#list>
当前日期：${today?date}<br>
当前时间：${today?time}<br>
当前 日期+时间   ：${today?datetime}<br>
格式化：${today?string("yyyy年MM月dd日")}<br>
${point}<br>
累计月薪 ${point?c}
<#if aaa??>
    aaa变量存在
<#else>
    aaa变量不存在
</#if>
${aaa!'这个aaa变量不存在'}
</body>
</html>