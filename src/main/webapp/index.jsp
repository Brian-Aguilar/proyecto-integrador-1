<%@page import="com.example.integradorsi.DAO.DAOProductos"%>
<%@page import="com.example.integradorsi.DAO.DAOTipoComprobante"%>
<%@page import="com.example.integradorsi.DAO.DAOMarca"%>
<%@page import="com.example.integradorsi.DAO.DAOLocal"%>
<%@page import="com.example.integradorsi.DAO.DAOClientes"%>
<%@page import="com.example.integradorsi.DAO.DAOCategoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>TuBaz Ar | Inicio</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.min.css"/>
    </head>
    <body>
        <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
             data-sidebar-position="fixed" data-header-position="fixed">

            <%@include file="components/SideBar.jsp" %>

            <!<!-- Body de jsp -->
            <div class="body-wrapper">
                <%@include file="components/Header.jsp" %>
                <!<!-- Contenido -->
                <%
                    DAOCategoria daoC = new DAOCategoria(null);
                    DAOClientes daoClientes = new DAOClientes();
                    DAOLocal daoLocal = new DAOLocal(null);
                    DAOMarca daoMarca = new DAOMarca(null);
                    DAOTipoComprobante daoTC = new DAOTipoComprobante(null);
                    DAOProductos daoP = new DAOProductos();
                %>
                <div class="container-fluid">
                    <div class="row gap-7 justify-content-between">
                        <div class="col-3 card p-4 text-center">
                            <h3>Categorias</h3>
                            <h4 class="my-8 py-8"><%=daoC.size()%></h4>
                        </div>
                        <div class="col-3 card p-4 text-center">
                            <h3>Clientes</h3>
                            <h4 class="my-8 py-8"><%=daoClientes.size()%></h4>
                        </div>
                        <div class="col-3 card p-4 text-center">
                            <h3>Local</h3>
                            <h4 class="my-8 py-8"><%=daoLocal.size()%></h4>
                        </div>
                        <div class="col-3 card p-4 text-center">
                            <h3>Marcas</h3>
                            <h4 class="my-8 py-8"><%=daoMarca.size()%></h4>
                        </div>
                        <div class="col-3 card p-4 text-center">
                            <h3>Tipo de comprobantes</h3>
                            <h4 class="my-8 py-8"><%=daoTC.size()%></h4>
                        </div>
                        <div class="col-3 card p-4 text-center">
                            <h3>Productos</h3>
                            <h4 class="my-8 py-8"><%=daoP.size()%></h4>
                        </div>
                        <div class="col-3 card p-4 text-center">
                            <h3>Ventas</h3>
                            <h4 class="my-8 py-8"><%=daoC.size()%></h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/sidebarmenu.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/app.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/apexcharts.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/simplebar.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/dashboard.js"></script>
    </body>
</html>
