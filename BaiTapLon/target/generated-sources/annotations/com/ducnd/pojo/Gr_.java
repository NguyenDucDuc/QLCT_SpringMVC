package com.ducnd.pojo;

import com.ducnd.pojo.BelongTo;
import com.ducnd.pojo.Message;
import com.ducnd.pojo.User;
import com.ducnd.pojo.UserIncomeGroup;
import com.ducnd.pojo.UserSpendingGroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-31T14:08:08")
@StaticMetamodel(Gr.class)
public class Gr_ { 

    public static volatile CollectionAttribute<Gr, BelongTo> belongToCollection;
    public static volatile CollectionAttribute<Gr, UserSpendingGroup> userSpendingGroupCollection;
    public static volatile SingularAttribute<Gr, String> purpose;
    public static volatile CollectionAttribute<Gr, Message> messageCollection;
    public static volatile SingularAttribute<Gr, Integer> id;
    public static volatile SingularAttribute<Gr, String> groupname;
    public static volatile SingularAttribute<Gr, User> userId;
    public static volatile CollectionAttribute<Gr, UserIncomeGroup> userIncomeGroupCollection;

}