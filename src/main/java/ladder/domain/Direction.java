package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static ladder.utils.LadderPointGenerator.generatePoint;

public class Direction {

    private static final boolean FALSE = false;

    private boolean left;
    private boolean right;
    private static Map<String, Direction> reusableDirection = new HashMap<>();

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }

        this.left = left;
        this.right = right;
    }

    public static Direction getInstance(boolean l, boolean r) {
        String key = l + "" + r;

        if(!reusableDirection.containsKey(key)) {
            reusableDirection.put(key, new Direction(l, r));
        }

        return reusableDirection.get(key);
    }

    static Direction of(boolean first, boolean second) {
        return Direction.getInstance(first, second);
    }

    public Direction isOverlapped() {
        if (this.right) {
            return of(this.right, FALSE);
        }

        return of(this.right, generatePoint());
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left &&
                right == direction.right;
    }

    @Override
    public int hashCode() {

        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
