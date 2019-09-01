package cn.wengzi.ioc.ioc;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class ClassPathXmlApplicationContext implements ApplicationContext {

    private Map<String, Object> map = new HashMap<String, Object>();

    /**
     * @param path Spring配置文件路径
     */
    public ClassPathXmlApplicationContext(String path) {
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read("./src/main/resources" + path);
            //解析xml文件中所有的bean,通过迭代器进行遍历
            Element rootElement = document.getRootElement();
            Iterator<Element> iterator = rootElement.elementIterator();
            while (iterator.hasNext()) {
                //每一个element就是一个bean标签
                Element element = iterator.next();
                //获取每个bean标签的id和全类名
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                //通过反射创建对象
                Class<?> clazz = Class.forName(className);
                //获取无参构造函数,创建目标对象
                Constructor<?> constructor = clazz.getConstructor();
                Object newInstance = constructor.newInstance();

                //给目标对象赋值
                Iterator<Element> BeanIterator = element.elementIterator();
                while (BeanIterator.hasNext()) {
                    Element properties = BeanIterator.next();
                    String name = properties.attributeValue("name");
                    String valueStr = properties.attributeValue("value");
                    String ref = properties.attributeValue("ref");
                    if (null == ref) {
                        String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                        Field field = clazz.getDeclaredField(name);
                        System.out.println(field.getType().getName());
                        Method method = clazz.getDeclaredMethod(methodName, field.getType());
                        //根据成员变量的数据类型将 value 进行转换
                        Object value = null;
                        if (field.getType().getName() == "java.lang.String") {
                            value = valueStr;
                        }
                        if (field.getType().getName() == "java.lang.Integer") {
                            value = Integer.parseInt(valueStr);
                        }
                        method.invoke(newInstance, value);
                    }
                    map.put(id, newInstance);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String BeanId) {
        return map.get(BeanId);
    }
}
