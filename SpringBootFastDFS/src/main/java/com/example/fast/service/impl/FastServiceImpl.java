package com.example.fast.service.impl;

import com.example.fast.entity.Fast;
import com.example.fast.mapper.FastMapper;
import com.example.fast.service.IFastService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.util.FastDFSUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shyheng
 * @since 2022-03-27
 */
@Service
public class FastServiceImpl extends ServiceImpl<FastMapper, Fast> implements IFastService {

    @Override
    public void delete(int id) {
        Map map = new HashMap();
        map.put("id",id);
        List<Fast> fasts = listByMap(map);
        Fast fast = fasts.get(0);
        FastDFSUtil.delete(fast.getGroupName(),fast.getRemoteFile());
        fast.setFileSize(0L);
        fast.setGroupName("");
        fast.setOldFile("");
        fast.setRemoteFile("");
        saveOrUpdate(fast);
    }
}
