<%@page import="com.example.integradorsi.models.Login"%>
<%@page import="com.example.integradorsi.models.Llocal"%>
<%@page import="com.example.integradorsi.DAO.DAOLocal"%>
<%@page import="com.example.integradorsi.models.TipoComprobante"%>
<%@page import="com.example.integradorsi.DAO.DAOTipoComprobante"%>
<%@page import="com.example.integradorsi.DAO.DAOProductos"%>
<%@page import="com.example.integradorsi.models.Productos"%>
<form action="${pageContext.request.contextPath}/" method="POST">
    <%DAOProductos producto = new DAOProductos();%>
    <div class="mb-3">
        <label for="productos" class="form-label">Producto:</label>
        <select class="form-control" id="productos" name="producto">
            <% for (Productos p : producto.getAll()) {%>
            <option value="<%=p.getId()%>"><%=p.getNombre()%></option>
            <%}%>
        </select>
    </div>
    <%DAOTipoComprobante tipoc = new DAOTipoComprobante();%>
    <div class="mb-3">
        <label for="tippo_comprobante" class="form-label">Comprobante:</label>
        <select class="form-control" id="tippo_comprobante" name="tipo_comprobante">
            <% for (TipoComprobante tc : tipoc.getAll()) {%>
            <option value="<%=tc.getId()%>"><%=tc.getNombre()%></option>
            <%}%>
        </select>
    </div>

    <div class="mb-3">
        <label for="comprobante" class="form-label">N° de comprobante:</label>
        <input type="number" class="form-control" id="comprobante" name="comprobante" min="0" value="0">
    </div>

    <div class="mb-3">
        <label for="fecha" class="form-label">Fecha:</label>
        <input type="date" class="form-control" id="fecha" name="fecha">
    </div>
    <%DAOLocal local = new DAOLocal();%>
    <div class="mb-3">
        <label for="local" class="form-label">Local:</label>
        <select class="form-control" id="local" name="local">
            <% for (Llocal l : local.getAll()) {%>
            <option value="<%=l.getId()%>"><%=l.getNombre()%></option>
            <%}%>
        </select>
    </div>

    <div class="mb-3">
        <label for="importe" class="form-label">Importe:</label>
        <input type="number" class="form-control" id="importe" name="importe" min="0" value="0">
    </div>

    <div class="mb-3">
        <label for="cantidad" class="form-label">Cantidad:</label>
        <input type="number" class="form-control" id="cantidad" name="cantidad" min="1" value="1">
    </div>

    <input type="hidden" name="usuario" value="<%=usuario.getId()%>">

    <button type="submit" class="btn btn-primary">Guardar</button>
</form>
