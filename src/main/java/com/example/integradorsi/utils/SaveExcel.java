package com.example.integradorsi.utils;

import com.example.integradorsi.DAO.DAOLocal;
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

    private void Init() throws Exception{
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
        Row header =  sheet.createRow(index);
        Cell header1 = header.createCell(0);
        header1.setCellValue("Id");
        Cell header2 = header.createCell(1);
        header2.setCellValue("Nombre");
        Cell header3 = header.createCell(2);
        header3.setCellValue("Descripcion");
        Cell header4 = header.createCell(3);
        header4.setCellValue("Estado");
        
        while(items.hasNext()) {
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

}
