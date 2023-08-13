package telran.measure;

public class Length implements Comparable<Length> {
	float amount;
	LengthUnit unit;
	public Length(float amount, LengthUnit unit) {
		this.amount = amount;
		this.unit = unit;
	}
	@Override
	public int compareTo(Length o) {
		int res;
		float value = o.amount;
		if(this.unit != o.unit) {
			value = o.convert(this.unit).amount;
		} 
			res = (int) Math.ceil(this.amount - value);
			
		return res;
	}
	public boolean equals(Object object) {
		
		return compareTo((Length) object) == 0 ? true : false;
	}
	public Length convert (LengthUnit unit) {
		float value = amount * this.unit.getValue() / unit.getValue();
		Length res = new Length(value, unit);
		return res;
	}
	public String toString() {
		
		return Float.toString(amount) + unit.name();
	}
	public float getAmount() {
		
		return this.amount;
	}
	public LengthUnit getUnit() {
		
		return this.unit;
	}

}
