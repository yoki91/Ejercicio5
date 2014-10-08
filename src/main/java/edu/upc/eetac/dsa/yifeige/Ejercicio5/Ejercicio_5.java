package edu.upc.eetac.dsa.yifeige.Ejercicio5;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.*;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;
import java.io.File;
import javax.imageio.ImageIO;



public class Ejercicio_5 
{

	public static void main( String[] args )
    {
        Date fecha=new Date();
        SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
        File fichero=null;
        Path p1=Paths.get("/home/yifeige/dsa-projects/Ejercicio5/cat.jpg");
        boolean bool=false;
    	PrintWriter salida=null;
    	long longitud=0;
    	
    	try
    	{
    		fichero=new File("/home/yifeige/dsa-projects/Ejercicio5/cat.jpg");
    		bool=fichero.exists();
    		if(bool)
    		{
    			System.out.println("El fichero existe");
    			longitud=fichero.length();
    			System.out.printf("El fichero tiene %d bytes", longitud);
    		}
    		else
    			System.out.println("El fichero no existe");
       
    	}
    	catch(Exception e)
    	{
    		System.out.println("El error de exception :"+e.getMessage());
    	}
    	
    	try// lo mismo que ejercicio4 crear fichero de registro
    	{
    		salida=new PrintWriter(new BufferedWriter(new FileWriter("registro.txt")));
    		salida.printf("El fichero tiene %d bytes\n", longitud);
    		salida.println(formato.format(fecha));
    		salida.println(p1.getFileName());
    	}
    	catch(IOException e)
    	{
    		System.out.println("El error de exception IO:"+e.getMessage());
    	} 	  	
    	finally
    	{
    		if(salida !=null)
    		salida.close();	
    	}    	
    }
}
