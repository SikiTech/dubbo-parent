/**
 * projectName: dubbo-parent
 * fileName: SetRenferenceTest.java
 * packageName: PACKAGE_NAME
 * date: 2020-02-20 下午4:52
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */

import com.alibaba.dubbo.common.utils.ConcurrentHashSet;

import java.util.Iterator;
import java.util.Set;

/**
 * @className: SetRenferenceTest
 * @packageName: PACKAGE_NAME
 * @description: 引用拷贝
 * @author: Robert
 * @data: 2020-02-20 下午4:52
 * @version: V1.0
 **/
public class SetRenferenceTest {

    public static void main(String[] args) {

        Set<Class<?>> set = new ConcurrentHashSet<Class<?>>();
        set.add(Integer.class);
        set.add(Long.class);


        Set<Class<?>> oset = set;
        oset.add(String.class);

        Iterator<Class<?>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Class<?> next = iterator.next();
            System.out.println(next.getSimpleName());
        }

        String name = "abcd";
        change(name);
        System.out.println(name);

    }


    private static String change(String original) {
        String name = original;
        name = "1234";
        return  name;
    }




}