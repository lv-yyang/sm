package com.ly.dao.impl;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ly.dao.Bookdao;
import com.ly.pojo.Book;

public class Bookdaoimpl implements Bookdao{

	public Book queryBookById(int id){
		// 1)���������ļ�
		Book book=null;
		try {
			InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
			

			// 2)�����Ự����
			// 2.1)����SqlSessionFactoryBuilder����
				SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			
			// 2.2)����SqlSessionFactory����
			SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
			
			//�򿪻Ự
			SqlSession openSession = build.openSession();
			
			//ִ��sql
			book = openSession.selectOne("com.ly.mapper.BookMap.queryBookById", id);
			
			//�رջỰ
			openSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return book;
		
	}
	
	public List<Book> queryBookAll(){
		List<Book> list=new ArrayList<Book>();

		try {
			InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new  SqlSessionFactoryBuilder();
			SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
			SqlSession openSession = build.openSession();
			list=openSession.selectList("com.ly.mapper.BookMap.queryBookAll");
			openSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public int addbook(Book book) {
		int i=0;
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
			SqlSessionFactory build = sessionFactoryBuilder.build(inputStream);
			SqlSession openSession = build.openSession();
			 i = openSession.insert("com.ly.mapper.BookMap.addbook", book);
		openSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
		
	}

	@Override
	public int deletebook(int id) {
		int i=0;
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
			SqlSessionFactory build = sessionFactoryBuilder.build(inputStream);
			SqlSession openSession = build.openSession();
			 i = openSession.update("com.ly.mapper.BookMap.deletebook", id);
		openSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
		
	}

	@Override
	public int updatebook(Book book) {
		int i=0;
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
			SqlSessionFactory build = sessionFactoryBuilder.build(inputStream);
			SqlSession openSession = build.openSession();
			 i = openSession.update("com.ly.mapper.BookMap.updatebook", book);
		openSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
		
	}
}
