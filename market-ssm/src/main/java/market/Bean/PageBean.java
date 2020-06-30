package market.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页对象
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageBean<T> {

    private long totalCount;//总记录数
    private long totalPage;//总页数
    private long currentPage;//当前页码
    private long pageSize;//每页显示的条数
    private List<T> list;//每页显示的数据集合
}
