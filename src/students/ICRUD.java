package students;

public interface ICRUD<T> {
    public T create(T item);
    public T[] requestAll();
    public T requestById(int id);
    public T update(T item);
    public T delete(int id);
}
