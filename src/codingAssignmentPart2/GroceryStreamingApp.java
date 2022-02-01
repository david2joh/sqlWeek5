package codingAssignmentPart2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import groceryListDao.GLDao;
import groceryListDao.groceryShop;

public class GroceryStreamingApp {
	private static GLDao gld = GLDao.getGLDao();

	public static void main(String[] args) {
		
		System.out.println("--UnSorted---");
		List<groceryShop> gList = gld.getGroceryShops();
		gList.forEach(System.out::println);
		// 
		// Convert to a Stream using my compare vs natural compare / Sort/ add a , between the elements
		// Using my compare as the groceryShop.toString() emits the className and some formating as well as the name element.
		// grpceryShop.compare does sort in natural order based on the sName (shop name) member of the groceryShop class
		System.out.println("--Sorted on the object sName.  Use the entire object toString method---");
		String s2 = gList.stream().sorted((o1, o2)->groceryShop.compare(o1,o2)).map(e -> e.toString())
				.collect(Collectors.joining (" , "));
		System.out.println(s2);
		//map with groceryShop.getSname which only emits the shop name then sort then collect
		//This is the order the assignment wanted so here it is.
		System.out.println("--Sorted using natural order on the shop name .  Only emit the shop name---");
		String s3 = gList.stream().map(e -> e.getsName()).sorted(Comparator.naturalOrder())
				.collect(Collectors.joining (" , "));	
		System.out.println(s3);
	}

}
