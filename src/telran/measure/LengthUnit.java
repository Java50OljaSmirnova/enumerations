package telran.measure;

public enum LengthUnit {
	MM(1), CM(10), IN(25.4f), FT(304.8f), M(1000), KM(1_000_000);
	float value;
	LengthUnit(float nMillimeter) {
		value = nMillimeter;
	}
	public float getValue() {
		return this.value;
	}
	public Length between (Length length1, Length length2) {
		
		float amount = Math.abs(length1.convert(this).amount - length2.convert(this).amount);
		Length res = new Length(amount, this);
		return res;
	}
}
