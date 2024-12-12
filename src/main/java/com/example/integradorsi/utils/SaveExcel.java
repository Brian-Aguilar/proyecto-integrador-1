package com.example.integradorsi.utils;

import com.example.integradorsi.DAO.DAOLocal;
import com.example.integradorsi.models.DetalleIngresos;
import com.example.integradorsi.models.DetalleVentas;
import com.example.integradorsi.models.Llocal;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaveExcel<T> {

    private String archivo;
    private String nombreHoja;
    private Workbook workbook;
    private Row row;
    private Sheet sheet;

    private final Logger logger = LoggerFactory.getLogger(DAOLocal.class);

    public SaveExcel(String archivo, String nombreHoja) {
        this.archivo = archivo;
        this.nombreHoja = nombreHoja;
    }

    private void Init() throws Exception {
        if (archivo.endsWith(".xlsx")) {
            workbook = new XSSFWorkbook();
        } else {
            String msg = "Archivo con el formato no valido.";
            logger.warn(msg);
            throw new Exception(msg);
        }
        sheet = workbook.createSheet(this.nombreHoja);
    }

    private void save() throws Exception {
        FileOutputStream fos = new FileOutputStream(archivo);
        workbook.write(fos);
        fos.close();
        logger.info("Se creo el archivo exitosamente.");
    }

    public void reporteLocal(List<T> i) throws Exception {
        this.Init();
        Iterator<T> items = i.iterator();
        int index = 0;
        Row header = sheet.createRow(index);
        Cell header1 = header.createCell(0);
        header1.setCellValue("Id");
        Cell header2 = header.createCell(1);
        header2.setCellValue("Nombre");
        Cell header3 = header.createCell(2);
        header3.setCellValue("Descripcion");
        Cell header4 = header.createCell(3);
        header4.setCellValue("Estado");

        while (items.hasNext()) {
            Llocal local = (Llocal) items.next();
            Row row = sheet.createRow(++index);
            Cell cell0 = row.createCell(0);
            cell0.setCellValue(local.getId());
            Cell cell1 = row.createCell(1);
            cell1.setCellValue(local.getNombre());
            Cell cell2 = row.createCell(2);
            cell2.setCellValue(local.getDescripcion());
            Cell cell3 = row.createCell(3);
            cell3.setCellValue(local.isEstado());
        }

        this.save();
    }

    public void reporteIngresos(List<T> i) throws Exception {
        this.Init();
        Iterator<T> items = i.iterator();
        int index = 0;
        Row header = sheet.createRow(index);
        Cell header1 = header.createCell(0);
        header1.setCellValue("Id");
        Cell header2 = header.createCell(1);
        header2.setCellValue("Fecha");
        Cell header3 = header.createCell(2);
        header3.setCellValue("Tipo de comprobante");
        Cell header4 = header.createCell(3);
        header4.setCellValue("N° de comprobante");
        Cell header5 = header.createCell(4);
        header5.setCellValue("Local");
        Cell header6 = header.createCell(5);
        header6.setCellValue("Importe");

        while (items.hasNext()) {
            DetalleIngresos dato = (DetalleIngresos) items.next();
            Row row = sheet.createRow(++index);
            Cell cell0 = row.createCell(0);
            cell0.setCellValue(dato.getId());
            Cell cell1 = row.createCell(1);
            cell1.setCellValue(dato.getIngreso().getFecha());
            Cell cell2 = row.createCell(2);
            cell2.setCellValue(dato.getIngreso().getComprobante().getNombre());
            Cell cell3 = row.createCell(3);
            cell3.setCellValue(dato.getIngreso().getNumero_comprobante());
            Cell cell4 = row.createCell(4);
            cell4.setCellValue(dato.getIngreso().getLocal().getNombre());
            Cell cell5 = row.createCell(5);
            cell5.setCellValue(dato.getIngreso().getImporte());
        }

        this.save();
    }

    public void reporteVentas(List<T> i) throws Exception {
        this.Init();
        Iterator<T> items = i.iterator();
        int index = 0;
        Row header = sheet.createRow(index);
        Cell header1 = header.createCell(0);
        header1.setCellValue("Cliente");
        Cell header2 = header.createCell(1);
        header2.setCellValue("DNI");
        Cell header3 = header.createCell(2);
        header3.setCellValue("Local");
        Cell header4 = header.createCell(3);
        header4.setCellValue("Tipo de venta");
        Cell header5 = header.createCell(4);
        header5.setCellValue("Producto");
        Cell header6 = header.createCell(5);
        header6.setCellValue("Cantidad");
        Cell header7 = header.createCell(6);
        header7.setCellValue("Precio U.");
        Cell header8 = header.createCell(7);
        header8.setCellValue("Precio T.");
        Cell header9 = header.createCell(8);
        header9.setCellValue("Fecha Venta");

        while (items.hasNext()) {
            DetalleVentas dato = (DetalleVentas) items.next();
            Row row = sheet.createRow(++index);
            Cell cell0 = row.createCell(0);
            cell0.setCellValue(dato.getVenta().getCliente().getNombre());
            Cell cell1 = row.createCell(1);
            cell1.setCellValue(dato.getVenta().getCliente().getDocumento());
            Cell cell2 = row.createCell(2);
            cell2.setCellValue(dato.getVenta().getLocal().getNombre());
            Cell cell3 = row.createCell(3);
            cell3.setCellValue(dato.getTipo_venta().getNombre());
            Cell cell4 = row.createCell(4);
            cell4.setCellValue(dato.getProducto().getNombre());
            Cell cell5 = row.createCell(5);
            cell5.setCellValue(dato.getCantidad());
            Cell cell6 = row.createCell(6);
            cell6.setCellValue(dato.getProducto().getPrecio());
            Cell cell7 = row.createCell(7);
            cell7.setCellValue(dato.getTotal_pagar());
            Cell cell8 = row.createCell(8);
            cell8.setCellValue(dato.getVenta().getFecha_venta());
        }

        this.save();
    }

}
