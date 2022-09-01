package com.ducnd.pojo;

import com.ducnd.pojo.User;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-31T14:08:09")
@StaticMetamodel(Income.class)
public class Income_ { 

    public static volatile SingularAttribute<Income, Double> money;
    public static volatile SingularAttribute<Income, String> purpose;
    public static volatile SingularAttribute<Income, Integer> id;
    public static volatile SingularAttribute<Income, Date> time;
    public static volatile SingularAttribute<Income, User> userId;

}