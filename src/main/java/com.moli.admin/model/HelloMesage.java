package com.moli.admin.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by gary on 17/8/25.
 */
public class HelloMesage implements Serializable {

    private static final long serialVersionUID = 531332587548447535L;

    @NotBlank
    @Length
    @Size(min = 2, max = 4)
    private String name;

    @NotNull
    @Size(min = 4, max = 10)
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
