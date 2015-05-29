package com.sarojaba.stopwatch;

import java.text.NumberFormat;

/**
 * Stopwatch class
 * 
 * @author sarojaba
 *
 */
public abstract class AbstractStopwatch {

	private long time;

	abstract protected long sysTime();

	void time(long time) {
		this.time = time;
	}

	public long time() {
		return time;
	}

	@Override
	public String toString() {

		// ex) 12345 => 12,345
		NumberFormat format = NumberFormat.getInstance();
		format.setGroupingUsed(true);
		return format.format(time);
	}
}
