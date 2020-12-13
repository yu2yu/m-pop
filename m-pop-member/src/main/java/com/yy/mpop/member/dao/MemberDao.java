package com.yy.mpop.member.dao;

import com.yy.mpop.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author yy
 * @email youny1118@gmail.com
 * @date 2020-12-13 10:09:15
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
