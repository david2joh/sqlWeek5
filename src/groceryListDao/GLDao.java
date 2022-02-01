package groceryListDao;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GLDao {

	private static GLDao instance;
	private static List<groceryShop> shops;

	private GLDao () {
		shops = new ArrayList<groceryShop>(Arrays.asList(
				new groceryShop("Market Basket"), 
				new groceryShop("Shaws"),
				new groceryShop("Walmart"),
				new groceryShop("QuickStop")));
	}

	public static GLDao getGLDao()  {
		if ( instance == null) {
			instance = new GLDao();
		}
		return instance;
	}

	public List<groceryShop> getGroceryShops()  {
		return shops;
	}


}
