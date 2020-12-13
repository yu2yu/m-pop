package com.yy.mpop.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.mpop.common.utils.PageUtils;
import com.yy.mpop.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author yy
 * @email youny1118@gmail.com
 * @date 2020-12-13 10:09:15
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

