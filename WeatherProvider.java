import java.util.Random;
import java.math.BigDecimal; // Вариант округления N 2
import java.math.RoundingMode; // Вариант округления N 2


public class WeatherProvider {
	
	private static double temperatureForToday = generateTemperature();
    private static double[] temperaturesFor10Days = generateTemperaturesForecastFor10Days();

    private static double generateTemperature() {
        Random rd = new Random(); 
        double temperature = 300 * (rd.nextDouble() - 0.5);// Без округления и Вариант округления N 2
        //double temperature = (double)((int) (300 * (rd.nextDouble() - 0.5) * 10)) / 10; // Вариант округления N 1
        double roundTemperature = new BigDecimal(temperature).setScale(1, RoundingMode.UP).doubleValue(); // Вариант округления N 2
        return roundTemperature; // Вариант округления N 2
        
        //return temperature; // Без округления и Вариант округления N 1
    }

    private static double[] generateTemperaturesForecastFor10Days() {
        double [] forecastArray = new double [10];
        for(int i = 0; i < forecastArray.length; i++) {
        	forecastArray [i] = generateTemperature();
        }
        return forecastArray;
    }  


    public static double getTemperatureForToday() {
        return temperatureForToday;
    }

    public static double[] getTemperaturesForecastFor10Days() {
        return temperaturesFor10Days;
    }

    public static double calculateAvgFor10Days() {
        double avgTemp10Days = 0;
    	for(int i = 0; i < temperaturesFor10Days.length; i++) {
    		avgTemp10Days += temperaturesFor10Days[i];
    	}
    	return avgTemp10Days/temperaturesFor10Days.length;
    }

    public static double getMaxTemperatureFor10Days() {
    	double MaxTemp10Days = temperaturesFor10Days[0];
    	for(int i = 1; i < temperaturesFor10Days.length; i++) {
    		if(MaxTemp10Days >= temperaturesFor10Days[i]) {
    			continue;
    		}
    		MaxTemp10Days = temperaturesFor10Days[i];
    	}
    	return MaxTemp10Days;
    }

    public static double getMinTemperatureFor10Days() {
    	double MinTemp10Days = temperaturesFor10Days[0];
    	for(int i = 1; i < temperaturesFor10Days.length; i++) {
    		if(MinTemp10Days <= temperaturesFor10Days[i]) {
    			continue;
    		}
    		MinTemp10Days = temperaturesFor10Days[i];
    	}
    	return MinTemp10Days;
    }
}