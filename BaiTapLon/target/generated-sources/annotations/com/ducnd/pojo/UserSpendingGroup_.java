package com.ducnd.pojo;

import com.ducnd.pojo.Gr;
import com.ducnd.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-31T14:08:09")
@StaticMetamodel(UserSpendingGroup.class)
public class UserSpendingGroup_ { 

    public static volatile SingularAttribute<UserSpendingGroup, Double> money;
    public static volatile SingularAttribute<UserSpendingGroup, String> purpose;
    public static volatile SingularAttribute<UserSpendingGroup, Integer> id;
    public static volatile SingularAttribute<UserSpendingGroup, Date> time;
    public static volatile SingularAttribute<UserSpendingGroup, Gr> gr;
    public static volatile SingularAttribute<UserSpendingGroup, User> userId;

}