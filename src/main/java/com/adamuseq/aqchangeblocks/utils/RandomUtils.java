package com.adamuseq.aqchangeblocks.utils;

import org.apache.commons.lang.Validate;

import java.util.Random;

public class RandomUtils
{
    private static final Random RAND;

    static {
        RAND = new Random();
    }

    public static int getRandInt(final int min, final int max) throws IllegalArgumentException {
        Validate.isTrue(max >= min, "Max can't be smaller than min!");
        return RandomUtils.RAND.nextInt(max - min + 1) + min;
    }

    public static double getRandDouble(final double min, final double max) throws IllegalArgumentException {
        Validate.isTrue(max >= min, "Max can't be smaller than min!");
        return RandomUtils.RAND.nextDouble() * (max - min) + min;
    }

    public static boolean getChance(final double chance) {
        return chance >= 100.0 || chance >= getRandDouble(0.0, 100.0);
    }

    public static boolean isInt(final String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException ex) {
            return false;
        }
    }
}
