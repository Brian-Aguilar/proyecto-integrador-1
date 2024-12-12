<%@page import="com.example.integradorsi.models.CarritoProd"%>
<%@page import="com.example.integradorsi.models.Carrito"%>
<%@page import="com.example.integradorsi.models.Productos"%>
<%@page import="com.example.integradorsi.DAO.DAOProductos"%>
<%@page import="com.example.integradorsi.models.Clientes"%>
<%@page import="com.example.integradorsi.DAO.DAOClientes"%>
<%@page import="com.example.integradorsi.models.TipoComprobante"%>
<%@page import="com.example.integradorsi.DAO.DAOTipoComprobante"%>
<%@page import="com.example.integradorsi.models.Llocal"%>
<%@page import="com.example.integradorsi.DAO.DAOLocal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>TuBaz Ar | Registro Ventas</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.min.css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Libre+Barcode+39&display=swap" rel="stylesheet">
        <style>
            .font-barra {
                font-family: "Libre Barcode 39", system-ui;
                font-weight: 400;
                font-style: normal;
            }
        </style>
    </head>
    <body>
        <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
             data-sidebar-position="fixed" data-header-position="fixed">

            <%@include file="../components/SideBar.jsp" %>

            <!<!-- Body de jsp -->
            <div class="body-wrapper">
                <%@include file="../components/Header.jsp" %>
                <!<!-- Contenido -->
                <%                    Carrito carrito = (Carrito) request.getSession().getAttribute("carrito");
                    double total = 0;
                    if (carrito == null) {
                        carrito = new Carrito();
                        carrito.setLocal(new Llocal(1));
                        carrito.setCliente(new Clientes(0));
                    }
                %>
                <div class="container-fluid">
                    <div class="card">
                        <div class="card-body">
                            <h1 class="mb-3">Registro Ventas</h1>
                            <div class="row">
                                <div class="col-sm-4">
                                    <form method="POST" action="${pageContext.request.contextPath}/CarritoController">
                                        <div>
                                            <label for="local" class="my-2">Local:</label>
                                            <select name="local" class="form-control" required>
                                                <% DAOLocal localdao = new DAOLocal(null);
                                                    for (Llocal l : localdao.getAll()) {
                                                        String selected = l.getId() == carrito.getLocal().getId() ? "selected" : "";%>
                                                <option value="<%=l.getId()%>" <%=selected%> ><%= l.getNombre()%></option>
                                                <%}%>
                                            </select>
                                        </div>
                                        <% DAOClientes daoC = new DAOClientes();%>
                                        <div>
                                            <label for="cliente" class="my-2">Cliente:</label>
                                            <div class="d-flex flex-nowrap gap-2">
                                                <select name="cliente" class="form-control" required>
                                                    <option value="" selected="">Seleccionar</option>
                                                    <% for (Clientes c : daoC.getAll()) {
                                                    String selected = c.getId() == carrito.getCliente().getId() ? "selected" : ""; %>
                                                    <option value="<%=c.getId()%>" <%=selected%>><%=c.getDocumento()%></option>
                                                    <% }%>
                                                </select>
                                                <a class="btn btn-info" href="${pageContext.request.contextPath}/gestion/clientes.jsp" target="_blank">Agregar</a>
                                            </div>
                                        </div>
                                        <div>
                                            <label for="tipoVenta" class="my-2">Tipo de venta:</label>
                                            <select name="tipoVenta" class="form-control" required>
                                                <% DAOTipoComprobante comprobante = new DAOTipoComprobante(null);
                                                    for (TipoComprobante tc : comprobante.getAll()) {%>
                                                <option value="<%=tc.getId()%>"><%=tc.getNombre()%></option>
                                                <%}%>
                                            </select>
                                        </div>
                                        <% DAOProductos daoP = new DAOProductos();%>
                                        <div>
                                            <label for="nombreProd" class="my-2">Producto:</label>
                                            <select name="nombreProd" id="nombreProd" class="form-control" required>
                                                <option value="" selected="" data-precio="0">Seleccionar</option>
                                                <% for (Productos p : daoP.getAll()) {%>
                                                <option value="<%=p.getId()%>" data-precio="<%=p.getPrecio()%>"><%=p.getNombre()%></option>
                                                <% }%>
                                            </select>
                                        </div>
                                        <div>
                                            <label for="cantidad" class="my-2">Cantidad:</label>
                                            <input id="cantidad" name="cantidad" class="form-control" value="1" type="number" min="1" max="20" />
                                        </div>
                                        <div>
                                            <label for="precioTotal" class="my-2">Precio:</label>
                                            <input id="precioTotal" name="precioTotal" class="form-control disabled" value="1" step=".01" min="1" type="number" readonly/>
                                        </div>
                                        <button type="submit" class="btn btn-success mt-3 w-100 d-block">Agregar</button>
                                    </form>
                                </div>
                                <div class="col-sm-8">
                                    <h3>Lista de productos:</h3>
                                    <% for (CarritoProd cp : carrito.getAll()) {%>
                                    <div class="card my-2 p-4">
                                        <div class="d-flex align-items-center gap-4">
                                            <div class="flex-sm-fill">
                                                <h4><%=cp.getProducto().getNombre()%></h4>
                                                <span class="font-barra"><%=cp.getProducto().getId()%> <%=cp.getProducto().getNombre()%></span>
                                            </div>
                                            <input type="number" class="form-control w-25" value="<%=cp.getCantidad()%>" min="0" max="20" readonly />
                                            <h4>S/. <%=cp.getPrecio()%></h4>
                                            <button type="button" class="btn btn-danger">                       
                                                <i class="ti ti-trash"></i>
                                            </button>
                                        </div>
                                    </div>
                                    <% total += cp.getPrecio();
                                        }%>
                                    <hr />
                                    <div class="d-flex align-items-center gap-4 w-100 justify-content-end">
                                        <h4>Total:</h4>
                                        <h2>S/. <%=total%></h2>
                                    </div>
                                    <a class="btn btn-info col-6 mx-auto d-block my-4 h2" href="${pageContext.request.contextPath}/CarritoController">Pagar</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            let precio_seleccionado = 0;
            let cantidad_seleccionado = 1;
            const producto = document.getElementById("nombreProd");
            if (producto) {
                producto.addEventListener("change", (e) => {
                    const index = e.target.options.selectedIndex;
                    precio_seleccionado = e.target.options[index].attributes["data-precio"].value;
                    document.getElementById("precioTotal").value = (precio_seleccionado * cantidad_seleccionado);
                    //document.getElementById("precioTotal").dispatchEvent(new Event('change'));
                });
            }
            const cantidad = document.getElementById("cantidad");
            if (cantidad) {
                cantidad.addEventListener("change", (e) => {
                    cantidad_seleccionado = e.target.value;
                    document.getElementById("precioTotal").value = (cantidad_seleccionado * precio_seleccionado);
                    //document.getElementById("precioTotal").dispatchEvent(new Event('change'));
                });
            }
        </script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/sidebarmenu.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/app.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/simplebar.min.js"></script>
    </body>
</html>
