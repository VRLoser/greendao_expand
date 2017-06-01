package xw.cn.daoexample.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;

import java.io.Serializable;

/**
 * Created by weixia on 2017/5/31.
 */

@Entity
public class RepositoryNote implements Serializable{

    @Id(autoincrement = true)
    public int id;
    @Unique
    public String name;
    @Property(nameInDb = "USERNAME")
    private String username;
    @NotNull
    private int repos;
}
