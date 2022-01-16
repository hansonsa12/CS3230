
public class Fraction {
	
	private int numerator;
	private int denominator;
	
	//fraction constructor
	public Fraction (int numerator) {
		
		this.numerator = numerator;
		this.denominator = 1;
		
	}
	//fraction constructor that reduces the fraction to lowest terms
	public Fraction (int numerator, int denominator) {
		
		int gcd = gcd(numerator, denominator);
		this.numerator = numerator/gcd;
		this.denominator = denominator/gcd;
		
	}
	
	//fraction addition method
	public Fraction add(Fraction right) {
		
		int leftNumerator = this.numerator * right.denominator;
		int rightNumerator = this.denominator * right.numerator;
		int newNumerator = leftNumerator + rightNumerator;
		int newDenominator = this.denominator * right.denominator;
		return new Fraction(newNumerator, newDenominator);
		
	}
	
	//fraction subtraction method
	public Fraction sub(Fraction right) {
		
		int leftNumerator = this.numerator * right.denominator;
		int rightNumerator = this.denominator * right.numerator;
		int newNumerator = leftNumerator - rightNumerator;
		int newDenominator = this.denominator * right.denominator;
		return new Fraction(newNumerator, newDenominator);
		
	}
	
	//fraction multiplication method
	public Fraction mult(Fraction right) {
		
		int newNumerator = this.numerator * right.numerator;
		int newDenominator = this.denominator * right.denominator;
		return new Fraction(newNumerator, newDenominator);
		
	}
	
	//fraction division method
	public Fraction div(Fraction right) {
		
		int newDenominator = this.denominator * right.numerator;
		int newNumerator = this.numerator * right.denominator;
		return new Fraction(newNumerator, newDenominator);
		
	}
	
	//toString override
	@Override
	public String toString() {
		
		String fraction;
		String negative = "";
		
		//decides whether fraction needs a negative sign
		if(this.numerator < 0 || this.denominator < 0) {
			if(this.numerator < 0 && this.denominator < 0) {
				negative = "";
			}else {
				negative = "-";
			}
			
		}
		
		//displays fraction neatly
		fraction = negative + Math.abs(this.numerator) + "/" + Math.abs(this.denominator);
		return fraction;
		
	}
	
	//equals override
	@Override
	public boolean equals (Object other) {
		if(this == other) {
			return true;
		}
		
		if(other == null) {
			return false;
		}
		
		if(this.getClass() != other.getClass()) {
			return false;
		}
		
		if (!(other instanceof Fraction)) {
			return false;
		}
		
        Fraction casted = (Fraction)other;
        return this.toString().equals(casted.toString());
	}
	
	//method to find the gcd
	private int gcd(int u, int v)
	{
		u = (u < 0) ? -u : u;		// make u non-negative
		v = (v < 0) ? -v : v;		// make v non-negative

		while (u > 0)
		{
			if (u < v)
			{
				int t = u;	// swap u and v
				u = v;
				v = t;
			}

			u -= v;
		}

		return v; // the GCD of u and v
	}
}
