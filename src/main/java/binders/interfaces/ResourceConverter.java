package binders.interfaces;

public interface ResourceConverter<S,T> {
    T parse(S source) throws Exception;
}
