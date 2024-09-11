package lambda;

@FunctionalInterface
public interface MyFunction<T, U, R> {
    R apply(T t, U u);
}
