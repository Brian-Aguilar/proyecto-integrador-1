<style>
    .alert {
        position: fixed !important;
        top: 5em;
        right: -500px;
        z-index: 10;
        max-width: 30%;
        min-width: 300px;
        transition: .3s all ease-in;
        display: flex;
        align-items: center;
        justify-content: space-between;
    }
    .alert.animation {
        right: 2em;
    }
    .close-alert {
        cursor: pointer;
    }
</style>
<%
    String msg;
    String animation = "";
    try {
        msg = request.getSession().getAttribute("msg").toString();
        animation = "animation";
        request.getSession().setAttribute("msg", null);
    } catch (Exception e) {
        msg = null;
    }

%>
<div class="alert alert-success <%= animation%>" role="alert">
    <span>
        <%= msg%>
    </span>
    <i class="close-alert">x</i>
</div> 

<script>
    const alert = document.querySelector(".close-alert");
    if (alert) {
        alert.addEventListener("click", () => {
            document.querySelector(".alert").classList.toggle("animation")
        });
    }
</script>