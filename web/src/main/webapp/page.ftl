<html lang="en">
<#include "base.ftl">
<#macro title>All Users</#macro>
<#macro content>
    <img src="/files/1.png">
<table>
    <tr>
        <th>Login</th>
        <th>Firstname</th>
        <th>Lastname</th>
    </tr>
    <#if users??>
        <#list users as user>
            <tr>
                <td class="">${user.login}</td>
                <td>${user.name}</td>
                <td>${user.lastName}</td>
            </tr>
        </#list>
    </#if>
</table>
</#macro>
</html>