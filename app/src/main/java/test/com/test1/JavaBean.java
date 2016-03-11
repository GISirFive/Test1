package test.com.test1;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-3-10.
 */
public class JavaBean implements Parcelable {

    /**
     * name : 张三
     * age : 12
     * sex : true
     * clazz : 2
     * data : [{"name":"远洋头盔","power":95,"magic":10},{"name":"远洋战靴","power":36,"magic":8},{"name":"远洋戒指","power":64,"magic":92}]
     */

    private String name;
    private int age;
    private boolean sex;
    private int clazz;
    /**
     * name : 远洋头盔
     * power : 95
     * magic : 10
     */

    private List<Property> data;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setClazz(int clazz) {
        this.clazz = clazz;
    }

    public void setData(List<Property> data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isSex() {
        return sex;
    }

    public int getClazz() {
        return clazz;
    }

    public List<Property> getData() {
        return data;
    }

    public static class Property implements Parcelable {
        private String name;
        private int power;
        private int magic;

        public void setName(String name) {
            this.name = name;
        }

        public void setPower(int power) {
            this.power = power;
        }

        public void setMagic(int magic) {
            this.magic = magic;
        }

        public String getName() {
            return name;
        }

        public int getPower() {
            return power;
        }

        public int getMagic() {
            return magic;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.name);
            dest.writeInt(this.power);
            dest.writeInt(this.magic);
        }

        public Property() {
        }

        protected Property(Parcel in) {
            this.name = in.readString();
            this.power = in.readInt();
            this.magic = in.readInt();
        }

        public static final Creator<Property> CREATOR = new Creator<Property>() {
            public Property createFromParcel(Parcel source) {
                return new Property(source);
            }

            public Property[] newArray(int size) {
                return new Property[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.age);
        dest.writeByte(sex ? (byte) 1 : (byte) 0);
        dest.writeInt(this.clazz);
        dest.writeList(this.data);
    }

    public JavaBean() {
    }

    protected JavaBean(Parcel in) {
        this.name = in.readString();
        this.age = in.readInt();
        this.sex = in.readByte() != 0;
        this.clazz = in.readInt();
        this.data = new ArrayList<Property>();
        in.readList(this.data, List.class.getClassLoader());
    }

    public static final Parcelable.Creator<JavaBean> CREATOR = new Parcelable.Creator<JavaBean>() {
        public JavaBean createFromParcel(Parcel source) {
            return new JavaBean(source);
        }

        public JavaBean[] newArray(int size) {
            return new JavaBean[size];
        }
    };
}
