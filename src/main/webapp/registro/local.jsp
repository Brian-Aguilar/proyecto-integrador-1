<%@page import="com.example.integradorsi.models.Llocal"%>
<%@page import="java.util.List"%>
<%@page import="com.example.integradorsi.DAO.DAOLocal"%>
<%
    DAOLocal conexionLocal = new DAOLocal();
    String edit = request.getParameter("edit");
    String tipo;
    Llocal local = new Llocal(0, "", "", true);
    if (edit != null) {
        local = conexionLocal.getById(Integer.parseInt(edit));
        tipo = "Editar";
    } else {
        tipo = "Registrar";
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>TuBaz Ar | Registro Local</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.min.css"/>
    </head>
    <body>
        <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
             data-sidebar-position="fixed" data-header-position="fixed">
            <%@include file="../components/SideBar.jsp" %>
            <!<!-- Body de jsp -->
            <div class="body-wrapper">
                <%@include file="../components/Header.jsp" %>
                <!<!-- Contenido -->
                <div class="container-fluid">
                    <div class="card">
                        <div class="card-body">
                            <h1 class="mb-3">Registro Local</h1>

                            <form class="row align-items-end" method="post" action="${pageContext.request.contextPath}/LlocalController">
                                <%if (tipo == "Editar") {%>
                                <input type="hidden" name="tipo" value="editar" />
                                <input type="hidden" name="id" value="<%=local.getId()%>" />
                                <% }%>
                                <div class="col-sm-4">
                                    <label for="nombre" class="mb-3">Nombre:</label>
                                    <input name="nombre" placeholder="Nombre" class="form-control" value="<%= local.getNombre()%>" />
                                </div>
                                <div class="col-sm-4">
                                    <label for="descripcion" class="mb-3">Descripción:</label>
                                    <textarea name="descripcion" class="form-control" rows="1" placeholder="Descripción"><%= local.getDescripcion()%></textarea>
                                </div>
                                <div class="col-sm-4">
                                    <button type="submit" class="btn btn-secondary"><%= tipo%></button>
                                </div>
                            </form>
                            <%@include file="../components/Alert.jsp" %>

                            <div class="table-responsive mt-4">
                                <table class="table text-nowrap mb-0 align-middle">
                                    <thead class="text-dark fs-4">
                                        <tr>
                                            <th class="border-bottom-0">
                                                <h6 class="fw-semibold mb-0">ID</h6>
                                            </th>
                                            <th class="border-bottom-0">
                                                <h6 class="fw-semibold mb-0">Nombre</h6>
                                            </th>
                                            <th class="border-bottom-0">
                                                <h6 class="fw-semibold mb-0">Descripción</h6>
                                            </th>
                                            <th class="border-bottom-0">
                                                <h6 class="fw-semibold mb-0">Estado</h6>
                                            </th>
                                            <th class="border-bottom-0"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% List<Llocal> locales = conexionLocal.getAll();
                                            for (Llocal l : locales) {
                                        %>
                                        <tr>
                                            <td class="border-bottom-0"><h6 class="fw-semibold mb-0"><%=l.getId()%></h6></td>
                                            <td class="border-bottom-0">
                                                <span class="fw-normal"><%= l.getNombre()%></span>                          
                                            </td>
                                            <td class="border-bottom-0">
                                                <span class="fw-normal"><%= l.getDescripcion()%></span>                          
                                            </td>
                                            <td class="border-bottom-0">
                                                <span class="fw-normal"><%= l.isEstado() ? "<i class='ti ti-square-check' style='font-size:2rem; color: green;'></i>" : "<i class='ti ti-square-x' style='font-size:2rem; color: red;'></i>"%></span>                          
                                            </td>
                                            <td class="border-bottom-0 d-flex justify-content-center align-items-center gap-2" style="max-width: 100px;">
                                                <a href="${pageContext.request.contextPath}/registro/local.jsp?edit=<%=l.getId()%>" type="button" class="btn btn-info">
                                                    <i class="ti ti-edit"></i>
                                                </a>
                                                <a href="#" type="button" class="btn btn-danger">
                                                    <i class="ti ti-trash"></i>
                                                </a>
                                            </td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/sidebarmenu.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/app.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/simplebar.min.js"></script>

    </body>
</html>
