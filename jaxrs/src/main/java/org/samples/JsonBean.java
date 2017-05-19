package org.samples;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class JsonBean {
	@NotNull @Pattern(regexp = "^[0-9]{3}-[0-9]{3}-[0-9]{4}$",message="phone no should be valid")
    private String val1;
	@NotNull(message="value 2 cannot be null")
    private String val2;

    public String getVal1() {
        return val1;
    }

    public void setVal1(String val1) {
        this.val1 = val1;
    }

    public String getVal2() {
        return val2;
    }

    public void setVal2(String val2) {
        this.val2 = val2;
    }

}
