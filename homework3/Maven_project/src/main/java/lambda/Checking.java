package lambda;

@FunctionalInterface
public interface Checking<T> {
    boolean check(T t);
}
