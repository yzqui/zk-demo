package com.zk.dao;

import com.zk.pojo.ZkNode;
import com.zk.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

public class ZkDao {

	/**
	 * 添加 zk
	 */
	public int insertZK(ZkNode zkNode) {
		int rows = 0;
		//打开一个会话
		SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession(true);
		//查询多个对象
		System.out.println("zkNode=======" + zkNode.toString());
		rows = sqlSession.insert("com.zk.mapper.ZkMapper.insertZK", zkNode);
		//关闭会话
		SqlSessionFactoryUtil.closeSession(sqlSession);
		return rows;
	}

	/**
	 * 修改 zk
	 */
	public int updateZK(ZkNode zkNode) {
		int rows = 0;
		//打开一个会话
		SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession(true);
		//查询多个对象
		rows = sqlSession.update("com.zk.mapper.ZkMapper.updateZK", zkNode);
		//关闭会话
		SqlSessionFactoryUtil.closeSession(sqlSession);
		return rows;
	}

	/**
	 * 删除 zk
	 */
	public int deleteZK(String key) {
		int rows = 0;
		//打开一个会话
		SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession(true);
		//查询多个对象
		rows = sqlSession.update("com.zk.mapper.ZkMapper.deleteZK", key);
		//关闭会话
		SqlSessionFactoryUtil.closeSession(sqlSession);
		return rows;
	}
}
