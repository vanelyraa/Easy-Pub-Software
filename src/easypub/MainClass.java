/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypub;

import javax.swing.text.Document;
import net.sf.jasperreports.export.pdf.PdfDocument;

/**
 *
 * @author vanel
 */
public class MainClass {
   
    public static void main(String args[]){
        String path = "D:\\Invoice.pdf";
        PdfWriter writer = new PdfWriter (path);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document doc = new Document(pdfDoc);
        pdfDoc.setDefaultPageSize(PageSize.A4);
    }
}
