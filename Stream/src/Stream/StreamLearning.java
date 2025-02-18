package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamLearning {

	private String name;
	private boolean vegetarian;
	private int calories;
	private Type type;

	private enum Type {
		MEAT, FISH, OTHER
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + ", vegetarian=" + vegetarian + ", calories=" + calories + ", type=" + type + "]";
	}

	public StreamLearning(String name, boolean vegetarian, int calories, Type type) {
		super();
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public static void main(String[] args) {
		
		//Menu List
		List<StreamLearning> menu = Arrays.asList(new StreamLearning("pork", false, 800, Type.MEAT),
				new StreamLearning("beef", false, 700, StreamLearning.Type.MEAT), new StreamLearning("chicken", false, 400, StreamLearning.Type.MEAT),
				new StreamLearning("french fries", true, 530, StreamLearning.Type.OTHER), new StreamLearning("rice", true, 350, StreamLearning.Type.OTHER),
				new StreamLearning("season fruit", true, 120, StreamLearning.Type.OTHER), new StreamLearning("pizza", true, 450, StreamLearning.Type.OTHER),
				new StreamLearning("prawns", false, 300, StreamLearning.Type.FISH), new StreamLearning("salmon", false, 450, StreamLearning.Type.FISH));

		List<String> CaloriesName = menu.stream().filter(c -> c.getCalories() > 530).map(name -> name.getName())
				.toList();
		System.out.println(CaloriesName);
		
		//Distinct
		List<Integer> numberDistinct = Arrays.asList(1,2,3,4,5,1,2,4,3,5,6);
		List<Integer> numberDistinctResult = numberDistinct.stream().filter(n->n%2 ==0).distinct().toList();
		System.out.println(numberDistinctResult);
		
		
		//Note allMatch,noneMatch ,anyMatch <<return type is boolean>>
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,9,10);
		boolean anyEven = numbers.stream().anyMatch(n -> n%2 ==0);
		System.out.println(anyEven);
		boolean  noneOdd =numbers.stream().noneMatch(n ->n%2 !=0);
		System.out.println(noneOdd);
		boolean allEven = numbers.stream().allMatch(n -> n% 2 ==0);
		System.out.println(allEven);
		
		//FindAny is return the first element of the listUsually returns the first element.
		//May return any element, optimizing for performance.
		Optional<StreamLearning> findAnyResult = menu.stream().filter(n-> n.getType().equals(StreamLearning.Type.OTHER)).findAny();
		System.out.println(findAnyResult);
		
		//FindFirst always return the first element
		Optional<StreamLearning> findFirstResult = menu.stream().filter(dish-> dish.getType().equals(StreamLearning.Type.MEAT)).findFirst();
		System.out.println(findFirstResult);
		
		//Reduce sum
		List<Integer> number = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	    Integer sumResult = number.stream().reduce(0, (a,b)->(a + b));
	    System.out.println(sumResult);
	    
	    Optional<Integer> sum =  number.stream().reduce((a,b)-> (a + b));
	    System.out.println(sum);
		
	    Optional<Integer> min = number.stream().reduce(Integer::min);
	    System.out.println(min);
	    
	    Optional<Integer> max = number.stream().reduce(Integer::max);
	    System.out.println(max);
	    
       //MapToInt
	 long mapToIntResult =menu.stream().filter(m -> m.getType().equals(StreamLearning.Type.MEAT)).mapToInt(c -> c.getCalories()).sum();
	 System.out.println(mapToIntResult);
		
	}

}
