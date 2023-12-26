package com.goya.auth.provider.service;

import com.goya.auth.model.po.GoYaMenu;
import com.goya.auth.provider.repository.GoYaMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author limoum0u
 * @date 23/12/26 10:53
 */
@Service
public class GoYaMenuService {

    private GoYaMenuRepository menuRepository;

    @Transactional
    public List<GoYaMenu> findAll() {
        return menuRepository.findAll();
    }


    @Autowired
    public void setGoYaMenuRepository(GoYaMenuRepository goYaMenuRepository) {
        this.menuRepository = goYaMenuRepository;
    }
}
