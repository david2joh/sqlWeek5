package codingAssignmentPart3;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalApp {

	public static void main(String[] args) {
		//Model all three (3) modes of passing optionals -  
		//Complete optional object, Empty optional, Empty optional object
		//the assignment only asks for the first and third of these.
		Model model_1 = new Model("Part3");
		Model model_2 = null;
		Model model_3 = new Model(null);
		Optional<Model> opt1 = Optional.ofNullable(model_1);
		Optional<Model> opt2 = Optional.ofNullable(model_2); //this results in the same functionality as using .empty() 
		Optional<Model> optE = Optional.empty();
		Optional<Model> opt3 = Optional.ofNullable(model_3);
		
		//Go through and test calling unwrap on all these models -- ugly try/catch blocks
		Model m;
		try {
			m = model_1.unwrap(opt1);  //Should really make the unwrap a static rather than carrying it around 
			System.out.println(m);
		} catch (NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}
		try {
			m = model_1.unwrap(opt2); //need to use a real object to access the method --  should have been static !
			System.out.println(m);
		} catch (NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}
		try {
			m = model_1.unwrap(optE); //need to use a real object to access the method --  should have been static !
			System.out.println(m);
		} catch (NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}
		try {
			m = model_3.unwrap(opt3); //need to use a real object to access the method --  should have been static !
			System.out.println(m);
		} catch (NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}

		//Abstract calling into the object optional and the object itself
		//still having to use an instantiated Model to access the methods /frownface
		System.out.println("\n" + "Use MethodB to call unwrap and then print" +"\n");
		model_1.methodB(opt1);
		model_1.methodB(opt2);
		model_1.methodB(opt3);
	}

}
