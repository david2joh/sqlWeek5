package codingAssignmentPart1;

import java.util.Collections;
import java.util.List;
import groceryListDao.GLDao;
import groceryListDao.groceryShop;

public class groceryListApp {
      
	private static GLDao gld = GLDao.getGLDao();
	
	//Student Note
	//Rather than following the rather pedantic example of the video
	//I'm just going to pass the functional lamba and method reference
	//to Collections.sort which serves to illustrate the requirements
	//of the assignment.  Construction an entire model layer is a bit 
	//excessive for this. 

	public static void main(String[] args) {
		//Iterate List
		System.out.println("--UnSorted---");
		List<groceryShop> gList = gld.getGroceryShops();
		gList.forEach((item) -> System.out.println(item));
	
		//Making an immutable copy of our original list so that we can sort again 
		List<groceryShop> uList  = List.copyOf(gList);
		
		glLambaSort(gList);
		System.out.println("--Sorted via Lambda---");
		gList.forEach((item) -> System.out.println(item));
		
		Collections.copy(gList,uList);
		System.out.println("--UnSorted---");
		gList.forEach((item) -> System.out.println(item));

		System.out.println("--Sorted via Method Reference---");
		glMethodReferenceSort(gList);
		gList.forEach((item) -> System.out.println(item));
	}

	private static void glLambaSort(List<groceryShop> shops) {
		Collections.sort(shops,(s1,s2)->groceryShop.compare(s1,s2));
		return;
		}
	
	private static void glMethodReferenceSort(List<groceryShop> shops) {
		Collections.sort(shops,groceryShop::compare);
		return;
		}
}

