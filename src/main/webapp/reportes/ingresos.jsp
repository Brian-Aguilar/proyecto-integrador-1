<%@page import="com.example.integradorsi.models.Llocal"%>
<%@page import="com.example.integradorsi.DAO.DAOLocal"%>
<%@page import="com.example.integradorsi.models.TipoComprobante"%>
<%@page import="com.example.integradorsi.DAO.DAOTipoComprobante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>TuBaz Ar | Reportes Ingresos</title>
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
                            <h1>Reportes Ingresos</h1>
                            <div class="d-flex justify-content-between align-items-center py-2">
                                <div>
                                    <form action="" method="get" class="d-flex align-items-end gap-2">
                                        <div>
                                            <label for="fechaInicio">Fecha Inicio:</label>
                                            <input type="date" name="fechaInicio" class="form-control"/>
                                        </div>
                                        <div>
                                            <label for="fechaInicio">Fecha Fin:</label>
                                            <input type="date" name="fechaFin" class="form-control"/>
                                        </div>
                                        <% DAOTipoComprobante tc = new DAOTipoComprobante();%>
                                        <div>
                                            <label for="tipoVenta">Tipo de Venta:</label>
                                            <select name="tipoVenta" class="form-control">
                                                <option value="all" selected>Todos</option>
                                                <%for (TipoComprobante tv : tc.getAll()) {%>
                                                <option value="<%=tv.getId()%>"><%=tv.getNombre()%></option>
                                                <%}%>
                                            </select>
                                        </div>
                                        <% DAOLocal daoLocal = new DAOLocal();%>
                                        <div>
                                            <label for="local">Local:</label>
                                            <select name="local" class="form-control">
                                                <option value="all" selected>Todos</option>
                                                <% for (Llocal l : daoLocal.getAll()) {%>
                                                <option value="<%=l.getId()%>"><%= l.getNombre()%></option>
                                                <% }%>
                                            </select>
                                        </div>

                                        <button type="submit" class="btn btn-primary">Buscar</button>
                                    </form>
                                </div>
                                <div>
                                    <button type="button" class="btn btn-danger">PDF</button>
                                    <button type="button" class="btn btn-success">Excel</button>
                                </div>
                            </div>
                            <div class="table-responsive mt-4">
                                <table class="table text-nowrap mb-0 align-middle">
                                    <thead class="text-dark fs-4">
                                        <tr>
                                            <th class="border-bottom-0">
                                                <h6 class="fw-semibold mb-0">ID</h6>
                                            </th>
                                            <th class="border-bottom-0">
                                                <h6 class="fw-semibold mb-0">Fecha</h6>
                                            </th>
                                            <th class="border-bottom-0">
                                                <h6 class="fw-semibold mb-0">Tipo de comprobante</h6>
                                            </th>
                                            <th class="border-bottom-0">
                                                <h6 class="fw-semibold mb-0">N° comprobante</h6>
                                            </th>
                                            <th class="border-bottom-0">
                                                <h6 class="fw-semibold mb-0">Local</h6>
                                            </th>
                                            <th class="border-bottom-0">
                                                <h6 class="fw-semibold mb-0">Importe</h6>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td class="border-bottom-0">
                                                <span class="fw-normal">1</span>                          
                                            </td>
                                            <td class="border-bottom-0">
                                                <h6 class="mb-0 fw-normal">18/08/2024</h6>
                                            </td>
                                            <td class="border-bottom-0">
                                                <span class="fw-normal">Boleta</span>                          
                                            </td>
                                            <td class="border-bottom-0">
                                                <span class="fw-normal">20202022002</span>                          
                                            </td>
                                            <td class="border-bottom-0">
                                                <span class="fw-normal">Mi casa</span>                          
                                            </td>
                                            <td class="border-bottom-0">
                                                <span class="fw-normal">S/. 40.00</span>                          
                                            </td>
                                        </tr> 
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
