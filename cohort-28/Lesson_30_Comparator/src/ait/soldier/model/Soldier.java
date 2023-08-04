package ait.soldier.model;

public class Soldier implements Comparable<Soldier> {
	String name;
	int heigh;
	double weight;
	int profile;



	public Soldier(String name, int heigh, double weight, int profile) {
		this.name = name;
		this.heigh = heigh;
		this.weight = weight;
		this.profile = profile;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeigh() {
		return heigh;
	}

	public void setHeigh(int heigh) {
		this.heigh = heigh;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getProfile() {
		return profile;
	}

	public void setProfile(int profile) {
		this.profile = profile;
	}


	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Soldier{");
		sb.append("name='").append(name).append('\'');
		sb.append(", heigh=").append(heigh);
		sb.append(", weight=").append(weight);
		sb.append(", profile=").append(profile);
		sb.append('}');
		return sb.toString();
	}



	@Override
	public int compareTo(Soldier o) {
		int res = heigh - o.heigh;
		return res != 0 ? res : -(profile - o.profile);//: иначе

	}

}
