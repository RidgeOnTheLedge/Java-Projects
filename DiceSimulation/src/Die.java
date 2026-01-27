public class Die {
	DieType type;
	double successRate;

	public Die(DieType type) {
		this.type = type;
		successRate = 0.0;
	}

	public DieType getType() {
		return type;
	}

	public double getSuccessRate() {
		return successRate;
	}

	public void setSuccessRate(double successRate) {
		this.successRate = successRate;
	}

	@Override
	public String toString() {
		return String.format("%s Success Rate: %.1f%%", type, successRate);
	}

}