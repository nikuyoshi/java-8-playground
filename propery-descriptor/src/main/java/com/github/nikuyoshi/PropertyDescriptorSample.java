package com.github.nikuyoshi;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PropertyDescriptorSample {
    
    public static void main(String... args){
        try {
            new PropertyDescriptorSample().execute();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    
    private void execute() throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        UserBean userBean = new UserBean();

        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name", UserBean.class);
        Method nameSetter = propertyDescriptor.getWriteMethod();
        Method nameGetter = propertyDescriptor.getReadMethod();
        // セットする値を第二引数に渡す
        nameSetter.invoke(userBean, "nikuyoshi");

        // ゲッターは引数がないので、nullを引数として渡す。nullだと引数の型が解決できないので、明示的に Object[] に
        // キャストしてあげる必要がある。戻り値もObject型になってしまっているので、キャストする。
        String name = (String) nameGetter.invoke(userBean, (Object[])null);

        // name:nikuyoshi
        System.out.println("name:" + name);
    }
}
