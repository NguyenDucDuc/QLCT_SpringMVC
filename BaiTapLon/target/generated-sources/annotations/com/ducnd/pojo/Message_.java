package com.ducnd.pojo;

import com.ducnd.pojo.Gr;
import com.ducnd.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-31T14:08:09")
@StaticMetamodel(Message.class)
public class Message_ { 

    public static volatile SingularAttribute<Message, Gr> groupId;
    public static volatile SingularAttribute<Message, Integer> id;
    public static volatile SingularAttribute<Message, User> userId;
    public static volatile SingularAttribute<Message, String> content;

}