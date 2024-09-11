package lambda;

@FunctionalInterface
public interface TransformIntToStr<T, R> {
    R transform(int i);
}
