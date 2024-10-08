package model;



//tayma ibrahem 324094333  
//main : log in jframe
//MyMain : the main
//Student : user 
//AddStudent : add user 

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

import View.LogIn;



//the main page (it contain the serializable)

public class Main implements Serializable{

	/**
	 * the serialVersionUID number
	 */
	private static final long serialVersionUID = 1L;

	public static Factory libr;//library field
	public static void main(String args[]) throws UnsupportedAudioFileException, LineUnavailableException
	{
		try
		{
			Factory lib = loadingLibr();
			System.out.println(lib + "---------------");
			if(lib == null){
				lib = Factory.getInstance();
			}
		
		libr = lib;
		LogIn login = new LogIn();
		login.setVisible(true);

	
	//in case the file is not found
		}catch(FileNotFoundException e)
	{
		JOptionPane.showMessageDialog(null,"File not found");
	}
	//in case there was a problem loading data from file
	catch(IOException eio)
	{
		JOptionPane.showMessageDialog(null,"Sound Problems");
	}


}
public static void save() throws IOException
{
	
	String filename = "Factory.ser";
	FileOutputStream fos = null;
	ObjectOutputStream out = null;
	//because serializable dont save static values should save the run pk counters (in class factory there is countV and countD)
	libr.setCountV(VehicleTransportation.getCounter());
	libr.setCountD(Deal.getCounter());
	//trying to save the data
	try
	{
		
		fos = new FileOutputStream(filename);
		out = new ObjectOutputStream(fos);
		out.writeObject(Main.libr);
		out.close();
		JOptionPane.showMessageDialog(null,"Saving file was succesed", "Data Save successe", JOptionPane.INFORMATION_MESSAGE);
	}

	//general exceptions
	catch (Exception e)
	{
		e.printStackTrace();
		JOptionPane.showMessageDialog(null,"Saving file was failed ", "Save Error", JOptionPane.ERROR_MESSAGE);
	}
}//end of save method


@SuppressWarnings("resource")
private static Factory loadingLibr() throws IOException  {
Factory libr=null;
	String filename = "Factory.ser";
	FileInputStream fis = null;
	ObjectInputStream in = null;

	try
	{
		System.out.println("faaaaaaaaaaaaaaaaaaaaaat");
		fis = new FileInputStream(filename);
		in = new ObjectInputStream (fis);
		 libr=(Factory)in.readObject();
		
		//because serializable dont save static values should save the run pk counters (in class factory there is countV and countD)
		 VehicleTransportation.setCounter(libr.getCountV());
		 Deal.setCounter(libr.getCountD());
		return libr;
	}

	//in case the file is not found
	catch (FileNotFoundException e)
	{
		JOptionPane.showMessageDialog(null,"File wasn't found, creating new Library:", "Missing file", JOptionPane.ERROR_MESSAGE);
		return (libr= Factory.getInstance());

	}

	//in case there was a problem loading data from file
	catch(IOException eio)
	{
		JOptionPane.showMessageDialog(null,"system wasn't able to read from file.. creating new Library", "Read File Error", JOptionPane.INFORMATION_MESSAGE);
		return (libr= Factory.getInstance());
	}

	//genreal exceptions
	catch (Exception e)
	{
		System.out.println(e.getMessage());
		return (libr= Factory.getInstance());
	}
}

}
