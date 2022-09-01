package com.ducnd.pojo;

import com.ducnd.pojo.Gr;
import com.ducnd.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-31T14:08:08")
@StaticMetamodel(SpendingGroupTemp.class)
public class SpendingGroupTemp_ { 

    public static volatile SingularAttribute<SpendingGroupTemp, Double> money;
    public static volatile SingularAttribute<SpendingGroupTemp, String> purpose;
    public static volatile SingularAttribute<SpendingGroupTemp, Gr> groupId;
    public static volatile SingularAttribute<SpendingGroupTemp, Integer> id;
    public static volatile SingularAttribute<SpendingGroupTemp, Date> time;
    public static volatile SingularAttribute<SpendingGroupTemp, User> userId;

}