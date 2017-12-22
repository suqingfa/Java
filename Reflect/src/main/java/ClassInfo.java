import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class ClassInfo implements Serializable
{
    public static void main(String[] args)
    {
        Class clazz = ClassInfo.class;
    }

    @Getter
    @Setter
    private int pv;

    protected int po;

    public int pu;

    public static int ps;

    public static void psMethod()
    {
    }

    public void puMethod()
    {
    }

    protected void poMethod()
    {
    }

    private void pvMethod()
    {
    }
}
