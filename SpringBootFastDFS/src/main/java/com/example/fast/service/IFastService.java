package com.example.fast.service;

import com.example.fast.entity.Fast;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shyheng
 * @since 2022-03-27
 */
public interface IFastService extends IService<Fast> {
    void delete(int id);
}
