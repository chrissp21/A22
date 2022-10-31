package a22.climoilou.sim203.formatif.formatif5.services;

import java.util.Random;

public interface SlowHelper {

	public static void slow(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void slowRandom(int minMillis, int maxMillis) {
		SlowHelper.slow(new Random().nextInt(maxMillis - minMillis) + minMillis);
	}
}
