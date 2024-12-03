<%@page import="com.example.integradorsi.models.Clientes"%>
<%@page import="com.example.integradorsi.DAO.DAOClientes"%>
<%
    DAOClientes clientes = new DAOClientes();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>TuBaz Ar | Gestion Clientes</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"/>
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
                            <h1>Gestión Clientes</h1>
                            <div class="d-flex justify-content-between align-items-center py-2">
                                <div>
                                    <form action="" method="get" class="d-flex align-items-center gap-1">
                                        <input type="search" name="busqueda" class="form-control" placeholder="Buscar..." />
                                        <button type="submit" class="btn btn-primary">Buscar</button>
                                    </form>
                                </div>
                                <button id="btnAgregar" type="button" class="btn btn-secondary d-flex align-items-center">
                                    <i class="ti ti-plus mx-1"></i>Agregar cliente
                                </button>
                            </div>
                            <div class="table-responsive mt-4">
                                <table class="table text-nowrap mb-0 align-middle">
                                    <thead class="text-dark fs-4">
                                        <tr>
                                            <th class="border-bottom-0">
                                                <h6 class="fw-semibold mb-0">ID</h6>
                                            </th>
                                            <th class="border-bottom-0">
                                                <h6 class="fw-semibold mb-0">Nombres</h6>
                                            </th>
                                            <th class="border-bottom-0">
                                                <h6 class="fw-semibold mb-0">Apellidos</h6>
                                            </th>
                                            <th class="border-bottom-0">
                                                <h6 class="fw-semibold mb-0">Documento</h6>
                                            </th>
                                            <th class="border-bottom-0">
                                                <h6 class="fw-semibold mb-0">Correo</h6>
                                            </th>
                                            <th class="border-bottom-0">
                                                <h6 class="fw-semibold mb-0">Teléfono</h6>
                                            </th>
                                            <th class="border-bottom-0"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%for (Clientes c : clientes.getAll()) { %>
                                        <tr>
                                            <td class="border-bottom-0"><h6 class="fw-semibold mb-0"><%=c.getId()%></h6></td>
                                            <td class="border-bottom-0">
                                                <span class="fw-normal"><%=c.getNombre()%></span>                          
                                            </td>
                                            <td class="border-bottom-0">
                                                <h6 class="mb-0 fw-normal"><%=c.getApellidoP()%> <%=c.getApellidoM()%></h6>
                                            </td>
                                            <td class="border-bottom-0">
                                                <span class="fw-normal"><%=c.getDocumento()%></span>                          
                                            </td>
                                            <td class="border-bottom-0">
                                                <span class="fw-normal"><%=c.getCorreo()%></span>                          
                                            </td>
                                            <td class="border-bottom-0">
                                                <span class="fw-normal"><%=c.getTelefono()%></span>                          
                                            </td>
                                            <td class="border-bottom-0 d-flex justify-content-center align-items-center gap-2" style="max-width: 100px;">
                                                <button type="button" class="btn btn-info">
                                                    <i class="ti ti-edit"></i>
                                                </button>
                                                <button type="button" class="btn btn-danger">
                                                    <i class="ti ti-trash"></i>
                                                </button>
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
        <div class="modal">
            <div class="card">
                <i class="ti ti-x close"></i>
                <div class="card-body">
                    <%@include file="../components/gestionClientes.jsp" %>
                </div>
            </div>
        </div>

        <script src="${pageContext.request.contextPath}/assets/js/modal.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/sidebarmenu.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/app.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/simplebar.min.js"></script>
    </body>
</html>
