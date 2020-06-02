package core.basesyntax;

@FunctionalInterface
public interface Operationable<T> {
    T compute(T x, T y);
}
