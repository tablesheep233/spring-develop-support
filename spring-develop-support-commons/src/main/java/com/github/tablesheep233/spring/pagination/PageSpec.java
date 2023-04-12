package com.github.tablesheep233.spring.pagination;

/**
 * The type Page spec.
 * @author tablesheep233
 */
public class PageSpec {

    /**
     * Of page spec.
     *
     * @param page the page
     * @param size the size
     * @return the page spec
     */
    public static PageSpec of(int page, int size) {
        return new PageSpec(page, size);
    }

    /**
     * Instantiates a new Page spec.
     *
     * @param page the page
     * @param size the size
     */
    public PageSpec(int page, int size) {
        this.page = page;
        this.size = size;
    }

    private final int page;

    private final int size;

    /**
     * Gets page.
     *
     * @return the page
     */
    public int getPage() {
        return page;
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }
}
