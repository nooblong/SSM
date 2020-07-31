package github.nooblong.dao;

import github.nooblong.domain.Role;

import java.util.List;

public interface IRoleDao {
    /**
     * 查询所有
     * @return
     */
    List<Role> findAll();
}
