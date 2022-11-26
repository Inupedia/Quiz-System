<nav class="navbar navbar-light bg-light">
    <div class="container-fluid ms-2 d-flex justify-content-start">
        <a class="navbar-brand" href="/home">
            Home
        </a>
        <a class="navbar-brand login" href="/login">
            Login
        </a>
        <a class="navbar-brand logout" href="/logout">
            Logout
        </a>
        <a class="navbar-brand" href="/register">
            Register
        </a>
        <a class="navbar-brand" href="/feedback">
            Feedback
        </a>
        <a class="navbar-brand" href="/contact">
            Contact Us
        </a>
    </div>
</nav>
<script type="text/javascript">
    const getUserSession = () => {
        let user = '<%= session.getAttribute("user") %>';
        const loginTag = document.getElementsByClassName("login")[0];
        const logoutTag = document.getElementsByClassName("logout")[0];
        if (user !== "null" && user !== "") {
            loginTag.style.display = "none";
            logoutTag.style.display = "block";
        } else {
            loginTag.style.display = "block";
            logoutTag.style.display = "none";
        }
    }
    getUserSession();
</script>