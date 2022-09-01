package com.ducnd.pojo;

import com.ducnd.pojo.User;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-31T14:08:09")
@StaticMetamodel(Spending.class)
public class Spending_ { 

    public static volatile SingularAttribute<Spending, Double> money;
    public static volatile SingularAttribute<Spending, String> purpose;
    public static volatile SingularAttribute<Spending, Integer> id;
    public static volatile SingularAttribute<Spending, Date> time;
    public static volatile SingularAttribute<Spending, User> userId;

}