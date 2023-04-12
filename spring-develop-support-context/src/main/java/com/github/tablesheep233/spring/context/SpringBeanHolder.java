package com.github.tablesheep233.spring.context;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

/**
 * The type Spring bean holder.
 *
 * @param <T> the type parameter
 */
public final class SpringBeanHolder<T> {
    /**
     * The constant HOLDER_CACHE.
     */
    public static final Map<HolderKey, SpringBeanHolder<?>> HOLDER_CACHE = new ConcurrentHashMap<>();

    /**
     * Hold object.
     *
     * @param clazz the clazz
     * @return the object
     */
    public static Object hold(Class<?> clazz) {
        return HOLDER_CACHE.computeIfAbsent(HolderKey.of(clazz, null), t -> new SpringBeanHolder<>(clazz));
    }

    /**
     * Hold object.
     *
     * @param clazz    the clazz
     * @param supplier the supplier
     * @return the object
     */
    public static <T> Object hold(Class<T> clazz, Supplier<T> supplier) {
        return HOLDER_CACHE.computeIfAbsent(HolderKey.of(clazz, supplier), t -> new SpringBeanHolder<>(clazz, supplier));
    }

    private T bean;

    private final Class<T> clazz;

    private Supplier<T> supplier;

    /**
     * Instantiates a new Spring bean holder.
     *
     * @param clazz the clazz
     */
    public SpringBeanHolder(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * Instantiates a new Spring bean holder.
     *
     * @param clazz    the clazz
     * @param supplier the supplier
     */
    public SpringBeanHolder(Class<T> clazz, Supplier<T> supplier) {
        this.clazz = clazz;
        this.supplier = supplier;
    }

    /**
     * Get t.
     *
     * @return the t
     */
    public T get() {
        if (bean == null) {
            bean = supplier != null ? supplier.get() : SpringApplicationContextHolder.getBean(clazz);
        }
        return bean;
    }

    private static class HolderKey {
        /**
         * Of holder key.
         *
         * @param clazz    the clazz
         * @param supplier the supplier
         * @return the holder key
         */
        public static HolderKey of(Class<?> clazz, Supplier<?> supplier) {
            return new HolderKey(clazz, supplier);
        }

        private final Class<?> clazz;
        private final Supplier<?> supplier;

        /**
         * Instantiates a new Holder key.
         *
         * @param clazz    the clazz
         * @param supplier the supplier
         */
        public HolderKey(Class<?> clazz, Supplier<?> supplier) {
            this.clazz = Objects.requireNonNull(clazz, "holder key need hold object type");
            this.supplier = supplier;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            HolderKey holderKey = (HolderKey) o;
            return Objects.equals(clazz, holderKey.clazz) && Objects.equals(supplier, holderKey.supplier);
        }

        @Override
        public int hashCode() {
            return Objects.hash(clazz, supplier);
        }
    }
}
