package cn.huzd.springframework.beans.factory.component;


import jdk.nashorn.internal.objects.annotations.Property;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * bean 属性值集合
 */

public class ProperyValues {

    private final List<PropertyValue> propertyValueList=new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue){
       this.propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue pv:this.propertyValueList) {
            if(pv.getName().equals(propertyName)){
                return pv;
            }
        }
        return null;
    }

}
