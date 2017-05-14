import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class MenuPresenter {
    //This is the class that will handle the menu <-> UI communication.
	ArrayList<MenuItem> menuItems;
    MenuItem model;
    MenuGUI view;
    String file;
    File f;
    
    public MenuPresenter(String file)
    {
    	this.file = file;
    }
    
    public String getFile() {
		return file;
	}
    
    /**
    public MenuPresenter(File f)
    {
    	this.f = f;
    }*/
    
    public ArrayList<MenuItem> getMenuItems() throws FileNotFoundException 
	{
   
		menuItems = new ArrayList<MenuItem>();
		Scanner in = new Scanner(new File(this.getFile()));
		//Scanner in = new Scanner(this.f);
		
			while(in.hasNextLine())
			{	
				String line = in.nextLine();
				line = line.replace("|", " , ");
				String[] split = line.split(" , ");
				String itemName = split[0];
				if (itemName.length() > 0)
				{
					double itemPrice = Double.parseDouble(split[1]);
					MenuItem m = new MenuItem(itemName,itemPrice);
					menuItems.add(m);
				}
			}
			in.close();
		
		
		return menuItems; 
	}

    void attachView(MenuGUI view) {
        this.view = view;
    }

}