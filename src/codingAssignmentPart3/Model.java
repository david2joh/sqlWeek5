package codingAssignmentPart3;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Model {
	
	private String name;
	
	@Override
	public String toString() {
		return name;
	}
	
	public Model(String name) {
		this.name = name;
	}

	public Model unwrap(Optional<Model> optionalModel) {
//		if (optionalModel.isEmpty()) {
//			throw new IllegalStateException ("This space for rent");
//		}  
//		return optionalModel.get();
		Model m = optionalModel.orElseThrow(()->new NoSuchElementException ("-- Unwrap :: This space for rent--"));
		return m;
	}

	public void methodB(Optional<Model> opt) {
		try {
//			Model m = opt.orElseThrow(()->new NoSuchElementException ("-- MethodB :: This space for rent--"));
			Model m = unwrap(opt);
			// great we have  valid model object do we have a valid name in the model?
			Optional<String> ostr = Optional.of(Optional.ofNullable(m.toString()).orElseThrow(
					()-> new NoSuchElementException ("-- MethodB ::  Null name in Model")));
			System.out.println(ostr.get());
		} catch (NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
