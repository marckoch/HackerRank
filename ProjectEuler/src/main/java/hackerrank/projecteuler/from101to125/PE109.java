package hackerrank.projecteuler.from101to125;

import java.util.*;
import java.util.stream.Collectors;

public class PE109 {
    static List<String> finishesMethod1 = new ArrayList<>();
    static List<String> finishesMethod2 = new ArrayList<>();

    static int from = 1;
    static int to = 180;

    public static void main(String[] args) {
        Stack<Field> darts = new Stack<>();
        Set<String> finishes = new HashSet<>();

        for (int i = from; i <= to; i++) {
            finish(i, darts, finishes);
        }

        System.out.println(finishes.size());

        finish2();
    }

    private static void finish(int remaining, Stack<Field> darts, Set<String> finishes) {
        if (remaining < 0) {
            //System.out.println(darts + " bust!");
            return;
        }
        if (darts.size() == 3 && remaining > 0) { // 3 darts thrown but not finished
            //System.out.println(darts + " did not finish, " + remaining + " left");
            return;
        }
        if (darts.size() == 2 && remaining % 2 == 1) { // last throw must be double
            //System.out.println(darts + " cannot finish odd " + remaining);
            return;
        }
        if (remaining == 0 && darts.lastElement().modifier != 2) {
            //System.out.println(darts + " did not finish on double");
            return;
        }
        if (remaining == 0) {
            int sum = darts.stream().mapToInt(Field::getValue).sum();
            System.out.println(darts + " finished! "
                    + darts.stream().map(d -> String.valueOf(d.getValue())).collect(Collectors.joining("+"))
                    + "=" + sum);

            //String finish = rearrangeAndCopy(new ArrayList<>(Arrays.asList(darts.toArray(new Field[]{}))));
            String finish = rearrangeAndCopy(new ArrayList<>(Arrays.asList(darts.toArray(new Field[]{}))));

            finishes.add(finish);
            finishesMethod1.add(finish);
            return;
        }

        int limit = Math.min(25, remaining);
        for (int dart = 1; dart <= limit; dart++) {
            if (20 < dart && dart < 25) { // there are no fields for 21 - 24
                continue;
            }
            for (int modifier = 1; modifier <= 3; modifier++) { // single, double or treble value fields
                if (dart == 25 && modifier == 3) { // there is no T25 field!
                    continue;
                }
                Field f = Field.of(modifier, dart);
                darts.push(f);
                finish(remaining - f.getValue(), darts, finishes);
                darts.pop();
            }
        }
    }

    public static String rearrangeAndCopy(List<Field> darts) {
        // rearrange first two darts, to account for equal finishes (see problem description)
        if (darts.size() == 3) {
            Field d3 = darts.get(2);

            List<Field> firstTwoOrdered = darts.subList(0,2);
            firstTwoOrdered.sort(Field::compareTo);
            firstTwoOrdered.add(d3);

            return firstTwoOrdered.toString();
        }
        // add empty darts in front to compare with solution 2 (brumme), used during bug hunt
        while (darts.size() < 3) {
            darts.add(0, Field.of(0,0));
        }
        return darts.toString();
    }

    // did not work properly! Field.compareTo is a better solution!
    public static List<Field> reorderFirstTwo(Field f1, Field f2) {
        if (f1.getValue() > f2.getValue()) {
            return new ArrayList<>(Arrays.asList(f2, f1));
        }
        if (f1.modifier > f2.modifier) {
            return new ArrayList<>(Arrays.asList(f2, f1));
        }
        return new ArrayList<>(Arrays.asList(f1, f2));
    }

    static class Field implements Comparable {
        final int modifier;
        final int nominalValue;

        public Field(int modifier, int nominalValue) {
            this.modifier = modifier;
            this.nominalValue = nominalValue;
        }

        public static Field of(int modifier, int nominalValue) {
            return new Field(modifier, nominalValue);
        }

        public int getValue() {
            return modifier * nominalValue;
        }

        @Override
        public String toString() {
            String name;
            switch (modifier) {
                case 0:
                    name = "0";
                    break;
                case 1:
                    name = "S";
                    break;
                case 2:
                    name = "D";
                    break;
                case 3:
                    name = "T";
                    break;
                default:
                    throw new IllegalStateException("illegal modifier: " + modifier);
            }
            return (name + nominalValue);
        }

        @Override
        public int compareTo(Object o) {
            if (o instanceof Field) {
                Field other = (Field) o;
                int v = this.getValue() - other.getValue();
                if (v != 0) return v;

                int m = this.modifier - other.modifier;
                if (m != 0) return m;

                return this.nominalValue - other.nominalValue;
            }
            throw new IllegalArgumentException(o + " is not a Field!");
        }
    }

    // https://euler.stephan-brumme.com/109/ written to find bug in my solution (bug was in ordering fields)
    public static void finish2() {
        List<Field> fields = new ArrayList<>();
        fields.add(Field.of(0,0));
        for (int i = 1; i <= 20; i++) {
            fields.add(Field.of(1, i));
            fields.add(Field.of(2, i));
            fields.add(Field.of(3, i));
        }
        fields.add(Field.of(1, 25));
        fields.add(Field.of(2, 25));

        int combinations = 0;

        for (int total = from; total <= to; total++) {
            for (Field dart3 : fields) {
                if (dart3.modifier != 2 || dart3.getValue() > total) {
                    continue;
                }
                for (int dart1 = 0; dart1 < fields.size(); dart1++) {
                    for (int dart2 = dart1; dart2 < fields.size(); dart2++) {
                        Field f1 = fields.get(dart1);
                        Field f2 = fields.get(dart2);

                        int sum = f1.getValue() + f2.getValue() + dart3.getValue();
                        if (sum == total) {
                            finishesMethod2.add(Arrays.asList(f1, f2, dart3).toString());
                            //System.out.println(Arrays.asList(f1, f2, dart3) + " " + sum);
                            combinations++;
                        }
                    }
                }

            }
        }

        System.out.println(combinations);
    }
}
