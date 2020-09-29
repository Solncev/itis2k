<html lang="en">
<#include "base.ftl">
<#macro title>All Users</#macro>
<#macro content>
<table>
    <tr>
        <th>Firstname</th>
        <th>Lastname</th>
    </tr>
    <#if users??>
        <#list users as user>
            <tr>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
            </tr>
        </#list>
    </#if>
</table>
</#macro>
</html>