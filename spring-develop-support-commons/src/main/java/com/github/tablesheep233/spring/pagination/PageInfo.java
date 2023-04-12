package com.github.tablesheep233.spring.pagination;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * The type Page info.
 *
 * @param <T> the type parameter
 */
@Getter
@Setter
@NoArgsConstructor
public class PageInfo<T> implements IPageable<T> {

    /**
     * Of page info.
     *
     * @param <T>   the type parameter
     * @param total the total
     * @param page  the page
     * @param size  the size
     * @return the page info
     */
    public static <T> PageInfo<T> of(Long total, Integer page, Integer size) {
        //todo check param
        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setTotal(total);
        pageInfo.setTotalPage(totalPages(total, size));
        pageInfo.setCurrent(page);
        pageInfo.setSize(size);
        return pageInfo;
    }

    /**
     * Of page info.
     *
     * @param <T>           the type parameter
     * @param totalElements the total elements
     * @param page          the page
     * @param size          the size
     * @param data          the data
     * @return the page info
     */
    public static <T> PageInfo<T> of(Long totalElements, Integer page, Integer size, List<T> data){
        PageInfo<T> pageInfo = of(totalElements, page, size);
        pageInfo.setData(data);
        return pageInfo;
    }

    private static int totalPages(long totalElements, int size) {
        return Math.toIntExact(totalElements % size == 0 ? totalElements / size : totalElements / size + 1);
    }

    private Long total;

    private Integer totalPage;

    private Integer current;

    private Integer size;

    private Boolean first;

    private Boolean last;

    private Boolean hasNext;

    private Boolean hasPrevious;

    private List<T> data;
}
