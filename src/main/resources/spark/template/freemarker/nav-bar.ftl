<div class="navigation">
    <#if !signin>
        <form id="signin" action="/signin" method="post">
                <a href="/signin"> Sign in! </a>
        </form>
    <#else>
         <p>Welcome back ${username}</p>
    </#if>

</div>