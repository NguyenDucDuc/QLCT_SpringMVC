package com.ducnd.pojo;

import com.ducnd.pojo.Gr;
import com.ducnd.pojo.User;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-31T14:08:09")
@StaticMetamodel(UserIncomeGroup.class)
public class UserIncomeGroup_ { 

    public static volatile SingularAttribute<UserIncomeGroup, Double> money;
    public static volatile SingularAttribute<UserIncomeGroup, String> purpose;
    public static volatile SingularAttribute<UserIncomeGroup, Gr> groupId;
    public static volatile SingularAttribute<UserIncomeGroup, Integer> id;
    public static volatile SingularAttribute<UserIncomeGroup, Date> time;
    public static volatile SingularAttribute<UserIncomeGroup, User> userId;

}