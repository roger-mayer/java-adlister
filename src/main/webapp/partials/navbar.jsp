<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <c:choose>
            <c:when test="${sessionScope.user == null}">
            <li><a href="/login">Login</a></li>
            </c:when>
            <c:otherwise>
            <li>
                <form action="/logout" method="post">
                    <button>Logout</button>
                </form>
            </li>
            </c:otherwise>
            </c:choose>

    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
