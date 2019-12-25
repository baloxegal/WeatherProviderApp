public class WeatherApplication {

	public static void main(String[] args) {
		
		printWeather();

	}
	
	public static void printWeather() {
		for(int i = 0; i < 13; i++) {
    	   System.out.print("#");
    	}
		System.out.print(" WEATHER ");
		for(int i = 0; i < 13; i++) {
			System.out.print("#");
		}
		System.out.println("\n");
       
		System.out.printf("TODAY: %f C\n\n", WeatherProvider.getTemperatureForToday());
       
		for(int i = 0; i < 35; i++) {
			System.out.print("-");
		}
       
		System.out.println("\n\nFORECAST FOR 10 DAYS\n");
       
		for(int i = 0; i < 10; i++) {
			System.out.printf("DAY %2d: %f C\n", i + 1, WeatherProvider.getTemperaturesForecastFor10Days()[i]);
		}
		System.out.println("");
		System.out.printf("MAX: %f C\n", WeatherProvider.getMaxTemperatureFor10Days());
		System.out.printf("AVG: %f C\n", WeatherProvider.calculateAvgFor10Days());
		System.out.printf("MIN: %f C\n", WeatherProvider.getMinTemperatureFor10Days());
		System.out.println();
		for(int i = 0; i < 35; i++) {
	    	   System.out.print("#");
	    }
	}

}
