# greendao_expand
this IS modify content
This is mac os moidify
get the commit

Note:
准备工作：
    1.添加mavenCentral仓库，添加classpath 'org.greenrobot:greendao-gradle-plugin:3.2.2'依赖插件
    2.pply plugin: 'org.greenrobot.greendao'，添加compile 'org.greenrobot:greendao:3.2.2'依赖
    3.greendao闭包的介绍：
        1：schemaVersion：当前版本的数据库模式。这被 * OpenHelpers类用于在模式版本之间迁移。如果您更改了实体/数据库模式，则必须增加该值。默认为1。
        2：daoPackage：生成的DAO，DaoMaster和DaoSession的包名称。 默认为源实体的包名称。
        3：targetGenDir：生成源应存储在的位置。 默认为构建目录（ build / generated / source / greendao）中生成的源文件夹。
    4.实体和注释的介绍：
        @Entity
        public class User {
            @Id
            private Long id;
            private String name;
            @Transient
            private int tempUsageCount; // not persisted
           // getters and setters for id and user ...
        }
        1:@Entity 注解打开Java类 用户到数据库支持的实体。这也将指示greenDAO生成必需的代码（例如DAO。注意：只支持Java类。如果您喜欢Kotlin等其他语言，您的实体类仍然是Java。
            其中，@Entity中还可以配置；schema = "myschema"（如果有多个模式，可以将greenDAO告知实体属于哪个模式（以任何字符串的名称））；active = true，
        2:@Id 注释选择 long/Long 属性作为实体ID。在数据库方面，它是主要的关键。参数autoincrement是使ID值不断增加的标志（不重复使用旧值）。
        3:@Property 注解允许您定义属性映射到的非默认列名称。如果缺少，greenDAO将以SQL-ish方式使用字段名称（大写字母，下划线而不是骆驼案例，例如 customName将成为 CUSTOM_NAME）。注意：当前只能使用内联常量来指定列名。
        4:@NotNull 注解使该属性在数据库端成为“NOT NULL”列。通常使用@NotNull标记原始类型（long，int，short，byte）是有意义的，而具有包装类（Long，Integer，Short，Byte））的可空值。
        5:@Transient 注解标记要从持久性排除的属性。使用这些临时状态等。或者，您也可以使用来自Java 的transient关键字。
        主键限制；
            实体必须具有long或Long属性作为其主键，要解决此问题，请将您的密钥属性定义为附加属性，但为其创建唯一的索引：
            @Id
            private Long id;
            @Index(unique = true)
            private String key;
        属性指标：
            在属性中使用@Index为相应的数据库列创建数据库索引。使用以下参数自定义：
            名称：如果您不喜欢greenDAO为索引生成的默认名称，则可以在此处指定。
            唯一：向索引添加UNIQUE约束，强制所有值都是唯一的。
            @Entity
            public class User {
                @Id private Long id;
                @Index(unique = true)
                private String name;
            }
            @Entity
            public class User {
                @Id private Long id;
                @Index(unique = true)
                private String name;
            }
            @Unique向数据库列添加了一个UNIQUE约束。请注意，SQLite还会隐式地为其创建索引。
            @Entity
            public class User {
                @Id private Long id;
                @Unique private String name;
            }
            @Entity
            public class User {
                @Id private Long id;
                @Unique private String name;
            }
