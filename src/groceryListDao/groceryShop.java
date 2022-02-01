package groceryListDao;

public class groceryShop {

	private String sName;
	
	public String getsName() {
		return sName;
	}

	@Override
	public String toString() {
		return this.getClass() +" [shop Name = " + sName + "]";
	}

	public groceryShop(String str) {
		this.sName = str;
		}

	public int compareGroceryShop(groceryShop g1, groceryShop g2) {
		return g1.sName.compareTo(g2.sName);
	}
	
	//to meet assignment requirements create "compare"
	public static int compare(groceryShop g1, groceryShop g2)
	{
		return  g1.sName.compareTo(g2.sName);
	}
}
