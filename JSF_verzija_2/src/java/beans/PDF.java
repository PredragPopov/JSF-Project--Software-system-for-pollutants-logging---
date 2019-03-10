/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.FileOutputStream;
import java.io.StringReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
 
/**
 *
 * @author POPOV
 */
@ManagedBean(name="pdf",eager=true)
@RequestScoped
public class PDF implements Serializable{
    public void createPDF() throws FileNotFoundException, DocumentException, IOException{
        
	
	//C:\\Users\\POPOV\\Desktop\\DRUGI.pdf
             
        /*              
        try {
            String path="C:\\Users\\POPOV\\Desktop\\TEST_JSF.pdf";
            Document document = new Document();
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(path));
            
            document.addAuthor("betterThanZero");
            document.addCreationDate();
            document.addProducer();
            document.addCreator("MySampleCode.com");
            document.addTitle("Demo for iText XMLWorker");
            document.setPageSize(PageSize.LETTER);

            //open document
            document.open();
   
   //To convert a HTML file from the filesystem
   //String File_To_Convert = "docs/SamplePDF.html";
   //FileInputStream fis = new FileInputStream(File_To_Convert);

   //URL for HTML page
   URL myWebPage = new URL("http://demo.mysamplecode.com/");
   InputStreamReader fis = new InputStreamReader(myWebPage.openStream());

   //get the XMLWorkerHelper Instance
   XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
   //convert to PDF
   worker.parseXHtml(pdfWriter, document, fis);
   
   //close the document
   document.close();
   //close the writer
   pdfWriter.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		*/
        
        
        /*
      // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\POPOV\\Desktop\\TEST.pdf"));
        // step 3
        document.open();
        // step 4
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,new FileInputStream("index.xhtml")); 
        //step 5
         document.close();
 
        System.out.println( "PDF Created!" );
    */
        
        
        
        
    }
}
