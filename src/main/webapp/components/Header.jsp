<%@page import="com.example.integradorsi.utils.Authenticator"%>
<%@page import="com.example.integradorsi.models.Login"%>
<%
    Authenticator.validated(request, response);
    Login usuario = new Login();
    try {
        usuario = (Login) request.getSession().getAttribute("login");
        if (usuario == null) {
            response.sendRedirect("login.jsp");
        }
    } catch (Exception e) {
        usuario = new Login();
    }
%>

<header class="app-header">
    <nav class="navbar navbar-expand-lg navbar-light">
        <ul class="navbar-nav">
            <li class="nav-item d-block d-xl-none">
                <a class="nav-link sidebartoggler nav-icon-hover" id="headerCollapse" href="javascript:void(0)">
                    <i class="ti ti-menu-2"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link nav-icon-hover" href="javascript:void(0)">
                    <i class="ti ti-bell-ringing"></i>
                    <div class="notification bg-primary rounded-circle"></div>
                </a>
            </li>
        </ul>
        <div class="navbar-collapse justify-content-end px-0" id="navbarNav">
            <ul class="navbar-nav flex-row ms-auto align-items-center justify-content-end">
                <span><%= usuario.getNombre_completo()%></span>
                <li class="nav-item dropdown">
                    <a class="nav-link nav-icon-hover" href="javascript:void(0)" id="drop2" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        <img src="https://cdn-icons-png.flaticon.com/512/7656/7656421.png" alt="" width="35" height="35" class="rounded-circle">
                    </a>
                    <div class="dropdown-menu dropdown-menu-end dropdown-menu-animate-up" aria-labelledby="drop2">
                        <div class="message-body">
                            <a href="javascript:void(0)" class="d-flex align-items-center gap-2 dropdown-item">
                                <i class="ti ti-user fs-6"></i>
                                <p class="mb-0 fs-3">Mi Perfil</p>
                            </a>
                            <a href="${pageContext.request.contextPath}/LoginController" class="btn btn-outline-primary mx-3 mt-2 d-block">Cerrar Sessión</a>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
</header>
<style>
    .open-sidebar {
        left: 0px !important;
    }
</style>
<script>
    const asideFunctions = () => {
        const aside = document.querySelector(".left-sidebar");
        if (aside) {
            aside.classList.toggle('open-sidebar');
        }
    }
    const bar = document.getElementById("headerCollapse");
    if (bar) {
        bar.addEventListener("click", (e) => {
            asideFunctions();
        });
    }

    const closeSidebar = document.getElementById("sidebarCollapse");
    if (closeSidebar) {
        closeSidebar.addEventListener("click", (e) => {
            asideFunctions();
        });
    }
</script>