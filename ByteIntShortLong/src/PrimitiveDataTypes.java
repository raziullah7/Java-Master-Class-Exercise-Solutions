public class PrimitiveDataTypes {
    public static void main(String[] args) {

        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;
        System.out.println("Integer Minimum Value = " + myMinIntValue);
        System.out.println("Integer Maximum Value = " + myMaxIntValue);
        // Overflow error turned the wheel around to the min value
        System.out.println("Busted Max Value = " + (myMaxIntValue + 1));
        // Underflow error turned the wheel around to the max value
        System.out.println("Busted Min Value = " + (myMaxIntValue - 1));
        // Using underscores instead of commas for better readability
        int maxIntTest = 2_147_483_647;

        byte myByteMinValue = Byte.MIN_VALUE;
        byte myByteMaxValue = Byte.MAX_VALUE;
        System.out.println("Byte Minimum Value = " + myByteMinValue);
        System.out.println("Byte Maximum Value = " + myByteMaxValue);

        short myShortMinValue = Short.MIN_VALUE;
        short myShortMaxValue = Short.MAX_VALUE;
        System.out.println("Short Minimum Value = " + myShortMinValue);
        System.out.println("Short Maximum Value = " + myShortMaxValue);

        // to make any integer a long (even if defined with long data type)
        // you must place an 'L' next to the value
        long myLongValue = 100L;
        long myLongMinValue = Long.MIN_VALUE;
        long myLongMaxValue = Long.MAX_VALUE;
        System.out.println("Long Minimum Value = " + myLongMinValue);
        System.out.println("Long Maximum Value = " + myLongMaxValue);

                // CHALLENGE
        byte var1 = 122;
        short var2 = 30000;
        int var3 = 2000000000;
        long var4 = 50000L + ((var1 + var2 + var3) * 10L);
        System.out.println(var4);
    }
}
