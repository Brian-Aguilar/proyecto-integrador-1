<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>TuBaz Ar | Registro Ventas</title>
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
                            <h1 class="mb-3">Registro Ventas</h1>

                            <div class="row">
                                <div class="col-sm-4">
                                    <div>
                                        <label for="local" class="my-2">Local:</label>
                                        <select name="local" class="form-control">
                                            <option value="">Local 1</option>
                                        </select>
                                    </div>
                                    <div>
                                        <label for="tipoVenta" class="my-2">Tipo de venta:</label>
                                        <select name="tipoVenta" class="form-control">
                                            <option value="">Efectivo</option>
                                        </select>
                                    </div>
                                    <div>
                                        <label for="dni" class="my-2">DNI:</label>
                                        <input name="dni" class="form-control" placeholder="DNI cliente" />
                                    </div>
                                    <div>
                                        <label for="cliente" class="my-2">Cliente:</label>
                                        <input name="cliente" class="form-control" placeholder="cliente" disabled />
                                    </div>
                                    <div>
                                        <label for="codProd" class="my-2">Código del producto:</label>
                                        <input name="codProd" class="form-control" placeholder="codigo" />
                                    </div>
                                    <div>
                                        <label for="nombreProd" class="my-2">Producto:</label>
                                        <input name="nombreProd" class="form-control" placeholder="producto" disabled />
                                    </div>
                                    <div>
                                        <label for="cantidad" class="my-2">Cantidad:</label>
                                        <input name="cantidad" class="form-control" value="0" type="number" min="0" max="20" />
                                    </div>
                                    <div>
                                        <label for="precio" class="my-2">Precio:</label>
                                        <input name="precio" class="form-control" placeholder="precio" type="number" disabled />
                                    </div>
                                    <button type="button" class="btn btn-success mt-3 w-100 d-block">Agregar</button>
                                </div>
                                <div class="col-sm-8">
                                    <h3>Lista de productos:</h3>
                                    <div class="card my-2 p-4">
                                        <div class="d-flex align-items-center gap-4">
                                            <div class="flex-sm-fill">
                                                <h4>Producto</h4>
                                                <span>Codigo de barra</span>
                                            </div>
                                            <input type="number" class="form-control w-25" value="1" min="0" max="20" />
                                            <h4>S/. 40.00</h4>
                                            <button type="button" class="btn btn-danger">                       
                                                <i class="ti ti-trash"></i>
                                            </button>
                                        </div>
                                    </div>
                                    
                                    <hr />
                                    <div class="d-flex align-items-center gap-4 w-100 justify-content-end">
                                        <h4>Total:</h4>
                                        <h2>S/. 40.00</h2>
                                    </div>
                                    
                                </div>
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
