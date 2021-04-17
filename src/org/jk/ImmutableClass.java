package org.jk;

import java.util.Date;

// 1. Declare the class as final
public final class ImmutableClass {
    // 2. Make instance variables final
    // Integer is an immutable class, therefore we provide only normal getter method.
    private final Integer immutableField1;

    // String is an immutable class, therefore just provide a normal getter method for it.
    private final String immutableField2;

    // Date is a mutable class, so pay attention while providing a getter method.
    private final Date date;

    // 3. initialize those final fields inside a constructor
    public ImmutableClass(Integer immutableField1, String immutableField2, Date date){
        this.immutableField1 = immutableField1;
        this.immutableField2 = immutableField2;
        this.date = new Date(date.getTime());
    }

    // 4. Provide only getter methods for fields.
    public Integer getImmutableField1() {
        return immutableField1;
    }

    public String getImmutableField2() {
        return immutableField2;
    }

    // return a copy of original Date instance.
    public Date getDate() {
        return new Date(date.getTime());
    }
}
