package cn.huzd.springframework.beans.factory.component;

import lombok.Data;

/**
 * bean的属性信息
 */
@Data
public class PropertyValue {

    private final String name;

    private final Object value;

}
