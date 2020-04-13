/*

package com.mvc.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.annoation.EnjoyController;
import com.mvc.annoation.EnjoyRequestMapping;

*/
/**
 *  MyDispatcherServlet.java
 *  TODO
 *  Created: 2018年8月19日 下午2:56:20
 *  Author: raogugen
 *//*


public class MyDispatcherServlet extends HttpServlet {

	private Properties properties = new Properties();
	private List<String> classNames = new ArrayList<>();
	private Map<String, Object> ioc = new HashMap<>();
	private Map<String, Method> handlerMapping = new HashMap<>();
	private Map<String, Object> controllerMap =new HashMap<>();
	
	
		@Override
		public void init(ServletConfig config) throws ServletException {
			//1. 加载配置文件
			doLoadConfig(config.getInitParameter("contextConfigLocation"));
			//2. 初始化所有相关的类
			doScanner(properties.getProperty("scanPackage"));
			//3. 拿到扫描的类 通过反射 实例化 放到ios容器中
			doInstance();
			//4. 初始化HandlerMapping
			initHandlerMapping();
			
			
		}
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//处理请求
			try {
			doDispatch(req,resp);
			}catch(Exception e) {
				resp.getWriter().write("500!! Server Exception");
			}
		}
		
		private void doDispatch(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
			if(handlerMapping.isEmpty()){
				return;
				}
			String url =req.getRequestURI();
			String contextPath = req.getContextPath();
			url=url.replace(contextPath, "").replaceAll("/+", "/");
			if(!this.handlerMapping.containsKey(url)){
				resp.getWriter().write("404 NOT FOUND!");
				return;
				}
			//根据url获取对应的方法
			Method method=this.handlerMapping.get(url);
			//获取方法的参数类型列表
			Class<?>[] parameterTypes=method.getParameterTypes();
			//获取请求参数
			Map<String,String[]> paramMap=req.getParameterMap();
			//保存参数值
			Object [] paramValues= new Object[parameterTypes.length];
			for(int i=0;i<parameterTypes.length;i++) {
				//根据参数名称，做某些处理
				String requestParam = parameterTypes[i].getSimpleName();
				if(requestParam.equals("HttpServletRequest")) {
					paramValues[i]=req;//参数类型已明确，这边强转类型
					continue;
				}
				if (requestParam.equals("HttpServletResponse")){
					paramValues[i]=resp;
					continue;
					}
				if(requestParam.equals("String")) {
					for (Entry<String, String[]> param : paramMap.entrySet()) {
						String value =Arrays.toString(param.getValue()).replaceAll("[|]", "").replaceAll(",s", ",");
						paramValues[i]=value;
					}
				}
			}
			//利用反射机制来调用
			try {
				method.invoke(this.controllerMap.get(url), paramValues);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		private void doLoadConfig(String path) {
			InputStream stream=this.getClass().getClassLoader().getResourceAsStream(path);
			try {
				//加载所有的配置项
				properties.load(stream);
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(stream!=null) {
					try {
						stream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		private void doScanner(String packageName) {
			//把包中所有的 . 换成 /
			URL url=this.getClass().getClassLoader().getResource("/"+packageName.replace(".", "/"));
			File dir =new File(url.getFile());
			for(File file:dir.listFiles()) {
				if(file.isDirectory()) {
					doScanner(packageName+"."+file.getName());
				}else {
					//类名称
					String className=packageName+"."+file.getName().replace(".class", "");
					classNames.add(className);
				}
			}
		}
		
	private void doInstance() {
		if (classNames.isEmpty()) {
			return;
		}
		// 把类搞出来,反射来实例化(只有加@EnjoyController需要实例化)
		try {
			for (String className : classNames) {
				Class<?> clazz = Class.forName(className);
				// 如果包含EnjoyController
				if (clazz.isAnnotationPresent((Class<? extends Annotation>) EnjoyController.class)) {
					ioc.put(toLowerFirstWord(clazz.getSimpleName()), clazz.newInstance());
				} else {
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	private void initHandlerMapping() {
		if(ioc.isEmpty()) {
			return;
		}
		for(Entry<String,Object> entry:ioc.entrySet()) {
			Class<?> clazz=entry.getValue().getClass();
			//沒有controller注解的类跳過
			if(!clazz.isAnnotationPresent(EnjoyController.class)) {
				continue;
			}
			//拼url  先handler上的EnjoyRequestMapping
			String baseUrl="";
			if(clazz.isAnnotationPresent(EnjoyRequestMapping.class)) {
				EnjoyRequestMapping anno=clazz.getAnnotation(EnjoyRequestMapping.class);
				baseUrl=anno.value();
			}
			//沒有EnjoyRequestMapping注解的方法就跳過
			Method[] methods=clazz.getMethods();
			for(Method me:methods) {
				if(!me.isAnnotationPresent(EnjoyRequestMapping.class)) {
					continue;
				}
				EnjoyRequestMapping reqanno=me.getAnnotation(EnjoyRequestMapping.class);
				String url=reqanno.value();
				url =(baseUrl+"/"+url).replaceAll("/+", "/");
				//添加url和method映射到map中
				handlerMapping.put(url, me);
				try {
					controllerMap.put(url, clazz.newInstance());
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				System.out.println(url+","+me);
			}
		}
	}
		
		*/
/**

		* 把字符串的首字母小写

		* @param name

		*//*

		private String toLowerFirstWord(String name){

		char[] charArray = name.toCharArray();

		charArray[0] += 32;

		return String.valueOf(charArray);

		}
		
}
*/
