<%@page import="com.example.integradorsi.DAO.DAOTipoDocumento"%>
<%@page import="com.example.integradorsi.models.TipoDocumento"%>
<form action="${pageContext.request.contextPath}/" method="POST">
    <div class="mb-3">
        <label for="nombre" class="form-label">Nombre completo:</label>
        <input type="text" class="form-control" id="nombre" name="nombre">
    </div>
    <div class="mb-3">
        <label for="apellido_paterno" class="form-label">Apellido paterno:</label>
        <input type="text" class="form-control" id="apellido_paterno" name="apellido_paterno">
    </div>
    <div class="mb-3">
        <label for="apellido_materno" class="form-label">Apellido materno:</label>
        <input type="text" class="form-control" id="apellido_materno" name="apellido_materno">
    </div>
    <div class="mb-3">
        <label for="telefono" class="form-label">Telefono:</label>
        <input type="number" class="form-control" id="telefono" name="telefono" min="900000000" maxlength="9">
    </div>
    <%DAOTipoDocumento daotd = new DAOTipoDocumento();%>
    <div class="mb-3">
        <label for="tipo_documento" class="form-label">Tipo de documento:</label>
        <select class="form-control" id="tipo_documento" name="tipo_documento">
            <% for (TipoDocumento tipodoc : daotd.getAll()) {%>
            <option value="<%=tipodoc.getId()%>"><%=tipodoc.getNombre()%></option>
            <%}%>
        </select>
    </div>
    <div class="mb-3">
        <label for="documento" class="form-label">N° de documento:</label>
        <input type="number" class="form-control" id="documento" name="documento" min="0" maxlength="8">
    </div>

    <button type="submit" class="btn btn-primary">Guardar</button>
</form>