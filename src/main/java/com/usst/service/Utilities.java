package com.usst.service;

import com.usst.entity.account.UserLogin;
import com.usst.entity.question.Question;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Utilities{

    private Object object;

    /**
     * java通过UUID生成唯一标识性固定位数id
     *@param first 一位前缀
     *@param count 总共几位
     *@return 生成的唯一标识性id
     * */
    public static String getOrderIdByUUId(String first,int count) {
        System.out.println(first);
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // d 代表参数为正数型
        return first + String.format("%0"+String.valueOf(count-1)+"d", hashCodeV);
    }

    /**
     * 该方法是用于相同对象不同属性值的合并，如果两个相同对象中同一属性都有值，那么sourceBean中的值会覆盖targetBean重点的值
     * @param sourceBean    被提取的对象bean
     * @param targetBean    用于合并的对象bean
     * @param unchangedFields 保持不变的fields
     * @return 合并后的对象
     */
    public static Object combineBeans(Object sourceBean,String unchangedFields,Object targetBean){
        Class sourceBeanClass = sourceBean.getClass();

        Field[] sourceFields = sourceBeanClass.getDeclaredFields();
        Field[] targetFields = sourceBeanClass.getDeclaredFields();
        for(int i=0; i<sourceFields.length; i++){
            Field sourceField = sourceFields[i];
            Field targetField = targetFields[i];
            if(unchangedFields.indexOf(sourceField.getName()) != -1){
                continue;
            }
            sourceField.setAccessible(true);
            targetField.setAccessible(true);
            try {
                //sourceField.get(sourceBean) 获取该属性属性值
                if( !(sourceField.get(sourceBean) == null) &&  !"serialVersionUID".equals(sourceField.getName().toString())){
                    targetField.set(targetBean,sourceField.get(sourceBean));
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e){
                e.printStackTrace();
            }
        }
        return targetBean;
    }

    /*
     * 为字段设置日期和时间, fieldsName[] 和 formats[] 数组长度应该一致
     * @param object
     * @param fieldsName 需要set的字段
     * @param formats    时间格式：yyyy-MM-dd hh:mm:ss
     * */
    public static void setCurrentDateAndTime(Object object, String[] fieldsName, String[] formats) {
        String fieldName       = null;
        String now             = null;
        String fieldType       = null;
        Field  field           = null;
        DateFormat fmt   = null;
        System.out.println("-----set c d t-----");
        for(int i=0; i<Math.min(fieldsName.length,formats.length); i++) {
            System.out.println(fieldsName[i]);
            fieldName = fieldsName[i];
            fmt=new SimpleDateFormat(formats[i]);
            try {
                field = object.getClass().getDeclaredField(fieldName);
                //设置对象的访问权限，保证对private的属性的访问
                field.setAccessible(true);

                now = fmt.format(new Date());
                System.out.println(now.toString());
                fieldType = field.getGenericType().toString();
                //字段类型为String
                if (fieldType.equals("class java.lang.String")) {
                    field.set(object, now);
                } else if (fieldType.equals("class java.util.Date")) {
                    field.set(object, fmt.parse(now));
                } else if (fieldType.equals("class java.sql.Timestamp")) {
                    field.set(object, Timestamp.valueOf(now));
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }  catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e){
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        //test getOrderIdByUUId
        String orderingID= getOrderIdByUUId("q",16);
        System.out.println(orderingID);

        UserLogin sourceModel = new UserLogin();    //    第一个对象
        UserLogin targetModel = new UserLogin();    //    第二个model对象

        sourceModel.setUserId("test1");
        sourceModel.seteMail("email1");

        targetModel.setUserId("test2");
        targetModel.seteMail("email2");

        //test combineBeans
        String dateStr = "2010-05-04 12:34:23";
        Date date = new Date();
        //注意format的格式要与日期String的格式相匹配
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse(dateStr);
            System.out.println(date.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //test SetDateAndTime
        Question testQ = new Question();
        Utilities.setCurrentDateAndTime(testQ, new String[]{"timestamp"}, new String[]{"yyyy-MM-dd hh:mm:ss"});
        System.out.println(testQ.getTimestamp());

    }
}