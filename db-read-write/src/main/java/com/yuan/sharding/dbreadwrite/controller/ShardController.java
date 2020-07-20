package com.yuan.sharding.dbreadwrite.controller;

import com.yuan.sharding.dbreadwrite.service.ShardServiceB;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yuanjm
 * @date 2020/7/20 10:47 上午
 */
@RestController
public class ShardController {
    @Resource
    private ShardServiceB serviceB;

}
