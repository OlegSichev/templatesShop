public interface Products { // Dependency inversion principle - Отдельные интерфейсы для обобщений каких-то будущих
    // продуктов, если магазин будет расширяться
    public String toString();
}
