package ait.pet.model;

public class Cat implements Comparable<Cat>{
	//создать класс 4- 5 полей
	//стандартный конструктор, геттеры и сеттеры
	//toString
	//Создать исполняемый класс для тестирования
	//Создать масив с представителями класса
	//добавить comparable в класс Cat, переопределить метод
	//compareTo и в итоге отсортировать масив

	String name;
	private int weight;
	String color;
	int age;

	public Cat(String name, int weight, String color, int age) {
		this.name = name;
		this.setWeight(weight);
		this.color = color;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Cat " + " name= " + name + ", weight= " + getWeight() + ", color= " + color + ", age=" + age;
	}


	@Override
	public int compareTo(Cat o) {
		int res = this.getWeight() - o.getWeight();
		return res;
//		if (res > 0){
//			return 1;
//		}else if (res == 0) {
//			return 0;
//		}else {
//			return -1;
//		}
	}
}

