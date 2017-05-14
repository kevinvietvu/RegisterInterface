import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

public class McPatterns {

	public static void main(String args[]) 
	{	
		/**
			if (args.length != 1) 
			{
				System.out.println("Invalid number of arguments");
				System.out.println("Usage: [ file name ]");
				System.out.println("file name: file to use to create the menu ");
				return;
			} 
			else 
			{
				MenuPresenter presenter = new MenuPresenter(args[0]);
				try {
					MenuGUI gui = new MenuGUI(presenter);
				} 
				catch (FileNotFoundException e) {
					System.err.println("Error processing " + args[0] + " " + e);
					return;
				}
			} 
			*/
			
			try {
				MenuGUI gui = new MenuGUI(new MenuPresenter("items.txt"));
			} 
			catch (FileNotFoundException e) {
				System.err.println("Error processing " + e);
			} 
	}
	
}
/**
//Create a file chooser
 	File selectedFile = null;
    JFileChooser fileChooser = new JFileChooser();
    
    int returnValue = fileChooser.showOpenDialog(null);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
    	selectedFile = fileChooser.getSelectedFile();
    }
	try {
		MenuGUI gui = new MenuGUI(new MenuPresenter(selectedFile));
	} 
	catch (FileNotFoundException e) {
		System.err.println("Error processing " + e);
	} */
