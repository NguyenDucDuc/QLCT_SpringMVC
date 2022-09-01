package com.ducnd.pojo;

import com.ducnd.pojo.User;
import com.ducnd.pojo.UserIncomeGroup;
import com.ducnd.pojo.UserSpendingGroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-09T20:11:26")
@StaticMetamodel(Group1.class)
public class Group1_ { 

    public static volatile CollectionAttribute<Group1, UserSpendingGroup> userSpendingGroupCollection;
    public static volatile SingularAttribute<Group1, String> purpose;
    public static volatile SingularAttribute<Group1, Integer> id;
    public static volatile SingularAttribute<Group1, String> groupname;
    public static volatile SingularAttribute<Group1, User> user;
    public static volatile CollectionAttribute<Group1, UserIncomeGroup> userIncomeGroupCollection;

}