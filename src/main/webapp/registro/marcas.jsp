<%@page import="com.example.integradorsi.services.MarcaService"%>
<%@page import="com.example.integradorsi.models.Marca"%>
<%
    MarcaService service = new MarcaService();
    Marca marca = new Marca("");
    String edit = request.getParameter("edit");
    String tipo;
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
        <title>TuBaz Ar | Registro de Marcas</title>
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
                            <h1 class="mb-3">Registro de Marcas</h1>

                            <form class="row align-items-end" method="post">
                                <div class="col-sm-4">
                                    <label for="nombre" class="mb-3">Nombre:</label>
                                    <input name="nombre" placeholder="Nombre" class="form-control" value="<%= marca.getNombre()%>" />
                                </div>
                                <div class="col-sm-4">
                                    <label for="descripcion" class="mb-3">Descripción:</label>
                                    <textarea name="descripcion" class="form-control" rows="1" placeholder="Descripción"><%= marca.getDescripcion()%></textarea>
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
                                            <th class="border-bottom-0">
                                                <h6 class="fw-semibold mb-0">Descripcion</h6>
                                            </th>
                                            <th class="border-bottom-0"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% for (Marca m : service.obtenerMarcas()) {%>
                                        <tr>
                                            <td class="border-bottom-0"><h6 class="fw-semibold mb-0"><%= m.getId()%></h6></td>
                                            <td class="border-bottom-0">
                                                <span class="fw-normal"><%= m.getNombre()%></span>                          
                                            </td>
                                            <td class="border-bottom-0">
                                                <span class="fw-normal"><%= m.getDescripcion()%></span>                          
                                            </td>
                                            <td class="border-bottom-0 d-flex justify-content-center align-items-center gap-2" style="max-width: 100px;">
                                                <a href="${pageContext.request.contextPath}/registro/local.jsp?edit=<%=m.getId()%>" type="button" class="btn btn-info">
                                                    <i class="ti ti-edit"></i>
                                                </a>
                                                <% if (m.isEstado()) {%>
                                                <a href="${pageContext.request.contextPath}/LlocalController?delete=<%=m.getId()%>" type="button" class="btn btn-danger">
                                                    <i class="ti ti-trash"></i>
                                                </a>
                                                <%} else {%>
                                                <a href="${pageContext.request.contextPath}/LlocalController?delete=<%=m.getId()%>" type="button" class="btn btn-success">
                                                    <i class="ti ti-receipt-refund"></i>
                                                </a>
                                                <%}%>
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
        </div>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/sidebarmenu.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/app.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/simplebar.min.js"></script>

    </body>
</html>
