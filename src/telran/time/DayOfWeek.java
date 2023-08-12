package telran.time;

public enum DayOfWeek {
	MON("Mon#Monday"), TUE("Tue#Tuesday"), WED("Wed#Wednesday"), THU("Thu#Thusday"), 
	FRI("Fri#Friday"), SAT("Sat#Saturday"), SUN("Sun#Sunday");
	String shortName;
	String fullName;
	static int N_Days = values().length;
	
	DayOfWeek(String name){
		String[] tokens = name.split("#");
		shortName = tokens[0];
		fullName = tokens[1];
	}
	public String displayName(TypeDisplay type) {
		return type == TypeDisplay.Short ? shortName : fullName;
	}
	public int getValue() {
		return ordinal() + 1;
	}
	public DayOfWeek plusDays(int days) {
		int index = (ordinal() + days) % N_Days;
		if(index < 0) {
			index += N_Days;
		}
		return values()[index];
	}
	public DayOfWeek minusDays(int days) {
		return plusDays(-days);
	}
	public static int between (DayOfWeek day1, DayOfWeek day2) {
		int res = day2.ordinal() - day1.ordinal();
		if (res < 0) {
			res += N_Days;
		}
		return res;
	}
	public int between(DayOfWeek other) {
		return DayOfWeek.between(this, other);
	}
}
