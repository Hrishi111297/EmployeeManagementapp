package com.tech.controllers;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xhtmlrenderer.pdf.ITextRenderer;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/try")
public class PDfGenerator {
	//I have created this code for  generating the pdf for the further use 
	// By using this code we can generate the html code and same code for the pdf file 
	// for 
	 @GetMapping("/genpdf")
	    public void generatePdf(HttpServletResponse response) throws IOException {
	        // Set the content type and attachment header
	        response.setContentType("application/pdf");
	        response.setHeader("Content-Disposition", "attachment; filename=sample.pdf");

	        // Get the HTML content as a string (you can also load it from a file or template)
	        String htmlContent = "<html><head><style>" +
	                "body { font-family: Arial, sans-serif; }" +
	                "h1 { color: red; }" +
	                "p { color: green; }" +
	                "</style></head><body><h1>Hello, PDF!</h1><p>This is a sample PDF document created using HTML and CSS.</p></body></html>";

	        // Generate PDF from HTML content
	        try (OutputStream os = response.getOutputStream()) {
	            ITextRenderer renderer = new ITextRenderer();
	            renderer.setDocumentFromString(htmlContent);
	            renderer.layout();
	            renderer.createPDF(os);
	            renderer.finishPDF();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

