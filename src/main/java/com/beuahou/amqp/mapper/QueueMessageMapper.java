package com.beuahou.amqp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.beuahou.amqp.entity.QueueMessageEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: BeauHou
 * @Date: 2022/7/17
 * @Description:
 */
@Mapper
public interface QueueMessageMapper extends BaseMapper<QueueMessageEntity> {
}
