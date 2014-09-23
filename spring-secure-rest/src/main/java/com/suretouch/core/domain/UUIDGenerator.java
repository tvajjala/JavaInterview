package com.suretouch.core.domain;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UUIDGenerator implements IdentifierGenerator {
	private final static AtomicInteger counter = new AtomicInteger(0);

	@Override
	public Serializable generate(SessionImplementor arg0, Object arg1)
			throws HibernateException {
		return generateUUID(SureTouchObjectType.BASE.getObjectType(),
				UUIDGenerator.class);
	}

	@SuppressWarnings("all")
	public static String generateUUID(String objectPrefix, Class clazz) {
		/*
		 * parameter clazz is not used in the UUID generation. It's removal
		 * shall be considered upon usage validation.
		 */

		if (objectPrefix != null) {

			return new StringBuilder(36).append(objectPrefix).append('-')
					.append(format3Bytes(getHiTime3Bytes())).append('-')
					.append(format3Bytes(getLoTime3Bytes())).append('-')
					.append(formatByte(getCountByte())).toString();
		} else {
			return new StringBuilder(19)
					.append(format3Bytes(getHiTime3Bytes())).append('-')
					.append(format3Bytes(getLoTime3Bytes())).append('-')
					.append(formatByte(getCountByte())).toString();
		}
	}

	private static short getCountByte() {
		for (;;) {
			int current = counter.get();
			int next = (current + 1) % 1000;
			if (counter.compareAndSet(current, next))
				return (short) next;
		}
	}

	private static String format3Bytes(long val) {
		String formatted = Long.toString(val);
		StringBuilder buf = new StringBuilder("00000000");
		buf.replace(8 - formatted.length(), 8, formatted);
		return buf.toString();
	}

	private static String format3Bytes(int val) {
		String formatted = Integer.toString(val);
		StringBuilder buf = new StringBuilder("000000");
		buf.replace(6 - formatted.length(), 6, formatted);
		return buf.toString();
	}

	private static String formatByte(short val) {
		String formatted = Short.toString(val);
		StringBuilder buf = new StringBuilder("000");
		buf.replace(3 - formatted.length(), 3, formatted);
		return buf.toString();
	}

	public static int getHiTime3Bytes() {
		return ((int) (System.currentTimeMillis() >>> 24)) & 0x000FFFFF;
	}

	public static long getLoTime3Bytes() {
		return System.currentTimeMillis() & 0x00000000FFFFFF;
	}
}