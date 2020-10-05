<html lang="en">
<#include "base.ftl">
<#macro title>All Users</#macro>
<#macro content>
<table>
    <tr>
        <th>Login</th>
        <th>Firstname</th>
        <th>Lastname</th>
    </tr>
    <#if users??>
        <#list users as user>
            <tr>
                <td>${user.login}</td>
                <td>${user.name}</td>
                <td>${user.lastName}</td>
            </tr>
        </#list>
    </#if>
</table>
</#macro>
</html>