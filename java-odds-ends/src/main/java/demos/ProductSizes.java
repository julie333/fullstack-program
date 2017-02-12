package demos;

public enum ProductSizes {

	S, M, L, XL, XXL;

	public double getSurchargePercentage() {

		switch (this) {

		case S:
		case M:
		case L:
			return 0;
		case XL:
			return 0.05;
		case XXL:
			return 0.1;
			default : return 0;
		}

	}

}

