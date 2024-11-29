<%@page import="com.example.integradorsi.models.Categoria"%>
<%@page import="com.example.integradorsi.services.CategoriaService"%>
<%@page import="com.example.integradorsi.models.Marca"%>
<%@page import="com.example.integradorsi.services.MarcaService"%>
<form action="${pageContext.request.contextPath}/ProductosController" method="POST">
    <div class="mb-3">
        <label for="nombre" class="form-label">Nombre:</label>
        <input type="text" class="form-control" id="nombre" name="nombre">
    </div>
    <div class="mb-3">
        <label for="descripcion" class="form-label">Descripción</label>
        <textarea class="form-control" id="descripcion" name="descripcion"></textarea>
    </div>
    <div class="mb-3">
        <label for="precio" class="form-label">Precio</label>
        <input type="number" class="form-control" id="precio" name="precio" min="0" value="0.00" step="0.05">
    </div>
    <%CategoriaService categoria = new CategoriaService();%>
    <div class="mb-3">
        <label for="categoria" class="form-label">Categoria</label>
        <select class="form-control" id="categoria" name="categoria">
            <% for (Categoria c : categoria.obtenerCategorias()) {%>
            <option value="<%=c.getId()%>"><%=c.getNombre()%></option>
            <%}%>
        </select>
    </div>
    <%MarcaService marca = new MarcaService();%>
    <div class="mb-3">
        <label for="marca" class="form-label">Marca</label>
        <select class="form-control" id="marca" name="marca">
            <% for (Marca m : marca.obtenerMarcas()) {%>
            <option value="<%=m.getId()%>"><%=m.getNombre()%></option>
            <%}%>
        </select>
    </div>

    <button type="submit" class="btn btn-primary">Guardar</button>
</form>