/**
 * FileName: SqlSessionFactoryUtil
 * Author:   小江
 * Date:     2019/2/6 22:30
 * History:
 */
package com.zk.utils;

import com.zk.dao.ZkDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {

	public static SqlSessionFactory getFactory() {
		InputStream inputStream = null;
		SqlSessionFactory sqlSessionFactory = null;
		try {
			inputStream = ZkDao.class.getClassLoader().getResourceAsStream("mybatis-cfg.xml");
			//根据配置的输入流构造一个SQL会话工厂
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sqlSessionFactory;
	}

	public static SqlSession openSqlSession(boolean isAutoCommit) {
		return getFactory().openSession(isAutoCommit);
	}

	public static void closeSession(SqlSession sqlSession) {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
}