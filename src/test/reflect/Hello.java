package test.reflect;

import java.lang.management.MonitorInfo;
import java.lang.reflect.*;

public class Hello {

	public static void main(String[] args) {

		Class<?> demo = null;

		try{
			demo = Class.forName("test.reflect.Person");
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}

		try {
			Constructor<?> constructor[] = demo.getConstructors();
			//System.out.println(constructor);

			Person person1 = (Person)constructor[0].newInstance();
			System.out.println(person1);
			Person person2 = (Person)constructor[1].newInstance("jhf", 25);
			System.out.println(person2);
			person2.sayHello();

			Class<?> temp = demo.getSuperclass();
			System.out.println(temp.getName());

			for(Integer index = 0; index < constructor.length; index++){
				Class<?> parameters[] = constructor[index].getParameterTypes();
				System.out.println("构造方法 ：");
				Integer modifiers = constructor[index].getModifiers();
				System.out.println(Modifier.toString(modifiers) + " " + constructor[index].getName());
				for(Integer jndex = 0; jndex < parameters.length; jndex++){
					System.out.print(parameters[jndex].getName() + " arg " + index);
					if(jndex < parameters.length - 1){
						System.out.print(",");
					}
				}
				System.out.println();
 			}

 			Field[] fields = demo.getDeclaredFields();
			for(Integer index = 0; index < fields.length; index++){
				Integer modifiers = fields[index].getModifiers();
				String privility = Modifier.toString(modifiers);

				Class<?> type = fields[index].getType();
				System.out.println(privility + " " + type.getName() + " " + fields[index].getName() + ";");
			}

			Method method = demo.getMethod("sayHello");
			method.invoke(demo.newInstance());
		}catch (InstantiationException e){
			e.printStackTrace();
		}catch (IllegalAccessException e){
			e.printStackTrace();
		}catch (InvocationTargetException e){
			e.printStackTrace();
		}catch (NoSuchMethodException e){
			e.printStackTrace();
		}
	}
}
