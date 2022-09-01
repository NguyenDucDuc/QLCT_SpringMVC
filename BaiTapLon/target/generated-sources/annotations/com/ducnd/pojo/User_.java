package com.ducnd.pojo;

import com.ducnd.pojo.BelongTo;
import com.ducnd.pojo.Gr;
import com.ducnd.pojo.Income;
import com.ducnd.pojo.Message;
import com.ducnd.pojo.Spending;
import com.ducnd.pojo.UserIncomeGroup;
import com.ducnd.pojo.UserSpendingGroup;
import com.ducnd.pojo.Warning;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-31T14:08:09")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile CollectionAttribute<User, Warning> warningCollection;
    public static volatile CollectionAttribute<User, UserSpendingGroup> userSpendingGroupCollection;
    public static volatile SingularAttribute<User, String> role;
    public static volatile SingularAttribute<User, Integer> active;
    public static volatile SingularAttribute<User, String> avatar;
    public static volatile CollectionAttribute<User, Spending> spendingCollection;
    public static volatile CollectionAttribute<User, UserIncomeGroup> userIncomeGroupCollection;
    public static volatile CollectionAttribute<User, BelongTo> belongToCollection;
    public static volatile CollectionAttribute<User, Gr> grCollection;
    public static volatile SingularAttribute<User, String> password;
    public static volatile CollectionAttribute<User, Income> incomeCollection;
    public static volatile CollectionAttribute<User, Message> messageCollection;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}