package com.github.tablesheep233.spring.pagination;

import java.util.List;

/**
 * The interface Pageable.
 *
 * @param <T> the type parameter
 * @author tablesheep233
 */
public interface IPageable<T> {
    /**
     * Get total data amount.
     *
     * @return the total
     */
    Long getTotal();

    /**
     * get total page size
     *
     * @return the total page
     */
    Integer getTotalPage();

    /**
     * get current page
     *
     * @return the current
     */
    Integer getCurrent();

    /**
     * get page data size
     *
     * @return the size
     */
    Integer getSize();

    /**
     * is home page
     *
     * @return the first
     */
    Boolean getFirst();

    /**
     * is last page
     *
     * @return the last
     */
    Boolean getLast();

    /**
     * has next page
     *
     * @return the has next
     */
    Boolean getHasNext();

    /**
     * has previous page
     *
     * @return the has previous
     */
    Boolean getHasPrevious();

    /**
     * get data
     *
     * @return the data
     */
    List<T> getData();
}
