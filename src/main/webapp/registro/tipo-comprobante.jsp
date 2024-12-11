<%@page import="com.example.integradorsi.models.TipoComprobante"%>
<%@page import="java.util.List"%>
<%@page import="com.example.integradorsi.DAO.DAOTipoComprobante"%>
<%
    DAOTipoComprobante conexionTC = new DAOTipoComprobante(null);
    String edit = request.getParameter("edit");
    String tipo;
    TipoComprobante comp = new TipoComprobante(0, "", true);
    if (edit != null) {
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
        <title>TuBaz Ar | Registro de Tipos de Comprobantes</title>
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
                            <h1 class="mb-3">Registro de Tipos de Comprobantes</h1>

                            <form class="row align-items-end" method="post">
                                <div class="col-sm-4">
                                    <label for="nombre" class="mb-3">Nombre:</label>
                                    <input name="nombre" placeholder="Nombre" class="form-control" value="<%= comp.getNombre()%>" />
                                </div>
                                <div class="col-sm-4">
                                    <button type="submit" class="btn btn-secondary"><%= tipo%></button>
                                </div>
                            </form>

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
                                            <th class="border-bottom-0"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% List<TipoComprobante> comprobantes = conexionTC.getAll();
                                            for (TipoComprobante c : comprobantes) {
                                        %>
                                        <tr>
                                            <td class="border-bottom-0"><h6 class="fw-semibold mb-0"><%= c.getId()%></h6></td>
                                            <td class="border-bottom-0">
                                                <span class="fw-normal"><%= c.getNombre()%></span>                          
                                            </td>
                                            <td class="border-bottom-0 d-flex justify-content-center align-items-center gap-2" style="max-width: 100px;">
                                                <a href="registro-local.jsp?edit=<%=c.getId()%>" type="button" class="btn btn-info">
                                                    <i class="ti ti-edit"></i>
                                                </a>
                                                <a href="#" type="button" class="btn btn-danger">
                                                    <i class="ti ti-trash"></i>
                                                </a>
                                            </td>
                                        </tr>
                                        <% }%>
                                    </tbody>
                                </table>
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
