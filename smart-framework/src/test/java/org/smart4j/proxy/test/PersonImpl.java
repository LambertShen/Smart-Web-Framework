package org.smart4j.proxy.test;

/**
 * @ClassName PersonImpl
 * @Description TODO
 * @Author Lambert
 * @Date 4/14/2020 3:31 PM
 * @Version 1.0
 **/
public class PersonImpl implements Person
{
    @Override
    public void say()
    {
        System.out.println("hello");
    }

    @Override
    public void aa()
    {
        System.out.println("oooo");
    }
}
