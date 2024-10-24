<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>TuBaz Ar | Registro Ingresos</title>
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
                <div class="container-fluid">
                    <div class="card">
                        <div class="card-body">
                            <h1>Registro Ingresos</h1>
                            <div class="d-flex justify-content-end align-items-center py-2">
                                <button type="button" class="btn btn-secondary d-flex align-items-center">
                                    <i class="ti ti-plus mx-1"></i>Agregar ingreso
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
                                                <h6 class="fw-semibold mb-0">Producto</h6>
                                            </th>
                                            <th class="border-bottom-0">
                                                <h6 class="fw-semibold mb-0">Cantidad</h6>
                                            </th>
                                            <th class="border-bottom-0">
                                                <h6 class="fw-semibold mb-0">Precio</h6>
                                            </th>
                                            <th class="border-bottom-0">
                                                <h6 class="fw-semibold mb-0">Total</h6>
                                            </th>
                                            <th class="border-bottom-0"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td class="border-bottom-0"><h6 class="fw-semibold mb-0">1</h6></td>
                                            <td class="border-bottom-0">
                                                <span class="fw-normal">Panzito</span>                          
                                            </td>
                                            <td class="border-bottom-0">
                                                <h6 class="mb-0 fw-normal">2</h6>
                                            </td>
                                            <td class="border-bottom-0">
                                                <span class="fw-normal">S/. 1.20</span>                          
                                            </td>
                                            <td class="border-bottom-0">
                                                <span class="fw-normal">S/. 2.40</span>                          
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
        <script src="${pageContext.request.contextPath}/assets/js/apexcharts.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/simplebar.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/dashboard.js"></script>
    </body>
</html>
