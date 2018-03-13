package com.example.demo.reflesh;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class TestBean {

	public static void main(String[] args) throws Exception {
		Person p = new Person("lixia", "1717h5", 20);
		BeanInfo bi = Introspector.getBeanInfo(p.getClass(),Object.class);
		PropertyDescriptor[] pds = bi.getPropertyDescriptors();
		for (int i = 0, len = pds.length; i < len; ++i) {
			PropertyDescriptor pd = pds[i];
			Class propCl = pd.getPropertyType();
			String propName = pd.getName();
			System.err.println("---> " + propName);
			System.err.println("className-->" + p.getClass());
			System.err.println("fieldClassName-->" + propCl);
			System.err.println("readMethod-->" + pd.getReadMethod());
			System.err.println("writeMethod-->" + pd.getWriteMethod());
			Method readMethod = pd.getReadMethod();
			if (readMethod != null) {
				Object propVal = readMethod.invoke(p, new Object[0]);
				System.err.println("propName: " + propName + " propVal: " + propVal);
			}
		}
//		setPropertyByIntrospector(p,"pass");
		
	}
	
	 public static void setPropertyByIntrospector(Person userInfo,String userName)throws Exception{
	        BeanInfo beanInfo=Introspector.getBeanInfo(Person.class);
	        PropertyDescriptor[] proDescrtptors=beanInfo.getPropertyDescriptors();
	        if(proDescrtptors!=null&&proDescrtptors.length>0){
	            for(PropertyDescriptor propDesc:proDescrtptors){
	                if(propDesc.getName().equals(userName)){
	                    Method methodSetUserName=propDesc.getWriteMethod();
	                    System.out.println("old userName:"+userInfo.getPass());
	                    methodSetUserName.invoke(userInfo, "alan");
	                    System.out.println("direct set userName:"+userInfo.getPass());
	                    System.out.println("-----------------------------");
	                    Method methodGetUserName=propDesc.getReadMethod();
	                    System.out.println("invoke set userName:"+ methodGetUserName.invoke(userInfo, null));
	                    break;
	                }
	            }
	        }
	    }

}
