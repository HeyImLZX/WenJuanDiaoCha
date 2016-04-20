import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;
import javafx.scene.control.Spinner;


public class MyDaoGenerator {
    public static void main(String[] args) throws Exception {
        // 正如你所见的，你创建了一个用于添加实体（Entity）的模式（Schema）对象。
        // 两个参数分别代表：数据库版本号与自动生成代码的包路径。
        Schema schema = new Schema(1, "com.ice.greendao");
//      当然，如果你愿意，你也可以分别指定生成的 Bean 与 DAO 类所在的目录，只要如下所示：
//      Schema schema = new Schema(1, "me.itangqi.bean");
//      schema.setDefaultJavaPackageDao("me.itangqi.dao");

        // 模式（Schema）同时也拥有两个默认的 flags，分别用来标示 entity 是否是 activie 以及是否使用 keep sections。
        // schema2.enableActiveEntitiesByDefault();
        // schema2.enableKeepSectionsByDefault();

        // 一旦你拥有了一个 Schema 对象后，你便可以使用它添加实体（Entities）了。
        addNote(schema);

        // 最后我们将使用 DAOGenerator 类的 generateAll() 方法自动生成代码，此处你需要根据自己的情况更改输出目录（既之前创建的 java-gen)。
        // 其实，输出目录的路径可以在 build.gradle 中设置，有兴趣的朋友可以自行搜索，这里就不再详解。
        new DaoGenerator().generateAll(schema, "E:/Android/AndroidStudioWorkplace/WenJuanDiaoCha/app/src/main/java-gen");
    }

    /**
     * @param schema
     */
    private static void addNote(Schema schema) {
        // 一个实体（类）就关联到数据库中的一张表，此处表名为「Note」（既类名）
        Entity note = schema.addEntity("PersonInfo");
        // 你也可以重新给表命名
        // note.setTableName("NODE");

        // greenDAO 会自动根据实体类的属性值来创建表字段，并赋予默认值
        // 接下来你便可以设置表中的字段：
        note.addIdProperty();
        note.addStringProperty("name").notNull();

        note.addStringProperty("questionId");
        // 与在 Java 中使用驼峰命名法不同，默认数据库中的命名是使用大写和下划线来分割单词的。
        // For example, a property called “creationDate” will become a database column “CREATION_DATE”.
        note.addStringProperty("sex");
        note.addStringProperty("birthday");


        note.addStringProperty("height");
        note.addStringProperty("weight");
        note.addStringProperty("provider");
        note.addStringProperty("relation");
        note.addStringProperty("religion");
        note.addStringProperty("personId");
        note.addStringProperty("education");
        note.addStringProperty("occupation");
        note.addStringProperty("marriage");
        note.addStringProperty("payment");
        note.addStringProperty("home");
        note.addStringProperty("economy");
        note.addStringProperty("oldhelp");
        note.addStringProperty("accident");
        note.addStringProperty("wish1");
        note.addStringProperty("wish2");

        Entity simpleInfo = schema.addEntity("SimpleInfo");
        // 你也可以重新给表命名
        // note.setTableName("NODE");
        // greenDAO 会自动根据实体类的属性值来创建表字段，并赋予默认值
        // 接下来你便可以设置表中的字段：
        simpleInfo.addIdProperty();
        simpleInfo.addStringProperty("questionId").notNull();
        // 与在 Java 中使用驼峰命名法不同，默认数据库中的命名是使用大写和下划线来分割单词的。
        // For example, a property called “creationDate” will become a database column “CREATION_DATE”.
        simpleInfo.addStringProperty("personId");

        simpleInfo.addStringProperty("disease");
        simpleInfo.addStringProperty("medicine");

        simpleInfo.addBooleanProperty("one1");
        simpleInfo.addBooleanProperty("one2");
        simpleInfo.addBooleanProperty("one3");
        simpleInfo.addBooleanProperty("two1");
        simpleInfo.addBooleanProperty("two2");
        simpleInfo.addBooleanProperty("three1");
        simpleInfo.addBooleanProperty("three2");
        simpleInfo.addBooleanProperty("four1");
        simpleInfo.addBooleanProperty("four2");
        simpleInfo.addBooleanProperty("five1");
        simpleInfo.addBooleanProperty("five2");
        simpleInfo.addBooleanProperty("five3");
        simpleInfo.addBooleanProperty("six1");
        simpleInfo.addBooleanProperty("six2");
        simpleInfo.addBooleanProperty("seven1");
        simpleInfo.addBooleanProperty("eight1");
        simpleInfo.addBooleanProperty("eight2");
        simpleInfo.addBooleanProperty("eight3");
        simpleInfo.addBooleanProperty("nine1");
        simpleInfo.addBooleanProperty("nine2");
        simpleInfo.addBooleanProperty("ten1");
        simpleInfo.addBooleanProperty("ten2");
        simpleInfo.addBooleanProperty("ten3");
        simpleInfo.addBooleanProperty("ten4");
        simpleInfo.addBooleanProperty("fourteen1");
        simpleInfo.addBooleanProperty("fourteen2");
        simpleInfo.addBooleanProperty("fourteen3");
        simpleInfo.addBooleanProperty("fourteen4");
        simpleInfo.addBooleanProperty("fourteen5");
        simpleInfo.addBooleanProperty("seventeen1");
        simpleInfo.addBooleanProperty("seventeen2");
        simpleInfo.addBooleanProperty("seventeen3");
        simpleInfo.addBooleanProperty("seventeen4");
        simpleInfo.addBooleanProperty("seventeen5");
        simpleInfo.addBooleanProperty("nineteen1");
        simpleInfo.addBooleanProperty("nineteen2");
        simpleInfo.addBooleanProperty("twenty1");
        simpleInfo.addBooleanProperty("twenty2");

        Entity questionResult = schema.addEntity("QuestionResult");
        // 你也可以重新给表命名
        // note.setTableName("NODE");

        // greenDAO 会自动根据实体类的属性值来创建表字段，并赋予默认值
        // 接下来你便可以设置表中的字段：
        questionResult.addIdProperty();
        questionResult.addStringProperty("questionId").notNull();
        // 与在 Java 中使用驼峰命名法不同，默认数据库中的命名是使用大写和下划线来分割单词的。
        // For example, a property called “creationDate” will become a database column “CREATION_DATE”.
        questionResult.addStringProperty("personId");

        questionResult.addStringProperty("tableId");
        questionResult.addStringProperty("blank");
        questionResult.addStringProperty("result");
        questionResult.addStringProperty("score");






    }
}
